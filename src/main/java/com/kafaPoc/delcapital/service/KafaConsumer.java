package com.kafaPoc.delcapital.service;

import com.kafaPoc.delcapital.request.PaymentReconciliationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafaConsumer.class);

//    @KafkaListener(topics = "payment-upload",groupId = "delcapital")
//    public void consume(String msg){
//        LOGGER.info(String.format("Message recieved:   " + msg));
//    }

    @KafkaListener(topics = "payment",groupId = "delcapital")
    public void consume(PaymentReconciliationRequest paymentReconciliationRequest){
        LOGGER.info("mesaage recieved  {}",paymentReconciliationRequest);
    }
}
