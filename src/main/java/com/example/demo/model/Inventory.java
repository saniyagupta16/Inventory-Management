package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by saniya on 26/5/17.
 */
@Entity
@Table(name = "inventory")

public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String unit_of_measurement;
    private float unit_cost;
    private int opening_balance;
    private float dim_length;
    private float dim_breadth;
    private float dim_height;


    public Inventory() {
    }
//
//    @OneToMany(mappedBy = "inventory",orphanRemoval = true,fetch=FetchType.LAZY ,cascade = CascadeType.ALL )
//    private List<InventoryItems> inventoryItems;

    public float getDim_height() {
        return dim_height;
    }

    public void setDim_height(float dim_height) {
        this.dim_height = dim_height;
    }

    public float getDim_breadth() {

        return dim_breadth;
    }

    public void setDim_breadth(float dim_breadth) {
        this.dim_breadth = dim_breadth;
    }


    public int getOpening_balance() {

        return opening_balance;
    }

    public void setOpening_balance(int opening_balance) {
        this.opening_balance = opening_balance;
    }

    public float getDim_length() {

        return dim_length;
    }

    public void setDim_length(float dim_length) {
        this.dim_length = dim_length;
    }

    public float getUnit_cost() {

        return unit_cost;
    }

    public void setUnit_cost(float unit_cost) {
        this.unit_cost = unit_cost;
    }

    public String getUnit_of_measurement() {

        return unit_of_measurement;
    }

    public void setUnit_of_measurement(String unit_of_measurement) {
        this.unit_of_measurement = unit_of_measurement;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDimension() {
        return dim_length * dim_breadth * dim_height;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
