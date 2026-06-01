package com.hrajaona.userservice.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private UUID id;
    private String label;
    private String street;
    private String houseNumber;
    private Integer boxNumber;
    private String city;
    private Integer postalCode;
    private String country;
    private Boolean isDefault;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
