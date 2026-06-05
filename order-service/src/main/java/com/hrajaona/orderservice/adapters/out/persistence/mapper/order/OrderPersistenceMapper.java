package com.hrajaona.orderservice.adapters.out.persistence.mapper.order;

import com.hrajaona.orderservice.adapters.out.persistence.entity.order.OrderJpaEntity;
import com.hrajaona.orderservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderPersistenceMapper {
    OrderJpaEntity toEntity(Order order);
    Order toDomain(OrderJpaEntity orderJpaEntity);
}
