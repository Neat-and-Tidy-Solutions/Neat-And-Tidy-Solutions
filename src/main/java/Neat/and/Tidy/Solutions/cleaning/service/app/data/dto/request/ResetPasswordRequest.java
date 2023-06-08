package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String token;
    private String newPassword;
}
