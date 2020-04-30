package com.sms.server.SMSServer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SmsServerApplication implements CommandLineRunner{
	
	private final static String ACCOUNT_SID ="AC591f0ae975834806acebdeee5239c449";
	private final static String AUTH_TOKEN = "29cad427d6840ee62626fa0b437ddfa1";

	public static void main(String[] args) {
		SpringApplication.run(SmsServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
		Message.creator(new PhoneNumber("+94778702750"), new PhoneNumber("+12183963759"), "Fire Alert !").create(); 
	}
	

}
