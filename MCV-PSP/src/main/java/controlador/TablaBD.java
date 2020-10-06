/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Alumno;
import modelo.Asignatura;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Matricula;

/**
 *
 * @author artur
 */
public class TablaBD {
    
    private ArrayList<Alumno> array_alumno_mostrar;
    private ArrayList<Asignatura> array_asignatura;
    private ArrayList<Matricula> array_matricula;
    
    public void setArray_alumno_mostrar(ArrayList<Alumno> array_alumno_mostrar) {
        this.array_alumno_mostrar = array_alumno_mostrar;
    }

    public void setArray_asignatura(ArrayList<Asignatura> array_asignatura) {
        this.array_asignatura = array_asignatura;
    }

    public void setArray_matricula(ArrayList<Matricula> array_matricula) {
        this.array_matricula = array_matricula;
    }
    
    
    
    public ArrayList<Alumno> getArray_alumno_mostrar() {
        return array_alumno_mostrar;
    }

    public ArrayList<Asignatura> getArray_asignatura() {
        return array_asignatura;
    }

    public ArrayList<Matricula> getArray_matricula() {
        return array_matricula;
    }
    
    
    
    public void cleanArrayAlumno(ArrayList<Alumno> array_alumn){
        array_alumn.clear();
    }
    
    public void cleanArrayAsignatura(ArrayList<Asignatura> array_asignatura){
        array_asignatura.clear();
    }
    
    public void cleanArrayMatricula(ArrayList<Matricula> array_matricula){
        array_matricula.clear();
    }
    
    public ArrayList<Alumno> getTablaAlumno() throws SQLException{
        
          Alumno alumn = new Alumno();
          this.setArray_alumno_mostrar(alumn.getTablaAlumno());
          return this.getArray_alumno_mostrar();
        
    }
    
    public ArrayList<Asignatura> getTablaAsignatura() throws SQLException{
         
        Asignatura asig = new Asignatura();
        this.setArray_asignatura(asig.getTablaAsignatua());
        return this.getArray_asignatura();
        
    }
    
    public ArrayList<Matricula> getTablaMatricula(String dni_user) throws SQLException{
        
        Matricula matricula = new Matricula();
        this.setArray_matricula(matricula.getTablaMatricula(dni_user));
        return this.getArray_matricula();
    }
}
