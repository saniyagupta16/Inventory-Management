package com.example.demo.repository;

import com.example.demo.model.Production;
import com.example.demo.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by saniya on 27/5/17.
 */@Repository
public interface ProductionRepository extends JpaRepository<Production,Long> {

    @Query("select p from Production as p  join p.productionInventoryItem as i where id=?1 ")
    List<Production> findProductionByItem(long id);
}
