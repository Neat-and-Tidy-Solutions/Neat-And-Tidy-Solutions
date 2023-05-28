package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import jakarta.mail.MessagingException;

public interface MailService {
    void send(String to, String email) throws MessagingException;
}
