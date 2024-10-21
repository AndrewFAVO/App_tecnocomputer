/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.app_tecnocomputer.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jaider Carmona
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3307/base_tencocomputer";
    private static final String User = "root"; // Cambia según tu configuración
    private static final String Passaword = "haider1028"; // Cambia según tu configuración

    public Connection getConnection() {
        
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, User, Passaword);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }
            return con;
        }

}
