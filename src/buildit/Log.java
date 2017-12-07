/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author Dries
 */
public class Log {
    public static void addToLog(Employee e, String s) {
        Date d = new Date();
        String bestandsNaam = "log.txt";
        PrintWriter outputStream = null;
        try { 
            outputStream = new PrintWriter(new FileOutputStream (bestandsNaam,true));
    } catch (FileNotFoundException ex){
        System.out.println("Fout bij het opnenen van het bestand" + bestandsNaam);
        System.exit(0);
    }
        String lijn = e.getEmployeeID() + "  " + HelperMethods.dateToString(d) + "   "+ s;
        outputStream.println(lijn);
    
        outputStream.close();      
    }
}
