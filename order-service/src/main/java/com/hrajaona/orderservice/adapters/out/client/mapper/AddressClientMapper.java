package com.hrajaona.orderservice.adapters.out.client.mapper;

import com.hrajaona.orderandpayv2lib.model.AddressSnapshot;
import com.hrajaona.orderservice.adapters.out.client.address.AddressResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressClientMapper {
    AddressSnapshot toDomain(AddressResponseDto addressResponseDto);
}
