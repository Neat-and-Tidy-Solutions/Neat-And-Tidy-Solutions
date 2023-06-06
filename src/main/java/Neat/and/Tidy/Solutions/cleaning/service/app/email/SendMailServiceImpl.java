package Neat.and.Tidy.Solutions.cleaning.service.app.email;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SendMailServiceImpl implements SendMailService{
    private final MailService mailService;
    private final JavaMailSender javaMailSender;
//    private final AppUserService appUserService;
    @Override
    public String sendMail(EmailSendingRequest request) {
        EmailRequest emailRequest = EmailRequest.builder()
                .to(List.of(new Recipient(request.getRecipientName(), request.getRecipientEmail())))
                .subject("Welcome Admin")
                .htmlContent("I want to send an email")
                .build();
        return mailService.sendMail(emailRequest);
    }

    @Override
    public String sendMailToCustomer(EmailSendingRequest request) {
        EmailRequest emailRequest = EmailRequest.builder()
                .to(List.of(new Recipient(request.getRecipientName(), request.getRecipientName())))
                .subject("CONGRATULATIONS OUR DEAR ESTEEMED CUSTOMER")
                .htmlContent(" We are pleased to say that you have successfully registered on our platform." +
                        " Click on the link below to have access to your dashboard." +
                        "http://localhost:8080/customer/dashboard. " +
                        "Thank you for your time and consideration. " +
                        "Sincerely, " +
                                "The NTSJ Cleaning Service Industry Team")
                .build();
        //emailRequest.getTo().add(new Recipient(request.getRecipientName(), request.getRecipientEmail()));
        return mailService.sendMail(emailRequest);
    }

    @Override
    public void send(String to) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setFrom("neattidyservices@gmail.com");
        mailMessage.setSubject("CONGRATULATIONS OUR DEAR ESTEEMED CUSTOMER");
        mailMessage.setText("We are pleased to say that you have successfully registered on our platform." +
                "Click on the link below to have access to your dashboard." +
                        "http://localhost:8080/customer/dashboard. " +
                        "Thank you for your time and consideration. " +
                        "Sincerely, " +
                        "The NTSJ Cleaning Service Industry Team");
        javaMailSender.send(mailMessage);
    }

//    public void sendToken(String to){
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setText(to);
//        mailMessage.setFrom("neattidyservices@gmail.com");
//        mailMessage.setSubject("CHANGE PASSWORD TOKEN.");
//        mailMessage.setText("Please do not share with any other.");
//        mailMessage.setReplyTo(appUserService.generateCustomerToken());
//        javaMailSender.send(mailMessage);
//    }
}
