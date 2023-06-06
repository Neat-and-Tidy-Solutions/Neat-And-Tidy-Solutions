package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.AppUserRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.ForgetPasswordRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.ResetPasswordRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCustomerRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.AppUserResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AppUserRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CustomerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.email.EmailSendingRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.email.MailService;
import Neat.and.Tidy.Solutions.cleaning.service.app.email.SendMailService;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.NTSManagementException;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.TokenNotFoundException;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.UserNotFoundException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final SendMailService sendMailService;
    private final JavaMailSender javaMailSender;
    private final CustomerRepository customerRepository;
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

    @Override
    public AppUserResponse register(AppUserRequest appUserRequest) {
        AppUser appUser = new AppUser();
        appUser.setUsername(appUserRequest.getUsername());
        appUser.setEmail(appUserRequest.getEmail());
        appUser.setContactNumber(appUserRequest.getContactNumber());
        appUser.setPassword(hashPassword(appUserRequest.getPassword()));
        appUser.setGender(appUserRequest.getGender());
        sendMailService.send(appUserRequest.getEmail());
        appUserRepository.save(appUser);
        return new AppUserResponse("Registration successful",appUser.getUsername());
    }

    public AppUserResponse updateCustomerProfile(UpdateCustomerRequest updateCustomerRequest){
        AppUser foundUser = appUserRepository.findByEmail(updateCustomerRequest.getEmail())
                .orElseThrow(()-> new UserNotFoundException("User not found"));
        //if(Objects.isNull(foundUser)) throw new NTSManagementException("user not found");
        foundUser.setFullName(updateCustomerRequest.getFullName());
        foundUser.setUsername(updateCustomerRequest.getUserName());
        foundUser.setContactNumber(updateCustomerRequest.getContactNumber());
        foundUser.setAddress(updateCustomerRequest.getAddress());
        Customer customer = new Customer();
        customer.setId(foundUser.getId());
        customer.setAddress(foundUser.getAddress());
        customer.setEmail(foundUser.getEmail());
        customer.setContactNumber(foundUser.getContactNumber());
        customer.setFullName(foundUser.getFullName());
        customer.setGender(foundUser.getGender());
        customerRepository.save(customer);
        return new AppUserResponse("Profile updated for user ", foundUser.getUsername());
    }

    @Override
    public AppUserResponse login(AppUserRequest appUserRequest) {
        AppUser foundUser = appUserRepository.findByEmail(appUserRequest.getEmail())
                .orElseThrow(()-> new UserNotFoundException("User not found"));
       // if(Objects.isNull(foundUser)) throw new NTSManagementException("user not found");
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

    @Override
    public String forgotPassword(ForgetPasswordRequest forgetPasswordRequest) {
        AppUser user = appUserRepository.findByEmail(forgetPasswordRequest.getEmail())
                .orElseThrow(()-> new UserNotFoundException("not found"));
        String token = generateCustomerToken();
        user.setToken(token);
        user.setTokenCreationDateTime(LocalDateTime.now());

        SimpleMailMessage simpleMailMessage =  new SimpleMailMessage();
        simpleMailMessage.setFrom("samuelabiodun324@gmail.com");
//        simpleMailMessage.setReplyTo("gibecifi@jollyfree.com");
        simpleMailMessage.setTo("samabiodun89@gmail.com");
        simpleMailMessage.setSubject(" NEAT AND TIDY SOLUTIONS: Reset password token: ");
        simpleMailMessage.setText(String.format("To reset your password, use this token : %s", token));
        javaMailSender.send(simpleMailMessage);
        return appUserRepository.save(user).getToken();
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
//    public String forgotPassword(String email){
//        AppUser appUser = appUserRepository.findByEmail(email)
//                .orElseThrow(()-> new UserNotFoundException("Invalid email id"));
//
////        Optional<AppUser> appUser = Optional.ofNullable(appUserRepository.findByEmail(email));
////        if(appUser.isEmpty()){
////            return "Invalid email id";
////        }
//        //AppUser appUser = appUser.get();
//        appUser.setToken(generateCustomerToken());
//        appUser.setTokenCreationDateTime(LocalDateTime.now());
//        appUser = appUserRepository.save(appUser);
//        return appUser.getToken();
//    }
    public String generateCustomerToken(){
        StringBuilder token = new StringBuilder();
        return token.append(UUID.randomUUID().toString())
                .append(UUID.randomUUID().toString()).toString();
    }
    public String resetPassword(ResetPasswordRequest resetPasswordRequest){
        AppUser user = appUserRepository.findByToken(resetPasswordRequest.getToken())
                .orElseThrow(()-> new TokenNotFoundException("not found"));
        LocalDateTime tokenCreationDateTime = user.getTokenCreationDateTime();
        if(isTokenExpired(tokenCreationDateTime)){
            return  "Token expired";
        }
        user.setPassword(hashPassword(resetPasswordRequest.getNewPassword()));
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
    private Optional<AppUser> getUserByEmail(String email){
        return appUserRepository.findByEmail(email);
    }
}