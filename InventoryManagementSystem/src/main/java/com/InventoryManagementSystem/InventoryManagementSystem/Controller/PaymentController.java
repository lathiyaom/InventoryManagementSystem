package com.BillGenrationsSystem.BillManagementSystem.Controller;


import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Payment;
import com.BillGenrationsSystem.BillManagementSystem.Services.OrderServices;
import com.BillGenrationsSystem.BillManagementSystem.Services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment/{orderId}")
public class PaymentController {
    @Autowired
    PaymentServices paymentServices;
    @Autowired
    OrderServices orderServices;
    @GetMapping("/get")
    public ResponseEntity<?>getAllDetailsaboutthisorder(@PathVariable Integer orderId) {
        try {

            if(orderServices.existOrNot(orderId)!=false)
            {
                return new ResponseEntity<>(paymentServices.getByOrderId(orderId),HttpStatus.FOUND);
            }
            else {
                return new ResponseEntity<>("check your orderId",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Eroor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping("/add")
    public ResponseEntity<?>payment(@RequestBody Payment payment,@PathVariable Integer  orderId)
    {
        try {
            if(orderServices.existOrNot(orderId)!=false)
            {
                return new ResponseEntity<>(paymentServices.addPayment(payment,orderId),HttpStatus.ACCEPTED);
            }
            else
            {
                return new ResponseEntity<>("chechk your order id",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
