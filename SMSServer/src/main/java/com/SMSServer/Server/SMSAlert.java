package com.SMSServer.Server;

import java.io.Serializable;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component
public class SMSAlert implements Serializable {
	
    private static final String ACCOUNT_SID = "AC591f0ae975834806acebdeee5239c449";
    private static final String AUTH_TOKEN = "29cad427d6840ee62626fa0b437ddfa1";
    
    public SMSAlert() {
    }
    
    public void sendsms(String... args) throws Exception {
        Twilio.init("AC591f0ae975834806acebdeee5239c449", "29cad427d6840ee62626fa0b437ddfa1");
        Message.creator(new PhoneNumber("+94778702750"), new PhoneNumber("+12183963759"), "This is an emergency fire alert!!!").create();
}
}


