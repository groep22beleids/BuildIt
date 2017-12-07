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
public class Site {
    private String adress;
    private Employee siteEngineer;

    public Site(String adress, Employee siteEngineer) {
        this.adress = adress;
        this.siteEngineer = siteEngineer;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Employee getSiteEngineer() {
        return siteEngineer;
    }

    public void setSiteEngineer(Employee siteEngineer) {
        this.siteEngineer = siteEngineer;
    }

    @Override
    public String toString() {
        return "Adress: " + adress + " ";
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
        final Site other = (Site) obj;
        if (!Objects.equals(this.adress, other.adress)) {
            return false;
        }
        return true;
    }
    
}
