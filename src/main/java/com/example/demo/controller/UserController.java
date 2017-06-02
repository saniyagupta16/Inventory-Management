package com.example.demo.controller;

import com.example.demo.dto.Status;
import com.example.demo.model.Inventory;
import com.example.demo.model.Users;
import com.example.demo.service.InventoryService;
import com.example.demo.service.UserOperationService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by saniya on 27/5/17.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    UserOperationService userOperationService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Users> getAll() {
        List<Users> user = userOperationService.getAll();
        return user;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Status add(@RequestBody Users users) {

            Users user = userOperationService.saveAll(users);
        Status status = new Status();

        if (user != null) {
            status.setStatus("Success");
            //status.setDescription("Inventory Id: "+inventor1.getId());
        } else
            status.setStatus("Failure");
        return status;

    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Status delete(@PathVariable Long id) {
       userOperationService.delete(id);
        Status status = new Status();
        status.setStatus("Success");
        return status;
    }


}