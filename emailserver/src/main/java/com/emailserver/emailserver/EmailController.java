package com.emailserver.emailserver;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	
	@Autowired
	private EmailAlert emailAlert;

	@RequestMapping("/send-mail")
	public void sendMail() throws MessagingException {
		
		emailAlert.send("afirealert@gmail.com", "Fire Alert !", "This is an emergency fire alert!!!");
		
	}

}
