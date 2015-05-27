package com.gmail.andersoninfonet.jsfcomplete.util.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.gmail.andersoninfonet.jsfcomplete.util.jsf.FacesUtil;


public class EmailFactory {
	
	private static final Logger log = Logger.getLogger(EmailFactory.class);

	public Session configuraSessao(){
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.mandrillapp.com"); 
		props.put("mail.smtp.socketFactory.port", "587"); 
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.port", "587"); 
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("andersoninfonet@gmail.com", "CKGeMIykdCkZnoHsTRi-Uw");
			}
		});
		
		session.setDebug(true);
		
		log.info("sessão de email criada !!");
		
		return session;
	}
	
	public boolean enviaEmail(String destinatario, String assunto, String mensagem){
		
		Session sessao = configuraSessao();
		boolean sucesso = false;
		
		try{
			Message msg = new MimeMessage(sessao);
			msg.setFrom(new InternetAddress("andersoninfonet@gmail.com"));
			
			Address[] to = InternetAddress.parse(destinatario);
			
			msg.setRecipients(Message.RecipientType.TO, to);
			msg.setSubject(assunto);
			msg.setText(mensagem);
			
			Transport.send(msg);
			sucesso = true;
			
			log.info("email enviado com sucesso !!");
//			return sucesso;
		}catch(MessagingException e){
			FacesUtil.addErrorMessage("Email não foi enviado !");
			log.error("Email não foi enviado !");
//			throw new RuntimeException(e);
		}
		return sucesso;
		
	}
	
}
