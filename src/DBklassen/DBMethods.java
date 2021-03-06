/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBklassen;

import DomeinKlassen.Employee;
import DomeinKlassen.PurchaseOrder;
import DomeinKlassen.Site;
import DomeinKlassen.SupplierEquipment;
import DomeinKlassen.Supplier;
import DomeinKlassen.EquipmentRentalRequest;
import DomeinKlassen.BuildItEquipment;
import DomeinKlassen.Invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
            
            srs.next();
            e = new Employee(srs.getInt("employeeID"), srs.getString("email"), srs.getInt("phoneNumber"), srs.getString("function"));
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        DBConnector.closeConnection(con);
        return e;
    }
    
    public static Site getSite(String site) throws DBException {
        Site s = null;
        Connection con = null;
        
        try{
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement();
            
            String sql = "SELECT address, employeeID "
                    + "FROM ConstructionSites " 
                    + "WHERE address = '" + site + "'";
            ResultSet srs = stmt.executeQuery(sql);
            
            srs.next();
            s = new Site(srs.getString("address"), getEmployee(srs.getInt("employeeID")));
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        DBConnector.closeConnection(con);
        return s;
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
            
            srs.next();
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
        Supplier supplier = null;
        Connection con = null;
        
        try{
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement();
            
            String sql = "SELECT name, email, phoneNumber "
                    + "FROM Suppliers "
                    + "WHERE name = '" + s + "'";
            ResultSet srs = stmt.executeQuery(sql);
            
            srs.next();
            supplier = new Supplier(srs.getString("name"), srs.getString("email"), srs.getInt("phoneNumber"));
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        DBConnector.closeConnection(con);
        return supplier;
    }
    
    public static EquipmentRentalRequest getEER(int requestNumber) throws DBException{
        EquipmentRentalRequest eer = null;
        Connection con = null;
        try{
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql = "SELECT requestNumber, requestDate, constructionSite, "
                    + "rentalPeriodStart, rentalPeriodEnd, rentalStatus, siteEngineerID, clerkID, "
                    + "worksEngineerID, reasonForCancellationOrRefusal "
                    + "FROM EquipmentRentalRequests "
                    + "WHERE requestNumber = " + requestNumber;
            ResultSet srs = stmt.executeQuery(sql);
            
            String site, status, reasonForCancel;
            int request, siteEngineer, clerk, worksEngineer;
            Date requestDate, rentalStart, rentalEnd;
            HashMap<BuildItEquipment, Integer> bie = new HashMap<BuildItEquipment, Integer>();
            HashMap<SupplierEquipment, Integer> se = new HashMap<SupplierEquipment, Integer>();
            
            srs.next();
            site = srs.getString("constructionSite");
            status = srs.getString("rentalStatus");
            reasonForCancel = srs.getString("reasonForCancellationOrRefusal");
            request = srs.getInt("requestNumber");
            siteEngineer = srs.getInt("siteEngineerID");
            clerk = srs.getInt("clerkID");
            worksEngineer = srs.getInt("worksEngineerID");
            requestDate = srs.getDate("requestDate");
            rentalStart = srs.getDate("rentalPeriodStart");
            rentalEnd = srs.getDate("rentalPeriodEnd");
            
            sql = "SELECT equipmentCode, numberOfPieces "
                    + "FROM ERRBuildItEquipments "
                    + "WHERE requestNumber = " + requestNumber;
            srs = stmt.executeQuery(sql);
            
            while(srs.next())
                bie.put(getBuildItEquipment(srs.getInt("equipmentCode")), srs.getInt("numberOfPieces"));
            eer = new EquipmentRentalRequest(clerk, requestDate, site, rentalStart, rentalEnd, status, siteEngineer, bie);
            
            if(!status.equals("Requested")){
            sql = "SELECT supplierEquipmentCode, supplierName, numberOfPieces "
                    + "FROM ERRSupplierEquipments "
                    + "WHERE requestNumber = " + requestNumber;
            srs = stmt.executeQuery(sql);
            while(srs.next())
                se.put(getSupplierEquipment(srs.getInt("supplierEquipmentCode"), srs.getString("supplierName")), srs.getInt("numberOfPieces"));
            }
            eer.setSelectedSupplierEquipment(se);
        }catch (Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        DBConnector.closeConnection(con);
        return eer;
    }
    
    public static BuildItEquipment getBuildItEquipment(int code) throws DBException{
        BuildItEquipment bie = null;
        Connection con = null;
        try{
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql = "SELECT code, typeName, description, requirements "
                    + "FROM BuildItEquipments "
                    + "WHERE code = " + code;
            ResultSet srs = stmt.executeQuery(sql);
            
            srs.next();
            bie = new BuildItEquipment(srs.getInt("code"), srs.getString("typeName"), srs.getString("description"), srs.getString("requirements"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        DBConnector.closeConnection(con);
        return bie;
    }
    
    public static SupplierEquipment getSupplierEquipment(int code, String name) throws DBException{
        SupplierEquipment se = null;
        Connection con = null;
        try{
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql = "SELECT supplierEquipmentCode, supplierName, equipmentCode, dailyRentalPrice "
                    + "FROM SupplierEquipments "
                    + "WHERE supplierEquipmentCode = " + code + " AND supplierName = '" + name + "'";
            ResultSet srs = stmt.executeQuery(sql);
            
            srs.next();
            se = new SupplierEquipment(srs.getInt("supplierEquipmentCode"), srs.getString("supplierName"), srs.getInt("equipmentCode"), srs.getDouble("dailyRentalPrice"));
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        DBConnector.closeConnection(con);
        return se;
    }
    
    public static HashMap<BuildItEquipment, Integer> 
        getBuildItEquipmentHashMap(int requestNumber) throws DBException{
            HashMap<BuildItEquipment, Integer> h = new HashMap<BuildItEquipment, Integer>();
            Connection con = null;
            try{
                con = DBConnector.getConnection();
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                
                String sql = "SELECT equipmentCode, numberOfPieces "
                        + "FROM ERRBuildItEquipments "
                        + "WHERE requestNumber = " + requestNumber;
                ResultSet srs = stmt.executeQuery(sql);
                
                while(srs.next()){
                    h.put(getBuildItEquipment(srs.getInt("equipmentCode")), srs.getInt("numberOfPieces"));
                }
            } catch (Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
            DBConnector.closeConnection(con);
            return h;
    }
        
    public static HashMap<SupplierEquipment, Integer>
        getSupplierEquipmentHashMap(int requestNumber) throws DBException{
        Connection con = null;
        HashMap<SupplierEquipment, Integer> h = new HashMap<SupplierEquipment, Integer>();
        try{
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql = "SELECT supplierEquipmentCode, supplierName, numberOfPieces "
                    + "FROM ERRSupplierEquipments "
                    + "WHERE requestNumber = " + requestNumber;
            ResultSet srs = stmt.executeQuery(sql);
            
            while(srs.next()){
                h.put(getSupplierEquipment(srs.getInt("supplierEquipmentCode"), srs.getString("supplierName")), srs.getInt("numberOfPieces"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        DBConnector.closeConnection(con);
        return h;
    }
    
    public static Invoice getInvoice(int invoiceNumber) throws DBException{
        Invoice i = null;
        Connection con = null;
        try{
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql = "SELECT invoiceNumber";
        } catch (SQLException ex) {
            Logger.getLogger(DBMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        DBConnector.closeConnection(con);
        return i;
    }

    public static void setEquipmentRentalRequest(int employeeID,LocalDate startDate,LocalDate endDate,String constructionSite,HashMap<BuildItEquipment,Integer> codes) throws DBException{
        LocalDate today= LocalDate.now();
        int requestNumber = 0;
        Connection con = null;
        try{
        con = DBConnector.getConnection();
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); 
        String insert = "INSERT INTO EquipmentRentalRequests (requestDate,constructionSite,rentalPeriodStart,rentalPeriodEnd,rentalStatus,siteEngineerID) values " 
                +"(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        ps.setDate(1, java.sql.Date.valueOf(today));
        ps.setString(2, constructionSite);
        ps.setDate(3, java.sql.Date.valueOf(startDate));
        ps.setDate(4, java.sql.Date.valueOf(endDate));
        ps.setString(5, "requested");
        ps.setInt(6, employeeID);
        ps.executeUpdate();
        
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next())
            requestNumber = generatedKeys.getInt(1);
                
        for(Map.Entry<BuildItEquipment, Integer> entry : codes.entrySet()) {
        BuildItEquipment key = entry.getKey();
        Integer value = entry.getValue();
        
        String ins = "INSERT INTO ERRBuildItEquipments (requestNumber, equipmentCode, numberOfPieces) values "
                + "(?,?,?)";
        ps = con.prepareStatement(ins);
        ps.setInt(1, requestNumber);
        ps.setInt(2, key.getCode());
        ps.setInt(3, value);
        ps.executeUpdate();
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        DBConnector.closeConnection(con);
    }
    
    public static void procesEquipmentRentalRequest(int requestNumber,int employeeID,HashMap<SupplierEquipment,Integer> codes) throws SQLException, DBException{
        Connection con = DBConnector.getConnection();
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); 
        String insert = "INSERT INTO EquipmentRentalRequests (clerkID) values " 
                +"(?) WHERE requestNumber="+ requestNumber;
        PreparedStatement ps = con.prepareStatement(insert);
        ps.setInt(1,employeeID);
        ps.executeUpdate();
        for (HashMap.Entry<SupplierEquipment, Integer> entry : codes.entrySet()) {
            SupplierEquipment key = entry.getKey();
            Integer value = entry.getValue();
            String insert1 = "INSERT INTO ERRSupplierEquipments (requestNumber,supplierName,supplierEquipmentCode,numberOfPieces) values " 
                +"(?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(insert1);
            ps1.setInt(1, requestNumber);
            ps1.setString(2, key.getSupplierName());
            ps1.setInt(3, key.getSupplierEquipmentCode());
            ps1.setInt(4,value);
            ps1.executeUpdate();}       
        con.close();
    }
    
    public static void main(String[] args)throws DBException,SQLException{
        getSite("Veldstraat 35, 9000 Gent");
        getSupplier("Caterpillar");
        getBuildItEquipment(11);
        getSupplierEquipment(1234, "Boels nv");
        getEER(181);
        System.exit(0);
        LocalDate s = LocalDate.now();
        LocalDate e = LocalDate.now();
        BuildItEquipment bie = getBuildItEquipment(11);
        HashMap<BuildItEquipment, Integer> h = new HashMap<BuildItEquipment, Integer>();
        h.put(bie,6);
        setEquipmentRentalRequest(4, s,e , "Veldstraat 35, 9000 Gent", h);
    }
}