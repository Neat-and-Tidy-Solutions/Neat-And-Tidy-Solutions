package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Booking> bookings;


    private String email;
    private String contactNumber;
    private String address;
    private Gender gender;



//    public void addBooking(Booking booking) {
//        if (bookings == null) {
//            bookings = new ArrayList<>();
//        }
//        bookings.add(booking);
//        booking.setCustomer(this);
//    }
//
//    public void removeBooking(Booking booking) {
//        if (bookings != null) {
//            bookings.remove(booking);
//            booking.setCustomer(null);
//        }
//    }
}
