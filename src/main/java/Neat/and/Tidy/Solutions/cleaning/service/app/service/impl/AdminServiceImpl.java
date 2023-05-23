package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.AdminDTO;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AdminRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CleanerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CustomerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.FeedbackRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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

    @Autowired


//
//    @Override
//    public Admin registerAdmin(AdminDTO admin) {
//        // Check if the admin username is already taken
//        if (adminRepository.isUsernameTaken(admin.getUsername())) {
//            return false;
//        }
//        return adminRepository.save(admin);
//    }


//    @Override
//    public String registerAdmin(AdminDTO adminDTO) {
//        boolean isExists = adminService.findByUserName(username)
//        if (adminRepository.existsById() {
//
//        }
//
//        Admin admin = new Admin();
//        admin.setUsername(adminDTO.getUserName());
//        admin.setPassword(adminDTO.getPassword());
//        return adminRepository.save(admin);
//
//    }


//    @Override
//    public boolean login(String username, String password) {
//        // Retrieve the admin with the given username from the database
//        Admin admin = adminRepository.findByUsername(username);
//
//        // Check if the admin exists and the provided password matches
//        if (admin != null && admin.getPassword().equals(password)) {
//            return true; // Login successful
//        }
//
//        return false; // Login failed
//    }

//    @Override
//    public boolean update(Admin admin) {
//        return false;
//    }

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
