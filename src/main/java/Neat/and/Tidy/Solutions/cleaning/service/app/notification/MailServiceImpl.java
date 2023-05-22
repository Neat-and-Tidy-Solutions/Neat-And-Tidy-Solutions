//package Neat.and.Tidy.Solutions.cleaning.service.app.notification;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//public class MailServiceImpl implements MailService{
//
//    private final MailConfig mailConfig;
//
//    @Override
//    public String sendHtmlMail(EmailNotificationRequest request) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("api-key", mailConfig.getApiKey());
//        HttpEntity<EmailNotificationRequest> requestEntity = new HttpEntity<>(request, headers);
//
//        ResponseEntity<String> response =
//                restTemplate.postForEntity(mailConfig.getMailUrl(), requestEntity, String.class);
//        log.info("res->{}", response);
//        return response.getBody();
//    }
//}
