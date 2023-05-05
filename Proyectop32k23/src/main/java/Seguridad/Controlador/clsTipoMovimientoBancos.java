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

public class clsTipoMovimientoBancos {
    private int IdPerfil;
    private String NombrePerfil;
    private String EstatusPerfil;

    public clsTipoMovimientoBancos() {
    }

    public clsTipoMovimientoBancos(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public clsTipoMovimientoBancos(String NombrePerfil, String EstatusPerfil) {
        this.NombrePerfil = NombrePerfil;
        this.EstatusPerfil = EstatusPerfil;
    }

    public clsTipoMovimientoBancos(int IdPerfil, String NombrePerfil, String EstatusPerfil) {
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
    public clsTipoMovimientoBancos getBuscarInformacionPerfilPorNombre(clsTipoMovimientoBancos perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.consultaPerfilPorNombre(perfil);
    }
    public clsTipoMovimientoBancos getBuscarInformacionPerfilPorId(clsTipoMovimientoBancos perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.consultaPerfilPorId(perfil);
    }    
    public List<clsTipoMovimientoBancos> getListadoPerfiles()
    {
        daoPerfil daoperfil = new daoPerfil();
        List<clsTipoMovimientoBancos> listadoPerfiles = daoperfil.consultaPerfil();
        return listadoPerfiles;
    }
    public int setBorrarPerfil(clsTipoMovimientoBancos perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.borrarPerfil(perfil);
    }          
    public int setIngresarPerfil(clsTipoMovimientoBancos perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.ingresaPerfil(perfil);
    }              
    public int setModificarPerfil(clsTipoMovimientoBancos perfil)
    {
        daoPerfil daoperfil = new daoPerfil();
        return daoperfil.actualizaPerfil(perfil);
    }              
}
