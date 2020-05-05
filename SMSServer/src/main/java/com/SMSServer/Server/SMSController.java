package com.SMSServer.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {
    @Autowired
    private SMSAlert smsalert;
    public SMSController() {
    }
    @RequestMapping({"/send-sms"})
    public void send() throws Exception {
        this.smsalert.sendsms(new String[0]);
    }
}