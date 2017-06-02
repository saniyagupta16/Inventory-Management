package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by saniya on 26/5/17.
 */
@Entity
@Table(name = "inventory_items")
public class InventoryItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inventory_items;

    private int quantity;

    private double cost;

    @Transient
    private long id;


    public long getId() {
        return id;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id",insertable=true,updatable=true,nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Inventory inventory;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="purchase_order_number",insertable=true,updatable=true,nullable = false)

    private PurchaseOrder purchaseOrder;


    public InventoryItems() {
    }

    public long getInventory_items() {
        return inventory_items;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
