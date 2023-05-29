package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Admin;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("em123nest@gmail.com");
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setText(body);
            mimeMessageHelper.setSubject(subject);
            javaMailSender.send(mimeMessage);
            System.out.println("Message sent successfully");
        }catch(MessagingException e) {
            log.info("problem2: ");
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
