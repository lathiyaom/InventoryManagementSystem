package com.BillGenrationsSystem.BillManagementSystem.Controller;

import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Customer;
import com.BillGenrationsSystem.BillManagementSystem.Repository.CustomerRepository;
import com.BillGenrationsSystem.BillManagementSystem.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServices customerServices;
    @GetMapping("/get-all")
    public ResponseEntity<?>getAllCustomers()
    {
        try {
            return new ResponseEntity<>(customerServices.getAllCustomers(),HttpStatus.FOUND);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping("/add-all")
    public ResponseEntity<?>addAllCustomers(@RequestBody List<Customer>customers)
    {
        try {

            return new ResponseEntity<>(customerServices.addAllCustomer(customers),HttpStatus.ACCEPTED);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
