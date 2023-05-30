package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCustomerResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    RegisterCustomerResponse updateProfile(UpdateCustomerRequest updateCustomerRequest);
    Customer getCustomerById(Long id);
    List<Customer> getCleaners();
    void deleteCustomerById(Long id);
}
