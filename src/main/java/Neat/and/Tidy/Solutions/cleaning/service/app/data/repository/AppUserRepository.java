package Neat.and.Tidy.Solutions.cleaning.service.app.data.repository;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String email);
}
