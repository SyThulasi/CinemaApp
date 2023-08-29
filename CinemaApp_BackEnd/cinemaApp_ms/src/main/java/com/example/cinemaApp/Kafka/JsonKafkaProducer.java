package com.example.cinemaApp.Kafka;

import com.example.cinemaApp.DTO.CinemaUserDTO;
import com.example.cinemaApp.DTO.MoviePublishDTO;
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
    @Value("movie")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

//    private KafkaTemplate<String, CinemaUserDTO> kafkaTemplate;
    private KafkaTemplate<String, MoviePublishDTO> kafkaTemplate;

    @Autowired
    public JsonKafkaProducer(KafkaTemplate<String, MoviePublishDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MoviePublishDTO data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<MoviePublishDTO> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "movie_json")
                .build();

        kafkaTemplate.send(message);
    }

}
