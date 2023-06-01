package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import com.github.fge.jsonpatch.JsonPatch;

import java.util.List;

public interface CustomerService {
//    UpdateCustomerDetailResponse updateProfile(UpdateCustomerRequest updateCustomerRequest);
    Customer updateProfile(Long customerId, JsonPatch updatePayload);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
//    List<Customer> getCleaners();
//    void deleteCustomerById(Long id);


}
