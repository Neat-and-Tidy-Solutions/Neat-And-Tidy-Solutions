package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCustomerResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    RegisterCustomerResponse register(RegisterCustomerRequest registerCustomerRequest);

    boolean login(LoginRequest loginRequest);

}
