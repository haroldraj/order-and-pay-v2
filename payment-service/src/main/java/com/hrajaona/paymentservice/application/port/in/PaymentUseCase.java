package com.hrajaona.paymentservice.application.port.in;


import com.hrajaona.orderandpayv2lib.events.OrderCreatedEvent;
import com.hrajaona.paymentservice.adapters.in.web.dto.PaymentRequest;
import com.hrajaona.paymentservice.domain.model.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentUseCase {
    Payment createPayment(PaymentRequest paymentRequest);
    void deletePayment(UUID id);
    Payment getPaymentById(UUID id);
    List<Payment> getAllPayments();
    Payment updatePayment(UUID id, PaymentRequest paymentRequest);
    void processOrderPayment(OrderCreatedEvent orderCreatedEvent, String correlationId);

}
