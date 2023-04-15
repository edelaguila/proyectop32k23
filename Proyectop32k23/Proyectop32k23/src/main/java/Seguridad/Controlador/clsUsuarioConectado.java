/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;

/**
 *
 * @author visitante
 */
public class clsUsuarioConectado {
    private static int IdUsuario;
    private static String NombreUsuario;     
    
public clsUsuarioConectado() {
    }    

    public static int getIdUsuario() {
        return IdUsuario;
    }

    public static void setIdUsuario(int IdUsuario) {
        clsUsuarioConectado.IdUsuario = IdUsuario;
    }

    public static String getNombreUsuario() {
        return NombreUsuario;
    }

    public static void setNombreUsuario(String NombreUsuario) {
        clsUsuarioConectado.NombreUsuario = NombreUsuario;
    }

    
    
}
