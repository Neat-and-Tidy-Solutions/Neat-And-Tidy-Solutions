package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.HistoryEntry;

import java.util.List;

public interface CleanerHistoryService {
    List<HistoryEntry> getCleanerHistory(String cleanerId);
}
