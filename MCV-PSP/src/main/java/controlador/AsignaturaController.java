/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Asignatura;

/**
 *
 * @author artur
 */
public class AsignaturaController {
    private ArrayList<Asignatura> array_asignaturas;
    
    public AsignaturaController(){
        this.array_asignaturas = new ArrayList();
    }

    public void setArray_asignaturas(ArrayList<Asignatura> array_asignaturas) {
        this.array_asignaturas = array_asignaturas;
    }

    public ArrayList<Asignatura> getArray_asignaturas() {
        return array_asignaturas;
    }
    
    public ArrayList<Asignatura> getTablaAsignatura() throws SQLException{
         
        Asignatura asig = new Asignatura();
        this.setArray_asignaturas(asig.getTablaAsignatua());
        return this.getArray_asignaturas();
        
    }
}
