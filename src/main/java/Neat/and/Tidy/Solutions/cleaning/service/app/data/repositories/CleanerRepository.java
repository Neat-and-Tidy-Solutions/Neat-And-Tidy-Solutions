package Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CleanerRepository extends JpaRepository<Cleaner, Long> {
    Optional<Cleaner> findByEmail(String email);
}
