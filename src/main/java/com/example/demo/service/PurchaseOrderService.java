package com.example.demo.service;

import com.example.demo.model.Inventory;
import com.example.demo.model.PurchaseOrder;

import java.util.List;

/**
 * Created by saniya on 26/5/17.
 */
public interface PurchaseOrderService {

    List<PurchaseOrder> findData();
    void delete(long  id);

    void addData(PurchaseOrder purchaseOrder);

    List<PurchaseOrder> findPOByItem(long id);
}
