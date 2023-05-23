package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CleanerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CustomerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.FeedbackRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CleanerRepository cleanerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Override
    public void approveCleaner(Long cleanerId) {
        Optional<Cleaner> optionalCleaner = cleanerRepository.findById(cleanerId);
        if(optionalCleaner.isPresent()) {
            Cleaner cleaner = optionalCleaner.get();
            cleaner.setApproved(true);
            cleanerRepository.save(cleaner);
        } else {
            throw new IllegalArgumentException("Cleaner not found with ID" + cleanerId);
        }
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




//    public void addBooking(Booking booking) {
//        if (bookings == null) {
//            bookings = new ArrayList<>();
//        }
//        bookings.add(booking);
//        booking.setCleaner(this);
//    }
//
//    public void removeBooking(Booking booking) {
//        if (bookings != null) {
//            bookings.remove(booking);
//            booking.setCleaner(null);
//        }
//    }


//    @Override
//    public ApiResponse sendInviteRequests(Set<InviteAdminRequest> inviteAdminRequestList) {
//        EmailNotificationRequest request = new EmailNotificationRequest();
//        var recipients = inviteAdminRequestList.stream()
//                .map(inviteAdminRequest -> createAdminProfile(inviteAdminRequest))
//                .map(inviteAdminRequest -> new Recipient(inviteAdminRequest.getUserDetails().getName() ,
//                        inviteAdminRequest.getUserDetails().getEmail()))
//                .toList();
//        request.getTo().addAll(recipients);
//
//
//        String adminMail = AppUtilities.getAdminMailTemplate();
//        request.setHtmlContent(String.format(adminMail, "admin", AppUtilities.generateVerificationLink(0L)));
//        var response = mailService.sendHtmlMail(request);
//        if (response!=null) return ApiResponse.builder().message("invite requests sent").build();
//        throw new BusinessLogicException("invite requests sending failed");
//    }
//
//
//    private Admin createAdminProfile(InviteAdminRequest inviteAdminRequest) {
//        Admin admin = new Admin();
//        admin.setUserDetails(new AppUser());
//        admin.getUserDetails().setName(inviteAdminRequest.getName());
//        admin.getUserDetails().setEmail(inviteAdminRequest.getEmail());
//        return admin;
//    }
}
