package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCustomerRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.UpdateCustomerResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AppUserRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CustomerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.NTSManagementException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final AppUserRepository appUserRepository;
    private final CustomerRepository customerRepository;



//    @Override
//    public Customer updateProfile(Long customerId, JsonPatch updatePayload) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Customer foundCustomer = getCustomerById(customerId);
////        AppUser customerDetails = foundCustomer.getAppUser();
//        JsonNode node = objectMapper.convertValue(foundCustomer, JsonNode.class);
//        try{
//            JsonNode updatedNode = updatePayload.apply(node);
//            Customer updatedCustomer = objectMapper.convertValue(updatedNode, Customer.class);
//
//            updatedCustomer = customerRepository.save(updatedCustomer);
//            return updatedCustomer;
//        }catch (JsonPatchException jsonPatchException){
//            log.error(jsonPatchException.getMessage());
//            throw new RuntimeException();
//        }
//    }

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
