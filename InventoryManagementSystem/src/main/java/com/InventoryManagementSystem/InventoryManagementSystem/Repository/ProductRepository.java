package com.BillGenrationsSystem.BillManagementSystem.Repository;

import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Product;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT * FROM `stock`  WHERE product_id= :proId AND stock_id = :stId",nativeQuery = true)
    List<Object[]> getAllStockByProidAndStockId(@Param("proId") Integer proId, @Param("stId") Integer stId);
}
