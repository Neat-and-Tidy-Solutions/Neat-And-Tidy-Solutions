package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.AppUserRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.LoginRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.AppUserResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;

public interface AppUserService {
    AppUserResponse register(AppUserRequest appUserRequest);
    AppUserResponse login(AppUserRequest appUserRequest);
    String forgotPassword(String email);
    String resetPassword(String token, String newPassword);

}
