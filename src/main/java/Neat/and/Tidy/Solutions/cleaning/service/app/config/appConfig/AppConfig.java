//package Neat.and.Tidy.Solutions.cleaning.service.app.config.appConfig;
//
//import Neat.and.Tidy.Solutions.cleaning.service.app.config.security.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
//
//@Configuration
//public class AppConfig {
//    @Value("${jwtSecret}")
//    private String jwtSecret;
//
//    @Bean
//    public JwtUtil jwtUtil(){
//        return new JwtUtil(jwtSecret);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}
