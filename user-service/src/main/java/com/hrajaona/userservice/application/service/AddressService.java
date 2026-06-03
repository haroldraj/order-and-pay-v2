package com.hrajaona.userservice.application.service;

import com.hrajaona.userservice.application.port.in.address.GetAllAddressByUserIdUseCase;
import com.hrajaona.userservice.application.port.in.address.GetDefaultAddressByUserIdUseCase;
import com.hrajaona.userservice.application.port.out.AddressRepositoryPort;
import com.hrajaona.userservice.domain.exception.DefaultAddressNotFoundException;
import com.hrajaona.userservice.domain.model.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService implements GetAllAddressByUserIdUseCase, GetDefaultAddressByUserIdUseCase {
    private final AddressRepositoryPort addressRepositoryPort;

    @Override
    public List<Address> getAllAddressByUserId(UUID userId) {
        return addressRepositoryPort.findAllByUserId(userId);
    }

    @Override
    public Address getDefaultAddressByUserId(UUID userId) {
        return addressRepositoryPort.findDefaultByUserId(userId)
                .orElseThrow(() -> new DefaultAddressNotFoundException(userId));
    }
}
