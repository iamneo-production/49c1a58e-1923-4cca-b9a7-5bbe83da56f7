package com.examly.springapp.Repository;

import com.examly.springapp.Model.OrderDetailModel;
import com.examly.springapp.Model.OrderDetail;

import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends CrudRepository<OrderDetailModel, OrderDetail> {

}