package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCustomerResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CustomerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.UserAlreadyExistsException;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//@AllArgsConstructor
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
private CustomerRepository customerRepository;
private BCryptPasswordEncoder passwordEncoder;

    public CustomerServiceImpl(CustomerRepository customerRepository, BCryptPasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterCustomerResponse register(RegisterCustomerRequest registerCustomerRequest) {
        Optional<Customer> customer = customerRepository.findByEmail(registerCustomerRequest.getEmail());
        if(customer.isPresent()) throw new UserAlreadyExistsException("Customer with email address exists already!");
        Customer customerToBeCreated = Customer.builder()
                .address(registerCustomerRequest.getAddress())
                .firstName(registerCustomerRequest.getFirstName())
                .secondName(registerCustomerRequest.getSecondName())
                .gender(registerCustomerRequest.getGender())
                .password(passwordEncoder.encode(registerCustomerRequest.getPassword()))
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
        Customer customer = customerRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()-> new UserNotFoundException("User with this email not found"));
        if (passwordEncoder.matches(loginRequest.getPassword(), customer.getPassword()))return true;
        return false;
    }

}
