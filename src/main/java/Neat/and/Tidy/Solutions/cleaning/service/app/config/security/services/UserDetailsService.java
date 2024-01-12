//package Neat.and.Tidy.Solutions.cleaning.service.app.config.security.services;
//
//import Neat.and.Tidy.Solutions.cleaning.service.app.config.security.users.SecureUser;
//import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@AllArgsConstructor
//@Service
//public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
//    private final AppUserService appUserService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppUser user = appUserService.getByEmail(username);
//        return new SecureUser(user);
//    }
//}
