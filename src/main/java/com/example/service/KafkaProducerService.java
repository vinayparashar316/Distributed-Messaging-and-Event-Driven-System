package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    // Load topic name from application.yml
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.println("Producing message: " + message);
        kafkaTemplate.send(topicName, message); // Send the message to the topic
    }
}