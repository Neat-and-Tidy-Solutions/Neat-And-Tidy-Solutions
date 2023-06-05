package Neat.and.Tidy.Solutions.cleaning.service.app.controller;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.AppUserRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.LoginRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.AppUserResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AppUserRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.ResourceNotFoundException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appUser")
public class AppUserController {
    private final AppUserRepository appUserRepository;

    @Autowired
    private AppUserService appUserService;

    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AppUserRequest appUserRequest){
        appUserService.register(appUserRequest);
        return ResponseEntity.ok("Registration successful");
    }

    @GetMapping("/appusers/{email}")
    public AppUser getAppUser(@RequestBody String email) throws ResourceNotFoundException {
        AppUser appUser = appUserRepository.findByEmailIgnoreCase(email);
        if (appUser == null) {
            throw new ResourceNotFoundException("AppUser not found with email: " + email);
        }
        return appUser;
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUserRequest appUserRequest){
        AppUserResponse appUserResponse = appUserService.login(appUserRequest);
//        return new ResponseEntity<>(appUserResponse, HttpStatus.ACCEPTED);
        return ResponseEntity.ok("Login successful");
    }
}
