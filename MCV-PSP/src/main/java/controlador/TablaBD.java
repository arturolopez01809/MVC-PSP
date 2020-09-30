/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datos.Alumno;
import datos.Asignatura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.ConnectionJDBC;

/**
 *
 * @author artur
 */
public class TablaBD {
    
    private ArrayList<Alumno> array_alumno_mostrar;
    private ArrayList<Asignatura> array_asignatura;
    
    private final String SQL_SELECT_ALUMNO = "SELECT * FROM alumno";
    private final String SQL_SELECT_ASIGNATURA = "SELECT * FROM asignatura";

    public void setArray_alumno_mostrar(ArrayList<Alumno> array_alumno_mostrar) {
        this.array_alumno_mostrar = array_alumno_mostrar;
    }

    public void setArray_asignatura(ArrayList<Asignatura> array_asignatura) {
        this.array_asignatura = array_asignatura;
    }

    public ArrayList<Alumno> getArray_alumno_mostrar() {
        return this.array_alumno_mostrar;
    }

    public ArrayList<Asignatura> getArray_asignatura() {
        return this.array_asignatura;
    }

    public String getSQL_SELECT_ALUMNO() {
        return this.SQL_SELECT_ALUMNO;
    }
    
    public void cleanArrayAlumno(ArrayList<Alumno> array_alumn){
        array_alumn.clear();
    }
    
    public void cleanArrayAsignatura(ArrayList<Asignatura> array_asignatura){
        array_asignatura.clear();
    }

    public TablaBD() {
        this.array_alumno_mostrar = new ArrayList<Alumno>();
        this.array_asignatura = new ArrayList<Asignatura>();
    }
    
    
    
    public ArrayList<Alumno> printAlumno() throws SQLException{

        ConnectionJDBC conn_jdvc = new ConnectionJDBC();
        
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
                
                this.getArray_alumno_mostrar().add(alumn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally{
            stmt.close();
            rs.close();
            conn_jdvc.getConn().close();
        } 
        return array_alumno_mostrar;
        
    }
    
    public ArrayList<Asignatura> printAsignatura() throws SQLException{
        ConnectionJDBC conn_jdvc = new ConnectionJDBC();
        
        Statement stmt = null;
        ResultSet rs = null;
        
        Asignatura asignatura = new Asignatura();
        
        try{
            stmt = conn_jdvc.getConn().createStatement();
            
            rs = stmt.executeQuery(SQL_SELECT_ASIGNATURA);
            
            while(rs.next()){
                asignatura.setCod_asig(rs.getString("cod_asig"));
                asignatura.setNom_asig(rs.getString("nom_asig"));
                
                this.getArray_asignatura().add(asignatura);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally{
            stmt.close();
            rs.close();
            conn_jdvc.getConn().close();
        } 
        
        return array_asignatura;
    }
}
