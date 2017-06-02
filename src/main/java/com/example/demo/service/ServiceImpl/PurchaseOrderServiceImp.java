package com.example.demo.service.ServiceImpl;

import com.example.demo.model.Inventory;
import com.example.demo.model.InventoryItems;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.repository.InventoryItemsRepository;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saniya on 26/5/17.
 */
@Service
public class PurchaseOrderServiceImp  implements PurchaseOrderService{
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryItemsRepository inventoryItemsRepository;

    @Override
    public List<PurchaseOrder> findData() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public void delete(long id) {
        purchaseOrderRepository.delete(id);

    }

    @Override
    public void addData(PurchaseOrder purchaseOrder) {
        PurchaseOrder purchaseOrder1=purchaseOrderRepository.save(purchaseOrder);
        List<InventoryItems> inventoryItems = purchaseOrder.getInventoryItems();
        for(InventoryItems inventoryItems1:inventoryItems){
            inventoryItems1.setPurchaseOrder(purchaseOrder1);

            Inventory inventory= inventoryRepository.findOne(inventoryItems1.getId());
            if(inventory!=null){
                inventoryItems1.setCost(inventoryItems1.getQuantity()*inventory.getUnit_cost());

                inventory.setOpening_balance(inventory.getOpening_balance()+inventoryItems1.getQuantity());
                inventoryItems1.setInventory(inventory);
                purchaseOrder1.setTotal_cost(purchaseOrder1.getTotal_cost()+inventoryItems1.getCost());


            }
        }


        purchaseOrder1.setNet_cost(purchaseOrder1.getTotal_cost()+(purchaseOrder1.getTotal_cost()*purchaseOrder1.getTax()*0.01));
        if(!inventoryItems.isEmpty()) {
            inventoryItemsRepository.save(inventoryItems);
        }
    }

    @Override
    public List<PurchaseOrder> findPOByItem(long id) {
            return purchaseOrderRepository.findPurchaseOrderByItem(id);

    }
}
