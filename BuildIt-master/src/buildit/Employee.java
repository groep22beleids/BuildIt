/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

import java.util.Objects;

/**
 *
 * @author Dries
 */
public class Employee {
    private String email, functionString;
    private int employeeID, phoneNumber;
    private Function function;
    private String sander;
    
    enum Function {SITE_ENGINEER , CLERK , WORKS_ENGINEER}

    public Employee() {
    }
    
    public Employee(String email, int phoneNumber, Function function) {
        this.employeeID = this.hashCode();                                      //Staan deze in de gegeven database of moeten we die zelf genereren?
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.function = function;
        this.functionString = this.function.name().toLowerCase();
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {                                 //Mag niet gebruikt worden
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + this.phoneNumber;
        hash = 79 * hash + Objects.hashCode(this.function);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.employeeID != other.employeeID) {
            return false;
        }
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.function != other.function) {
            return false;
        }
        return true;
    }
    
}
