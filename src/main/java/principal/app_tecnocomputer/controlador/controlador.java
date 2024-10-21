/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.app_tecnocomputer.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import principal.app_tecnocomputer.Modelo.consulta;
import principal.app_tecnocomputer.Vista.Vista_cliente;
import principal.app_tecnocomputer.Modelo.Cliente;



/**
 * @author Jaider Carmona
 */
public class controlador  implements ActionListener {
    
  private Vista_cliente vista;  
        private consulta modelo;  

        // Constructor: recibe la vista y el modelo
        public controlador(Vista_cliente vista, consulta modelo) {
            this.vista = vista;
            this.modelo = modelo;

            // Escuchar eventos de los botones
            this.vista.boton_save.addActionListener(this);
            this.vista.boton_mod.addActionListener(this);
            this.vista.boton_dele.addActionListener(this);
            this.vista.boton_buscar.addActionListener(this);
            this.vista.boton_limpiar.addActionListener(this);
        }

        // Método que maneja las acciones de los botones
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == vista.boton_save) {
               guardarCliente();
            } else if (e.getSource() == vista.boton_mod) {
                modificarCliente();
            } else if (e.getSource() == vista.boton_dele) {
                eliminarCliente();
            } else if (e.getSource() == vista.boton_buscar) {
                buscarCliente();
            } else if (e.getSource() == vista.boton_limpiar) {
                limpiarCampos();
            }
        }

        // Métodos para cada acción de los botones

        private void guardarCliente(){
            Cliente Cliente = new Cliente();
            Cliente.setnombreCompleto (vista.tex_name.getText());
            Cliente.setUsuario(vista.tex_user.getText());
            Cliente.setContrasena(new String(vista.tex_contrasena.getPassword()));
            Cliente.setCorreo_electronico(vista.tex_correo.getText());
            String nombreCompleto = (vista.tex_name.getText());  
            String Usuario = (vista.tex_user.getText());  
            String Contrasena = (new String(vista.tex_contrasena.getPassword()));  
            String Correo_electronico = (vista.tex_correo.getText());;
            
                 if (nombreCompleto.isEmpty() || Usuario.isEmpty() || Contrasena.isEmpty() || Correo_electronico.isEmpty()) {
       
                    JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.");
                    return;  
    }
            
            

            if (modelo.AgregarCliente(Cliente)) {
                JOptionPane.showMessageDialog(vista, "Cliente guardado exitosamente");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al guardar el Cliente");
            }
        }

        private void modificarCliente() {
            Cliente Cliente = new Cliente();
            Cliente.setID(Integer.parseInt(vista.tex_id.getText()));
            Cliente.setnombreCompleto(vista.tex_name.getText());
            Cliente.setUsuario(vista.tex_user.getText());
            Cliente.setContrasena(new String(vista.tex_contrasena.getPassword()));
            Cliente.setCorreo_electronico(vista.tex_correo.getText());

            if (modelo.actualizarCliente(Cliente)) {
                JOptionPane.showMessageDialog(vista, "Cliente actualizado exitosamente");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar el usuario");
            }
        }

        private void eliminarCliente() {
            int id = Integer.parseInt(vista.tex_id.getText());
            if (modelo.eliminarCliente(id)) {
                JOptionPane.showMessageDialog(vista, "Usuario eliminado exitosamente");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al eliminar el usuario");
            }
        }

        private void buscarCliente() {
            int id = Integer.parseInt(vista.tex_id.getText());
            Cliente cliente = modelo.buscarCliente(id);

            if (cliente != null) {
                vista.tex_name.setText(cliente.getnombreCompleto());
                vista.tex_user.setText(cliente.getUsuario());
                vista.tex_contrasena.setText(cliente.getContrasena());
                vista.tex_correo.setText(cliente.getCorreo_electronico());
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario no encontrado");
            }
        }

        private void limpiarCampos() {
            vista.tex_id.setText("");
            vista.tex_name.setText("");
            vista.tex_user.setText("");
            vista.tex_contrasena.setText("");
            vista.tex_correo.setText("");
        }         
        
}
       
  

