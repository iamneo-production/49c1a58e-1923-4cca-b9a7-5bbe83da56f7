package com.examly.springapp.Repository;

import org.springframework.data.repository.CrudRepository;
import com.examly.springapp.Model.UserModel;
//import java.util.List;
//import java.util.Optional;

public interface UserRepository extends CrudRepository<UserModel, String> {
    
}