package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CustomerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.UserAlreadyExistsException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public RegisterCustomerResponse register(RegisterCustomerRequest registerCustomerRequest) {
        Optional<Customer> customer = customerRepository.findByEmail(registerCustomerRequest.getEmail());
        if(customer.isPresent()) throw new UserAlreadyExistsException("Customer with email address exists already");
        Customer customerToBeCreated = Customer.builder()
                .address(registerCustomerRequest.getAddress())
                .firstName(registerCustomerRequest.getFirstName())
                .secondName(registerCustomerRequest.getSecondName())
                .gender(registerCustomerRequest.getGender())
                .contactNumber(registerCustomerRequest.getContactNumber())
                .build();

        Customer newCustomer = customerRepository.save(customerToBeCreated);
        return RegisterCustomerResponse.builder()
                .id(newCustomer.getId())
                .email(newCustomer.getEmail())
                .firstName(newCustomer.getFirstName())
                .secondName(newCustomer.getSecondName())
                .build();
    }

    @Override
    public boolean login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Customer customer = customerRepository.findCustomerByEmailAndPassword(password, email);

        if (customer != null && customer.getPassword().equals(password)) {
            return true; // Login successful
        }

        return false; // Login failed
    }
}
