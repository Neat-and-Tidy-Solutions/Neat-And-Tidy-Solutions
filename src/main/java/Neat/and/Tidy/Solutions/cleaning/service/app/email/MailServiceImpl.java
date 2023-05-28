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

    private Admin admin;

    public void send(String to, String email) throws MessagingException {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject("Invitation to become an admin of our cleaning service industry");
            mimeMessageHelper.setFrom("em123nest@gmail.com");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText(email,

                    "Dear " + admin.getName() + ", \n\n" +
                            "We are pleased to invite you to become an admin of the cleaning service industry. As an admin, you will have the ability to manage users, create and edit cleaning jobs, and track the progress of cleaning jobs. \n\n" +
                            "To accept this invitation, please click on the following link: \n\n" +
                            "http://localhost:8080/admin/accept-invitation \n\n" +
                            "Thank you for your time and consideration. \n\n" +
                            "Sincerely, \n\n" +
                            "The NTSJ Cleaning Service Industry Team");
            javaMailSender.send(mimeMessage);
        }catch(MessagingException e) {
            log.info("problem2: ");
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }


//    @Override
//    public MailServiceImpl(JavaMailSender mailSender) {
//        this.javaMailSender = javaMailSender;
//    }

    //    public void send(MailMessage) throws MessagingException {
//        try {
//            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//            mimeMessageHelper.setSubject("Invitation to become an admin of our cleaning service industry");
//            mimeMessageHelper.setFrom("em123nest@gmail.com");
//            mimeMessageHelper.setTo();
//            mimeMessageHelper.setText(email, true);
//            javaMailSender.send(mimeMessage);
//        }catch(MessagingException e) {
//            log.info("problem2: ");
//            log.info(e.getMessage());
//            throw RuntimeException(e);
//        }
//    }
}
