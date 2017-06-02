package com.example.demo.repository;

import com.example.demo.model.InventoryItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by saniya on 26/5/17.
 */
@Repository
public interface InventoryItemsRepository extends JpaRepository<InventoryItems , Long> {
}
