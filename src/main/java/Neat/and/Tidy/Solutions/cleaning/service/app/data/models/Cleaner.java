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
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    private AppUser appuser;
    private String profileImage;
    private String address;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Guarantor guarantor;
}
