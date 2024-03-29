//package Neat.and.Tidy.Solutions.cleaning.service.app.controller;
//
//import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.LoginRequest;
//import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCustomerResponse;
//import Neat.and.Tidy.Solutions.cleaning.service.app.service.CustomerService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/customer")
//@Controller
//@AllArgsConstructor
//public class CustomerController {
//
//    private final CustomerService customerService;
//
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody RegisterCustomerRequest registerCustomerRequest) {
//        RegisterCustomerResponse registerCustomerResponse = customerService.register(registerCustomerRequest);
//        return new ResponseEntity<>(registerCustomerResponse, HttpStatus.CREATED);
//    }
//
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        boolean isLoggedIn = customerService.login(loginRequest);
//
//        if (isLoggedIn) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//        }
//    }
//=======
////
////import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCustomerRequest;
////import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCustomerResponse;
////import Neat.and.Tidy.Solutions.cleaning.service.app.service.CustomerService;
////import lombok.AllArgsConstructor;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.stereotype.Controller;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////@RestController
////@RequestMapping("/customer")
////@Controller
////@AllArgsConstructor
//public class CustomerController {
//////    @Autowired
////    private final CustomerService customerService;
////    @PostMapping("/register")
////    public ResponseEntity<?> register(@RequestBody UpdateCustomerRequest registerCustomerRequest){
////        RegisterCustomerResponse registerCustomerResponse = customerService.updateProfile(registerCustomerRequest);
////        return new ResponseEntity<>(registerCustomerResponse, HttpStatus.CREATED);
////    }
////    @PostMapping("/login")
////    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
////        customerService.login(loginRequest);
////        return ResponseEntity.ok("User logged in");
////    }
//>>>>>>> 0d202051ff43f97ec2acaf76368f24345ff76212
//}
