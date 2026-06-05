package com.hrajaona.orderservice.application.port.in;


import com.hrajaona.orderandpayv2lib.events.OrderDeliveredEvent;

public interface OrderDeliveredUseCase {
    void handle(OrderDeliveredEvent orderDeliveredEvent, String correlationId);
}
