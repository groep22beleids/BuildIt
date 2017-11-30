/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

import java.util.Date;

/**
 *
 * @author Dries
 */
public class Invoice {
    private int invoiceNumber, supplierInvoiceNumber, purchaseOrderNumber, equipmentCode, priceCharged;
    private Date date, logDate, rentalPeriodStart, rentalPeriodEnd;
    private Supplier supplier;
    private PurchaseOrder purchaseOrder;
    private String supplierName;

    public Invoice(int invoiceNumber, int supplierInvoiceNumber, int purchaseOrderNumber, int equipmentCode, int priceCharged, String date, String rentalPeriodStart, String rentalPeriodEnd, String supplierName) {
        this.invoiceNumber = invoiceNumber;
        this.supplierInvoiceNumber = supplierInvoiceNumber;
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.equipmentCode = equipmentCode;
        this.priceCharged = priceCharged;
        this.date = HelperMethods.stringToDate(date);
        this.logDate = new Date();
        this.rentalPeriodStart = HelperMethods.stringToDate(rentalPeriodStart);
        this.rentalPeriodEnd = HelperMethods.stringToDate(rentalPeriodEnd);
        this.supplier = supplier;                                               //Op basis van supplierName
        this.purchaseOrder = purchaseOrder;                                     //Op basis van PONumber
        this.supplierName = supplierName;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getSupplierInvoiceNumber() {
        return supplierInvoiceNumber;
    }

    public void setSupplierInvoiceNumber(int supplierInvoiceNumber) {
        this.supplierInvoiceNumber = supplierInvoiceNumber;
    }

    public int getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(int purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public int getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(int equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public int getPriceCharged() {
        return priceCharged;
    }

    public void setPriceCharged(int priceCharged) {
        this.priceCharged = priceCharged;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Date getRentalPeriodStart() {
        return rentalPeriodStart;
    }

    public void setRentalPeriodStart(Date rentalPeriodStart) {
        this.rentalPeriodStart = rentalPeriodStart;
    }

    public Date getRentalPeriodEnd() {
        return rentalPeriodEnd;
    }

    public void setRentalPeriodEnd(Date rentalPeriodEnd) {
        this.rentalPeriodEnd = rentalPeriodEnd;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
    public void printOutput(){
        System.out.println("Invoice number: " + this.invoiceNumber);
        System.out.println("Supplier invoice number: " + this.supplierInvoiceNumber);
        System.out.println("Date: " + HelperMethods.dateToString(this.date));
        System.out.println("Supplier: " + this.supplierName);
        System.out.println("Purchase order: " + this.purchaseOrderNumber);
        System.out.println("Equipment code: " + this.equipmentCode);
        System.out.println("Rental period start: " + HelperMethods.dateToString(this.rentalPeriodStart));
        System.out.println("Rental period end: " + HelperMethods.dateToString(this.rentalPeriodEnd));
        System.out.println("Price charged: " + this.priceCharged);
    }
}
