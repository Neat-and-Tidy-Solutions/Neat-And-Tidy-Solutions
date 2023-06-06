package Neat.and.Tidy.Solutions.cleaning.service.app.controller;

//import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.CreateServiceRequest;
//import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCustomerRequest;
//import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.CreateServiceResponse;
//import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.FindServiceResponse;
//import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCustomerResponse;
//import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.UpdateCustomerDetailResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCleanerRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCustomerRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.AppUserResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.UpdateCustomerResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AppUserService;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.BookingService;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.CustomerService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
   private final BookingService bookingService;
   private final CustomerService customerService;
   private final AppUserService appUserService;

//    @PatchMapping(value = "/{customerId}", consumes = "application/json-patch+json")
//    public ResponseEntity<?> updateProfile(@PathVariable Long customerId, @RequestBody JsonPatch updatePatch){
//        try{
//            var response = customerService.updateProfile(customerId, updatePatch);
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//        }catch (Exception exception){
//            return ResponseEntity.badRequest().body(exception.getMessage());
//        }
//    }
    @PutMapping("/update_customer_profile")
    public AppUserResponse updateCustomerResponse(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        return appUserService.updateCustomerProfile(updateCustomerRequest);
    }

    @GetMapping("/get_customer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        Customer customerGotten = customerService.getCustomerById(id);
        return new ResponseEntity<>(customerGotten, HttpStatus.OK);
    }
    @GetMapping("/all_customers")
    public ResponseEntity<?> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
