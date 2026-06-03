package com.hrajaona.userservice.domain.exception;

import java.util.UUID;

public class DefaultAddressNotFoundException extends RuntimeException{
    public DefaultAddressNotFoundException(UUID userId) {
        super("No default address found with userId="+ userId);
    }
}
