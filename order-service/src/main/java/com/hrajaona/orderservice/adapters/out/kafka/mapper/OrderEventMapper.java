package com.hrajaona.orderservice.adapters.out.kafka.mapper;

import com.hrajaona.orderandpayv2lib.events.OrderCreatedEvent;
import com.hrajaona.orderandpayv2lib.model.OrderItemPayload;
import com.hrajaona.orderservice.domain.model.Order;
import com.hrajaona.orderservice.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderEventMapper {

    @Mapping(source = "id", target = "orderId")
    OrderCreatedEvent toEvent(Order order);

    List<OrderItemPayload> itemToPayloadList(List<OrderItem> orderItems);
}
