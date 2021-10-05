package com.example.springbootexercise.redis.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RedisMessagePublisher implements MessagePublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;
    private Logger logger = LoggerFactory.getLogger(RedisMessagePublisher.class);
    @Override
    public void publish(String channelName, Object message) throws JsonProcessingException {
        String response = objectMapper.writeValueAsString(message);
        logger.info(String.format("message published into channel %s with data %s",channelName,response));
        redisTemplate.convertAndSend("abc",response);
    }

    @Override
    public void publish(List<String> channels, Object message) throws JsonProcessingException {

    }
}
