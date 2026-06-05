package com.hrajaona.orderservice.application.handler;

import com.hrajaona.orderandpayv2lib.enums.OrderStatus;
import com.hrajaona.orderandpayv2lib.events.OrderPaidEvent;
import com.hrajaona.orderandpayv2lib.events.PaymentCompletedEvent;
import com.hrajaona.orderandpayv2lib.model.CustomerSnapshot;
import com.hrajaona.orderservice.adapters.out.client.user.UserClient;
import com.hrajaona.orderservice.application.mapper.OrderApplicationMapper;
import com.hrajaona.orderservice.application.port.in.PaymentCompletedUseCase;
import com.hrajaona.orderservice.application.port.out.OrderEventProducerPort;
import com.hrajaona.orderservice.application.port.out.OrderRepositoryPort;
import com.hrajaona.orderservice.application.port.out.OrderStatusHistoryRepositoryPort;
import com.hrajaona.orderservice.domain.model.Order;
import com.hrajaona.orderservice.domain.model.OrderStatusHistory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentCompletedHandler implements PaymentCompletedUseCase {
    private final OrderRepositoryPort orderRepositoryPort;
    private final OrderApplicationMapper orderApplicationMapper;
    private final OrderEventProducerPort orderEventProducerPort;
    private final UserClient userClient;
    private final OrderStatusHistoryRepositoryPort orderStatusHistoryRepositoryPort;

    @Override
    @Transactional
    public void handle(PaymentCompletedEvent event, String correlationId) {
        Order order = orderRepositoryPort.findByIdAndUserId(event.getOrderId(), event.getUserId());
        OrderStatus orderPreviousStatus = order.getStatus();

        order.markAsPaid();

        orderRepositoryPort.update(order);

        saveOrderPreviousStatus(order, orderPreviousStatus);

        OrderPaidEvent orderPaidEvent = orderApplicationMapper.toOrderPaidEvent(order);

        CustomerSnapshot customer = userClient.getUser(order.getUserId());

        orderPaidEvent.setCustomer(customer);

        orderEventProducerPort.publishOrderPaid(orderPaidEvent, correlationId);

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
