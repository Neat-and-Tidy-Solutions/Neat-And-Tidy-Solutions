package Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleanerRepository extends JpaRepository<Cleaner, Long> {
}
