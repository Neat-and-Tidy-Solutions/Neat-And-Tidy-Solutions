package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CleanerHistoryService {
    List<Cleaner> getCleanerHistory();
}
