//package com.example.demo.service.ServiceImpl;
//
//import com.example.demo.model.Role;
//import com.example.demo.model.Users;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by saniya on 30/5/17.
// */
//
//    public class UserDetailsImpl implements UserDetails {
//
//    String ROLE_PREFIX = "ROLE_";
//    private Long userId;
//    private String email;
//    private String password;
//    private Role role;
//
//    public UserDetailsImpl(Long userId, String email, String password, Role role) {
//        this.userId = userId;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//    }
//
//    private Users user;
//
//    public UserDetailsImpl(Users user){
//        this.user = user;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
//
//        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
//
//        return list;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public Long getUserId() {
//
//        return userId;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
