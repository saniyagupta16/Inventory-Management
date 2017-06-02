package com.example.demo.service;

import com.example.demo.model.Inventory;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by saniya on 26/5/17.
 */
public interface InventoryService {
    List<Inventory> getAll();

    Inventory save(Inventory inventory);

    void delete(long  id);

    Inventory editInventory(long id,Inventory inventory);
}
