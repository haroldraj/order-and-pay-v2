package com.hrajaona.userservice.application.port.in.address;

import com.hrajaona.userservice.domain.model.Address;

import java.util.List;
import java.util.UUID;

public interface GetAllAddressByUserIdUseCase {
    List<Address> getAllAddressByUserId(UUID userId);
}
