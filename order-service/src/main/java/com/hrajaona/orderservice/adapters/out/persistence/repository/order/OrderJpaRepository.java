package com.hrajaona.orderservice.adapters.out.persistence.repository.order;

import com.hrajaona.orderservice.adapters.out.persistence.entity.order.OrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity, UUID> {

    Optional<OrderJpaEntity> findByIdAndUserIdAndAmount( UUID id, UUID userId, BigDecimal amount);

    @Query("""
        SELECT o FROM OrderJpaEntity o
        LEFT JOIN FETCH o.orderItems
        WHERE o.id =:id AND o.userId = :userId
    """)
    Optional<OrderJpaEntity> findByIdAndUserId(
            @Param("id") UUID id,
            @Param("userId") UUID userId);

    @Query("""
        SELECT o FROM OrderJpaEntity  o
        LEFT JOIN FETCH o.orderItems
        WHERE o.id = :id AND o.restaurantId = :restaurantId
    """)
    Optional<OrderJpaEntity> findByIdAndRestaurantId(
            @Param("id") UUID id,
            @Param("restaurantId") UUID restaurantId
    );

}
