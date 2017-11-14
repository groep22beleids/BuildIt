/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Dries
 */
public class HelperMethods {
    private static final SimpleDateFormat fullDate = new SimpleDateFormat("E dd.MM.yyyy 'at' HH:mm:ss");
    private static final SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
    
    public static final int daysBetweenDates(Date d1, Date d2){                 //Wordt de laatste dag bij de huurperiode gereken of niet? m.a.w tot en met rentalPeriodEnd of niet?
        long diffInMillies = d2.getTime() - d1.getTime();
        return (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    
    public static final Date stringToDate(String s){                   
        Date d = null;
        try{
            d = date.parse(s);
        } catch(ParseException e){
            System.out.println("Unparseable using " + date);
        }
        return d;
    }
    
    public static final String fullDateToString(Date d){
        return fullDate.format(d);
    }
    
    public static final String dateToString(Date d){
        return date.format(d);
    }
    
}
