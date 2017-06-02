//package com.example.demo.service.ServiceImpl;
//
//import com.example.demo.model.Inventory;
//import com.example.demo.model.Users;
//import com.example.demo.repository.UserRepository;
//import com.example.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * Created by saniya on 26/5/17.
// */
//@Service
//
//public class UserServiceImpl implements UserService, UserDetailsService {
//
//
//    private UserRepository userRepository;
//
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//
//
//
//    @Override
//    public Users findByEmail(String email) {
//        return userRepository.findByEmail(email);
//
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = findByEmail(username);
//        if( user == null ){
//            throw new UsernameNotFoundException(username);
//        }
//
//        return new UserDetailsImpl(user);
//    }
//}
//
//
//
