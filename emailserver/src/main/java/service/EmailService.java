package service;

import model.EmailAlert;
import model.Response;


public interface EmailService {
	Response sendEmail(EmailAlert mail);
	
}
