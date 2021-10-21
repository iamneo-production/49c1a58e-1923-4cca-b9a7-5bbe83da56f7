package com.examly.springapp.Service;

import java.util.ArrayList;
import java.util.List;

import com.examly.springapp.Repository.OrderRepository;
import com.examly.springapp.Model.OrderModel;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void addNewOrder(OrderModel order) {
        orderRepository.save(order);
    }

    public boolean checkOrderById(Long id) {
        return orderRepository.existsById(id);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderModel getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    public List<OrderModel> getOrdersByUserId(String userId) {
        return orderRepository.getOrdersByUserId(userId);
    }

    public List<OrderModel> getAllOrders() {
        List<OrderModel> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    public void updateOrderById(Long id, OrderModel order) {
        orderRepository.updateOrderById(id, order);
    }
}
