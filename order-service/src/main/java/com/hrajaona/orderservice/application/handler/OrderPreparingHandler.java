package com.hrajaona.orderservice.application.handler;

import com.hrajaona.orderandpayv2lib.enums.OrderEvent;
import com.hrajaona.orderandpayv2lib.enums.OrderStatus;
import com.hrajaona.orderandpayv2lib.events.OrderPreparingEvent;
import com.hrajaona.orderservice.application.port.in.OrderPreparingUseCase;
import com.hrajaona.orderservice.application.port.out.OrderRepositoryPort;
import com.hrajaona.orderservice.application.port.out.OrderStatusHistoryRepositoryPort;
import com.hrajaona.orderservice.domain.model.Order;
import com.hrajaona.orderservice.domain.model.OrderStatusHistory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderPreparingHandler implements OrderPreparingUseCase {
    private final OrderRepositoryPort orderRepositoryPort;
    private final OrderStatusHistoryRepositoryPort orderStatusHistoryRepositoryPort;

    @Override
    @Transactional
    public void handle(OrderPreparingEvent orderPreparingEvent, String correlationId) {
        Order order = orderRepositoryPort.findByIdAndRestaurantId(orderPreparingEvent.getOrderId(), orderPreparingEvent.getRestaurantId());

        OrderStatus orderPreviousStatus = order.getStatus();

        order.markAsPreparing();

        orderRepositoryPort.update(order);

        saveOrderPreviousStatus(order, orderPreviousStatus);

        log.info("{} event processed successfully.", OrderEvent.ORDER_PREPARING);
    }

    private void saveOrderPreviousStatus(Order order, OrderStatus previousStatus) {
        OrderStatusHistory orderStatusHistory = new OrderStatusHistory();
        orderStatusHistory.setOrderId(order.getId());
        orderStatusHistory.setPreviousStatus(previousStatus);
        orderStatusHistory.setStatus(order.getStatus());
        orderStatusHistory.setChangedAt(order.getUpdatedAt());

        orderStatusHistoryRepositoryPort.save(orderStatusHistory);
    }
}
