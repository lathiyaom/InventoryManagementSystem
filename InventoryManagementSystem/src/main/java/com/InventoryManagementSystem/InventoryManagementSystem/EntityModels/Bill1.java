package com.BillGenrationsSystem.BillManagementSystem.EntityModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Bill1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "orderId")
    private Order order;
    private Date billDate;
    private Double billAmount;
    private Double gstAmount;
    private Double netAmount;
    private boolean paidornot;

    public boolean isPaidornot() {
        return paidornot;
    }

    public void setPaidornot(boolean paidornot) {
        this.paidornot = paidornot;
    }

    public Bill1(Integer billId, Order order, Date billDate, Double billAmount, Double gstAmount, Double netAmount, boolean paidornot) {
        this.billId = billId;
        this.order = order;
        this.billDate = billDate;
        this.billAmount = billAmount;
        this.gstAmount = gstAmount;
        this.netAmount = netAmount;
        this.paidornot = paidornot;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public Bill1(Integer billId, Order order, Date billDate, Double billAmount, Double gstAmount, Double netAmount) {
        this.billId = billId;
        this.order = order;
        this.billDate = billDate;
        this.billAmount = billAmount;
        this.gstAmount = gstAmount;
        this.netAmount = netAmount;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Double getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(Double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public Bill1() {
    }

    public Bill1(Integer billId, Order order, Date billDate, Double billAmount, Double gstAmount) {
        this.billId = billId;
        this.order = order;
        this.billDate = billDate;
        this.billAmount = billAmount;
        this.gstAmount = gstAmount;
    }
}
