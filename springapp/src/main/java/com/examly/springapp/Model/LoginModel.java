package com.examly.springapp.Model;

public class LoginModel {
    private String email;
    private String password;

    /**
     * default constructor
     */
    public LoginModel() {
    }

    /**
     * parameterized constructor
     */
    public LoginModel(String email, String password) {
        super();
        this.email = email.toLowerCase();
        this.password = password;
    }

    // getters

    /**
     * getter for email
     */
    public String getEmail() {
        return email;
    }

    /**
     * getter for password
     */
    public String getPassword() {
        return password;
    }

    // setters

    /**
     * setter for email
     */
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    /**
     * setter for password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
