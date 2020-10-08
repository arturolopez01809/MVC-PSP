/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.AlumnoController;
import controlador.AsignaturaController;
import controlador.MatriculaController;
import modelo.Alumno;
import modelo.Asignatura;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Matricula;

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
    
    public void printTablaMatricula(ArrayList<Matricula> array_matricula){
        
        for(Matricula matricula : array_matricula){
            
            System.out.println(matricula);
        }
    }
    
    public String getDni_user(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dni del usuario: ");
        String dni = sc.next();
        
        return dni;
    }
    
    public void menu() throws SQLException{
        System.out.println("1) Mostrar alumnos pertenecientes al sistema");
        System.out.println("2) Mostrar asignaturas pertenecientes al sistema");
        System.out.println("3) Mostrar asignaturas matriculadas por un alumno");
        
        System.out.println("Opción: ");
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = sc.nextInt();
        
        switch(opcion){
            
            case 1:
                AlumnoController alumn_controller = new AlumnoController();
                ArrayList<Alumno> array_alumn = alumn_controller.getTablaAlumno();
                this.printTablaALumno(array_alumn);
                
                alumn_controller.getArray_alumno().get(1).setApellido("Cabezazo de Zidane");
                
                System.out.println("Array de controlador");
                System.out.println(alumn_controller.getArray_alumno());
                System.out.println("Array de Vista");
                System.out.println(array_alumn);
                
                
                break;
            case 2:
                AsignaturaController asig_controller = new AsignaturaController();
                ArrayList<Asignatura> array_asignatura = asig_controller.getTablaAsignatura();
                this.printTablaAsignatura(array_asignatura);
                
                break;
            case 3:
                MatriculaController matricula_controller = new MatriculaController();
                String dni = this.getDni_user();
                ArrayList<Matricula> array_matricula = matricula_controller.getTablaMatricula(dni);
                this.printTablaMatricula(array_matricula);
                
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
