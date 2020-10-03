/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Alumno;
import modelo.Asignatura;
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
    
    public void setArray_alumno_mostrar(ArrayList<Alumno> array_alumno_mostrar) {
        this.array_alumno_mostrar = array_alumno_mostrar;
    }

    public void setArray_asignatura(ArrayList<Asignatura> array_asignatura) {
        this.array_asignatura = array_asignatura;
    }
    
    public ArrayList<Alumno> getArray_alumno_mostrar() {
        return array_alumno_mostrar;
    }

    public ArrayList<Asignatura> getArray_asignatura() {
        return array_asignatura;
    }
    
    public void cleanArrayAlumno(ArrayList<Alumno> array_alumn){
        array_alumn.clear();
    }
    
    public void cleanArrayAsignatura(ArrayList<Asignatura> array_asignatura){
        array_asignatura.clear();
    }
    
    public ArrayList<Alumno> printAlumno() throws SQLException{

        ConnectionJDBC connection = new ConnectionJDBC();
        this.setArray_alumno_mostrar(connection.getTablaAlumno(connection));
        return this.getArray_alumno_mostrar();
        
    }
    
    public ArrayList<Asignatura> printAsignatura() throws SQLException{
         
        ConnectionJDBC connection = new ConnectionJDBC();
        this.setArray_asignatura(connection.getTablaAsignatua(connection));
        return this.getArray_asignatura();
        
    }
    
    
}
