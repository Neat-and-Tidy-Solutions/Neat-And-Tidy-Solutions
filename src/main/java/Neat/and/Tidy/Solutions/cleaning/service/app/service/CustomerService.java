package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Customer;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Rating;

public interface CustomerService {
    Customer register(RegisterCustomerRequest registerCustomerRequest);
    void logout();
    LoginResponse login(LoginRequest loginRequest);
    ViewHistoryResponse viewHistory(ViewHistoryRequest viewHistoryRequest);
    UpdateProfileResponse updateProfile(UpdateProfileRequest updateProfileRequest);
    MakeCallsResponse makeCalls(MakeCallsRequest makeCallsRequest);
    PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);
    CancelOrderResponse cancelOrderResponse();
    GiveFeedbackResponse giveFeedback(GiveFeedbackRequest giveFeedbackRequest);
    MakePaymentResponse makePayment(MakePaymentRequest makePaymentRequest);
    ChangePasswordResponse changePasswordResponse(ChangePasswordRequest changePasswordRequest);
    ComputeChecklistResponse computeCheckList(ComputeChecklistRequest computeChecklistRequest);
    AddCardResponse addCardResponse(AddCardRequest addCardRequest);
}
