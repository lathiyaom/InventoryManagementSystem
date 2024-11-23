package com.BillGenrationsSystem.BillManagementSystem.EntityModels;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer productId;
    private String productName;
    private String productDescription;
    private  Double price;
    private Double gstRate;
    @JsonIgnore
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private List<Order>oreders;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Stock>stocks;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getGstRate() {
        return gstRate;
    }

    public void setGstRate(Double gstRate) {
        this.gstRate = gstRate;
    }

    public List<Order> getOreders() {
        return oreders;
    }

    public void setOreders(List<Order> oreders) {
        this.oreders = oreders;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public Product() {
    }

    public Product(Integer productId, String productName, String productDescription, Double price, Double gstRate, List<Order> oreders, List<Stock> stocks) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.gstRate = gstRate;
        this.oreders = oreders;
        this.stocks = stocks;
    }
}
