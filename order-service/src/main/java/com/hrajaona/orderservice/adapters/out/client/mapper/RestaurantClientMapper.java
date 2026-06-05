package com.hrajaona.orderservice.adapters.out.client.mapper;

import com.hrajaona.orderandpayv2lib.model.RestaurantSnapshot;
import com.hrajaona.orderservice.adapters.out.client.restaurant.RestaurantResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantClientMapper {
    RestaurantSnapshot toDomain(RestaurantResponseDto restaurantResponseDto);
}
