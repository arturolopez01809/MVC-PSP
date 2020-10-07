/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Matricula;

/**
 *
 * @author artur
 */
public class MatriculaController {
    private ArrayList<Matricula> array_matricula;
    
    public MatriculaController(){
        this.array_matricula = new ArrayList();
    }

    public void setArray_matricula(ArrayList<Matricula> array_matricula) {
        this.array_matricula = array_matricula;
    }

    public ArrayList<Matricula> getArray_matricula() {
        return array_matricula;
    }
    
    public ArrayList<Matricula> getTablaMatricula(String dni_user) throws SQLException{
        
        Matricula matricula = new Matricula();
        this.setArray_matricula(matricula.getTablaMatricula(dni_user));
        return this.getArray_matricula();
    }
}
