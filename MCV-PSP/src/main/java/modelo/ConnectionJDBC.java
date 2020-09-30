/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author artur
 */
public class ConnectionJDBC {
    
    private Connection conn;

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }
    
    
    
    public ConnectionJDBC(){
        String url = "jdbc:mysql://localhost:3306/mvc-psp?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        
        conn = null;
        try {
            conn = DriverManager.getConnection(url, "root", "Poquipsi1.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
