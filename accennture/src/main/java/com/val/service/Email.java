package com.val.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.val.exceptions.MailException;
import com.val.persistence.entity.UsuarioE;



public class Email {
	

	/**
	 * es posible que haya que acudir a esta web
	 * 
	 * https://www.google.com/settings/security/lesssecureapps
	 * 
	 *y aceptar el envío de correos desde "app no seguras"
	 */
	private final static Logger log = Logger.getLogger("mylog");
	
	private static final String REMITE = "valexx55@gmail.com"; //@gmail.com
	private static final String CLAVE = "gvnrmnct29"; //pass gmail.com
	private static final String ASUNTO_OLVIDO = "RDO Credenciales";
	
	
	public static void enviarEmailOlvido (UsuarioE usuario) throws MailException
	{
		String destinatario = usuario.getEmail();
        String from = REMITE;
        String pass = CLAVE;
        String[] to = { destinatario }; // list of recipient email addresses
		String subject = ASUNTO_OLVIDO;

		        Properties props = System.getProperties();
		        String host = "smtp.gmail.com";
		        
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.smtp.host", host);
		        props.put("mail.smtp.user", from);
		        props.put("mail.smtp.password", pass);
		        props.put("mail.smtp.port", "587");
		        props.put("mail.smtp.auth", "true");

		        Session session = Session.getDefaultInstance(props);
		        MimeMessage message = new MimeMessage(session);

		        try {
		            message.setFrom(new InternetAddress(from));
		            InternetAddress[] toAddress = new InternetAddress[to.length];

		            // To get the array of addresses
		            for( int i = 0; i < to.length; i++ ) {
		                toAddress[i] = new InternetAddress(to[i]);
		            }

		            for( int i = 0; i < toAddress.length; i++) {
		                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		            }

		            message.setSubject(subject);
		            
		            String mensaje_html = "<h1>MENSAJE DE RECORDATORIO DE MY APP</h1><br><h1>Sus credenciales son:</h1><br><br><h1>USUARIO "+ usuario.getNombre() +"</h1><br><h1>CLAVE "+ usuario.getPwd() +"</h1>";
		            message.setContent(mensaje_html, "text/html");
		            Transport transport = session.getTransport("smtp");
		            transport.connect(host, from, pass);
		            transport.sendMessage(message, message.getAllRecipients());
		            transport.close();
		        }
		        catch (AddressException ae) {
		        	log.error("Error enviando el Mail de recodatorio (1)", ae);
		        	MailException me = new MailException(ae);
		            //log.error("Error enviando el Mail de recodatorio (1)", ae);
		            throw me;
		        }
		        catch (MessagingException mex) {
		        	MailException me = new MailException(mex);
		            log.error("Error enviando el Mail de recodatorio (1)", mex);
		            throw me;
		        }

	}

}
