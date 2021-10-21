package com.examly.springapp.Service;

import java.util.ArrayList;
import java.util.List;

import com.examly.springapp.Repository.OrderDetailRepository;
import com.examly.springapp.Model.OrderDetailModel;
import com.examly.springapp.Model.OrderDetail;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailsRepository;

    public void addNewOrderDetails(OrderDetailModel data) {
        orderDetailsRepository.save(data);
    }

    public boolean checkOrderDetailsById(String id) {
        return true; // orderDetailsRepository.existsById(id);
    }

    /*
     * public void deleteOrderDetailsById(String id) { //
     * orderDetailsRepository.deleteById(id); }
     */

    public OrderDetailModel getOrderDetailsById(String id) {
        return new OrderDetailModel();// orderDetailsRepository.findById(id).get();
    }

    public List<OrderDetailModel> getAllOrderDetails() {
        List<OrderDetailModel> orders = new ArrayList<>();
        orderDetailsRepository.findAll().forEach(orders::add);
        return orders;
    }

}
