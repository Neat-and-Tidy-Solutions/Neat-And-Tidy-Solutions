package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.AdminDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String emailAddress;
    private String password;
    private Status status;
//    private String body;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Customer> customerDetails;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Cleaner> cleanersDetails;

}