package com.BillGenrationsSystem.BillManagementSystem.EntityModels;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer repostId;
    private Date reportDate;
    private String reportData;

    public Integer getRepostId() {
        return repostId;
    }

    public void setRepostId(Integer repostId) {
        this.repostId = repostId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportData() {
        return reportData;
    }

    public void setReportData(String reportData) {
        this.reportData = reportData;
    }

    public Report() {
    }

    public Report(Integer repostId, Date reportDate, String reportData) {
        this.repostId = repostId;
        this.reportDate = reportDate;
        this.reportData = reportData;
    }
}
