package com.example.OrderService.Service;

import com.example.OrderService.Model.Order;
import com.example.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public void saveOrder(Order order) {

        orderRepository.save(order);

    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
