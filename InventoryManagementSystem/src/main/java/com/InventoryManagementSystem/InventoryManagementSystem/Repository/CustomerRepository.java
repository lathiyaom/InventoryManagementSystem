package com.BillGenrationsSystem.BillManagementSystem.Repository;

import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
