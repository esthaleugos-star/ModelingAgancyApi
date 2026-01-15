package com.example.ModelingAgancyApi.repository;

import com.example.ModelingAgancyApi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}