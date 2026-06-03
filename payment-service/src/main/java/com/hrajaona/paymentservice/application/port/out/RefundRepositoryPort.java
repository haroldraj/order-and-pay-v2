package com.hrajaona.paymentservice.application.port.out;


import com.hrajaona.paymentservice.adapters.out.persistence.entity.RefundJpaEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RefundRepositoryPort {
    List<RefundJpaEntity> findAll();
    Optional<RefundJpaEntity> findById(UUID id);
}
