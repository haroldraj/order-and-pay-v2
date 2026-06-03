package com.hrajaona.userservice.adapters.out.persistence;

import com.hrajaona.userservice.adapters.out.persistence.mapper.AddressPersistenceMapper;
import com.hrajaona.userservice.adapters.out.persistence.repository.AddressJpaRepository;
import com.hrajaona.userservice.application.port.out.AddressRepositoryPort;
import com.hrajaona.userservice.domain.model.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
@Slf4j
public class AddressPersistenceAdapter implements AddressRepositoryPort {
    private final AddressPersistenceMapper addressPersistenceMapper;
    private final AddressJpaRepository addressJpaRepository;


    @Override
    public List<Address> findAllByUserId(UUID userId) {
        return addressJpaRepository.findAllByUserId(userId)
                .stream()
                .map(addressPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Address> findDefaultByUserId(UUID userId) {
        return addressJpaRepository.findDefaultByUserId(userId)
                .map(addressPersistenceMapper::toDomain);
    }
}
