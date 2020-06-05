package com.task.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.demo.exception.RecordNotFoundException;
import com.task.demo.model.OrderEntity;
import com.task.demo.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;

	public List<OrderEntity> getAllOrders() throws RecordNotFoundException {
		List<OrderEntity> response = repo.findAll();
		return response;
	}

	public OrderEntity getOrderById(Long id) throws RecordNotFoundException {
		Optional<OrderEntity> response = repo.findById(id);
		if (response.isPresent()) {
			return response.get();
		} else {
			throw new RecordNotFoundException("No order record exist for given order id");
		}
	}

}
