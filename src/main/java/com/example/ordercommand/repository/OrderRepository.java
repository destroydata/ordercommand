package com.example.ordercommand.repository;

import com.example.ordercommand.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository
    extends JpaRepository<Order, UUID> {
}
