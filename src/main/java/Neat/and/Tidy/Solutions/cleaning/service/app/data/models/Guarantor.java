package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import static Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Guarantor.hasName;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Guarantor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String image;
    private String contactNumber;
    private String address;
    private String relationship;
    private boolean isVerified;

    public boolean isMissingNecessaryAttributes(Guarantor guarantor) {
        return !hasName(guarantor) || !hasAddress(guarantor) || !hasContactNumber(guarantor);
    }

    private boolean hasName(Guarantor guarantor) {
        return guarantor.getName() != null && !guarantor.getName().isEmpty();
    }

    private boolean hasAddress(Guarantor guarantor) {
        return guarantor.getAddress() != null && !guarantor.getAddress().isEmpty();
    }

    private boolean hasContactNumber(Guarantor guarantor) {
        return guarantor.getContactNumber() != null && !guarantor.getContactNumber().isEmpty();
    }
}
