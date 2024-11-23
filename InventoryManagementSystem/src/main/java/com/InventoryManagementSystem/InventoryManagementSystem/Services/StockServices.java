package com.BillGenrationsSystem.BillManagementSystem.Services;

import com.BillGenrationsSystem.BillManagementSystem.EntityModels.HalperCount;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Product;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Stock;
import com.BillGenrationsSystem.BillManagementSystem.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServices {
HalperCount h=new HalperCount();
    @Autowired
    StockRepository stockRepository;
    @Autowired
    ProductsServices productsServices;
    public Stock getAllStockByProid(Integer proid) {
        return stockRepository.getByProIdNative(proid);
    }

    public Stock addAstock(Stock stock) {
       h.incrementStockUpdated();
       return stockRepository.save(stock);
    }

    public boolean existOrNot(Integer stId) {
        return stockRepository.existsById(stId);
    }

    public Stock updateThroughProIdAndStockId(Integer proId, Integer stId, Stock stock) {
        Stock old=stockRepository.findById(stId).get();
        Product p=productsServices.getByProductId(proId);
        old.setProduct(p);
//        old.setStockId(stock.getStockId());
        old.setStockQuantity(old.getStockQuantity()+stock.getStockQuantity());
        old.setThresholdLevel(stock.getThresholdLevel());
       return stockRepository.save(old);

    }

    public Integer getStock(Integer proId) {
        Stock s=stockRepository.getByProIdNative(proId);
        return s.getStockQuantity();
    }

    public int getthreshold(Integer proId) {
        Stock s=stockRepository.getByProIdNative(proId);
        return s.getThresholdLevel();
    }
}
