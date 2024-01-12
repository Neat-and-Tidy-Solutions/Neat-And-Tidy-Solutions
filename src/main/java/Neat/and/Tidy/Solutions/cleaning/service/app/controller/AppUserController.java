package Neat.and.Tidy.Solutions.cleaning.service.app.controller;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.AppUserRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.ForgetPasswordRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.ResetPasswordRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.AppUserResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/app_user")
public class AppUserController {
    private final AppUserService appUserService;
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AppUserRequest appUserRequest){
        appUserService.register(appUserRequest);
        return ResponseEntity.ok("Registration successful");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUserRequest appUserRequest){
        AppUserResponse appUserResponse = appUserService.login(appUserRequest);
//        return new ResponseEntity<>(appUserResponse, HttpStatus.ACCEPTED);
        return ResponseEntity.ok("Login successful");
    }
//    @PostMapping("/forgot-password")
//    public ResponseEntity<?> forgotPassword(@RequestBody String email){
//        String response = appUserService.forgotPassword(email);
////        if(!response.startsWith("Invalid")){
////            response = "Invalid email";
////        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
    @PostMapping("/forget_password")
    public ResponseEntity<?> forgetPassword(@RequestBody ForgetPasswordRequest forgetPasswordRequest) {
        String response = appUserService.forgotPassword(forgetPasswordRequest);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest){
        String setPassword = appUserService.resetPassword(resetPasswordRequest);
        return new ResponseEntity<>(setPassword, HttpStatus.OK);
    }
}
