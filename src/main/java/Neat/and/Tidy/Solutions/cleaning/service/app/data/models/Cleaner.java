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
@Table(name = "cleaners")
public class Cleaner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "cleanerId")
    private List<Booking> bookings;



    @Column(unique = true)
    private String email;

    private String password;
    private String profileImage;
    private String contactNumber;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    private AppUser appuser;
//    private String profileImage;
    private String address;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Guarantor guarantor;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private boolean approved;
    private CleanerStatus status;


    public void setApproved(boolean approveTheCleaner) {
        this.approved = approveTheCleaner;
    }


//    public void addBooking(Booking booking) {
//        if (bookings == null) {
//            bookings = new ArrayList<>();
//        }
//        bookings.add(booking);
//        booking.setCleaner(this);
//    }
//
//    public void removeBooking(Booking booking) {
//        if (bookings != null) {
//            bookings.remove(booking);
//            booking.setCleaner(null);
//        }
//    }
}
