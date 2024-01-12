package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public String sendCustomerMail(EmailSendingRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", "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");
        HttpEntity<EmailSendingRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("https://api.sendinblue.com/v3/smtp/email", requestEntity, String.class);
        log.info("res->{}", response);
        return response.getBody();
    }



}
