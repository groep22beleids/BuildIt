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
public class Employee {
    private String employeeID, email, functionString;
    private int phoneNumber;
    private Function function;
    
    enum Function {SITE_ENGINEER , CLERK , WORKS_ENGINEER}

    public Employee() {
    }
    
    public Employee(String employeeID, String email, int phoneNumber, Function function) {
        this.employeeID = employeeID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.function = function;
        this.functionString = this.function.name().toLowerCase();
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "EmployeeID: " + employeeID + ", email: " + email + ", phoneNumber: " + phoneNumber + ", function: " + functionString + " ";
    }
    
}
