package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class ViewCleanerHistoryRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String profileImage;
    private String contactNumber;
    private String address;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
}
