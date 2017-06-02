package com.example.demo.service.ServiceImpl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saniya on 27/5/17.
 */
@Service
public class ProductionServiceImpl implements ProductionService{

    @Autowired
    private ProductionRepository productionRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductionInventoryItemsRepository productionInventoryItemsRepository;


    @Override
    public List<Production> findData() {
        return productionRepository.findAll();
    }

    @Override
    public void delete(long id) {
        productionRepository.delete(id);
    }

    @Override
    public void addData(Production production) {

        Production production1=productionRepository.save(production);
        List<ProductionInventoryItem> productionInventoryItems = production.getProductionInventoryItem();
        for(ProductionInventoryItem productionInventoryItem1:productionInventoryItems){
            productionInventoryItem1.setProduction(production1);

            Inventory inventory= inventoryRepository.findOne(productionInventoryItem1.getId());
            if(inventory!=null){
                //inventoryItems1.setCost(inventoryItems1.getQuantity()*inventory.getUnit_cost());

                inventory.setOpening_balance(inventory.getOpening_balance()-productionInventoryItem1.getQuantity());
                productionInventoryItem1.setInventory(inventory);
                //purchaseOrder1.setTotal_cost(purchaseOrder1.getTotal_cost()+inventoryItems1.getCost());


            }
        }

        production1.setTotal_manufactured_item(production1.getTotal_manufactured_item()+ 1);
   //     purchaseOrder1.setNet_cost(purchaseOrder1.getTotal_cost()+(purchaseOrder1.getTotal_cost()*purchaseOrder1.getTax()*0.01));
        if(!productionInventoryItems.isEmpty()) {
            productionInventoryItemsRepository.save(productionInventoryItems);
        }

    }

    @Override
    public List<Production> findPOByItem(long id) {
        return productionRepository.findProductionByItem(id);
    }
}
