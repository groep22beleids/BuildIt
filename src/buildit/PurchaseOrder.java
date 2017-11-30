/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dries
 */
public class PurchaseOrder {
    enum Status{DESIGN , ORDERED}
    
    private int orderNumber, supplierEquipmentCode, dailyRentalPrice, totalRentalPrice,handlingClerkCode, phoneSiteEngineer;
    private String supplierName, constructionSiteAdress;
    private Date designDate, orderDate, rentalPeriodStart, rentalPeriodEnd, logDate;
    private Employee handlingClerk, siteEngineer;
    private Supplier supplier;
    private Site constructionSite;
    private Equipment supplierEquipment;
    private Status status;

    public PurchaseOrder() {
        this.orderNumber = 0;
        this.supplierEquipmentCode = 0;
        this.dailyRentalPrice = 0;
        this.totalRentalPrice = 0;
        this.handlingClerkCode = 0;
        this.phoneSiteEngineer = 0;
        this.supplierName = null;
        this.constructionSiteAdress = null;
        this.designDate = new Date();
        this.orderDate = null;
        this.rentalPeriodStart = null;
        this.rentalPeriodEnd = null;
        this.logDate = new Date();
        this.handlingClerk = null;
        this.siteEngineer = null;
        this.supplier = null;
        this.constructionSite = null;
        this.supplierEquipment = null; 
        this.status = Status.DESIGN;
    }

    public PurchaseOrder(int supplierEquipmentCode, int dailyRentalPrice, 
            int handlingClerkCode, int phoneSiteEngineer, 
            String supplierName, String constructionSiteAdress, 
            String rentalPeriodStart, String rentalPeriodEnd) {                     //String en int input is mss makkelijker om mee te werken dan Employee of Supplier input?
        this.orderNumber = orderNumber;
        this.supplierEquipmentCode = supplierEquipmentCode;
        this.dailyRentalPrice = dailyRentalPrice;
        this.totalRentalPrice = dailyRentalPrice * HelperMethods.daysBetweenDates(this.rentalPeriodStart, this.rentalPeriodEnd);
        this.handlingClerkCode = handlingClerkCode;
        this.phoneSiteEngineer = phoneSiteEngineer;
        this.supplierName = supplierName;
        this.constructionSiteAdress = constructionSiteAdress;
        this.designDate = new Date();
        this.orderDate = null;
        this.rentalPeriodStart = HelperMethods.stringToDate(rentalPeriodStart);
        this.rentalPeriodEnd = HelperMethods.stringToDate(rentalPeriodEnd);
        this.logDate = new Date();
        this.handlingClerk = handlingClerk;                                     //Hiervoor zijn methodes nodig die een object vinden uit de database adhv een van hun variabelen>
        this.siteEngineer = siteEngineer;
        this.supplier = supplier;
        this.constructionSite = constructionSite;
        this.supplierEquipment = supplierEquipment;
        this.status = Status.DESIGN;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getSupplierEquipmentCode() {
        return supplierEquipmentCode;
    }

    public void setSupplierEquipmentCode(int supplierEquipmentCode) {
        this.supplierEquipmentCode = supplierEquipmentCode;
    }

    public int getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(int dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }

    public int getTotalRentalPrice() {
        return totalRentalPrice;
    }

    public void setTotalRentalPrice(int totalRentalPrice) {
        this.totalRentalPrice = totalRentalPrice;
    }

    public int getHandlingClerkCode() {
        return handlingClerkCode;
    }

    public void setHandlingClerkCode(int handlingClerkCode) {
        this.handlingClerkCode = handlingClerkCode;
    }

    public int getPhoneSiteEngineer() {
        return phoneSiteEngineer;
    }

    public void setPhoneSiteEngineer(int phoneSiteEngineer) {
        this.phoneSiteEngineer = phoneSiteEngineer;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getConstructionSiteAdress() {
        return constructionSiteAdress;
    }

    public void setConstructionSiteAdress(String constructionSiteAdress) {
        this.constructionSiteAdress = constructionSiteAdress;
    }

    public Date getDesignDate() {
        return designDate;
    }

    public void setDesignDate(Date designDate) {
        this.designDate = designDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Employee getHandlingClerk() {
        return handlingClerk;
    }

    public void setHandlingClerk(Employee handlingClerk) {
        this.handlingClerk = handlingClerk;
    }

    public Employee getSiteEngineer() {
        return siteEngineer;
    }

    public void setSiteEngineer(Employee siteEngineer) {
        this.siteEngineer = siteEngineer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Site getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(Site constructionSite) {
        this.constructionSite = constructionSite;
    }

    public Equipment getSupplierEquipment() {
        return supplierEquipment;
    }

    public void setSupplierEquipment(Equipment supplierEquipment) {
        this.supplierEquipment = supplierEquipment;
    }
    
    public void printOutput(){
        System.out.println("Order number: " + this.orderNumber);
        System.out.println("Design date: " + HelperMethods.dateToString(this.designDate));
        if(this.status.equals(Status.ORDERED))
            System.out.println("Order date: " + HelperMethods.dateToString(this.orderDate));
        System.out.println("Status: " + this.status);
        System.out.println("Handling clerk: " + this.handlingClerkCode);
        System.out.println("Supplier: " + this.supplierName);
        System.out.println("Supplier equipment code: " + this.supplierEquipmentCode);
        System.out.println("Daily rental price: $ " + this.dailyRentalPrice);
        System.out.println("Rental period start: " + HelperMethods.dateToString(this.rentalPeriodStart));
        System.out.println("Rental period end: " + HelperMethods.dateToString(this.rentalPeriodEnd));
        System.out.println("Total rental price: $ " + this.totalRentalPrice);
        System.out.println("Construction site: " + this.constructionSiteAdress);
        System.out.println("Phonenumber site engineer: " + this.phoneSiteEngineer);
    }
}
