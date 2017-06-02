package com.example.demo.service.ServiceImpl;

import com.example.demo.model.Inventory;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saniya on 26/5/17.
 */
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }


    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);

    }

    @Override
    public void delete(long id) {
        inventoryRepository.delete(id);
    }

    @Override
    public Inventory editInventory(long id, Inventory inventory) {
        Inventory invent = inventoryRepository.findOne(id);

        if(invent == null) {

            throw new IllegalStateException("no product with id" + id);

        }

        invent=inventory;
        return inventoryRepository.save(invent);
    }
}


