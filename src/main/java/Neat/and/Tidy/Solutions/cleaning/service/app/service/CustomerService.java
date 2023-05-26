package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCustomerResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;

import java.util.List;

public interface CustomerService {
    RegisterCustomerResponse updateProfile(UpdateCustomerRequest updateCustomerRequest);
    Customer getCustomerById(Long id);
    List<Customer> getCleaners();
    void deleteCustomerById(Long id);


}
