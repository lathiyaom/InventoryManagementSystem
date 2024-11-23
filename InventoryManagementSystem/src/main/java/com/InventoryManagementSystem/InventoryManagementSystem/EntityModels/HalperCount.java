package com.BillGenrationsSystem.BillManagementSystem.EntityModels;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
@ComponentScan("com.BillGenrationsSystem.BillManagementSystem")
public class HalperCount {
    private Long productcount;
    private Long ordercount;
    private Long stockupdated;
    private Long totaltimeofpayment;
    private Long  totaltimeofbill;
    private Long totalpaymnet;
    private Long totalnewuser;
    private Date today;
    public Long getProductcount() {
        return productcount;
    }

    public void setProductcount(Long productcount) {
        this.productcount = productcount;
    }

    public Long getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(Long ordercount) {
        this.ordercount = ordercount;
    }

    public Long getStockupdated() {
        return stockupdated;
    }

    public void setStockupdated(Long stockupdated) {
        this.stockupdated = stockupdated;
    }

    public Long getTotaltimeofpayment() {
        return totaltimeofpayment;
    }

    public void setTotaltimeofpayment(Long totaltimeofpayment) {
        this.totaltimeofpayment = totaltimeofpayment;
    }

    public Long getTotaltimeofbill() {
        return totaltimeofbill;
    }

    public void setTotaltimeofbill(Long totaltimeofbill) {
        this.totaltimeofbill = totaltimeofbill;
    }

    public Long getTotalpaymnet() {
        return totalpaymnet;
    }

    public void setTotalpaymnet(Long totalpaymnet) {
        this.totalpaymnet = totalpaymnet;
    }

    public Long getTotalnewuser() {
        return totalnewuser;
    }

    public void setTotalnewuser(Long totalnewuser) {
        this.totalnewuser = totalnewuser;
    }

    public HalperCount() {
        this.productcount = 0L;
        this.ordercount = 0L;
        this.stockupdated = 0L;
        this.totaltimeofpayment = 0L;
        this.totaltimeofbill = 0L;
        this.totalpaymnet = 0L;
        this.totalnewuser = 0L;
        this.today = new Date();
    }

    public HalperCount(Long productcount, Long ordercount, Long stockupdated, Long totaltimeofpayment, Long totaltimeofbill, Long totalpaymnet, Long totalnewuser, Date today) {
        this.productcount = productcount;
        this.ordercount = ordercount;
        this.stockupdated = stockupdated;
        this.totaltimeofpayment = totaltimeofpayment;
        this.totaltimeofbill = totaltimeofbill;
        this.totalpaymnet = totalpaymnet;
        this.totalnewuser = totalnewuser;
        this.today = today;
    }

    public void incrementProductCount(Long aLong) {
        productcount+=aLong;
    }

    public void incrementOrderCount() {
        ordercount++;
    }

    public void incrementStockUpdated() {
        stockupdated++;
    }

    public void incrementTotalTimeOfPayment() {
        totaltimeofpayment++;
    }

    public void incrementTotalTimeOfBill() {
        totaltimeofbill++;
    }

    public void incrementTotalPayment(long amount) {
        totalpaymnet+=amount;
    }

    public void incrementTotalNewUser(int size) {
        totalnewuser+=size;
    }
























        public void  resetCountForNewDay()
        {
            if (!isSameDay(today, new Date())) {
                productcount = 0L;
                ordercount = 0L;
                stockupdated = 0L;
                totaltimeofpayment = 0L;
                totaltimeofbill = 0L;
                totalpaymnet = 0L;
                totalnewuser = 0L;
                today = new Date();
            }
        }




        private boolean isSameDay(Date date1,Date date2)
        {
            Calendar cal1=Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2=Calendar.getInstance();
            cal2.setTime(date2);
            return cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR)&&
                    cal1.get(Calendar.MONTH)==cal2.get(Calendar.MONTH)&&
                    cal1.get(Calendar.DAY_OF_MONTH)==cal2.get(Calendar.DAY_OF_MONTH);
        }




}
