package com.hrajaona.userservice.application.port.out;

import com.hrajaona.userservice.domain.model.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AddressRepositoryPort {
    List<Address> findAllByUserId(UUID userId);
    Optional<Address> findDefaultByUserId(UUID userID);
}
