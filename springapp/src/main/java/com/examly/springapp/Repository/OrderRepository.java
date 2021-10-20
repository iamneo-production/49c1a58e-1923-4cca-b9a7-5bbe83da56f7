package com.examly.springapp.Repository;


import java.util.List;

import com.examly.springapp.Model.OrderModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

public interface OrderRepository extends CrudRepository<OrderModel, Long> {
    @Query("select orders from OrderModel orders where orders.userId = userId")
    List<OrderModel> getOrdersByUserId(String userId);

    @Modifying
    @Query("update OrderModel o set o = data where o.orderId = orderId")
    void updateOrderById(Long orderId, OrderModel data);
}