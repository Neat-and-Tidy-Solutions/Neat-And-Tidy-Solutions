package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.AppUserRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.ForgetPasswordRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.ResetPasswordRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCustomerRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.AppUserResponse;

public interface AppUserService {
    AppUserResponse register(AppUserRequest appUserRequest);
    AppUserResponse updateCustomerProfile(UpdateCustomerRequest updateCustomerRequest);
    AppUserResponse login(AppUserRequest appUserRequest);
    String forgotPassword(ForgetPasswordRequest forgetPasswordRequest);
    String resetPassword(ResetPasswordRequest resetPasswordRequest);
    String generateCustomerToken();

}
