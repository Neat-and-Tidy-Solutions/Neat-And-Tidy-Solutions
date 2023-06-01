package Neat.and.Tidy.Solutions.cleaning.service.app.email;

public interface SendMailService {
    String sendMail(EmailSendingRequest request);

    void send(String to);

//    String sendCustomerMail(EmailSendingRequest request);
//    String sendCustomerMail(EmailSendingRequest request);
}
