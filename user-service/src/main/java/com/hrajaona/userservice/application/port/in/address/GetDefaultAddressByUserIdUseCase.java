package com.hrajaona.userservice.application.port.in.address;

import com.hrajaona.userservice.domain.model.Address;

import java.util.UUID;

public interface GetDefaultAddressByUserIdUseCase {
    Address getDefaultAddressByUserId(UUID userId);
}
