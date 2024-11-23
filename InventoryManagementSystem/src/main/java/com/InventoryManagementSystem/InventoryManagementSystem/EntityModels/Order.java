package com.BillGenrationsSystem.BillManagementSystem.EntityModels;


import com.BillGenrationsSystem.BillManagementSystem.Services.BillServices;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date odrerDate;
    private Integer productCount;
    private Double totalAmount;
    @JsonIgnore
    @OneToOne(mappedBy = "order", fetch = FetchType.EAGER)
    private Bill1 bill;
    @JsonIgnore
    @OneToOne(mappedBy = "order", fetch = FetchType.EAGER)
    private Payment payment;
    private Boolean paidorno;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getOdrerDate() {
        return odrerDate;
    }

    public void setOdrerDate(Date odrerDate) {
        this.odrerDate = odrerDate;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Bill1 getBill() {
        return bill;
    }

    public void setBill(Bill1 bill) {
        this.bill = bill;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Boolean getPaidorno() {
        return paidorno;
    }

    public void setPaidorno(Boolean paidorno) {
        this.paidorno = paidorno;
    }

    public Order() {
    }

    public Order(Integer orderId, Customer customer, Product product, Date odrerDate, Integer productCount, Double totalAmount, Bill1 bill, Payment payment, Boolean paidorno) {
        this.orderId = orderId;
        this.customer = customer;
        this.product = product;
        this.odrerDate = odrerDate;
        this.productCount = productCount;
        this.totalAmount = totalAmount;
        this.bill = bill;
        this.payment = payment;
        this.paidorno = paidorno;
    }

    public Double genrategstAmount(Double gstRate, Double totalAmount) {
        Double gstAmount = totalAmount * (gstRate / 100);
        return gstAmount;
    }
}
