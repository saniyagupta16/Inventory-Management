package com.example.demo.repository;

import com.example.demo.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by saniya on 26/5/17.
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    @Query("select e from Inventory e where e.id = ?1")
    Inventory findInventoryById(Long id) ;

    @Query("select e from Inventory e where e.id = ?1")
    Inventory findInventoryDataById(Long id) ;
}
