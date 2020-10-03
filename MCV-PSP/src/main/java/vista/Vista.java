/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.TablaBD;
import modelo.Alumno;
import modelo.Asignatura;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author artur
 */
public class Vista {
    
    private boolean bucle;
    
    public Vista(){
        this.bucle = true;
    }

    public void setBucle(boolean bucle) {
        this.bucle = bucle;
    }

    public boolean isBucle() {
        return bucle;
    }
    
    public void printTablaALumno(ArrayList<Alumno> array_alumn){
        
        for(Alumno alumn : array_alumn){
            
            System.out.println(alumn);
        }
    }
    
    public void printTablaAsignatura(ArrayList<Asignatura> array_asig){
        
        for(Asignatura asignatura : array_asig){
            
            System.out.println(asignatura);
        }
    }
    
    
    
    public void menu() throws SQLException{
        System.out.println("1) Mostrar alumnos pertenecientes al sistema");
        System.out.println("2) Mostrar asignaturas pertenecientes al sistema");
        System.out.println("3) Mostrar asignaturas matriculadas por un alumno");
        
        System.out.println("Opción: ");
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = sc.nextInt();
        
        TablaBD tabla_bd = new TablaBD();
        
        switch(opcion){
            
            case 1:
                ArrayList<Alumno> array_alumn = tabla_bd.printAlumno();
                this.printTablaALumno(array_alumn);
                tabla_bd.cleanArrayAlumno(array_alumn);
                break;
            case 2:
                ArrayList<Asignatura> array_asignatura = tabla_bd.printAsignatura();
                this.printTablaAsignatura(array_asignatura);
                tabla_bd.cleanArrayAsignatura(array_asignatura);
                break;
            case 3:
                break;
            case 4:
                this.setBucle(false);
                break;
            default:
                System.out.println("Opción no reconocible");
                break;
        }
    }

    
  
}
