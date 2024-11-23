package com.BillGenrationsSystem.BillManagementSystem.EntityModels;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;
    private Date paymentDate;
    private Double paymentAmount;
    private String paymentConfirmation;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentConfirmation() {
        return paymentConfirmation;
    }

    public void setPaymentConfirmation(String paymentConfirmation) {
        this.paymentConfirmation = paymentConfirmation;
    }

    public Payment() {
    }

    public Payment(Integer paymentId, Order order, Date paymentDate, Double paymentAmount, String paymentConfirmation) {
        this.paymentId = paymentId;
        this.order = order;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentConfirmation = paymentConfirmation;
    }
}
