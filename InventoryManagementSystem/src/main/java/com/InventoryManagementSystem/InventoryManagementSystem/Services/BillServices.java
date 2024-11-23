package com.BillGenrationsSystem.BillManagementSystem.Services;


import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Bill1;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.HalperCount;
import com.BillGenrationsSystem.BillManagementSystem.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;


@Service
public class BillServices {
    HalperCount h=new HalperCount();
    @Autowired
    BillRepository billRepository;
    public BillServices(BillRepository billRepository) {
        this.billRepository = billRepository;
    }
    //    public List<Bill1> getByCustandProId(Integer orderId) {
//        return billRepository.getByOrderId(orderId);
//    }

    public void saveABill(Bill1 b) {
        h.incrementTotalTimeOfBill();
        billRepository.save(b);

    }

    public List<Bill1> getByOrderId(Integer orderId) {
        return billRepository.getByOrderId(orderId);
    }

    public Bill1 getAbill(Integer billId) {
        return billRepository.findById(billId).get();
    }


}
