/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author artur
 */
public class ConnectionJDBC {
    
    private Connection conn;
    
    private final String SQL_SELECT_ALUMNO = "SELECT * FROM alumno";
    private final String SQL_SELECT_ASIGNATURA = "SELECT * FROM asignatura";

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    
    public ConnectionJDBC(){
        
        String url = "jdbc:mysql://localhost:3306/mvc-psp?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        
        this.conn = null;
        try {
            this.conn = DriverManager.getConnection(url, "root", "Poquipsi1.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public ArrayList<Alumno> getTablaAlumno(ConnectionJDBC conn_jdvc) throws SQLException{
        
        ArrayList<Alumno> array_alumno = new ArrayList();
        
        Statement stmt = null;
        
        ResultSet rs = null;
        
        Alumno alumn = new Alumno();
        
        try {

            stmt = conn_jdvc.getConn().createStatement();

            rs = stmt.executeQuery(SQL_SELECT_ALUMNO);

            while (rs.next()) {
                
                alumn.setDni(rs.getString("dni"));
                alumn.setNombre(rs.getString("nombre"));
                alumn.setApellido(rs.getString("apellido"));
                
                array_alumno.add(alumn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally{
            stmt.close();
            rs.close();
            conn_jdvc.getConn().close();
        }
        
        return array_alumno;
    }
    
    public ArrayList<Asignatura> getTablaAsignatua(ConnectionJDBC conn_jdvc) throws SQLException{
        
        ArrayList<Asignatura> array_asignaturas = new ArrayList();
        
        Statement stmt = null;
        ResultSet rs = null;
        
        Asignatura asignatura = new Asignatura();
        
        try{
            stmt = conn_jdvc.getConn().createStatement();
            
            rs = stmt.executeQuery(SQL_SELECT_ASIGNATURA);
            
            while(rs.next()){
                asignatura.setCod_asig(rs.getString("cod_asig"));
                asignatura.setNom_asig(rs.getString("nom_asig"));
                
                array_asignaturas.add(asignatura);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally{
            stmt.close();
            rs.close();
            conn_jdvc.getConn().close();
        }
        
        return array_asignaturas;
    }
    
}
