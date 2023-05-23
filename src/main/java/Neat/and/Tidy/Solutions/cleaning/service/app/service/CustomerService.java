package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;

public interface CustomerService {
    Customer register(RegisterCustomerRequest registerCustomerRequest);

    boolean validateUser(LoginRequest loginRequest);

}
