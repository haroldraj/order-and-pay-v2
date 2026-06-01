package com.hrajaona.userservice.application.port.in;

import com.hrajaona.userservice.domain.model.User;

import java.util.List;

public interface GetAllUsersUseCase {
    List<User> getAllUsers();
}
