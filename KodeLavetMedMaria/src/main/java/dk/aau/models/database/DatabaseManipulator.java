package dk.aau.models.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManipulator {
        
    public static Connection getConnection(){
        Connection conn = null; 
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                try{
                    conn = DriverManager.getConnection(DataBaseDetails.host, DataBaseDetails.username, DataBaseDetails.password);
                }
                catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage());
                }
            }
            catch (ClassNotFoundException ex){
                System.out.println(ex.getMessage());
            } 
        return conn; 
    }


    public static void executeQueryWithResultSet(Queryable queryable){
        Connection conn = getConnection();
        Statement stmt = null; 
        ResultSet rs = null; 

        if (conn != null){
            try{
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM GenerelInformation");
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

    public static void updateDataBase(String sqlStatement){
        Connection conn = getConnection();
        Statement stmt = null; 
        if (conn != null){
            try{
                stmt = conn.createStatement();
                stmt.executeUpdate(sqlStatement); 
            }
            catch (SQLException sqlex){
                System.out.println(sqlex.getMessage());
            }
            finally {
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