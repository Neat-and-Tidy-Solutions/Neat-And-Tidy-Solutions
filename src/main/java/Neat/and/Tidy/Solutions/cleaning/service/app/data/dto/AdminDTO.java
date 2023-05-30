package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto;

//import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Admin;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
}
