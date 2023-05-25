package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;

import java.util.List;

public interface CleanerService {
    RegisterCleanerResponse updateProfile(UpdateCleanerRequest registerCleanerRequest);

    Cleaner getCleanerById(long id);
    List<Cleaner> getCleaners();

    void deleteCleanerById(long id);
}
