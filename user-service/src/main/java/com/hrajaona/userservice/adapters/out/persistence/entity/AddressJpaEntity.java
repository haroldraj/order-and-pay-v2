package com.hrajaona.userservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "addresses")
@EqualsAndHashCode
public class AddressJpaEntity {
    @Id
    private UUID id;

    @Column
    private String label;

    @Column
    private String street;

    @Column
    private String houseNumber;

    @Column
    private Integer boxNumber;

    @Column
    private String city;

    @Column
    private Integer postalCode;

    @Column
    private String country;

    @Column
    private Boolean isDefault;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserJpaEntity user;
}
