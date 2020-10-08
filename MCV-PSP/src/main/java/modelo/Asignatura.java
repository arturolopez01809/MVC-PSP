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
public class Asignatura extends ConnectionJDBC{
    
    private String cod_asig;
    private String nom_asig;
    
    private ArrayList<Asignatura> array_asignatura;
    
    private final String SQL_SELECT_ASIGNATURA = "SELECT * FROM asignatura";
    
    public Asignatura(){
        this.array_asignatura = new ArrayList();
        this.cod_asig = "";
        this.nom_asig = "";
    }

    public void setCod_asig(String cod_asig) {
        this.cod_asig = cod_asig;
    }

    public void setNom_asig(String nom_asig) {
        this.nom_asig = nom_asig;
    }

    public String getCod_asig() {
        return cod_asig;
    }

    public String getNom_asig() {
        return nom_asig;
    }
    
    public ArrayList<Asignatura> getTablaAsignatua() throws SQLException {

        this.getConnection();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = this.conn.createStatement();

            rs = stmt.executeQuery(SQL_SELECT_ASIGNATURA);

            while (rs.next()) {
                Asignatura asignatura = new Asignatura();
                asignatura.setCod_asig(rs.getString("cod_asig"));
                asignatura.setNom_asig(rs.getString("nom_asig"));

              
                this.array_asignatura.add(asignatura);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            stmt.close();
            rs.close();
            this.closeConnection();
        }

        return this.array_asignatura;
    }

    @Override
    public String toString() {
        return "\nAsignatura{" + "\nCod_asig = " + cod_asig + "\nNom_asig = " + nom_asig + "\n}";
    }
    
    
}
