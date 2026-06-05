package com.hrajaona.orderservice.adapters.out.persistence.repository.delivery;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DeliveryAssignmentId;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DeliveryAssignmentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAssignmentJpaRepository extends JpaRepository<DeliveryAssignmentJpaEntity, DeliveryAssignmentId> {
}
