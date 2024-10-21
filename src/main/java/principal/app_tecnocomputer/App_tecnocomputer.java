/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal.app_tecnocomputer;

import principal.app_tecnocomputer.Vista.Vista_cliente;
import principal.app_tecnocomputer.controlador.controlador;
import principal.app_tecnocomputer.Modelo.consulta;
/**
 * @author jaider carmona
 */
public class App_tecnocomputer {
    public static void main(String[] args) {
      // Crear instancia de la vista (formulario)
        Vista_cliente vista = new Vista_cliente();

        // Crear instancia del modelo (DAO)
        consulta modelo = new consulta();

        // Crear instancia del controlador y pasarle la vista y el modelo
       new controlador(vista, modelo);
        
        
        vista.setVisible(true);
    }
}
