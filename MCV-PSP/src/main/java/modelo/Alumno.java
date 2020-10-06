/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author artur
 */
public class Alumno extends ConnectionJDBC{
    
    private String dni;
    private String nombre;
    private String apellido;
    
    private ArrayList<Alumno> array_alumno;
    
    private final String SQL_SELECT_ALUMNO = "SELECT * FROM alumno";
    
    public Alumno(){
        this.dni = "";
        this.nombre = "";
        this.apellido = "";
        this.array_alumno = new ArrayList();
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    
    public ArrayList<Alumno> getTablaAlumno() throws SQLException {
        
        this.getConnection();
        
        Statement stmt = null;

        ResultSet rs = null;
 
        try {

            stmt = this.conn.createStatement();

            rs = stmt.executeQuery(SQL_SELECT_ALUMNO);

            while (rs.next()) {
                
                Alumno alumn = new Alumno();
                
                alumn.setDni(rs.getString("dni"));
                alumn.setNombre(rs.getString("nombre"));
                alumn.setApellido(rs.getString("apellido"));

                this.array_alumno.add(alumn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            stmt.close();
            rs.close();
            this.closeConnection();
        }

        return array_alumno;
    }
    
    
    @Override
    public String toString() {
        return "Alumno{" + "dni = " + dni + ", nombre = " + nombre + ", apellido = " + apellido + '}';
    }
    
    
}
