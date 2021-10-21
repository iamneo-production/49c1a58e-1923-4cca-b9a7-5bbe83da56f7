package com.examly.springapp.Controller;
import java.util.ArrayList;
import java.util.List;

import com.examly.springapp.Model.CartModel;
import com.examly.springapp.Model.ProductModel;
import com.examly.springapp.Model.UserModel;
import com.examly.springapp.Model.OrderModel;
import com.examly.springapp.Model.OrderDetailModel;
import com.examly.springapp.Service.CartService;
import com.examly.springapp.Service.OrderService;
import com.examly.springapp.Service.UserService;
import com.examly.springapp.Service.ProductService;
import com.examly.springapp.Service.OrderDetailService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailsService;

    @PostMapping("/cart/add")
    public String addToCart(@RequestBody CartModel cart) {
        if (!userService.checkUserById(cart.getUserid().toString()) || cart.getQuantity() < 0
                || !productService.checkProductById(cart.getProductId())) {
            return "Invalid request";
        }
        cartService.addNewCart(cart);
        return "item added to cart.";
    }

    @GetMapping("/cart/{userId}")
    public List<CartModel> showCart(@PathVariable String userId) {
        if (!userService.checkUserById(userId)) {
            return new ArrayList<CartModel>();
        }
        return cartService.getCartsByUserId(userId);
    }

    @PostMapping("/cart/delete")
    public String deleteCartItem(@RequestBody Long id) {
        if (cartService.checkCartById(id)) {
            cartService.deleteCartById(id);
            return "cart delted";
        }
        return "Invalid request";
    }
}
