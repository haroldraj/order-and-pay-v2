package com.hrajaona.userservice.adapters.out.persistence;

import com.hrajaona.userservice.adapters.out.persistence.mapper.UserPersistenceMapper;
import com.hrajaona.userservice.adapters.out.persistence.repository.UserJpaRepository;
import com.hrajaona.userservice.application.port.out.UserRepositoryPort;
import com.hrajaona.userservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserPersistenceAdapter implements UserRepositoryPort {
    private final UserPersistenceMapper userPersistenceMapper;
    private final UserJpaRepository userJpaRepository;

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll()
                .stream()
                .map(userPersistenceMapper::toDomain)
                .toList();
    }
}
