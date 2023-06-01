package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @Column(unique = true)
    private String fullName;
    @Column(unique = true)
    private String email;
    private String password;
    private String contactNumber;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String token;
    @Column(columnDefinition = "Timestamp")
    private LocalDateTime tokenCreationDateTime;
}

