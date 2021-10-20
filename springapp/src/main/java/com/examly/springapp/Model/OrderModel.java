package com.examly.springapp.Model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false, length = 100)
    private String ProductName;
    @Column(nullable = false, length = 50)
    private String Status;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private Long totalPrice;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Long Price;

    /**
     * default constructor
     */
    public OrderModel() {
        quantity = (long) 0;
    }

    /**
     * parameterized constructor
     */
    public OrderModel(Long userId, String ProductName, Long Price, Long quantity, Long totalPrice, String Status) {
        this.ProductName = ProductName;
        this.userId = userId;
        this.Price = Price;
        this.totalPrice = totalPrice;
        this.Status = Status;

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
        return orderId;
    }

    /**
     * returns the name of the Order cart
     */
    public String getName() {
        return ProductName;
    }

    /**
     * returns the Price of the Order cart
     */
    public Long getPrice() {
        return Price;
    }

    /**
     * returns the total Price of the Order cart
     */
    public Long getTotalPrice() {
        return totalPrice;
    }

    /**
     * returns the User information of the Order cart
     */
    public Long getUserid() {
        return userId;
    }

    public Long getProductid() {
        return productId;
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
        return Status;
    }

    // setters

    public void setName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setPrice(Long Price) {
        this.Price = Price;
    }

    public void setTotalprice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUserid(Long userId) {
        this.userId = userId;
    }

    public void setproductid(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, Price, ProductName, quantity, Status, totalPrice, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderModel other = (OrderModel) obj;
        return Objects.equals(orderId, other.orderId) && Objects.equals(Price, other.Price)
                && Objects.equals(ProductName, other.ProductName) && quantity == other.quantity
                && Objects.equals(Status, other.Status) && Objects.equals(totalPrice, other.totalPrice)
                && Objects.equals(userId, other.userId);
    }
}
