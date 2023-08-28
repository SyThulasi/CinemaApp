package com.example.cinemaApp.Kafka;

import com.example.cinemaApp.DTO.CinemaUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    @Value("My_Topic")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, CinemaUserDTO> kafkaTemplate;

    @Autowired
    public JsonKafkaProducer(KafkaTemplate<String, CinemaUserDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CinemaUserDTO data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<CinemaUserDTO> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "My_Topic_Json")
                .build();

        kafkaTemplate.send(message);
    }

}
