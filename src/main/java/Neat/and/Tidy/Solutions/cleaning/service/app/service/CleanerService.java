package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import org.springframework.stereotype.Service;

@Service
public interface CleanerService {
    Cleaner register(RegisterCleanerRequest registerCleanerRequest);
    LoginResponse login(LoginRequest loginRequest);

}
