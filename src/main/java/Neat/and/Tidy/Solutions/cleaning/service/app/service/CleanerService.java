package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;

public interface CleanerService {
    void logout();
    Cleaner register(RegisterCleanerRequest registerCleanerRequest);
    LoginResponse login(LoginRequest loginRequest);
    ViewHistoryResponse viewHistory(ViewHistoryRequest viewHistoryRequest);
    UpdateProfileResponse updateProfile(UpdateProfileRequest updateProfileRequest);
    MakeCallsResponse makeCalls(MakeCallsRequest makeCallsRequest);
    AcceptOrderResponse acceptOrder(AcceptOrderRequest acceptOrderRequest);
    CancelAcceptedOrderResponse cancelOrder();
    GiveFeedbackResponse giveFeedback(GiveFeedbackRequest giveFeedbackRequest);
    ChangePasswordResponse changePasswordResponse(ChangePasswordRequest changePasswordRequest);
}
