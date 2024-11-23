package com.BillGenrationsSystem.BillManagementSystem.Services;

import com.BillGenrationsSystem.BillManagementSystem.EntityModels.HalperCount;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Product;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Stock;
import com.BillGenrationsSystem.BillManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServices {
    HalperCount h=new HalperCount();
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getByProductId(Integer proid) {
        return productRepository.findById(proid).get();
    }

    public List<Product> saveAll(List<Product> products) {
        h.incrementProductCount(Long.valueOf(products.size()));
        return productRepository.saveAll(products);
    }

    public boolean exsitornot(Integer proid) {
        return productRepository.existsById(proid);
    }

    public List<Stock> getAllstocThroughProId(Integer proId, Integer stId) {
       List<Object[]>objectList=productRepository.getAllStockByProidAndStockId(proId,stId);
        List<Stock> stockList = new ArrayList<>();
        for (Object[] objArray : objectList) {
            Stock stock = new Stock();
            stock.setStockId((Integer) objArray[0]);
            stock.setStockQuantity((Integer) objArray[2]);
            stock.setThresholdLevel((Integer) objArray[3]);
            stockList.add(stock);
        }
        return stockList;
    }
}
