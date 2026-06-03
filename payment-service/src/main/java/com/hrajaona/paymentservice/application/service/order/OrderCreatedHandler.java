package com.hrajaona.paymentservice.application.service.order;

import com.hrajaona.orderandpayv2lib.events.OrderCreatedEvent;

public class OrderCreatedHandler implements OrderEventHandler<OrderCreatedEvent> {
    @Override
    public String support() {
        return "ORDER_CREATED";
    }

    @Override
    public void handle(OrderCreatedEvent event, String correlationId) {

    }
}
