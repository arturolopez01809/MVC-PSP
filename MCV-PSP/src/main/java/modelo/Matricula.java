/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author artur
 */
public class Matricula extends ConnectionJDBC{
    private String dni;
    private String cod_asig;
    
    private ArrayList<Matricula> array_matricula;
    
    private final String SQL_SELECT_MATRICULA_DNI = "SELECT * FROM matricula WHERE dni=?";
    
    public Matricula(){
        this.array_matricula = new ArrayList();
        this.dni = "";
        this.cod_asig = "";
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCod_asig(String cod_asig) {
        this.cod_asig = cod_asig;
    }

    public String getDni() {
        return dni;
    }

    public String getCod_asig() {
        return cod_asig;
    }
    
    
    public ArrayList<Matricula> getTablaMatricula(String dni_user) throws SQLException {
        
        this.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
  
            stmt = this.conn.prepareStatement(SQL_SELECT_MATRICULA_DNI);
            
            stmt.setString(1, dni_user);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Matricula matricula = new Matricula();
                
                matricula.setDni(rs.getString("dni"));
                matricula.setCod_asig(rs.getString("cod_asig"));

                this.array_matricula.add(matricula);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            stmt.close();
            rs.close();
            this.closeConnection();
        }

        return this.array_matricula;
    }
    

    @Override
    public String toString() {
        return "Matricula{" + "dni = " + dni + ", cod_asig = " + cod_asig + '}';
    }
    
    
}
