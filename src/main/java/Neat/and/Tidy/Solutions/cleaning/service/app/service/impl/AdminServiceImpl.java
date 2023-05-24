package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AdminRepository;
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
    private final AdminRepository adminRepository;

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
}
