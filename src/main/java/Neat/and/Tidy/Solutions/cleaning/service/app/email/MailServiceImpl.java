package Neat.and.Tidy.Solutions.cleaning.service.app.email;


import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AppUserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class MailServiceImpl implements MailService{

//    @Autowired
    private final JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        try {
            log.info("problem1: ");
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            log.info("problem2: ");
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            log.info("problem3: ");
            mimeMessageHelper.setFrom("em123nest@gmail.com");
            log.info("problem4: ");
            mimeMessageHelper.setTo(toEmail);
            log.info("problem5: ");
            mimeMessageHelper.setText(body);
            log.info("problem6: ");
            mimeMessageHelper.setSubject(subject);
            log.info("problem7: ");
            javaMailSender.send(mimeMessage);
            log.info("problem8: ");
        }catch(MessagingException e) {
            log.info("problem9: ");
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
