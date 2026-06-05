package com.hrajaona.orderservice.adapters.out.persistence.repository.order;

import com.hrajaona.orderservice.adapters.out.persistence.entity.order.OrderItemJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemJpaRepository extends JpaRepository<OrderItemJpaEntity, UUID> {
}
