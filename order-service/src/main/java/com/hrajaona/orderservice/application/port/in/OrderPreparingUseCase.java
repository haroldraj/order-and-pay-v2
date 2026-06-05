package com.hrajaona.orderservice.application.port.in;


import com.hrajaona.orderandpayv2lib.events.OrderPreparingEvent;

public interface OrderPreparingUseCase {
    void handle(OrderPreparingEvent orderPreparingEvent, String correlationId);
}
