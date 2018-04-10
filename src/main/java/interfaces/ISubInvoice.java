/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author M
 */
public interface ISubInvoice {
    String getInvoiceNumber();
    String getCountry();
    Boolean getPaymentStatus();
    String getInvoiceDate();
    Double getPrice();
}
