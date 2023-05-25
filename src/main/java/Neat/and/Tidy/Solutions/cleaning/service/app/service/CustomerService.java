package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCustomerResponse;

public interface CustomerService {
    RegisterCustomerResponse register(RegisterCustomerRequest registerCustomerRequest);
    boolean login(LoginRequest loginRequest);


}
