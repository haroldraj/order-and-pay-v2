package com.hrajaona.orderservice.application.mapper;

import com.hrajaona.orderandpayv2lib.events.OrderPaidEvent;
import com.hrajaona.orderservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderApplicationMapper {

    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "deliveryAddress", source = "addressSnapshot")
    @Mapping(target = "items", source = "orderItems")
    OrderPaidEvent toOrderPaidEvent(Order order);

}
