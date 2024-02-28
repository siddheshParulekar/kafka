package com.kafaPoc.delcapital.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafaPoc.delcapital.request.PaymentReconciliationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaJsonProducer {


    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    @Autowired
    private KafkaTemplate<String, PaymentReconciliationRequest > kafkaTemplate;

    public void sendMessage(PaymentReconciliationRequest paymentReconciliationRequest)  {

        Message<PaymentReconciliationRequest> message = MessageBuilder
                .withPayload(paymentReconciliationRequest)
                .setHeader(KafkaHeaders.TOPIC,"payment")
                .build();
        LOGGER.info("Message send 1 ");
        kafkaTemplate.send(message);
        LOGGER.info("Message send  ");
    }

}
