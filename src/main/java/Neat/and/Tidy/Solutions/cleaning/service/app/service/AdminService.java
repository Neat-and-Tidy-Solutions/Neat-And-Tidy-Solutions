package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.*;

public interface AdminService {
ViewCleanerHistoryResponse viewCleanerHistory(ViewHistoryRequest viewHistoryRequest);
ViewCustomerHistoryResponse viewCustomerHistory(ViewCustomerHistoryRequest viewCustomerHistoryRequest);
ApproveCleanerResponse approveCleaner(ApproveCleanerRequest approveCleanerRequest);
RejectCleanerResponse rejectCleaner(RejectCleanerRequest rejectCleanerRequest);
ReviewFeedbacksResponse reviewFeedbacks(ReviewFeedbacksRequest reviewFeedbacksRequest);
void deleteCleaner(DeleteCleanerRequest deleteCleanerRequest);
}
