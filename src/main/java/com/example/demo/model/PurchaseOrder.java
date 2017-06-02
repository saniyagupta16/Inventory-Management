package com.example.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by saniya on 26/5/17.
 */
@Entity
@Table(name="purchase_order")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long purchase_order_number;
    private String vendor_name;
    private Date purchase_order_date;
    private float tax;

    @Column(name = "total_cost", columnDefinition ="real default 0")
    private double total_cost;
    @Column(name ="net_cost", columnDefinition = " real default 0")
    private double net_cost;

    @OneToMany(mappedBy = "purchaseOrder",fetch=FetchType.LAZY   )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<InventoryItems> inventoryItems;

    public PurchaseOrder() {
    }

    public List<InventoryItems> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<InventoryItems> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }



    public long getPurchase_order_number() {
        return purchase_order_number;
    }

    public Date getPurchase_order_date() {

        return purchase_order_date;
    }

    public void setPurchase_order_date(Date purchase_order_date) {
        this.purchase_order_date = purchase_order_date;
    }

    public String getVendor_name() {

        return vendor_name;
    }


    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }
    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public double getNet_cost() {
        return net_cost;
    }

    public void setNet_cost(double net_cost) {
        this.net_cost = net_cost;
    }

}
