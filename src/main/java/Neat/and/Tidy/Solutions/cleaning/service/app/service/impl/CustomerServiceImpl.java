package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.LoginRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCustomerRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCustomerResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AppUserRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CustomerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.NTSManagementException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public RegisterCustomerResponse updateProfile(UpdateCustomerRequest updateCustomerRequest) {
        AppUser foundCustomer = appUserRepository.findByEmailIgnoreCase(updateCustomerRequest.getEmail());
        Customer customer = new Customer();
        if(Objects.isNull(foundCustomer)) throw new NTSManagementException("user not found");
        foundCustomer.setFullName(updateCustomerRequest.getFullName());
        customer.setAppUser(foundCustomer);
        customer.setId(foundCustomer.getId());
        customer.setAddress(updateCustomerRequest.getAddress());
        customer.setGender(foundCustomer.getGender());
        customerRepository.save(customer);

        return RegisterCustomerResponse.builder()
                .message("Thank you customer "+ foundCustomer.getUsername()
                        + ", your profile has been updated!")
                .build();
    }
    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(()->
                new NTSManagementException("Customer not found"));
    }

    @Override
    public List<Customer> getCleaners() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomerById(Long customerId) {
customerRepository.deleteById(customerId);
    }


}
