package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.AdminDTO;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Admin;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Booking;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Feedback;

import java.util.List;

public interface AdminService {
//    String registerAdmin(AdminDTO admin);
//    String login(String username, String password);
    void approveCleaner(Long cleanerId);
    List<Booking> rejectCleaner(Long cleanerId);
    List<Booking> viewCleanerHistory(Long cleanerId);
    List<Booking> viewCustomerHistory(Long cleanerId);
    List<Feedback> reviewFeedbacks();
    void deleteCleaner(Long cleanerId);
    boolean update(Admin admin);
}
