package com.quickfleet.repository;

import com.quickfleet.model.CourierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourierOrderRepository extends JpaRepository<CourierOrder, Long> {
    List<CourierOrder> findByUserId(Long userId);
    List<CourierOrder> findByCourierId(Long courierId);
}
