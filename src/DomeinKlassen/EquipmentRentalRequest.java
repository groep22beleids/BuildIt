/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomeinKlassen;

import DBklassen.DBException;
import DBklassen.DBMethods;
import DomeinKlassen.BuildItEquipment;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Dries
 */
public class EquipmentRentalRequest {
    private Site constructionSite;
    private Employee siteEngineerID, clerkID, worksEngineerID;
    private int requestNumber;
    private Date requestDate, rentalPeriodStart, rentalPeriodEnd, logDate;     
    private HashMap<BuildItEquipment, Integer> selectedBuildItEquipment;
    private HashMap<SupplierEquipment, Integer> selectedSupplierEquipment;
    private String reasonForCancellationOrRefusal, rentalStatus;

    public EquipmentRentalRequest(int code, Date requestDate, String constructionSite, 
            Date rentalPeriodStart, Date rentalPeriodEnd, String rentalStatus, 
            int siteEngineerID, HashMap<BuildItEquipment, Integer> h) throws DBException{
        this.siteEngineerID = DBMethods.getEmployee(siteEngineerID);                      
        this.constructionSite = DBMethods.getSite(constructionSite);
        this.requestNumber = code;
        this.requestDate = requestDate;
        this.rentalPeriodStart = rentalPeriodStart;
        this.rentalPeriodEnd = rentalPeriodEnd;
        this.logDate = new Date();
        this.rentalStatus = rentalStatus;
        this.selectedBuildItEquipment = h;
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

    public String getRentalStatus() {
        return this.rentalStatus;
    }

    public void setRentalStatus(String status) {
        this.rentalStatus = status;
    }

    public Employee getSiteEngineerID() {
        return siteEngineerID;
    }

    public void setSiteEngineerID(Employee siteEngineerID) {
        this.siteEngineerID = siteEngineerID;
    }

    public Employee getClerkID() {
        return clerkID;
    }

    public void setClerkID(Employee clerkID) {
        this.clerkID = clerkID;
    }

    public Employee getWorksEngineerID() {
        return worksEngineerID;
    }

    public void setWorksEngineerID(Employee worksEngineerID) {
        this.worksEngineerID = worksEngineerID;
    }

    public HashMap<BuildItEquipment, Integer> getSelectedBuildItEquipment() {
        return selectedBuildItEquipment;
    }

    public void setSelectedBuildItEquipment(HashMap<BuildItEquipment, Integer> selectedBuildItEquipment) {
        this.selectedBuildItEquipment = selectedBuildItEquipment;
    }

    public HashMap<SupplierEquipment, Integer> getSelectedSupplierEquipment() {
        return selectedSupplierEquipment;
    }

    public void setSelectedSupplierEquipment(HashMap<SupplierEquipment, Integer> selectedSupplierEquipment) {
        this.selectedSupplierEquipment = selectedSupplierEquipment;
    }

    public String getReasonForCancellationOrRefusal() {
        return reasonForCancellationOrRefusal;
    }

    public void setReasonForCancellationOrRefusal(String reasonForCancellationOrRefusal) {
        this.reasonForCancellationOrRefusal = reasonForCancellationOrRefusal;
    }
    
    
}
