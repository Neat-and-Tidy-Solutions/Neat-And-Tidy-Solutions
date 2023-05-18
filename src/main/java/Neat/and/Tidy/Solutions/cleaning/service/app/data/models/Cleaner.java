package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cleaner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String profileImage;
    private String contactNumber;
    private String address;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Guarantor guarantor;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
}
