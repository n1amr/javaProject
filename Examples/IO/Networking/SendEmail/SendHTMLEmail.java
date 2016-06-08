package com.n1amr;

import java.util.*;

import javax.activation.*;

public class SendHTMLEmail {
	public static void main(String[] args) {
		String TO_MAIL = "abcd@gmail.com";
		String FROM_MAIL = "web@gmail.com";
		// Assuming you are sending email from localhost
		String HOST = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", HOST);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(FROM_MAIL));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO_MAIL));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Send the actual HTML message, as big as you like
			message.setContent("<h1>This is actual message</h1>", "text/html");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}