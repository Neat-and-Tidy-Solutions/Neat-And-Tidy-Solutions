package Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
<<<<<<< HEAD:src/main/java/Neat/and/Tidy/Solutions/cleaning/service/app/data/dto/request/ViewHistoryRequest.java
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
=======
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCustomerDetailsRequest {
    private Long id;
    private String name;
    private String email;
    private String contactNumber;
    private String address;
    private String password;

>>>>>>> 86c0bdf384fc61d4669ba4734f9abaa728f84f54:src/main/java/Neat/and/Tidy/Solutions/cleaning/service/app/data/dto/request/UpdateCustomerDetailsRequest.java
}
