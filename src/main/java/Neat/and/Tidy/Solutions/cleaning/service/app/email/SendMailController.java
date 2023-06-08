package Neat.and.Tidy.Solutions.cleaning.service.app.email;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/mail")
public class SendMailController {
    private final SendMailService service;

    @PostMapping("send")
    public ResponseEntity<String> sendMail(@RequestBody EmailSendingRequest request) {
        var response = service.sendMail(request);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/customer")
//    public ResponseEntity<String> sendMailToCustomer(@RequestBody EmailRequest request) {
//        var response : String = service.sendCustomerMail(request);
//        return ResponseEntity.ok()
//    }

}
