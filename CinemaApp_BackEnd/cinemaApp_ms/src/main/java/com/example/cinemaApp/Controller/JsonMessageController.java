package com.example.cinemaApp.Controller;

import com.example.cinemaApp.DTO.BookingRequestDTO;
import com.example.cinemaApp.DTO.MoviePublishDTO;
import com.example.cinemaApp.Kafka.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cinemaUser/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody BookingRequestDTO user){
        jsonKafkaProducer.sendDummyMessage(user);
        return ResponseEntity.ok("Message sent to Kafka topic");
    }

}
