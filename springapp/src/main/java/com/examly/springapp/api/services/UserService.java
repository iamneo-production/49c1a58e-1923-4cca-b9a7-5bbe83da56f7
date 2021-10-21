package com.examly.springapp.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.examly.springapp.api.models.Cart;
import com.examly.springapp.api.models.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private static List<User> userslist = new ArrayList<>();

    static {
        userslist.add(new User(1, "Launda", "956456", "ADMIN"));
        userslist.add(new User(2, "Chuabe", "15645", "CUST"));
    }

    public List<User> getAllUsers() {
        return userslist;
    }

    public User findUser(int uid) {
        List<User> res = userslist.stream()
        .filter(o -> o.getId() == uid)
        .collect(Collectors.toList());

        User ret = res.get(0);
        if(res.size() > 0) {
            return ret;
        }
        return null;
    }

    public User addUser(User u) {
        //return null if could not be added or user already
        // exists

        // check whether user id exists before or not
        Optional<User> res = userslist.stream()
        .filter(o -> o.getId() == u.getId())
        .findFirst();

        if(res.isPresent()) {
            return null;
        }else {
            // u.setMyCart(new Cart(u.getId() + 1000));
            userslist.add(u);
            return u;
        }
    }

    //get user by id
    // public User getUserById(int id) {
    //     // list.stream().filter(predicate)
    // }
}
