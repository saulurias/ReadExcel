/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.perroDesgraciado.entidades;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SaulUrias
 */
public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/serviciodb";
    private String user = "root";
    private String password = "";
    public Connection c;
    
    public Connection conectarDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Exitosa");
        }catch(Exception e){
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return c;
    }
    
}
