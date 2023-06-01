package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.AppUserRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.AppUserResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AppUserRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.NTSManagementException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AppUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUserResponse register(AppUserRequest appUserRequest) {
        AppUser appUser = new AppUser();
        appUser.setUsername(appUserRequest.getUsername());
        appUser.setEmailAddress(appUserRequest.getEmail());
        appUser.setContactNumber(appUserRequest.getContactNumber());
        appUser.setPassword(hashPassword(appUserRequest.getPassword()));
        appUserRepository.save(appUser);
        return null;
    }

    @Override
    public AppUserResponse login(AppUserRequest appUserRequest) {
        AppUser foundUser = appUserRepository.findByEmailIgnoreCase(appUserRequest.getEmail());
        if(Objects.isNull(foundUser)) throw new NTSManagementException("user not found");
        try{
            if (!BCrypt.checkpw(appUserRequest.getPassword(), foundUser.getPassword())){
                throw new NTSManagementException("Password does not match");
            }
        } catch(NTSManagementException e){
            throw new RuntimeException(e);
        }
        return AppUserResponse.builder()
                .message("Login successful")
                .build();
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
