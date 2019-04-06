package com.eprogrammerz.examples.apacheCamel.controllers;

import com.eprogrammerz.examples.apacheCamel.models.KeyBody;
import com.eprogrammerz.examples.apacheCamel.models.Message;
import com.eprogrammerz.examples.apacheCamel.models.interfaces.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class MessageController {
    @Produce(uri = "{{message.route.uri}}")
    private ProducerTemplate messageProducer;

    @Produce(uri = "{{file.route.uri}}")
    private ProducerTemplate fileProducer;

    @PostMapping(value = "/api/messages", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> createMessage(@RequestBody Message message) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("message", message);
        Object response = messageProducer.requestBodyAndHeaders("", headers);
        log.info("Response from route: {}", response);
        if(!(response instanceof Message)) {
            throw new IllegalArgumentException("Invalid input");
        }
        Message createdMessage = (Message) response;
        return new ResponseEntity<>(new MessageResponse(createdMessage), HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/key", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<KeyBody> getKeyBody(@RequestParam("for") final String purpose) {
        final Map<String, Object> headers = new HashMap<>();
        headers.put("purpose", purpose);

        Object response = fileProducer.requestBodyAndHeaders("", headers);
        if(!(response instanceof KeyBody)) {
            throw new IllegalArgumentException("Invalid input");
        }
        return new ResponseEntity<>((KeyBody) response, HttpStatus.OK);
    }
}
