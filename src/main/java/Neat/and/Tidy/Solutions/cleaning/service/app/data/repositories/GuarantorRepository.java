package Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Guarantor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuarantorRepository extends JpaRepository<Guarantor, Long> {
    Guarantor findGuarantorByEmailIgnoreCase(String email);
}
