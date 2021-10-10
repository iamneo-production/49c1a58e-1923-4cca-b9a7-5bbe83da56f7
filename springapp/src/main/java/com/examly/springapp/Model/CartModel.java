package com.examly.springapp.Model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class CartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private Long userid;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private Long price;

    /**
     * default constructor
     */
    public CartModel() {
        quantity = (long) 0;
    }

    /**
     * parameterized constructor
     */
    public CartModel(Long userid, String name, Long price, Long quantity) {
        this.name = name;
        this.userid = userid;
        this.price = price;

        if (quantity < 0) {
            quantity = (long) 0;
        }
        this.quantity = quantity;
    }
    // getters

    /**
     * returns id of the model cart
     */
    public Long getId() {
        return id;
    }

    /**
     * returns the name of the model cart
     */
    public String getName() {
        return name;
    }

    /**
     * returns the Price of the model cart
     */
    public Long getPrice() {
        return price;
    }

    /**
     * returns the User information of the model cart
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * returns the quantity of the model cart
     */
    public Long getQuantity() {
        return quantity;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setUPrice(Long price) {
        this.price = price;
    }

    public void setUser(Long userid) {
        this.userid = userid;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
