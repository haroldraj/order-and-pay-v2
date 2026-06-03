package com.hrajaona.paymentservice.application.service.order;

public interface OrderEventHandler<T> {
    String support();
    void handle(T event, String correlationId);
}
