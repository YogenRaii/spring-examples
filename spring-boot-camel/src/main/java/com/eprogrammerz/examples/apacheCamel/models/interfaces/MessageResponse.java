package com.eprogrammerz.examples.apacheCamel.models.interfaces;

import com.eprogrammerz.examples.apacheCamel.models.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponse {
    private Message message;
}
