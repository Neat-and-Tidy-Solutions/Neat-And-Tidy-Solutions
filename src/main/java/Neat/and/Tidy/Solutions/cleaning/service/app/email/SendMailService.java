package Neat.and.Tidy.Solutions.cleaning.service.app.email;

public interface SendMailService {
    String sendMail(EmailSendingRequest request);
    String sendMailToCustomer(EmailSendingRequest request);
    void send(String to);
//    void sendToken(String to);
}
