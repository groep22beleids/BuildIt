/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dries
 */
public class DBConnector {
    private static final String DB_NAME = "BINFG22";
    private static final String DB_PASS = "BU54t23k";
    
    public static Connection getConnection() throws DBException{
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            String protocol = "jdbc";
            String subProtocol = "mysql";
            String subName = "//mysqlha2.ugent.be/" + DB_NAME + "?user=" + DB_NAME + "&password=" + DB_PASS;
            String URL = protocol + ":" + subProtocol + ":" + subName;
            
            con = DriverManager.getConnection(URL);
            return con;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        } catch (SQLException ex){
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }
    
    public static void closeConnection(Connection con){
        try{
            con.close();
        } catch (SQLException ex){
            
        }
    }
}
