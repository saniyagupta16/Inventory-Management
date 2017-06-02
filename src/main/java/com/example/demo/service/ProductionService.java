package com.example.demo.service;

import com.example.demo.model.Production;
import com.example.demo.model.PurchaseOrder;

import java.util.List;

/**
 * Created by saniya on 27/5/17.
 */
public interface ProductionService {
    List<Production> findData();
    void delete(long  id);

    void addData(Production production);

    List<Production> findPOByItem(long id);
}
