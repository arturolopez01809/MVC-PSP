/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author artur
 */
public class Asignatura {
    
    private String cod_asig;
    private String nom_asig;

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

    @Override
    public String toString() {
        return "Asignatura{" + "cod_asig=" + cod_asig + ", nom_asig=" + nom_asig + '}';
    }
    
    
}
