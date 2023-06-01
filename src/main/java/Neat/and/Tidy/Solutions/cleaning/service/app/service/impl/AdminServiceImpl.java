package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.email.MailServiceImpl;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.BadRequestException;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.ResourceNotFoundException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AdminService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CleanerRepository cleanerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private MailServiceImpl mailServiceImpl;

    @Autowired
    private AppUserRepository appUserRepository;

//    @Autowired
    private AppUser appUser;



//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail(Cleaner) throws MessagingException {
//        AppUser = appUserRepository.findById(cleaner);
//        mailServiceImpl.sendEmail("er123nest@gmail.com",
//                "Invitation to be an Admin of NTJS Cleaning Company",
//                    "Dear " + appUser.getFullName() + ", \n\n" +
//                            "We are pleased to invite you to become an admin of the cleaning service industry. As an admin, you will have the ability to manage users, create and edit cleaning jobs, and track the progress of cleaning jobs. \n\n" +
//                            "To accept this invitation, please click on the following link: \n\n" +
//                            "http://localhost:8080/admin/accept-invitation \n\n" +
//                            "Thank you for your time and consideration. \n\n" +
//                            "Sincerely, \n\n" +
//                            "The NTSJ Cleaning Service Industry Team"
//        );

//    }


    public boolean approveCleaner(@PathVariable Long cleanerId) throws ResourceNotFoundException {
        Cleaner cleaner = cleanerRepository.findById(cleanerId).orElseThrow(() -> new ResourceNotFoundException("Cleaner not found with id: " + cleanerId));
        Guarantor guarantor = new Guarantor();
        if (cleaner.getGuarantor().isMissingNecessaryAttributes(guarantor)) {
            throw new BadRequestException("Guarantor is missing necessary attributes");
        } else {
            cleaner.setStatus(CleanerStatus.APPROVED);
            cleanerRepository.save(cleaner);
        }
        return true;
    }


//    @Override
//    public boolean approveCleaner(Long cleanerId) {
//        Optional<Cleaner> optionalCleaner = cleanerRepository.findById(cleanerId);
//        if (optionalCleaner.isEmpty()) {
//            // Cleaner not found
//            return false;
//        }
//        Cleaner cleaner = optionalCleaner.get();
//        Guarantor guarantor = cleaner.getGuarantor();
//
//        if (guarantor == null || !isGuarantorAttributesComplete(guarantor)) {
//            // Guarantor is missing necessary attributes
//            return false;
//        }
//        cleaner.setApproved(true);
//        cleanerRepository.save(cleaner);
//
//
////        Optional<Cleaner> optionalCleaner = cleanerRepository.findById(cleanerId);
////        if(optionalCleaner.isPresent()) {
////            Cleaner cleaner = optionalCleaner.get();
////            cleaner.setApproved(true);
////            cleanerRepository.save(cleaner);
////        } else {
////            throw new IllegalArgumentException("Cleaner not found with ID" + cleanerId);
////        }
//        return false;
//    }

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
