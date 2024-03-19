package pe.company.service;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.activation.DataSource;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

@Service
public class EmailService {
@Autowired
    private  JavaMailSender javaMailSender;


	    public void sendEmail(String to, String subject, String text, byte[] attachment, String attachmentName) throws MessagingException, UnsupportedEncodingException {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);

	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(text);

	        // Crear un DataSource a partir del array de bytes
	        DataSource dataSource = new ByteArrayDataSource(attachment, "application/pdf");

	        helper.setFrom("parker.greenfelder@ethereal.email");

	        // Agregar el archivo adjunto utilizando el DataSource
	        helper.addAttachment(attachmentName, dataSource);

	        javaMailSender.send(message);
	    }
 
}
