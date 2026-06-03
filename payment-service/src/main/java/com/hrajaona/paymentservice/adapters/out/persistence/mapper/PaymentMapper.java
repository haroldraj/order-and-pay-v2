package com.hrajaona.paymentservice.adapters.out.persistence.mapper;

import com.hrajaona.paymentservice.adapters.out.persistence.entity.PaymentJpaEntity;
import com.hrajaona.paymentservice.domain.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {
    Payment toDomain(PaymentJpaEntity paymentJpa);
    PaymentJpaEntity toEntity(Payment payment);
}
