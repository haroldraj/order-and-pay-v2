package com.hrajaona.orderservice.application.port.out;


import com.hrajaona.orderservice.domain.model.OrderStatusHistory;

public interface OrderStatusHistoryRepositoryPort {
    void save(OrderStatusHistory orderStatusHistory);
}
