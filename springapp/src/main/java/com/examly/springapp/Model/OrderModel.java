package com.examly.springapp.Model;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 50)
    private String status;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private Long totalprice;
    @Column(nullable = false)
    private Long userid;
    @Column(nullable = false)
    private Long price;

    /**
     * default constructor
     */
    public OrderModel() {
        quantity = (long) 0;
    }

    /**
     * parameterized constructor
     */
    public OrderModel(Long userid, String name, Long price, Long quantity, Long totalprice, String status) {
        this.name = name;
        this.userid = userid;
        this.price = price;
        this.totalprice = totalprice;
        this.status = status;

        if (quantity < 0) {
            quantity = (long) 0;
        }
        this.quantity = quantity;
    }
    // getters

    /**
     * returns id of the Order cart
     */
    public Long getId() {
        return id;
    }

    /**
     * returns the name of the Order cart
     */
    public String getName() {
        return name;
    }

    /**
     * returns the Price of the Order cart
     */
    public Long getPrice() {
        return price;
    }

    /**
     * returns the total Price of the Order cart
     */
    public Long getTotalPrice() {
        return totalprice;
    }

    /**
     * returns the User information of the Order cart
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * returns the quantity of the Order cart
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * returns the status of the Order cart
     */
    public String getstatus() {
        return status;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setTotalprice(Long totalprice) {
        this.totalprice = totalprice;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setstatus(String status) {
        this.status = status;
    }
}
