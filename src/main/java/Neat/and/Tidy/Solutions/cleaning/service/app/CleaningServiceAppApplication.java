package Neat.and.Tidy.Solutions.cleaning.service.app;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Admin;
import Neat.and.Tidy.Solutions.cleaning.service.app.email.MailServiceImpl;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CleaningServiceAppApplication {
	@Autowired
	private MailServiceImpl mailServiceImpl;

	private Admin admin;
	

	public static void main(String[] args) {
		SpringApplication.run(CleaningServiceAppApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() throws MessagingException {
		mailServiceImpl.sendEmail("er123nest@gmail.com",
				"Invitation to be an Admin of NTJS Cleaning Company",
					"Dear " + admin.getName() + ", \n\n" +
							"We are pleased to invite you to become an admin of the cleaning service industry. As an admin, you will have the ability to manage users, create and edit cleaning jobs, and track the progress of cleaning jobs. \n\n" +
							"To accept this invitation, please click on the following link: \n\n" +
							"http://localhost:8080/admin/accept-invitation \n\n" +
							"Thank you for your time and consideration. \n\n" +
							"Sincerely, \n\n" +
							"The NTSJ Cleaning Service Industry Team");

	}
}
