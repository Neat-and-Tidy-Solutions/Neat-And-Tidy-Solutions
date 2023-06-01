package Neat.and.Tidy.Solutions.cleaning.service.app.controller;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.AppUserRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.LoginRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.AppUserResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/appUser")
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
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody String email){
        String response = appUserService.forgotPassword(email);
        if(!response.startsWith("Invalid")){
            response = "http://localhost:8080/reset-password?token=" + response;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody String token, @RequestBody String newPassword){
        String setPassword = appUserService.resetPassword(token, newPassword);
        return new ResponseEntity<>(setPassword, HttpStatus.OK);
    }
}
