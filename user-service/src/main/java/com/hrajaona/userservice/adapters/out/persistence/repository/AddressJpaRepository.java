package com.hrajaona.userservice.adapters.out.persistence.repository;

import com.hrajaona.userservice.adapters.out.persistence.entity.AddressJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AddressJpaRepository extends JpaRepository<AddressJpaEntity, UUID> {

    @Query("SELECT a FROM AddressJpaEntity a WHERE a.user.id= :userId")
    List<AddressJpaEntity> findAllByUserId(@Param("userId") UUID userId);

}
