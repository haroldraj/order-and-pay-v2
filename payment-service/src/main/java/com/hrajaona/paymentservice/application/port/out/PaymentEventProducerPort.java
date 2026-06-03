package com.hrajaona.paymentservice.application.port.out;


import com.hrajaona.orderandpayv2lib.events.PaymentCompletedEvent;

public interface PaymentEventProducerPort {
    void publishPaymentCompleted(PaymentCompletedEvent event, String correlationId);
}
