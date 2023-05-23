package Neat.and.Tidy.Solutions.cleaning.service.app.data.repository;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.HistoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CleanerRepository extends JpaRepository<Cleaner, Long> {

//    List<Cleaner> find(Long cleanerId);

//    void delete(Long cleanerId);
}
