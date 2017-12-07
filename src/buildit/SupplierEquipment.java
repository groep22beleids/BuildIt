/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

/**
 *
 * @author Dries
 */
public class SupplierEquipment {
    private int supplierEquipmentCode, buildItEauipmentCode;
    private String supplierName;
    
    public SupplierEquipment(int sEC, String sN, int bEC){
        this.supplierEquipmentCode = sEC;
        this.supplierName = sN;
        this.buildItEauipmentCode = bEC;
    }

    public int getSupplierEquipmentCode() {
        return supplierEquipmentCode;
    }

    public void setSupplierEquipmentCode(int supplierEquipmentCode) {
        this.supplierEquipmentCode = supplierEquipmentCode;
    }

    public int getBuildItEauipmentCode() {
        return buildItEauipmentCode;
    }

    public void setBuildItEauipmentCode(int buildItEauipmentCode) {
        this.buildItEauipmentCode = buildItEauipmentCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
}
