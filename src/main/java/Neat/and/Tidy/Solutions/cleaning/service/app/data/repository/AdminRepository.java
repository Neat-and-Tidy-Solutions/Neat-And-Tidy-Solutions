package Neat.and.Tidy.Solutions.cleaning.service.app.data.repository;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
