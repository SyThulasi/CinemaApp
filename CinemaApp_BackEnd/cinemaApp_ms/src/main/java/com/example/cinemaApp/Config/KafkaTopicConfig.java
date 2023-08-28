package com.example.cinemaApp.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic MyFirstTopic(){
        return TopicBuilder.name("My_Topic")
                .build();
    }

    @Bean
    public NewTopic MyJsonFirstTopic(){
        return TopicBuilder.name("My_Topic_Json")
                .build();
    }
}
