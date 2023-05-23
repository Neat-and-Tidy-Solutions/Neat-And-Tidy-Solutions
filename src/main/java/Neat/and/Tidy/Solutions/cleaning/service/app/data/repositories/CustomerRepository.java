package Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories;

<<<<<<< HEAD
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
=======
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);

>>>>>>> 86c0bdf384fc61d4669ba4734f9abaa728f84f54
}
