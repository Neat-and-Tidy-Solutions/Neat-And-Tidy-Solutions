package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Guarantor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCleanerRequest {
    private String email;
    private String FullName;
    private MultipartFile profileImage;
    private String address;

}
