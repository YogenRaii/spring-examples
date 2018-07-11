package com.eprogrammerz.examples.spring.getToken.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RemoteServiceClient {

    @Value("${remote.service.host.uri}")
    private String remoteServiceUri;


    @Autowired
    private RestTemplate restTemplate;

    public String authenticateToIcon(String saml) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("SAMLResponse", saml);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<?> response = restTemplate.postForEntity(remoteServiceUri, request , Object.class );
        return response.getBody().toString();
    }
}
