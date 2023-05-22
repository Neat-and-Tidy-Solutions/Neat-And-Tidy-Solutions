package Neat.and.Tidy.Solutions.cleaning.service.app.data.repository;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
