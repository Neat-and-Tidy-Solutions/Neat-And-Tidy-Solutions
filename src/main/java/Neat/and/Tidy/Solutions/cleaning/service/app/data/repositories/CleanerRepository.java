package Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
public interface CleanerRepository extends JpaRepository<Cleaner, Long> {
=======
import java.util.Optional;

public interface CleanerRepository extends JpaRepository<Cleaner, Long> {
    Optional<Cleaner> findByEmail(String email);
>>>>>>> 86c0bdf384fc61d4669ba4734f9abaa728f84f54
}
