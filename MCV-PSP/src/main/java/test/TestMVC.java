/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import vista.Vista;

/**
 *
 * @author artur
 */
public class TestMVC {
    public static void main(String args[]) throws SQLException{
        
        Vista vista = new Vista();
        
        do{
            vista.menu();
        }while(vista.isBucle() == true);
    }
}
