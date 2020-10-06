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

    protected Connection conn;
    private int port_number;
    private String data_base;
    private String db_name;
    private String name_host;
    private String user;
    private String password;

    public ConnectionJDBC() {
        this.user = "root";
        this.password = "Poquipsi1.";
        this.db_name = "mvc-psp";
        this.name_host = "localhost";
        this.port_number = 3306;
        this.data_base = "mysql";
    }
    
    public void setPort_number(int port_number) {
        this.port_number = port_number;
    }

    public void setData_base(String data_base) {
        this.data_base = data_base;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public void setName_host(String name_host) {
        this.name_host = name_host;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }
    
    public int getPort_number() {
        return port_number;
    }

    public String getData_base() {
        return data_base;
    }

    public String getDb_name() {
        return db_name;
    }

    public String getName_host() {
        return name_host;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    public void getConnection(){
        String url = "jdbc:" + this.getData_base() + "://" + this.getName_host() + ":" + this.getPort_number() + "/" + this.getDb_name() + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        this.conn = null;
        try {
            this.conn = DriverManager.getConnection(url, "root", "Poquipsi1.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void closeConnection(){
        try{
            this.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
