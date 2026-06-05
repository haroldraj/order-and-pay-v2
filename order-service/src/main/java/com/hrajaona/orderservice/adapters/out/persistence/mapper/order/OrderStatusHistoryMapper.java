package com.hrajaona.orderservice.adapters.out.persistence.mapper.order;

import com.hrajaona.orderservice.adapters.out.persistence.entity.order.OrderStatusHistoryJpaEntity;
import com.hrajaona.orderservice.domain.model.OrderStatusHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderStatusHistoryMapper {
    OrderStatusHistory toDomain(OrderStatusHistoryJpaEntity orderStatusHistoryJpaEntity);
    OrderStatusHistoryJpaEntity toEntity(OrderStatusHistory orderStatusHistory);
}
