/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoPerfilUsuario;
import Seguridad.Vista.frmMantenimientoPerfilUsuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author visitante
 */
 /*Creado por María José Véliz Ochoa 9959-21-5909 */

public class clsPerfilUsuario {
    

    public clsPerfilUsuario() {
    }


    public ArrayList<String> obtenerNombresUsuarios() {
    daoPerfilUsuario dao = new daoPerfilUsuario();
    return dao.obtenerNombresUsuarios();
    }


    public void cargarTabla(DefaultTableModel modelo) {
        daoPerfilUsuario dao = new daoPerfilUsuario();
        dao.cargarTabla(modelo);
    }

    public ArrayList<String> obtenerPerfilesUsuario(String usuario) {
    daoPerfilUsuario dao = new daoPerfilUsuario();
    return dao.obtenerPerfilesUsuario(usuario);
}




     

}