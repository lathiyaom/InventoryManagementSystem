package com.BillGenrationsSystem.BillManagementSystem.Repository;


import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {
    @Query(value = "SELECT * FROM stock WHERE product_id = :productId", nativeQuery = true)
    Stock getByProIdNative(@Param("productId") Integer productId);


}
