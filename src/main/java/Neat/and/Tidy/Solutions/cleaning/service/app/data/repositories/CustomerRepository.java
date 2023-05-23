package Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
