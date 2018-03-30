/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgenerator;

import interfaces.ISubInvoice;
import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author M
 */
@Model
@Entity
public class SubInvoice implements ISubInvoice, Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String invoiceNumber = null;
    private String country = null;
    private Boolean paymentStatus = false;
    private String invoiceDate = null;
    private Double price = null;
    
    public SubInvoice(){
        
    }
    
    public SubInvoice(String invoiceNumber, String country, Boolean paymentStatus,
            String invoiceDate, Double price){
        this.invoiceDate = invoiceDate;
        this.country = country;
        this.paymentStatus = paymentStatus;
        this.invoiceDate = invoiceDate;
        this.price = price;
    }
    
    @Override
    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public Boolean getPaymentStatus() {
        return this.paymentStatus;
    }

    @Override
    public String getInvoiceDate() {
        return this.invoiceDate;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
    
}
