package com.alura.sendemail.service;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Value("${email.host}")
	private String host;

	@Value("${email.port}")
	private Integer smtpPort;

	@Value("${email.username}")
	private String username;

	@Value("${email.password}")
	private String password;

	public void send(String name, String receiverEmail) {
		try {
			Email email = new SimpleEmail();
			email.setHostName(host);
			email.setSmtpPort(smtpPort);
			email.setAuthentication("test@gmail.com", password);
			email.setSSLOnConnect(true);

			email.setFrom("test@gmail.com");
			email.setSubject("Test email");
			email.setMsg("- "+ name + "test message email.");
			email.addTo(receiverEmail);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
