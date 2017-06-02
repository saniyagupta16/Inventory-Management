package com.example.demo.service;

import com.example.demo.model.Users;

import java.util.List;

/**
 * Created by saniya on 30/5/17.
 */
public interface UserOperationService {
    List<Users> getAll();

    Users saveAll(Users users);

    void delete(Long id);
}
