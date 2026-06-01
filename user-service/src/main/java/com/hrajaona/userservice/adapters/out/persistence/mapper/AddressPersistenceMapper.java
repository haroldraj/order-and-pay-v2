package com.hrajaona.userservice.adapters.out.persistence.mapper;

import com.hrajaona.userservice.adapters.out.persistence.entity.AddressJpaEntity;
import com.hrajaona.userservice.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressPersistenceMapper {

    AddressJpaEntity toEntity(Address address);
    Address toDomain(AddressJpaEntity addressJpaEntity);
}
