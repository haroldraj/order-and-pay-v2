package com.hrajaona.orderservice.adapters.out.client.restaurant;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponse {
    private UUID id;
    private String name;
    private String address;
    private List<MenuItemResponseDto> menuItemResponseDtos;
    private String phoneNumber;
    private String emailAddress;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
