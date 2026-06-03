package com.hrajaona.paymentservice.adapters.out.persistence;

import com.hrajaona.paymentservice.adapters.out.persistence.entity.RefundJpaEntity;
import com.hrajaona.paymentservice.adapters.out.persistence.repository.RefundJpaRepository;
import com.hrajaona.paymentservice.application.port.out.RefundRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RefundPersistenceAdapter implements RefundRepositoryPort {
    private final RefundJpaRepository refundJpaRepository;


    @Override
    public List<RefundJpaEntity> findAll() {
        return refundJpaRepository.findAll();
    }

    @Override
    public Optional<RefundJpaEntity> findById(UUID id) {
        return refundJpaRepository.findById(id);
    }
}
