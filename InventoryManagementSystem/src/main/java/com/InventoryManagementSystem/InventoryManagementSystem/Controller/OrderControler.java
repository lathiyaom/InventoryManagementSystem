package com.BillGenrationsSystem.BillManagementSystem.Controller;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Order;
import com.BillGenrationsSystem.BillManagementSystem.Services.CustomerServices;
import com.BillGenrationsSystem.BillManagementSystem.Services.OrderServices;
import com.BillGenrationsSystem.BillManagementSystem.Services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/{proid}/{custid}")
public class OrderControler {
    @Autowired
    OrderServices orderServices;
    @Autowired
    ProductsServices productsServices;
    @Autowired  
    CustomerServices customerServices;
    @GetMapping("/get-all")
    public ResponseEntity<?>getAllOrder(@PathVariable Integer proid,@PathVariable Integer custid) {
        try {

            return new ResponseEntity<>(orderServices.getAllorderswithproidandcustid(proid,custid),HttpStatus.FOUND);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
        @PostMapping("/add")
    public ResponseEntity<?>addAOrder(@RequestBody Order order,@PathVariable Integer proid,@PathVariable Integer custid )
    {

        try {
            if(productsServices.exsitornot(proid)!=false&&customerServices.exsitornot(custid)!=false) {
                return new ResponseEntity<>(orderServices.addAorder(order,proid,custid), HttpStatus.ACCEPTED);
            }

            else {
                return new ResponseEntity<>("Chek your id",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/update/{OrId}/{BillId}/{PayId}")
    public ResponseEntity<?>updateAOrder(@PathVariable Integer proid,@PathVariable Integer  custid,@PathVariable Integer  OrId,@RequestBody Order order,@PathVariable Integer BillId,@PathVariable Integer PayId)
    {
        try {

            if(productsServices.exsitornot(proid)!=false&& customerServices.exsitornot(custid)!=false&& orderServices.existOrNot(OrId)!=false)
            {
                return new ResponseEntity<>(orderServices.updateAOrder(proid,custid,order,OrId,BillId,PayId),HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Check your ids",HttpStatus.NOT_FOUND);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
