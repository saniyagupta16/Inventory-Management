package com.example.demo.service;

import com.example.demo.model.Users;

import java.util.List;

/**
 * Created by saniya on 26/5/17.
 */
public interface UserService {

    public Users findByEmail(String email);
}
