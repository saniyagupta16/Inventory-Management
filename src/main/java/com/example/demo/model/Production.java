package com.example.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by saniya on 27/5/17.
 */
@Entity
@Table(name = "production")
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long production_number;
    private String production_item;
    private Date production_date;

    @Column(name = "total_manufactured_item", columnDefinition ="int default 0")
    private int total_manufactured_item;

   @OneToMany(mappedBy = "production",fetch=FetchType.LAZY   )
   @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductionInventoryItem> productionInventoryItem;



    public Production() {
    }

    public long getProduction_number() {
        return production_number;
    }

    public String getProduction_item() {
        return production_item;
    }

    public void setProduction_item(String production_item) {
        this.production_item = production_item;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public int getTotal_manufactured_item() {
        return total_manufactured_item;
    }

    public void setTotal_manufactured_item(int total_manufactured_item) {
        this.total_manufactured_item = total_manufactured_item;
    }

    public List<ProductionInventoryItem> getProductionInventoryItem() {
        return productionInventoryItem;
    }

    public void setProductionInventoryItem(List<ProductionInventoryItem> productionInventoryItem) {
        this.productionInventoryItem = productionInventoryItem;
    }
}
