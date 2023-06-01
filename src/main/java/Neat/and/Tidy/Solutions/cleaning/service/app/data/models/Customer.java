package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

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

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Booking> bookings;


    private String email;
    private String contactNumber;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AppUser appUser;
    private String address;
    private Gender gender;
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Booking> bookingList;
    @OneToMany
    private List<Booking> bookings;


}
