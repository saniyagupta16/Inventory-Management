package com.example.demo.repository;

import com.example.demo.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by saniya on 26/5/17.
 */
@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long>
{
    @Query("select e from PurchaseOrder e")
    List<PurchaseOrder> findAlData();


    @Query("select po from PurchaseOrder as po  join po.inventoryItems as i where id=?1 ")

    List<PurchaseOrder> findPurchaseOrderByItem(long id);


}
