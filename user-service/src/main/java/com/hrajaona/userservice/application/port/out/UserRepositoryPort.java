package com.hrajaona.userservice.application.port.out;


import com.hrajaona.userservice.domain.model.User;

import java.util.List;

public interface UserRepositoryPort {
    List<User> findAll();
}
