package Neat.and.Tidy.Solutions.cleaning.service.app.controller;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Booking;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Feedback;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/cleaner/approve/{cleanerId}")
    public ResponseEntity<String> approveCleaner(@PathVariable Long cleanerId) {
        adminService.approveCleaner(cleanerId);
        return ResponseEntity.ok("Cleaner approved successfully");
    }

    @PostMapping("/cleaner/reject/{cleanerId}")
    public ResponseEntity<String> rejectCleaner(@PathVariable Long cleanerId) {
        adminService.rejectCleaner(cleanerId);
        return ResponseEntity.ok("Cleaner rejected successfully");
    }

    @GetMapping("/cleaner/{cleanerId}/history")
    public ResponseEntity<List<Booking>> viewCleanerHistory(@PathVariable Long cleanerId) {
        List<Booking> cleanerHistory = adminService.viewCleanerHistory(cleanerId);
        return ResponseEntity.ok(cleanerHistory);
    }

    @GetMapping("/customer/{customerId}/history")
    public ResponseEntity<List<Booking>> viewCustomerHistory(@PathVariable Long customerId) {
        List<Booking> customerHistory = adminService.viewCustomerHistory(customerId);
        return ResponseEntity.ok(customerHistory);
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> reviewFeedbacks() {
        List<Feedback> feedbacks = adminService.reviewFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    @DeleteMapping("/cleaner/{cleanerId}")
    public ResponseEntity<String> deleteCleaner(@PathVariable Long cleanerId) {
        adminService.deleteCleaner(cleanerId);
        return ResponseEntity.ok("Cleaner deleted successfully");
    }
}
