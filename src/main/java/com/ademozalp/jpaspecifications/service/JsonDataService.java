package com.ademozalp.jpaspecifications.service;

import com.ademozalp.jpaspecifications.model.Token;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class JsonDataService {
    private final ObjectMapper objectMapper;

    public JsonDataService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Token> readTokensFromJson(){
        try {
            ClassPathResource resource = new ClassPathResource("data/tokens.json");
            InputStream inputStream = resource.getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
