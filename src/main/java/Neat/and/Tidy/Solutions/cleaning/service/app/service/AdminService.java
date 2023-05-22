package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Booking;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Feedback;

import java.util.List;

public interface AdminService {
    void approveCleaner(Long cleanerId);
    List<Booking> rejectCleaner(Long cleanerId);
    List<Booking> viewCleanerHistory(Long cleanerId);
    List<Booking> viewCustomerHistory(Long cleanerId);
    List<Feedback> reviewFeedbacks();
    void deleteCleaner(Long cleanerId);
}
