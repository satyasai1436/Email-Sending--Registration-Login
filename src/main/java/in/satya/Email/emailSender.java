	package in.satya.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailSender {
	@Autowired
	private JavaMailSender emailSender;

	public void sendEmail(SimpleMailMessage email) {
		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(to);
//		message.setSubject(subject);
//		message.setText(text);
		emailSender.send(message);
	}
}
