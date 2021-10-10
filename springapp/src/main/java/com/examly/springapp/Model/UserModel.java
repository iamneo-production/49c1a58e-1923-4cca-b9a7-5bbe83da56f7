package com.examly.springapp.Model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "mobile_number", unique = true, length = 20)
    private String mobileNumber;

    @Column(nullable = false, length = 100)
    private String password;

    /**
     * Default constructor
     */
    public UserModel() {
    }

    /**
     * parameterized constructor
     */
    public UserModel(String firstName, String lastName, String email, String mobileNumber, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email.toLowerCase();
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    // getters and setters

    /**
     * getter to return primary key of the relation User
     * 
     * @return Long id
     */
    public Long getId() {
        return id;
    }

    /**
     * getter to return the first name of the relation User
     * 
     * @return String firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getter to return the last name of the relation User
     * 
     * @return String lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * getter to return the full name of the relation User
     * 
     * @return String firstName + " " + lastName
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * getter to return the email of the relation User
     * 
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * getter to return the mobileNumber of the relation user
     * 
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * getter to return the password of the relation User
     * 
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter to set the first name of the relation User
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * setter to set the last name of the relation User
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * setter to set the email of the relation User
     */
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    /**
     * setter to set the mobileNumber of the relation user
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * setter to set the password of the relation User
     */
    public void setPassword(String password) {
        this.password = password;
    }

    // overriding toString() method
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + this.getName() + ", email=" + email + ", mobile number=" + mobileNumber
                + ", password=" + password + "]";
    }
}