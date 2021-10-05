package com.example.springbootexercise.redis.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.List;

public interface MessagePublisher {

	/**
	 * Publishes an object to specific channel in redis defined by channelName
	 * 
	 * @param channelName
	 * @param message
	 * @throws JsonProcessingException
	 */
	void publish(String channelName, Object message) throws JsonProcessingException;

	void publish(List<String> channels, Object message) throws JsonProcessingException;
}