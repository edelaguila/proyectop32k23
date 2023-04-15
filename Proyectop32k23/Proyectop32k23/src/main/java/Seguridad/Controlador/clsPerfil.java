/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoPerfil;
/**
 *
 * @author visitante
 */
 /*Creado por María José Véliz Ochoa 9959-21-5909 */

public class clsPerfil {
    private int IdPerfil;
    private String NombrePerfil;
    private String EstatusPerfil;

    public clsPerfil() {
    }

    public clsPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public clsPerfil(String NombrePerfil, String EstatusPerfil) {
        this.NombrePerfil = NombrePerfil;
        this.EstatusPerfil = EstatusPerfil;
    }

    public clsPerfil(int IdPerfil, String NombrePerfil, String EstatusPerfil) {
        this.IdPerfil = IdPerfil;
        this.NombrePerfil = NombrePerfil;
        this.EstatusPerfil = EstatusPerfil;
    }

    public int getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public String getNombrePerfil() {
        return NombrePerfil;
    }

    public void setNombrePerfil(String NombrePerfil) {
        this.NombrePerfil = NombrePerfil;
    }

    public String getEstatusPerfil() {
        return EstatusPerfil;
    }

    public void setEstatusPerfil(String EstatusPerfil) {
        this.EstatusPerfil = EstatusPerfil;
    }

    
    @Override
    public String toString() {
        return "clsPerfil{" + "IdPerfil=" + IdPerfil + ", NombrePerfi=" + NombrePerfil + ", EstatusPerfil=" + EstatusPerfil + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsPerfil getBuscarInformacionPerfilPorNombre(clsPerfil perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.consultaPerfilPorNombre(perfil);
    }
    public clsPerfil getBuscarInformacionPerfilPorId(clsPerfil perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.consultaPerfilPorId(perfil);
    }    
    public List<clsPerfil> getListadoPerfiles()
    {
        daoPerfil daoperfil = new daoPerfil();
        List<clsPerfil> listadoPerfiles = daoperfil.consultaPerfil();
        return listadoPerfiles;
    }
    public int setBorrarPerfil(clsPerfil perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.borrarPerfil(perfil);
    }          
    public int setIngresarPerfil(clsPerfil perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.ingresaPerfil(perfil);
    }              
    public int setModificarPerfil(clsPerfil perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.actualizaPerfil(perfil);
    }              
}
