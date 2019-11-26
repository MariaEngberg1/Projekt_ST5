/*
package dk.aau.models.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Db_Generelinfo {
        
    public static Connection getConnection(){
        Connection conn = null; 
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                try{
                    conn = DriverManager.getConnection(DataBaseDetails.host, DataBaseDetails.username, DataBaseDetails.password);
                    // conn = DriverManager.getConnection(Db_Details.host, Db_Details.username, Db_Details.password);
                }
                catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage());
                    System.out.println("conn fejl");

                }
            }
            catch (ClassNotFoundException ex){
                System.out.println(ex.getMessage());
                System.out.println("maria er en baryl");
            } 
        return conn; 
    }


    public static void executeQueryWithResultSet(Queryable queryable) {
        Connection conn = getConnection();
        Statement stmt = null; 
        ResultSet rs = null; 

        if (conn != null){
            try{
                System.out.println("Database");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT CPR_nummer, Name  FROM cprAndName");
                
                queryable.processResultSet(rs); 

            }
            catch (SQLException sqlex){
                System.out.println(sqlex.getMessage());
            }
            finally {
                try{
                    rs.close();
                }
                catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage());
                }
                try{
                    stmt.close();
                }
                catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage());
                }
            }
        }
    } 
}
*/