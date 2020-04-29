package service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import model.EmailAlert;
import model.Response;

@Service("emailService")
public class ImpEmailService implements EmailService {

	@Override
	public Response sendEmail(EmailAlert mail) {
		
		Response res = new Response();
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(mail.getAdmin());
			message.setSubject(mail.getTitle());
			message.setText(mail.getAlert());
			
			res.setId(0);
			res.setMessage("test done!");
			
		}catch(Exception ex)
		{
			res.setId(1);
			res.setMessage("Error!" + ex.getMessage());	
		}
		
		return res;
	}

}
