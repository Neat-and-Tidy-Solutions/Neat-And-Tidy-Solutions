package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AdminRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CleanerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CustomerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.FeedbackRepository;
//import Neat.and.Tidy.Solutions.cleaning.service.app.email.MimeMessage;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    @Autowired
    private final AdminRepository adminRepository;

    @Autowired
    private CleanerRepository cleanerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;


//    @Override
//    public void sendInvitation(Admin admin) {
//        // Get the email address of the admin.
//        String emailAddress = admin.getEmailAddress();
//
//        // Create a new email message.
//        MimeMessage mimeMessage = new MimeMessage();
//        mimeMessage.setSubject("Invitation to become an admin of the cleaning service industry");
//        mimeMessage.setRecipient(emailAddress);
//        mimeMessage.setBody(
//                "Dear " + admin.getName() + ", \n\n" +
//                        "We are pleased to invite you to become an admin of the cleaning service industry. As an admin, you will have the ability to manage users, create and edit cleaning jobs, and track the progress of cleaning jobs. \n\n" +
//                        "To accept this invitation, please click on the following link: \n\n" +
//                        "http://localhost:8080/admin/accept-invitation \n\n" +
//                        "Thank you for your time and consideration. \n\n" +
//                        "Sincerely, \n\n" +
//                        "The Cleaning Service Industry Team");
//
//        // Send the email message.
//        mailService.send(mailMessage);
//    }

    @Override
    public boolean approveCleaner(Long cleanerId) {
        Optional<Cleaner> optionalCleaner = cleanerRepository.findById(cleanerId);
        if (optionalCleaner.isEmpty()) {
            // Cleaner not found
            return false;
        }
        Cleaner cleaner = optionalCleaner.get();
        Guarantor guarantor = cleaner.getGuarantor();

        if (guarantor == null || !isGuarantorAttributesComplete(guarantor)) {
            // Guarantor is missing necessary attributes
            return false;
        }
        cleaner.setApproved(true);
        cleanerRepository.save(cleaner);
        
        
//        Optional<Cleaner> optionalCleaner = cleanerRepository.findById(cleanerId);
//        if(optionalCleaner.isPresent()) {
//            Cleaner cleaner = optionalCleaner.get();
//            cleaner.setApproved(true);
//            cleanerRepository.save(cleaner);
//        } else {
//            throw new IllegalArgumentException("Cleaner not found with ID" + cleanerId);
//        }
        return false;
    }

    private boolean isGuarantorAttributesComplete(Guarantor guarantor) {
        // Check if all necessary guarantor attributes are present
        if (guarantor.getName() == null || guarantor.getContactNumber() == null || guarantor.getAddress() == null) {
            return false;
        }
        // Additional checks for other necessary attributes
        return true;
    }

    @Override
    public List<Booking> rejectCleaner(Long cleanerId) {
        Optional<Cleaner> optionalCleaner = cleanerRepository.findById(cleanerId);
        if (optionalCleaner.isPresent()) {
            Cleaner cleaner = optionalCleaner.get();
            return cleaner.getBookings();
        } else {
            throw new IllegalArgumentException("Cleaner not found with ID: " + cleanerId);
        }
    }

    @Override
    public List<Booking> viewCleanerHistory(Long cleanerId)  {
        Optional<Cleaner> optionalCleaner = cleanerRepository.findById(cleanerId);
        if (optionalCleaner.isPresent()) {
            Cleaner cleaner = optionalCleaner.get();
            return cleaner.getBookings();
        } else {
            throw new IllegalArgumentException("Cleaner not found with ID: " + cleanerId);
        }
    }

    @Override
    public List<Booking> viewCustomerHistory(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            return customer.getBookings();
        } else {
            throw new IllegalArgumentException("Customer not found with ID: " + customerId);
        }
    }

    @Override
    public List<Feedback> reviewFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public void deleteCleaner(Long cleanerId) {
        var foundCleaner = cleanerRepository.findById(cleanerId).orElseThrow(()-> new IllegalArgumentException("clearner not found"));
        cleanerRepository.delete(foundCleaner);
    }
}
