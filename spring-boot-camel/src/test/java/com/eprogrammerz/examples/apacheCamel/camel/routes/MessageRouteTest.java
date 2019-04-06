package com.eprogrammerz.examples.apacheCamel.camel.routes;

import com.eprogrammerz.examples.apacheCamel.models.Message;
import com.eprogrammerz.examples.apacheCamel.services.MessageService;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageRouteTest extends CamelTestSupport {

    private static final String MESSAGE_ROUTE_URI = "direct:message";

    @Autowired
    private MessageService messageService;

    @Produce(uri = MESSAGE_ROUTE_URI)
    protected ProducerTemplate template;

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Test
    public void testSendMatchingMessage() throws Exception {
        String expectedBody = "<matched/>";

        resultEndpoint.expectedHeaderReceived(Exchange.HTTP_RESPONSE_CODE, 201);

        Message message = new Message(12, "Content");

        template.sendBodyAndHeader(expectedBody, "message", message);

        resultEndpoint.assertIsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public static final String ROUTE_ID = "message.route";

            @Override
            public void configure() throws Exception {

                from(MESSAGE_ROUTE_URI)
                        .routeId(ROUTE_ID)
                        .tracing()
                        .process(exchange -> {
                            log.info("Got into process.....");
                            Message bodyIn = (Message) exchange.getIn().getHeader("message");
                            messageService.transform(bodyIn);
                            log.info("Transformed body: {}", bodyIn);
                            exchange.getIn().setBody(bodyIn);
                        })
                        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
            }
        };
    }

}