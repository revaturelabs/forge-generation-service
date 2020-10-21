package com.forge.PortfolioGenerationService.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	
	private JavaMailSender jms;

	
	@Autowired
	public EmailServiceImpl(JavaMailSender jms) {
		super();
		this.jms = jms;
	}

	public void send(String to, String title, String body) {
	
				SimpleMailMessage mimeMessage = new SimpleMailMessage();
			
				mimeMessage.setFrom("revature-b416ab@inbox.mailtrap.io");//set who the massage is from
				mimeMessage.setSubject(title); //set the title/subject of the message
				mimeMessage.setText(body); //set the body of the message
				mimeMessage.setTo(to);  //set the receiver
				jms.send(mimeMessage); //actually send the message
					
	}

}
