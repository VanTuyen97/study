/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.ConvertJsonToObject.jackson;

import java.time.LocalDate;
import java.util.Date;
import org.springframework.data.annotation.Id;

/**
 *
 * @author TuyenNV22
 */
public class Device {
    @Id
    private long id;
    private String deviceType;
    private Double price;
    private String currency;
    private Date udpateDate;

    public Device() {
    }

    public Device(long id, String deviceType, Double price, String currency, Date udpateDate) {
        this.id = id;
        this.deviceType = deviceType;
        this.price = price;
        this.currency = currency;
        this.udpateDate = udpateDate;
    }

    public long getId() {
        return id;
    }
    
    public String getDeviceType() {
        return deviceType;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getUdpateDate() {
        return udpateDate;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setUdpateDate(Date updateDate) {
        this.udpateDate = updateDate;
    }
    
    @Override
    public String toString(){
        return "\nid: " + id
                + "\ndeviceType: " + this.deviceType
                + "\nprice: " + this.price
                + "\nCurrency: " +  this.currency
                + "\nupdateDate: " + this.udpateDate.toString();
    }
}