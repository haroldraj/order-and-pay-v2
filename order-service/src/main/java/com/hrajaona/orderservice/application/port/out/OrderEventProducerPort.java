package com.hrajaona.orderservice.application.port.out;


import com.hrajaona.orderandpayv2lib.events.OrderCreatedEvent;
import com.hrajaona.orderandpayv2lib.events.OrderPaidEvent;

public interface OrderEventProducerPort {
    void publishOrderCreated(OrderCreatedEvent orderCreatedEvent, String correlationId);
    void publishOrderPaid(OrderPaidEvent event, String correlationId);
}
