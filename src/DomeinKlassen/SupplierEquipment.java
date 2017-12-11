/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomeinKlassen;

/**
 *
 * @author Dries
 */
public class SupplierEquipment {
    private int supplierEquipmentCode, buildItEquipmentCode;
    private String supplierName;
    private double dailyRentalPrice;
    
    public SupplierEquipment(int sEC, String sN, int bEC, double price){
        this.supplierEquipmentCode = sEC;
        this.supplierName = sN;
        this.buildItEquipmentCode = bEC;
        this.dailyRentalPrice = price;
    }

    public int getSupplierEquipmentCode() {
        return supplierEquipmentCode;
    }

    public void setSupplierEquipmentCode(int supplierEquipmentCode) {
        this.supplierEquipmentCode = supplierEquipmentCode;
    }

    public int getBuildItEquipmentCode() {
        return buildItEquipmentCode;
    }

    public void setBuildItEquipmentCode(int buildItEauipmentCode) {
        this.buildItEquipmentCode = buildItEauipmentCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(double dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }
    
}
