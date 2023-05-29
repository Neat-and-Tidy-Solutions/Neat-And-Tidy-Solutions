package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import jakarta.mail.MessagingException;

public interface MailService {
    void sendEmail(String toEmail, String subject, String body) throws MessagingException;
}
