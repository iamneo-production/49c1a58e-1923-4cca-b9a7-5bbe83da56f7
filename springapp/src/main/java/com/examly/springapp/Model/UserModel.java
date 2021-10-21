package com.examly.springapp.Model;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "users")
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String password;
    private String username;
    private String mobileNumber;
    private Boolean active;
    private Boolean verified;
    private String role;
    private boolean enabled = true;
    

    public UserModel(String email, String password, String username, String mobileNumber, Boolean verified) {
        super();
        this.email = email;
        this.password = password;
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.active = true;
        this.role = "User";
        this.verified = verified;
    }

    public Long getId() {
        return userId;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, email, mobileNumber, password, role, username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserModel other = (UserModel) obj;
        return Objects.equals(active, other.active) && Objects.equals(email, other.email)
                && Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(password, other.password)
                && Objects.equals(role, other.role) && Objects.equals(username, other.username);
    }

    public boolean isNull() {
        if (this.email == "" || this.password == "" || this.username == "" || this.mobileNumber == ""
                || this.active == false || this.role == "") {
            return true;
        }

        return false;
    }
}
