package com.BillGenrationsSystem.BillManagementSystem.EntityModels;


import jakarta.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;
    private Integer stockQuantity;
    private  Integer thresholdLevel;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getThresholdLevel() {
        return thresholdLevel;
    }

    public void setThresholdLevel(Integer thresholdLevel) {
        this.thresholdLevel = thresholdLevel;
    }

    public Stock() {
    }

    public Stock(Integer stockId, Product product, Integer stockQuantity, Integer thresholdLevel) {
        this.stockId = stockId;
        this.product = product;
        this.stockQuantity = stockQuantity;
        this.thresholdLevel = thresholdLevel;
    }

}
