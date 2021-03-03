package data;

import data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try{
            Class.forName("org.postgresql.Driver");     //calling posgresql driver

            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/emp","postgres","0000");  //getting connection with my Database
            return con;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
}
