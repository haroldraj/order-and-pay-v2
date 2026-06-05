package com.hrajaona.orderservice.application.port.in;


import com.hrajaona.orderandpayv2lib.events.PaymentCompletedEvent;

public interface PaymentCompletedUseCase {
    void handle(PaymentCompletedEvent event, String correlationId);
}
