package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;




@Service
@Slf4j
@AllArgsConstructor
public class MailServiceImpl implements MailService{

    private final MailConfig mailConfig;
    @Override
    public String sendMail(EmailRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", mailConfig.getApiKey());
        HttpEntity<EmailRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(mailConfig.getMailUrl(), requestEntity, String.class);
        log.info("res->{}", response);
        return response.getBody();

    }


//    @Autowired
//    private final JavaMailSender;
//
//    public void sendEmail(String toEmail, String subject, String body) throws MessagingException {
//        try {
//            log.info("problem1: ");
//            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//            log.info("problem2: ");
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//            log.info("problem3: ");
//            mimeMessageHelper.setFrom("em123nest@gmail.com");
//            log.info("problem4: ");
//            mimeMessageHelper.setTo(toEmail);
//            log.info("problem5: ");
//            mimeMessageHelper.setText(body);
//            log.info("problem6: ");
//            mimeMessageHelper.setSubject(subject);
//            log.info("problem7: ");
//            javaMailSender.send(mimeMessage);
//            log.info("problem8: ");
//        }catch(MessagingException e) {
//            log.info("problem9: ");
//            log.info(e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }


}
