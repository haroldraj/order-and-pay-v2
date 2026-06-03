package com.hrajaona.paymentservice.adapters.out.persistence.mapper;

import com.hrajaona.paymentservice.adapters.out.persistence.entity.RefundJpaEntity;
import com.hrajaona.paymentservice.domain.model.Refund;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PaymentMapper.class})
public interface RefundMapper {
    Refund toDomain(RefundJpaEntity refundJpaEntity);
    RefundJpaEntity toEntity(Refund refund);
}
