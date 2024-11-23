package com.BillGenrationsSystem.BillManagementSystem.Controller;


import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Product;
import com.BillGenrationsSystem.BillManagementSystem.Services.ProductsServices;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductsServices productsServices;

    @GetMapping("/get-all")
    public ResponseEntity<?> getListofAllProducts() {
        try {

            return new ResponseEntity<>(productsServices.getAllProducts(), HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get/{proid}")
    public ResponseEntity<?> getProdcutsById(@PathVariable Integer proid) {
        try {

            return new ResponseEntity<>(productsServices.getByProductId(proid), HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Eroor", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-all")
    public ResponseEntity<?> addAllProduct(@RequestBody List<Product> products) {
        try {
            return new ResponseEntity<>(productsServices.saveAll(products), HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get/{proId}/{stId}")
    public ResponseEntity<?> getAStockOfAProid(@PathVariable Integer proId, @PathVariable Integer stId)
    {
        try {

            if(productsServices.exsitornot(proId)!=false)
            {
                return new ResponseEntity<>(productsServices.getAllstocThroughProId(proId,stId),HttpStatus.FOUND);
            }
            return new ResponseEntity<>("Check your id s",HttpStatus.NOT_FOUND);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
