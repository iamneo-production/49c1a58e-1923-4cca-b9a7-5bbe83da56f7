package com.examly.springapp.Model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(length = 500)
    private String url;

    @Column()
    private Long quantity;

    /**
     * default constructor
     */
    public ProductModel() {
        quantity = (long) 0;
    }

    /**
     * parameterized constructor
     */
    public ProductModel(String name, String description, String url, Long quantity) {
        this.name = name;
        this.description = description;
        this.url = url;
        if (quantity < 0) {
            quantity = (long) 0;
        }
        this.quantity = quantity;
    }

    // getters

    /**
     * returns id of the model Product
     */
    public Long getId() {
        return id;
    }

    /**
     * returns the name of the model Product
     */
    public String getName() {
        return name;
    }

    /**
     * returns the url of the model Product
     */
    public String getUrl() {
        return url;
    }

    /**
     * returns the description of the model Product
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns the quantity of the model product
     */
    public Long getQuantity() {
        return quantity;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}