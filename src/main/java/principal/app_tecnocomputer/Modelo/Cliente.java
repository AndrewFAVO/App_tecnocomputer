/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.app_tecnocomputer.Modelo;


/**
 *
 * @author Jaider Carmona
 */
public class Cliente {

 
   
    //datos de la base de datos.
    private int ID;
    private String Nombre;
    private String Usuario;
    private String Contrasena;
    private String Correo_electronico;
            
    
        public Cliente() {}
        //parametros
        public Cliente(int ID, String Nombre_Completo, String Usuario, String Contrasena, String Correo_electronico) {
        this.ID = ID;
        this.Nombre = Nombre_Completo;
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
        this.Correo_electronico = Correo_electronico;
    }
        //Getters y Setters
    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    
    public String getnombreCompleto() { return Nombre; }
    public void setnombreCompleto(String Nombre_Completo) { this.Nombre = Nombre_Completo; }

    public String getUsuario() { return Usuario; }
    public void setUsuario(String Usuario) { this.Usuario = Usuario; }

    public String getContrasena() { return Contrasena; }
    public void setContrasena(String Contrasena) { this.Contrasena = Contrasena; }

    public String getCorreo_electronico() { return Correo_electronico; }
    public void setCorreo_electronico(String Correo_electronico) { this.Correo_electronico = Correo_electronico; }
}
