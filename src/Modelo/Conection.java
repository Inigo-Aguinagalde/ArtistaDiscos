package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
	
	public static Connection  connect() {
        Connection conn = null;
        

        try {
            // db parameters
            
            // create a connection to the database
        	Connection con=DriverManager.getConnection(  
            		"jdbc:mysql://localhost:3306/artistas_discos","root","root"); 
          
        	conn=con;
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
   
        
        return conn;
    }

}
