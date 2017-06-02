package com.example.demo.controller;

import com.example.demo.dto.InventoryItemDetailsDTO;
import com.example.demo.dto.Status;
import com.example.demo.model.Inventory;
import com.example.demo.model.InventoryItems;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.repository.InventoryItemsRepository;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
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
@RequestMapping(value="/purchaseOrder")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

//    @RolesAllowed({"Admin","PO"})
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<PurchaseOrder> getAll(){

        List<PurchaseOrder> purchaseOrder=purchaseOrderService.findData();
        return purchaseOrder;
    }

//    @RolesAllowed({"Admin","PO"})
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Status add(@RequestBody PurchaseOrder purchaseOrder){

        purchaseOrderService.addData(purchaseOrder);

        Status status=new Status();
        status.setStatus("Success");
        return  status;

    }

//    @RolesAllowed({"Admin","PO"})
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public Status delete(@PathVariable long id){
        purchaseOrderService.delete(id);

        Status status = new Status();
        status.setStatus("Success");
        return  status;
    }

//    @RolesAllowed({"Admin","PO"})
    @RequestMapping(value = "/details/{id}", method=RequestMethod.GET)
    public List<PurchaseOrder> details(@PathVariable long id){

        List<PurchaseOrder> purchaseOrder=purchaseOrderService.findPOByItem(id);
        return  purchaseOrder;
    }


}
