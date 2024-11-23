package com.BillGenrationsSystem.BillManagementSystem.Controller;


import com.BillGenrationsSystem.BillManagementSystem.Services.BillServices;
import com.BillGenrationsSystem.BillManagementSystem.Services.CustomerServices;
import com.BillGenrationsSystem.BillManagementSystem.Services.OrderServices;
import com.BillGenrationsSystem.BillManagementSystem.Services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill/{orderId}")
public class BillController {
    @Autowired
    ProductsServices productsServices;
    @Autowired
    CustomerServices customerServices;
    @Autowired
    BillServices billServices;
    @Autowired
    OrderServices orderServices;

    @GetMapping("/get-all")
    public ResponseEntity<?>getAllBill(@PathVariable Integer orderId)
    {
        try {

            if(orderServices.existOrNot(orderId)!=false)
            {
                return new ResponseEntity<>(billServices.getByOrderId(orderId),HttpStatus.FOUND);
            }
            else {
                return new ResponseEntity<>("Check your proid and cust id ",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("eroor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
