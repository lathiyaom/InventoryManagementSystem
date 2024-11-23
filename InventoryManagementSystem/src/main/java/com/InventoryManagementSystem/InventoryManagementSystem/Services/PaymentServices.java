package com.BillGenrationsSystem.BillManagementSystem.Services;

import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Bill1;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.HalperCount;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Order;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.Payment;
import com.BillGenrationsSystem.BillManagementSystem.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {
    HalperCount h=new HalperCount();
    private  OrderServices orderServices;
    private BillServices billServices;

    @Autowired
    public PaymentServices(@Lazy OrderServices orderServices, BillServices billServices) {
        this.orderServices = orderServices;
        this.billServices = billServices;
    }

    @Autowired
    PaymentRepository paymentRepository;

    public Payment getByOrderId(Integer orderId) {
        return paymentRepository.getDetailsByOrderId(orderId);
    }

    public void savePayment(Payment p1) {
        h.setTotaltimeofpayment(h.getTotaltimeofpayment()+1);

        paymentRepository.save(p1);
    }

    public Payment addPayment(Payment payment, Integer orderId) {
       h.incrementTotalPayment(payment.getPaymentAmount().longValue());
        Order o = orderServices.getorderByOrderId(orderId);
        o.setPaidorno(true);
        Bill1 b = o.getBill();
        b.setPaidornot(true);
        orderServices.saveAOrder(o);
        billServices.saveABill(b);
        payment.setOrder(o);
        if(b.getNetAmount()==payment.getPaymentAmount())
        {
            return paymentRepository.save(payment);
        }
        else {
            return null;
        }
    }
}