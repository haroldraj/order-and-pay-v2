package com.hrajaona.orderservice.adapters.out.persistence.mapper.order;


import com.hrajaona.orderservice.adapters.out.persistence.entity.order.OrderItemJpaEntity;
import com.hrajaona.orderservice.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemPersistenceMapper {
    OrderItemJpaEntity toEntity(OrderItem orderItem);
    OrderItem toDomain(OrderItemJpaEntity orderItemJpa);
    List<OrderItemJpaEntity> toEntities(List<OrderItem> orderItems);
}
