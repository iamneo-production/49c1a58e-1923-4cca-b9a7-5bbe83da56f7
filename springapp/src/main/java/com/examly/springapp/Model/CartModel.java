package com.examly.springapp.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class CartModel {

    

    @Column(nullable = false, length = 100)
    private String ProductName;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private Long Quantity;
    @Column(nullable = false)
    private Long Price;
    @Column(nullable = false)
    private Long ProductId;

    /**
     * default constructor
     */
    public CartModel() {
        Quantity = (long) 0;
    }

    /**
     * parameterized constructor
     */
    public CartModel(Long userId, String ProductName, Long Price, Long Quantity) {
        this.ProductName = ProductName;
        this.userId = userId;
        this.Price = Price;

        if (Quantity < 0) {
            Quantity = (long) 0;
        }
        this.Quantity = Quantity;
    }
    // getters

    
    public String getName() {
        return ProductName;
    }

    
    public Long getPrice() {
        return Price;
    }

    
    public Long getUserid() {
        return userId;
    }

    
    public Long getQuantity() {
        return Quantity;
    }

    public Long getProductId() {
        return this.ProductId;
    }

    // setters

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setPrice(Long Price) {
        this.Price = Price;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setQuantity(Long Quantity) {
        this.Quantity = Quantity;
    }
}
