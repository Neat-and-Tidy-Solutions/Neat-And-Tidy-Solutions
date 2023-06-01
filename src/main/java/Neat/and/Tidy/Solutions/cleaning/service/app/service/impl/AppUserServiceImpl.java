package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.AppUserRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.AppUserResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AppUserRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.NTSManagementException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AppUserService;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

    @Override
    public AppUserResponse register(AppUserRequest appUserRequest) {
        AppUser appUser = new AppUser();
        appUser.setUsername(appUserRequest.getUsername());
        appUser.setEmail(appUserRequest.getEmail());
        appUser.setContactNumber(appUserRequest.getContactNumber());
        appUser.setPassword(hashPassword(appUserRequest.getPassword()));
        appUser.setGender(appUserRequest.getGender());
        appUserRepository.save(appUser);
        return new AppUserResponse("Registration successful",appUser.getUsername());
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

    public String forgotPassword(String email){
        Optional<AppUser> appUser = Optional.ofNullable(appUserRepository.findByEmailIgnoreCase(email));
        if(appUser.isEmpty()){
            return "Invalid email id";
        }
        AppUser user = appUser.get();
        user.setToken(generateToken());
        user.setTokenCreationDateTime(LocalDateTime.now());
        user = appUserRepository.save(user);
        return user.getToken();
    }
    private String generateToken(){
        StringBuilder token = new StringBuilder();
        return token.append(UUID.randomUUID().toString())
                .append(UUID.randomUUID().toString()).toString();
    }
    public String resetPassword(String token, String newPassword){
        Optional<AppUser> appUser = Optional.ofNullable(appUserRepository.findByToken(token));
        if(appUser.isEmpty()){
            return "Invalid token";
        }
        LocalDateTime tokenCreationDateTime = appUser.get().getTokenCreationDateTime();
        if(isTokenExpired(tokenCreationDateTime)){
            return  "Token expired";
        }
        AppUser user = appUser.get();
        user.setPassword(newPassword);
        user.setToken(null);
        user.setTokenCreationDateTime(null);
        appUserRepository.save(user);
        return "Password successfully updated ";
        }

    private boolean isTokenExpired(LocalDateTime tokenCreationDateTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration difference = Duration.between(tokenCreationDateTime, now);
        return difference.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }
}