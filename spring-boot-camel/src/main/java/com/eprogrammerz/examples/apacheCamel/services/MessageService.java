package com.eprogrammerz.examples.apacheCamel.services;

import com.eprogrammerz.examples.apacheCamel.models.Message;
import org.springframework.stereotype.Service;

/**
 * Created by Yogen on 10/8/2017.
 */
@Service
public class MessageService {
    public void transform(Message message) {
        message.setId(message.getId() * 10);
        message.setContent(message.getContent() + " has been changed.");
    }
}
