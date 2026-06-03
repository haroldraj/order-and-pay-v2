package com.hrajaona.paymentservice.application.port.in;


import com.hrajaona.orderandpayv2lib.events.OrderCreatedEvent;

public interface HandleOrderCreatedUseCase {
    void handle(OrderCreatedEvent event, String correlationId);
}
