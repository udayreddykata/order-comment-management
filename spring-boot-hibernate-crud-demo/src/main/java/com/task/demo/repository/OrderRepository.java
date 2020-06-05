package com.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.demo.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
