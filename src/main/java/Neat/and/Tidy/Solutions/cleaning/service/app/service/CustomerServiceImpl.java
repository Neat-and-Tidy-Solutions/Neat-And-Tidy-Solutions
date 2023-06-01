package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.LoginRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCustomerRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCustomerResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.UpdateCustomerDetailResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AppUserRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CustomerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.NTSManagementException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService{
    private final AppUserRepository appUserRepository;
    private final CustomerRepository customerRepository;
//    @Override
//    public UpdateCustomerDetailResponse updateProfile(UpdateCustomerRequest updateCustomerRequest) {
//        AppUser foundCustomer = appUserRepository.findByEmailIgnoreCase(updateCustomerRequest.getEmail());
//        Customer customer = new Customer();
//        if(Objects.isNull(foundCustomer)) throw new NTSManagementException("user not found");
//        foundCustomer.setFullName(updateCustomerRequest.getFullName());
//        customer.setAppUser(foundCustomer);
//        customer.setId(foundCustomer.getId());
//        customer.setAddress(updateCustomerRequest.getAddress());
//        customer.setGender(foundCustomer.getGender());
//        customerRepository.save(customer);
//        return UpdateCustomerDetailResponse.builder()
//                .message("Thank you customer "+ foundCustomer.getUsername()
//                        + ", your profile has been updated!")
//                .build();
//    }
    @Override
    public Customer updateProfile(Long customerId, JsonPatch updatePayload) {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer foundCustomer = getCustomerById(customerId);
//        AppUser customerDetails = foundCustomer.getAppUser();
        JsonNode node = objectMapper.convertValue(foundCustomer, JsonNode.class);
        try{
            JsonNode updatedNode = updatePayload.apply(node);
            Customer updatedCustomer = objectMapper.convertValue(updatedNode, Customer.class);

            updatedCustomer = customerRepository.save(updatedCustomer);
            return updatedCustomer;
        }catch (JsonPatchException jsonPatchException){
            log.error(jsonPatchException.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(()->
                new NTSManagementException("Customer not found"));
    }

    public  List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
//    @Override
//    public List<Customer> getCleaners() {
//        return customerRepository.findAll();
//    }

//    @Override
//    public void deleteCustomerById(Long customerId) {
//customerRepository.deleteById(customerId);
//    }


}
