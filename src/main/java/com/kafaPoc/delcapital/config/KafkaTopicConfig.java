package com.kafaPoc.delcapital.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic delcapitalTopic(){
        return TopicBuilder.name("payment-upload")
                .build();
    }

    @Bean
    public NewTopic delcapitalTopic2(){
        return TopicBuilder.name("payment")
                .build();
    }
}
