package com.example.demo.controller;

import com.example.demo.dto.Status;
import com.example.demo.model.Inventory;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Created by saniya on 26/5/17.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

//    @RolesAllowed({"Admin","PO","Production"})
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Inventory> getAll(){
        List<Inventory> inventory = inventoryService.getAll();
        return inventory;
    }

//    @RolesAllowed("Admin")
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Status add(@RequestBody Inventory inventory){

        Inventory inventor1=inventoryService.save(inventory);
        Status status= new Status();
        if (inventor1!=null){
            status.setStatus("Success");

        }
        else
            status.setStatus("Failure");

        return  status;
    }


//    @RolesAllowed("Admin")
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public Status delete(@PathVariable long id){
      inventoryService.delete(id);

        Status status = new Status();
        status.setStatus("Success");
        return  status;
    }

    @RolesAllowed("Admin")
    @RequestMapping(value = "/edit/{id}", method=RequestMethod.PUT)
    public Status edit(@PathVariable long id,@RequestBody Inventory inventory ){
        Status status = new Status();
        Inventory inventory1=inventoryService.editInventory(id,inventory);
        if (inventory1!=null)
            status.setStatus("Success");
        else
            status.setStatus("Edit Unsuccessfull");

        return  status;

    }
}
