package com.examly.springapp.api.repositories;

import com.examly.springapp.api.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
