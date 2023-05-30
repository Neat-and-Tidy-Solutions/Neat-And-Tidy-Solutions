package Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories;

//import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Admin;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AppUser, Long> {
//    Optional<Admin> findByUsername(String username);
//    boolean isUsernameTaken(String username);

}
