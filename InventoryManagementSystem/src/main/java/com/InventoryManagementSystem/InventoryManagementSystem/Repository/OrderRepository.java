package com.BillGenrationsSystem.BillManagementSystem.Repository;

import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order,Integer> {
    @Query(value = "SELECT * FROM `order` WHERE customer_id =:custId AND product_id =:prodId;", nativeQuery = true)
    List<Order> getAllOrdersByProductIdAndCustomerId(@Param("custId") Integer customerId, @Param("prodId") Integer productId);
}
