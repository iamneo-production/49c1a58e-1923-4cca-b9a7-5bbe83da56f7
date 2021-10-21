package com.examly.springapp.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;


@Entity
// @Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;
    private String mobileNumber;

    private String role;

    // @OneToOne(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private Cart myCart;

    public User(int id, String userName, String mobileNumber, String role) {
        this.id = id;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.role = role;
        // this.myCart = new Cart(id + 1000);
    }

    // public Cart getMyCart() {
    //     return myCart;
    // }

    // public void setMyCart(Cart myCart) {
    //     this.myCart = myCart;
    // }

    @Override
    public String toString() {
        return "User [id=" + id + ", mobileNumber=" + mobileNumber + ", role=" + role + ", userName=" + userName + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
