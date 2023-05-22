package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViewHistoryRequest {
    // Ernest

    private Long id;
    private String name;
    private String address;
    private String contactNumber;
    private Gender gender;
//    private Customer customer;
//    private Cleaner cleaner;
//    private Payment payment;
//    private Order order;
//    private Feedback feedback;
}
