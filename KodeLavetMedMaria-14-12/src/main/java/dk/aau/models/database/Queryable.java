package dk.aau.models.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Queryable{
    void processResultSet(ResultSet rs) throws SQLException; 
}