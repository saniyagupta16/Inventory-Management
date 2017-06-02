package com.example.demo.service.ServiceImpl;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saniya on 30/5/17.
 */
@Service
public class UserOperationServiceImpl implements UserOperationService {

   @Autowired
    UserRepository userRepository;
    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Users saveAll(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);

    }
}
