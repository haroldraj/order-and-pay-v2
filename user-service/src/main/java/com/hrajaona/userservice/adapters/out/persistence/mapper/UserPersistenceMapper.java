package com.hrajaona.userservice.adapters.out.persistence.mapper;

import com.hrajaona.userservice.adapters.out.persistence.entity.UserJpaEntity;
import com.hrajaona.userservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserPersistenceMapper {

    UserJpaEntity toEntity(User user);
    User toDomain(UserJpaEntity userJpaEntity);
}
