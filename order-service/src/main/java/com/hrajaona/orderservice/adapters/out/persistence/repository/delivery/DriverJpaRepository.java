package com.hrajaona.orderservice.adapters.out.persistence.repository.delivery;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DriverJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DriverJpaRepository extends JpaRepository<DriverJpaEntity, UUID> {

    @Query("""
           SELECT d
           FROM DriverJpaEntity d
           WHERE d.available = true
           AND NOT EXISTS (
                      SELECT 1
                      FROM DeliveryAssignmentJpaEntity da
                      WHERE da.driver.id = d.id
                      AND da.status IN ('ACCEPTED', 'ASSIGNED', 'PICKED_UP')
                      )
           """)
    List<DriverJpaEntity> findAllAvailable();
}
