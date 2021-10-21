package com.examly.springapp.Controller;

import java.util.List;
import java.util.ArrayList;

import com.examly.springapp.Model.UserModel;
import com.examly.springapp.Model.ProductModel;
import com.examly.springapp.Model.OrderModel;
import com.examly.springapp.Model.OrderDetailModel;
import com.examly.springapp.Service.OrderService;
import com.examly.springapp.Service.UserService;
import com.examly.springapp.Service.ProductService;
import com.examly.springapp.Service.OrderDetailService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping("/orders")
    public List<OrderModel> getOrders(@RequestHeader String userId) {
        if (userService.checkUserById(userId)) {
            return orderService.getOrdersByUserId(userId);
        }
        return new ArrayList<OrderModel>();
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody String userId, @RequestBody Long productId, @RequestBody String productName,
            @RequestBody Long quantity, @RequestBody Long price) {
        if (!userService.checkUserById(userId) || !productService.checkProductById(productId)) {
            return "Invalid request.";
        }

        ProductModel product = productService.getProductById(productId);
        if (quantity > product.getQuantity()) {
            return "that much quantity is not available";
        } else {
            product.setQuantity(product.getQuantity() - quantity);
            productService.updateProductById(product.getId(), product);
        }

        OrderModel order = new OrderModel(Long.parseLong(userId), productName, price, quantity, (quantity * price),
                "processing");
        orderService.addNewOrder(order);
        List<OrderModel> orders = new ArrayList<OrderModel>(orderService.getOrdersByUserId(userId));
        order = orders.get(orders.size() - 1);

        OrderDetailModel orderDetails = new OrderDetailModel(order.getId(), product.getId(), quantity);
        orderDetailsService.addNewOrderDetails(orderDetails);

        order.setStatus("ordered");
        orderService.updateOrderById(order.getId(), order);
        return "Order Placed";
    }

    @GetMapping("/admin/orders")
    public List<OrderModel> getUserOrders() {
        return orderService.getAllOrders();
    }
    @RequestMapping("/hello")
    public String start() {
        return "hello";
    }
}
