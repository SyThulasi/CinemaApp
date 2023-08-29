package com.example.cinemaApp.Kafka;

import com.example.cinemaApp.DTO.CinemaUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);



    @KafkaListener(topics = "movie_json", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(CinemaUserDTO user) {

        LOGGER.info(String.format("Json Message received -> %s", user.toString()));
    }

}
