package com.examly.springapp.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(OrderDetail.class)
public class OrderDetailModel {
    @Id
    private Long orderId;
    @Id
    private Long productId;
    private Long quantity;

    public OrderDetailModel() {
    }

    public OrderDetailModel(Long orderId, Long productId, Long quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}