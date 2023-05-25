package Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Booking;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
