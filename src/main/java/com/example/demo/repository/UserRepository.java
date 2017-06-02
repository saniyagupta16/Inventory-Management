package com.example.demo.repository;

import com.example.demo.model.Inventory;
import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by saniya on 26/5/17.
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("select e from Users e where e.email = ?1")
    Users findByEmail(String email) ;
}
