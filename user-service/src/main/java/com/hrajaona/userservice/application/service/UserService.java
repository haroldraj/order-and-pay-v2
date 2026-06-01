package com.hrajaona.userservice.application.service;

import com.hrajaona.userservice.application.port.in.GetAllUsersUseCase;
import com.hrajaona.userservice.application.port.out.UserRepositoryPort;
import com.hrajaona.userservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements GetAllUsersUseCase {
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public List<User> getAllUsers() {
        return userRepositoryPort.findAll();
    }
}
