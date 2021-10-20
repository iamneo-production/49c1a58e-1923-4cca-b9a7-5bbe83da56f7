package com.examly.springapp.Repository;
import java.util.List;

import com.examly.springapp.Model.CartModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Modifying;

public interface CartRepository extends CrudRepository<CartModel, Long> {
    @Query("select carts from CartModel carts where carts.userId = userId")
    List<CartModel> getCartsByUserId(String userId);
}