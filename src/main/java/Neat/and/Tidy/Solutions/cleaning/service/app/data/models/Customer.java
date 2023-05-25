package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private AppUser userDetails;
    private String contactNumber;
    private String email;
    private String password;
    private String address;
    private Gender gender;
}
