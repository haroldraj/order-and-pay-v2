package com.hrajaona.orderservice.application.port.in;



import com.hrajaona.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderservice.domain.model.Order;

import java.util.List;

public interface OrderUseCase {
    List<Order> getAllOrders();
    Order create(OrderRequest orderRequest, String correlationId);
}
