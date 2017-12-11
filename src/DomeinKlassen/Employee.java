/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomeinKlassen;

import java.util.Objects;

/**
 *
 * @author Dries
 */
public class Employee {
    private String email, function;
    private int employeeID, phoneNumber;

    public Employee() {
    }
    
    public Employee(int employeeID, String email, int phoneNumber, String function) {
        this.employeeID = employeeID;                                           
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.function = function;
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

    @Override
    public String toString() {
        return "EmployeeID: " + employeeID + ", email: " + email + ", phoneNumber: " + phoneNumber + ", function: " + function + " ";
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
