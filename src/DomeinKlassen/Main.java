/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomeinKlassen;

import DBklassen.DBException;
import GUIs.EquipmentRentalRequestUI;
import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author Dries
 */
public class Main {
    public static void main(String[] args)throws Exception {
        EquipmentRentalRequestUI r = new EquipmentRentalRequestUI();
        r.setVisible(true);
    }
    
    public static void createERR(int employeeID, LocalDate s, LocalDate e, String site, HashMap<BuildItEquipment, Integer> h) throws DBException{
        DBklassen.DBMethods.setEquipmentRentalRequest(employeeID, s, e, site, h);
    }
}
