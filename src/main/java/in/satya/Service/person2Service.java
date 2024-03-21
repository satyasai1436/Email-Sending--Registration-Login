package in.satya.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.satya.Entity.Person2;
import in.satya.Repo.person2Repo;

@Service
public class person2Service {
    @Autowired
    private person2Repo Repo;

    @Autowired
    private JavaMailSender emailSender;// Inject the emailSender service
    

    public Person2 setData(Person2 p) {
        Person2 data = Repo.save(p);
        if (data.getpId() != null) {
            // Send registration email
            sendRegistrationEmail(data.getEmail());
        }
        return data;
    }

    private void sendRegistrationEmail(String email) {
        String subject = "Registration Confirmation";
        String text = "Thank you for registering with our application.";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message); // Use emailSender service to send email
    }

    public boolean validateUser(String email, String password) {
        
    	Optional<Person2> byEmailAndPassword = Repo.findByEmailAndPassword(email, password);
    	
    	if(byEmailAndPassword.isPresent()) {
    		Person2 person2 = byEmailAndPassword.get();
    		System.out.println(person2.getName() + " "+ person2.getpId());
    		return byEmailAndPassword.get().getpId() != null ? true : false;
    	}else {
    		return false;
    	}
    	
    }

}
