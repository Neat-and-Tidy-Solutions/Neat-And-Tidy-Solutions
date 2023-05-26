package Neat.and.Tidy.Solutions.cleaning.service.app.controller;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.AppUserRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.LoginRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.AppUserResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
