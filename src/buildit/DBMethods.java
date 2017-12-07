/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dries
 */
public class DBMethods {
    public static Employee getEmployee(int i) throws DBException{
        Employee e = null;
        Connection con = null;
        try{
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement();
            
            String sql = "SELECT employeeID, email, phoneNumber, function "
                    + "FROM Employees "
                    + "WHERE employeeID = " + i;
            ResultSet srs = stmt.executeQuery(sql);
            
            String email, function;
            int employeeID, phoneNumber;
            if(srs.next()){
                employeeID = srs.getInt("employeeID");
                email = srs.getString("email");
                phoneNumber = srs.getInt("phoneNumber");
                function = srs.getString("function");                           //Enum?
                e = new Employee(employeeID, email, phoneNumber, function);
            } else
                System.out.println("Employee with ID: " + i + " does not exist in the database.");
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        DBConnector.closeConnection(con);
        return e;
    }
    
    public static boolean isSite(String adress){
        boolean b = false;
        Connection con = null;
        try{
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement();
            
            String sql = "SELECT adress "
                    + "FROM ConstructionSites "
                    + "WHERE adress = '" + adress + "'";
            ResultSet srs = stmt.executeQuery(sql);
            if(srs.next())
                b = true;
        } catch (DBException ex) {
            Logger.getLogger(DBMethods.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    
    public static PurchaseOrder getPO(int poid) throws DBException{
        PurchaseOrder po = null;
        Connection con = null;
        try{
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement();
            
            String sql = "SELECT orderNumber, orderDate, handlingClerk, supplier," 
                    + "supplierEquipmentCode, dailyRentalPrice, rentalPeriodStart," 
                    + " rentalPeriodEnd, totalRentalPrice, constructionSite "
                    + "FROM POs "
                    + "WHERE orderNumber = " + poid;
            ResultSet srs = stmt.executeQuery(sql);
            
            po = new PurchaseOrder(srs.getInt("orderNumber"), srs.getDate("orderDate"),
                    srs.getInt("handlingClerk"), srs.getString("supplier"), srs.getInt("supplierEquipmentCode"),
                    srs.getInt("dailyRentalPrice"), srs.getDate("rentalPeriodStart"),
                    srs.getDate("rentalPeriodEnd"), srs.getInt("totalRentalPrice"),
                    srs.getString("constructionSite"));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        DBConnector.closeConnection(con);
        return po;
    }
    
    public static Supplier getSupplier(String s) throws DBException{
    }
}
