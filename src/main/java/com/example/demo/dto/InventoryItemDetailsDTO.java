package com.example.demo.dto;

/**
 * Created by saniya on 28/5/17.
 */
public class InventoryItemDetailsDTO {

    public long getInventory_items() {
        return inventory_items;
    }

    public void setInventory_items(long inventory_items) {
        this.inventory_items = inventory_items;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private long inventory_items;

    private int quantity;

    private double cost;
    private String name;

}
