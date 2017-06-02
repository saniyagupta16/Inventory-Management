package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by saniya on 27/5/17.
 */

@Entity
@Table(name = "production_inventory_item")
public class ProductionInventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long production_inventory_items;

    private int quantity;

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
    @JoinColumn(name="production_number",insertable=true,updatable=true,nullable = false)
    private Production production;

    public ProductionInventoryItem() {
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

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }
}
