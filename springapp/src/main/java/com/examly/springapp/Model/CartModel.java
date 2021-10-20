package com.examly.springapp.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class CartModel {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long cartItemID;

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

    /**
     * returns cartItemID of the model cart
     */
    /*
     * public Long getId() { return cartItemID; }
     */

    /**
     * returns the ProductName of the model cart
     */
    public String getName() {
        return ProductName;
    }

    /**
     * returns the Price of the model cart
     */
    public Long getPrice() {
        return Price;
    }

    /**
     * returns the User information of the model cart
     */
    public Long getUserid() {
        return userId;
    }

    /**
     * returns the Quantity of the model cart
     */
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
