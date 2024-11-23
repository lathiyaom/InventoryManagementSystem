package com.BillGenrationsSystem.BillManagementSystem.Services;


import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Customer;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.HalperCount;
import com.BillGenrationsSystem.BillManagementSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CustomerServices {

    HalperCount h=new HalperCount();
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> addAllCustomer(List<Customer> customers) {
        h.incrementTotalNewUser(customers.size());

        return customerRepository.saveAll(customers);
    }

    public Customer getbyacustId(Integer custid) {
        return customerRepository.findById(custid).get();
    }

    public boolean exsitornot(Integer custid) {
        return customerRepository.existsById(custid);
    }


    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
