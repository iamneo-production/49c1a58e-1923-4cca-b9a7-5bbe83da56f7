package com.examly.springapp.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false, length = 100)
    private String productName;

    @Column(length = 500)
    private String description;

    @Column(length = 500)
    private String imageUrl;

    @Column()
    private Long quantity;
    @Column()
    private Long price;

    /**
     * default constructor
     */
    public ProductModel() {
        quantity = (long) 0;
    }

    /**
     * parameterized constructor
     */
    public ProductModel(String productName, String description, String imageUrl, Long quantity) {
        this.productName = productName;
        this.description = description;
        this.imageUrl = imageUrl;
        if (quantity < 0) {
            quantity = (long) 0;
        }
        this.quantity = quantity;
    }

    
    public Long getId() {
        return productId;
    }

    
     
    public String getProductName() {
        return productName;
    }

    
    public String getImageUrl() {
        return imageUrl;
    }

    
    public String getDescription() {
        return description;
    }

   
    public Long getQuantity() {
        return quantity;
    }

   
    public Long getPrice() {
        return price;
    }

    

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, imageUrl, price, productName, productId, quantity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductModel other = (ProductModel) obj;
        return Objects.equals(description, other.description) && Objects.equals(imageUrl, other.imageUrl)
                && Objects.equals(price, other.price) && Objects.equals(productId, other.productId)
                && Objects.equals(productId, other.productId) && Objects.equals(quantity, other.quantity);
    }

    public boolean isValid() {
        if (this.imageUrl == "" || this.productName == "" || this.price < 0 || this.description == ""
                || this.quantity < 0) {
            return false;
        }
        return true;
    }
}