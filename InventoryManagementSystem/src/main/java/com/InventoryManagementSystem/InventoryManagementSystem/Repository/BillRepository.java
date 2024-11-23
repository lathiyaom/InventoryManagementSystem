package com.BillGenrationsSystem.BillManagementSystem.Repository;


import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Bill1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface BillRepository extends  JpaRepository<Bill1,Integer>{
        @Query(value = "SELECT * FROM Bill1 WHERE order_id IN (SELECT order_id FROM Order WHERE order_id = :orderId)", nativeQuery = true)
        List<Bill1> getByOrderId(@Param("orderId") Integer orderId);

    }

