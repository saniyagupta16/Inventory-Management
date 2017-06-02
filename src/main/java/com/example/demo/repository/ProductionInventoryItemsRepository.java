package com.example.demo.repository;

import com.example.demo.model.ProductionInventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by saniya on 29/5/17.
 */
@Repository
public interface ProductionInventoryItemsRepository extends JpaRepository<ProductionInventoryItem,Long>{
}
