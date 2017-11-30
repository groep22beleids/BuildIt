/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

import buildit.Employee.Function;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Dries
 */
public class EquipmentRentalRequest {
    enum Status{REQUESTED , PROCESSED};
    
    private Site constructionSite;
    private Employee requestor, handler;
    private int requestNumber;
    private Date requestDate, rentalPeriodStart, rentalPeriodEnd, logDate;      //Logdate is het tijdstip van laatste aanpassing. Dit wordt iedere keer met die datum in de log geplaatst
    private Status status;
    private Equipment selectedEquipment;                                        //De laatste drie pas vanaf status: PROCESSED
    private Supplier selectedSupplier;
    private int dailyRentalPrice;

    public EquipmentRentalRequest() {
        this.requestor = null;
        this.handler = null;
        this.constructionSite = null;
        this.requestNumber = 0;
        this.requestDate = new Date();
        this.rentalPeriodStart = null;
        this.rentalPeriodEnd = null;
        this.logDate = new Date();
        this.status = Status.REQUESTED;
        this.selectedEquipment = null;
        this.selectedSupplier = null;
        this.dailyRentalPrice = 0;
    }

    public EquipmentRentalRequest(int requestor, int handler, String constructionSite, String rentalPeriodStart, String rentalPeriodEnd) {
        this.requestor = requestor;                                             //Mehtodes om deze objecten te vinden uit de database adhv een string of variabele.
        this.handler = handler;
        this.constructionSite = constructionSite;
        this.requestNumber = this.hashCode();
        this.requestDate = new Date();
        this.rentalPeriodStart = HelperMethods.stringToDate(rentalPeriodStart);
        this.rentalPeriodEnd = HelperMethods.stringToDate(rentalPeriodEnd);
        this.logDate = new Date();
        this.status = Status.REQUESTED;
        this.selectedEquipment = null;                                          //Nog niet bepaald bij constructie
        this.selectedSupplier = null;
        this.dailyRentalPrice = 0;
    }

    public Employee getRequestor() {
        return requestor;
    }

    public void setRequestor(Employee requestor) {
        this.requestor = requestor;
    }

    public Employee getHandler() {
        return handler;
    }

    public void setHandler(Employee handler) {
        this.handler = handler;
    }

    public Site getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(Site constructionSite) {
        this.constructionSite = constructionSite;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getSelectedEquipment() {
        return selectedEquipment;
    }

    public void setSelectedEquipment(Equipment selectedEquipment) {
        this.selectedEquipment = selectedEquipment;
    }

    public Supplier getSelectedSupplier() {
        return selectedSupplier;
    }

    public void setSelectedSupplier(Supplier selectedSupplier) {
        this.selectedSupplier = selectedSupplier;
    }

    public int getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(int dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.requestor);
        hash = 13 * hash + Objects.hashCode(this.handler);
        hash = 13 * hash + Objects.hashCode(this.logDate);
        return hash;
    }
   
    public void printOutput(){
        System.out.println("Request number: " + this.requestNumber);
        System.out.println("Request date: " + HelperMethods.dateToString(this.requestDate));
        System.out.println("Status: " + this.status);
        System.out.println("Handler: " + this.handler.toString());
        System.out.println("Requestor: " + this.requestor.toString());
        System.out.println("Construction Site" + this.constructionSite.getAdress());
        System.out.println("Rental period start: " + HelperMethods.dateToString(this.rentalPeriodStart));
        System.out.println("Rental period end: " + HelperMethods.dateToString(this.rentalPeriodEnd));
        if(this.status.equals(status.PROCESSED)){
            System.out.println("Selected equipment: " + this.selectedEquipment.toString());
            System.out.println("Selected supplier: " + this.selectedSupplier.getName());
            System.out.println("Daily rental price: " + this.dailyRentalPrice);
        }
    }
}