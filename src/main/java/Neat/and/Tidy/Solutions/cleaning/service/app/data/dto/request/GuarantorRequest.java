package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class GuarantorRequest {
    private String id;
    private String name;
    private String email;
    private MultipartFile profileImage;
    private String contactNumber;
    private String address;
    private String relationship;
}
