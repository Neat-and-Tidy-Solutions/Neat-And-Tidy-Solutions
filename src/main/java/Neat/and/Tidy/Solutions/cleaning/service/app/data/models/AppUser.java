package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private String name;

    private String email;

    private String username;

    @Column(unique = true)
    private String emailAddress;

    private String password;

    private CleanerStatus cleanerStatus;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Customer> customerDetails;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Cleaner> cleanersDetails;

    @Column(unique = true)
    private String fullName;

    private String contactNumber;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;
}