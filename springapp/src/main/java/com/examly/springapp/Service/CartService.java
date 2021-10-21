package com.examly.springapp.Service;

import java.util.ArrayList;
import java.util.List;

import com.examly.springapp.Repository.CartRepository;
import com.examly.springapp.Model.CartModel;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void addNewCart(CartModel cart) {
        cartRepository.save(cart);
    }

    public boolean checkCartById(Long id) {
        return cartRepository.existsById(id);
    }

    public void deleteCartById(Long id) {
        cartRepository.deleteById(id);
    }

    public CartModel getCartById(Long id) {
        return cartRepository.findById(id).get();
    }

    public List<CartModel> getAllCarts() {
        List<CartModel> carts = new ArrayList<>();
        cartRepository.findAll().forEach(carts::add);
        return carts;
    }

    public List<CartModel> getCartsByUserId(String userId) {
        return cartRepository.getCartsByUserId(userId);
    }
}