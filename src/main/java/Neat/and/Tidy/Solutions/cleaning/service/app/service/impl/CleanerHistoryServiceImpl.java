package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repository.CleanerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.CleanerHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleanerHistoryServiceImpl implements CleanerHistoryService {
    private final CleanerRepository cleanerRepository;

    @Autowired
    public CleanerHistoryServiceImpl(CleanerRepository cleanerRepository) {
        this.cleanerRepository = cleanerRepository;
    }

    @Override
    public List<Cleaner> getCleanerHistory(Long cleanerId) {
        // Retrieve cleaner history from the database based on the cleanerId
        return cleanerRepository.findByCleanerId(cleanerId);
    }
}
