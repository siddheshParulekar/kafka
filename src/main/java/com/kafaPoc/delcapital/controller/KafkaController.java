package com.kafaPoc.delcapital.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafaPoc.delcapital.request.PaymentReconciliationRequest;
import com.kafaPoc.delcapital.service.KafkaJsonProducer;
import com.kafaPoc.delcapital.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaJsonProducer kafkaJsonProducer;



    @GetMapping("/send-msg")
    public ResponseEntity<String> sendMessage(@RequestParam("Msg") String msg){
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message has been sent");
    }


    @PostMapping("/payment-upload")
    public ResponseEntity<String> paymentUpload(@RequestBody PaymentReconciliationRequest paymentReconciliationRequest)  {
        kafkaJsonProducer.sendMessage(paymentReconciliationRequest);
        return ResponseEntity.ok("Message has been sent");
    }

}
