/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author M
 */
public interface IVehicle {
    String getHashedLicensePlate();
    List<IJourney> getJourneys();
    List<ISubInvoice> getSubInvoices();
}

