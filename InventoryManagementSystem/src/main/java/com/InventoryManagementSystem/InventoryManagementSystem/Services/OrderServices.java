package com.BillGenrationsSystem.BillManagementSystem.Services;

import com.BillGenrationsSystem.BillManagementSystem.BillManagementSystemApplication;
import com.BillGenrationsSystem.BillManagementSystem.EntityModels.*;
import com.BillGenrationsSystem.BillManagementSystem.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServices {
    @Autowired
    HalperCount h=new HalperCount();
    private  OrderRepository orderRepository;
    private  PaymentServices paymentServices;
    private  BillServices billServices;
    private  CustomerServices customerServices;
    private  ProductsServices productsServices;

    @Autowired
    public OrderServices(@Lazy OrderRepository orderRepository, PaymentServices paymentServices, BillServices billServices, CustomerServices customerServices, ProductsServices productsServices,HalperCount h) {
        this.orderRepository = orderRepository;
        this.paymentServices = paymentServices;
        this.billServices = billServices;
        this.customerServices = customerServices;
        this.productsServices = productsServices;
        this.h = h;
    }
    @Autowired
    public void setPaymentServices(PaymentServices paymentServices) {
        this.paymentServices = paymentServices;
    }
    @Autowired
    StockServices stockServices;
//    @Autowired
//    public OrderServices(@Lazy PaymentServices paymentServices) {
//        this.paymentServices = paymentServices;
//    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Autowired
    SMSservices smSservices;
    public Order addAorder(Order order, Integer proId, Integer custId) {
      h.incrementOrderCount();

        if(stockServices.getStock(proId)-order.getProductCount()<stockServices.getthreshold(proId))
        {
                    smSservices.sendMailtotheAdmin(custId,proId,order);
            System.out.println("this is hear.........");

//                smSservices.sendsmstotheAdmin(custId,proId,order);
//                 smSservices.sendwhatassmessagetotheadmin(custId,proId,order);
        }
//       smSservices.setup(custId);
        Stock stock = stockServices.getAllStockByProid(proId);
        Customer c = customerServices.getbyacustId(custId);
        Product p = productsServices.getByProductId(proId);
        Order order1 = new Order();
        order1.setCustomer(c);
        order1.setOdrerDate(order.getOdrerDate());
        order1.setPayment(order.getPayment());
        order1.setProductCount(order.getProductCount());
        order1.setProduct(p);
        order1.setTotalAmount(gettotalamount(p.getPrice(), order.getProductCount()));
        order1.setPaidorno(order.getPaidorno());
        stock.setStockQuantity(stock.getStockQuantity() - order.getProductCount());
        stockServices.addAstock(stock);
        orderRepository.save(order1); // Save the Order object first

        Bill1 b = new Bill1();
        b.setOrder(order1);
        b.setBillAmount(order1.getTotalAmount());
        b.setBillDate(Date.valueOf(LocalDate.now()));
        b.setGstAmount(order1.genrategstAmount(p.getGstRate(), order1.getTotalAmount()));
        b.setNetAmount(b.getBillAmount() - b.getGstAmount());
        b.setPaidornot(order.getPaidorno());
        billServices.saveABill(b);

        if (order.getPaidorno() == true) {
            Payment p1 = new Payment();
            p1.setOrder(order1); // Use the saved Order object here
            p1.setPaymentAmount(b.getNetAmount());
            p1.setPaymentDate(Date.valueOf(LocalDate.now()));
            p1.setPaymentConfirmation("paid");
            paymentServices.savePayment(p1);
//                smSservices.sendwhatsapp(custId, proId, order);
//                smSservices.sendsms(custId,proId,order);
//            smSservices.sendemailwithpayment(custId,proId,order);
        } else
        {
//            smSservices.sendwhatsappwithpayment(custId,proId,order);
//            smSservices.sendsmswithpayment(custId,proId,order);
//            smSservices.sendemail(custId,proId,order);
//            smSservices.sendemail(custId,proId,order);
        }
        return order1;
    }

    private Double gettotalamount(Double price, Integer productCount) {
        return price * productCount;
    }

    public List<Order> getAllorderswithproidandcustid(int proid, int custId) {
        return orderRepository.getAllOrdersByProductIdAndCustomerId(proid, custId);
    }

    public boolean existOrNot(Integer orderId) {
        return orderRepository.existsById(orderId);
    }

    public Order getorderByOrderId(Integer orderId) {
        return orderRepository.findById(orderId).get();
    }

    public void saveAOrder(Order o) {
        orderRepository.save(o);
    }

    public Order updateAOrder(Integer proid, Integer custid, Order order, Integer orId, Integer billId, Integer payId) {
        Order old=orderRepository.findById(orId).get();
        Product p=productsServices.getByProductId(proid);
        Customer c=customerServices.getbyacustId(custid);
        old.setPaidorno(order.getPaidorno());
        old.setTotalAmount(gettotalamount(p.getPrice(), order.getProductCount()));
        old.setPayment(order.getPayment());
        old.setProduct(p);
        old.setCustomer(c);
        old.setProductCount(order.getProductCount());
        old.setOdrerDate(order.getOdrerDate());
        orderRepository.save(old);
        Bill1 b=billServices.getAbill(billId);
        b.setPaidornot(order.getPaidorno());
        b.setOrder(old);
        b.setBillAmount(old.getTotalAmount());
        b.setBillDate(Date.valueOf(LocalDate.now()));
        b.setGstAmount(old.genrategstAmount(p.getGstRate(), old.getTotalAmount()));
        b.setNetAmount(b.getBillAmount() - b.getGstAmount());
        billServices.saveABill(b);
        if (order.getPaidorno() == true) {
            Payment p1 = new Payment();
            p1.setPaymentId(payId);
            p1.setOrder(old); // Use the saved Order object here
            p1.setPaymentAmount(b.getNetAmount());
            p1.setPaymentDate(Date.valueOf(LocalDate.now()));
            p1.setPaymentConfirmation("paid");
            paymentServices.savePayment(p1);
        }
        return old;
    }
}
