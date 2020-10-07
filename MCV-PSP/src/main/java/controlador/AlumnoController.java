/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Alumno;

/**
 *
 * @author artur
 */
public class AlumnoController {
    private ArrayList<Alumno> array_alumno;
    
    public AlumnoController(){
        this.array_alumno = new ArrayList();
    }

    public void setArray_alumno(ArrayList<Alumno> array_alumno) {
        this.array_alumno = array_alumno;
    }
    
    public ArrayList<Alumno> getArray_alumno() {
        return array_alumno;
    }
    
    public ArrayList<Alumno> getTablaAlumno() throws SQLException{
        
          Alumno alumn = new Alumno();
          this.setArray_alumno(alumn.getTablaAlumno());
          return this.getArray_alumno();
        
    }
}
