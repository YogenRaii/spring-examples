package com.eprogrammerz.examples.apacheCamel.camel.routes;

import com.eprogrammerz.examples.apacheCamel.models.KeyBody;
import com.eprogrammerz.examples.apacheCamel.models.Message;
import com.eprogrammerz.examples.apacheCamel.services.MessageService;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestActionRoute extends RouteBuilder {

    public static final String MESSAGE_ROUTE_ID = "message.route";
    public static final String FILE_ROUTE_ID = "file.route";
    public static final String MESSAGE_ROUTE_URI = "{{message.route.uri}}";
    public static final String FILE_ROUTE_URI = "{{file.route.uri}}";

    public static final String KEYS_ROOT_DIR = "{{keys.root.dir}}";

    @Autowired
    private MessageService messageService;

    @Override
    public void configure() throws Exception {

        from(MESSAGE_ROUTE_URI)
                .routeId(MESSAGE_ROUTE_ID)
                .tracing()
                .process(exchange -> {
                    log.info("Got into process.....");
                    Message bodyIn = (Message) exchange.getIn().getHeader("message");
                    this.messageService.transform(bodyIn);
                    exchange.getIn().setBody(bodyIn);
                })

                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));

        from(FILE_ROUTE_URI)
                .routeId(FILE_ROUTE_ID)
                .pollEnrich().simple("file:" + KEYS_ROOT_DIR + "?noop=true&fileName=${header.purpose}.key&idempotent=false&sendEmptyMessageWhenIdle=true")
                .convertBodyTo(String.class)
                .process(exchange -> {
                    log.info("Processing file . . .");
                    KeyBody keyBody = new KeyBody(exchange.getIn().getBody(String.class));
                    log.info("Body {}", keyBody);
                    exchange.getIn().setBody(keyBody);
                });
    }
}
