package Neat.and.Tidy.Solutions.cleaning.service.app.service;

//import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Admin;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Booking;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Feedback;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
//    void sendInvitation(Admin admin);
    boolean approveCleaner(Long cleanerId) throws ResourceNotFoundException;
    List<Booking> rejectCleaner(Long cleanerId);
    List<Booking> viewCleanerHistory(Long cleanerId);
    List<Booking> viewCustomerHistory(Long cleanerId);
    List<Feedback> reviewFeedbacks();
    void deleteCleaner(Long cleanerId);
}
