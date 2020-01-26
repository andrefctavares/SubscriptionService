package com.iban.demo;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iban.amqp.AMQP;
import com.iban.support.IncomingMessage;

@RestController
public class Controller {
    @PostMapping("/api/v1/subscription")
    public String subscription(@Valid @RequestBody IncomingMessage IncomingBody) {

        AMQP publish = new AMQP();    	
        Boolean rsp = publish.publishMessage(IncomingBody.getBody(IncomingBody));
       
        if(rsp!=false) {
        	return "The request was successfully submitted";
        }else {
        	return "An Error occurred and your request was not successfully submitted";
        }
        
    
    }
}

