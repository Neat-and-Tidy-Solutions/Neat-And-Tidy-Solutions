package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
    private String address;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String token;
    @Column(columnDefinition = "Timestamp")
    private LocalDateTime tokenCreationDateTime;
}

