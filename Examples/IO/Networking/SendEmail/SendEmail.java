package com.n1amr;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class SendEmail {
	public static void main(String[] args) {
		String TO_MAIL = "abcd@gmail.com";
		String FROM_MAIL = "web@gmail.com";
		// Assuming you are sending email from localhost
		String HOST = "localhost";

		// Get system properties
		Properties systemProperties = System.getProperties();

		// Setup mail server
		systemProperties.setProperty("mail.smtp.host", HOST);

		props.setProperty("mail.user", "myuser");
		props.setProperty("mail.password", "mypwd");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(systemProperties);

		try {
			// Create a default MimeMessage object.
			MimeMessage mMimeMessage = new MimeMessage(session);

			mMimeMessage.setFrom(new InternetAddress(FROM_MAIL));
			mMimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(TO_MAIL));
			mMimeMessage.setSubject("This is the Subject Line!");
			mMimeMessage.setText("This is actual message");

			// Send message
			Transport.send(mMimeMessage);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}