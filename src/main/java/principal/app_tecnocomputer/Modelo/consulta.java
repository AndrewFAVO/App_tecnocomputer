/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.app_tecnocomputer.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class consulta {
    
      Conexion conexion = new Conexion();

    
    
    //Crear un cliente.
      public boolean AgregarCliente(Cliente cliente){
      
           String sql = "INSERT INTO cliente (Nombre_Completo, Usuario, Contrasena,correo_electronico) VALUES (?, ?, ?, ?)";
           
        try (Connection con = conexion.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, cliente.getnombreCompleto());
            pst.setString(2, cliente.getUsuario());
            pst.setString(3, cliente.getContrasena());
            pst.setString(4, cliente.getCorreo_electronico());
            pst.executeUpdate();
            return true;
           } catch (SQLException e) {
            System.out.println("Error al agregar un cliente: " + e.getMessage());
            return false;
        }
    }
      //buscar todos los clientes.
       public List<Cliente> listarClientes() {
       List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM `cliente`";
        try (Connection con = conexion.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("ID"));
                cliente.setnombreCompleto(rs.getString("Nombre_Completo"));
                cliente.setUsuario(rs.getString("Usuario"));
                cliente.setContrasena(rs.getString("Contrasena"));
                cliente.setCorreo_electronico(rs.getString("correo_electronico"));
                lista.add(cliente);
            }} catch (SQLException e) {
            System.out.println("Error al buscar la tabla cliente " + e.getMessage());
                
            }
              return lista;
       }
       //actualizar el cliente.
       public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET Nombre_Completo=?, Usuario=?, Contrasena=?, correo_electronico=? WHERE ID=?";
        try (Connection con = conexion.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, cliente.getnombreCompleto());
            pst.setString(2, cliente.getUsuario());
            pst.setString(3, cliente.getContrasena());
            pst.setString(4, cliente.getCorreo_electronico());
            pst.setInt(5, cliente.getID());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la base de datos cliente: " + e.getMessage());
            return false;
        }
    }
       //Eliminar un cliente en la base de datos
       public boolean eliminarCliente(int id) { 
       
           String sql = "DELETE FROM cliente WHERE ID=?";
           try (Connection con = conexion.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar un cliente, vuelva a intentar: " + e.getMessage());
            return false;
        }
    }
       
        public Cliente buscarCliente(int id) {
           
            Cliente cliente = null;
            String sql = "SELECT * FROM cliente WHERE ID=?";
                try (Connection con = conexion.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setInt(1, id);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        cliente = new Cliente();
                        cliente.setID(rs.getInt("ID"));
                        cliente.setnombreCompleto(rs.getString("Nombre_Completo"));
                        cliente.setUsuario(rs.getString("Usuario"));
                        cliente.setContrasena(rs.getString("Contrasena"));
                        cliente.setCorreo_electronico(rs.getString("correo_electronico"));
                    }
                } catch (SQLException e) {
                    System.out.println("Error al buscar el ID del cliente " + e.getMessage());
                }
                return cliente;
            }
    
}
