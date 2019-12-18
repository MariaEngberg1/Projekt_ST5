package dk.aau.models.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManipulator {

    /**
     * method for establishing a connection to AAU database
     * @return a connection if successful else return null
     */
    public static Connection getConnection(){
        Connection conn = null; 
            try {
                // Define the DB communication driver 
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                try{
                    // Set user, password, and adress to database
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

    /**
     * Method for fetching information from database
     * @param queryable - any class implementing the interface Queryable can be used here
     * @param sqlStatement must be a SQL-statenent which return a result set
     */
    public static void executeQueryWithResultSet(Queryable queryable, String sqlStatement){
        // Establish the connection
        Connection conn = getConnection();
        Statement stmt = null; 
        ResultSet rs = null; 

        if (conn != null){
            try{
                // Creates a Statement object for sending SQL statements to the database.
                stmt = conn.createStatement();
                // Executes the given SQL statement, which returns a single ResultSet object.
                rs = stmt.executeQuery(sqlStatement);

                // Make inserted class procoess the resultset
                queryable.processResultSet(rs); 
            }
            catch (SQLException sqlex){
                System.out.println(sqlex.getMessage());
            }
            finally {
                // Releases this ResultSet object's database and JDBC resources immediately instead of waiting for this to happen when it is automatically closed.
                try{
                    rs.close();
                }
                catch (SQLException sqlex){
                    System.out.println(sqlex.getMessage());
                }
                
                // Releases this Statement object's database and JDBC resources immediately instead of waiting for this to happen when it is automatically closed.
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