package com.example.demo.controller;

import com.example.demo.dto.Status;
import com.example.demo.model.Production;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.service.ProductionService;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Created by saniya on 27/5/17.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/production")
public class ProductionController {
    @Autowired
    ProductionService productionService;


//    @RolesAllowed({"Admin","Production"})
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Production> getAll(){

        List<Production> production=productionService.findData();
        return production;
    }

//    @RolesAllowed({"Admin","Production"})
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Status add(@RequestBody Production production){

        productionService.addData(production);

        Status status=new Status();
        status.setStatus("Success");
        return  status;

    }


//    @RolesAllowed({"Admin","Production"})
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public Status delete(@PathVariable long id){
        productionService.delete(id);

        Status status = new Status();
        status.setStatus("Success");
        return  status;
    }

//    @RolesAllowed({"Admin","Production"})
    @RequestMapping(value = "/details/{id}", method=RequestMethod.GET)
    public List<Production> details(@PathVariable long id){

        List<Production> production=productionService.findPOByItem(id);
        return  production;
    }
}
