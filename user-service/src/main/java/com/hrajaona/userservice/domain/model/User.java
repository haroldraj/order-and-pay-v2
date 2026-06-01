package com.hrajaona.userservice.domain.model;

import com.hrajaona.userservice.domain.enums.UserStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {
    private UUID id;
    private String userName;
    private String phoneNumber;
    private String emailAddress;
    private UserStatus status;
    private List<Address> addresses;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
