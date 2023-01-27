package com.example.OrderService.Service;


import com.example.OrderService.Model.Orders;
import com.example.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public void saveOrder(Orders order1) {

        orderRepository.save(order1);

    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }
}
