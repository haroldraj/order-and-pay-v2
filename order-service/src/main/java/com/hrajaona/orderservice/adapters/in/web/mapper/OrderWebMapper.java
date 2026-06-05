package com.hrajaona.orderservice.adapters.in.web.mapper;


import com.hrajaona.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderservice.adapters.out.persistence.entity.order.OrderItemJpaEntity;
import com.hrajaona.orderservice.adapters.out.persistence.entity.order.OrderJpaEntity;
import com.hrajaona.orderservice.domain.model.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderWebMapper {
    Order toDomain(OrderRequest orderRequest);

    @AfterMapping
    default void linkChildren(@MappingTarget OrderJpaEntity orderEntity) {
        if (orderEntity.getOrderItems() == null) {
            return;
        }

        List<OrderItemJpaEntity> items = new ArrayList<>(orderEntity.getOrderItems());
        orderEntity.getOrderItems().clear();
//
//        for (OrderItemJpaEntity item : items) {
//            orderEntity.addOrderItem(item);
//        }
    }
}
