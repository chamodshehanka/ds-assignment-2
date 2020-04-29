package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import model.Response;
import service.EmailService;
import model.EmailAlert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/email")
public class serverController
{
	@Autowired
	private EmailService service;
	
	@PostMapping("/sendMail")
	public Response sendMail(@RequestBody EmailAlert mail) {
		return service.sendEmail(mail);
	}
}
