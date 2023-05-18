package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.PaymentRequest;

public interface PaymentService {
    void uploadReceipt(PaymentRequest paymentRequest);
}
