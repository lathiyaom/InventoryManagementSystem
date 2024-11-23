package com.BillGenrationsSystem.BillManagementSystem.Controller;


import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Stock;
import com.BillGenrationsSystem.BillManagementSystem.Services.ProductsServices;
import com.BillGenrationsSystem.BillManagementSystem.Services.StockServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockServices stockServices;
    @Autowired
    ProductsServices productsServices;
    @GetMapping("/get/{proid}")
    public ResponseEntity<?>getStockThroughproid(@PathVariable Integer proid)
    {
        try {
            if(productsServices.exsitornot(proid)!=false)
            {
                return new ResponseEntity<>(stockServices.getAllStockByProid(proid),HttpStatus.FOUND);
            }
            return new ResponseEntity<>("check your proid",HttpStatus.NOT_FOUND);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/add")
    public ResponseEntity<?>addAstockwithProduct(@RequestBody Stock stock) {
        try {

            return new ResponseEntity<>(stockServices.addAstock(stock),HttpStatus.ACCEPTED);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/addstock/{ProId}/{StId}")
    public ResponseEntity<?>updateAStockThroughProidandstid(@PathVariable Integer ProId,@PathVariable Integer StId,@RequestBody Stock stock) {
        try {
        if(productsServices.exsitornot(ProId)!=false&&stockServices.existOrNot(StId)!=false)
        {
            return new ResponseEntity<>(stockServices.updateThroughProIdAndStockId(ProId,StId,stock),HttpStatus.OK);
        }
        return new ResponseEntity<>("Check your ids",HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
