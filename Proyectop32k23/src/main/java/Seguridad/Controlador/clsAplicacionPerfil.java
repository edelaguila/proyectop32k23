/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoAplicacion;
/**
 *
 * @author visitante
 */
public class clsAplicacionPerfil {
    private int IdAplicacionPerfil;
    private String NombreAplicacionPerfil;
    private String EstatusAplicacionPerfil;

    public int getIdAplicacionPerfil() {
        return IdAplicacionPerfil;
    }

    public void setIdAplicacionPerfil(int IdAplicacionPerfil) {
        this.IdAplicacionPerfil = IdAplicacionPerfil;
    }

    public String getNombreAplicacionPerfil() {
        return NombreAplicacionPerfil;
    }

    public void setNombreAplicacionPerfil(String NombreAplicacionPerfil) {
        this.NombreAplicacionPerfil = NombreAplicacionPerfil;
    }

    public String getEstatusAplicacionPerfil() {
        return EstatusAplicacionPerfil;
    }

    public void setEstatusAplicacionPerfil(String EstatusAplicacionPerfil) {
        this.EstatusAplicacionPerfil = EstatusAplicacionPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacionPerfil, String NombreAplicacionPerfil, String EstatusAplicacionPerfil) {
        this.IdAplicacionPerfil = IdAplicacionPerfil;
        this.NombreAplicacionPerfil = NombreAplicacionPerfil;
        this.EstatusAplicacionPerfil = EstatusAplicacionPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacionPerfil, String NombreAplicacionPerfil) {
        this.IdAplicacionPerfil = IdAplicacionPerfil;
        this.NombreAplicacionPerfil = NombreAplicacionPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacionPerfil) {
        this.IdAplicacionPerfil = IdAplicacionPerfil;
    }

    public clsAplicacionPerfil() {
    }

    
    
    //Metodos de acceso a la capa controlador
    public clsAplicacionPerfil getBuscarInformacionAplicacionPorNombre(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.consultaAplicacionPorNombre(aplicacionPerfil);
    }
    public clsAplicacionPerfil getBuscarInformacionAplicacionPorId(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.consultaAplicacionPorId(aplicacionPerfil);
    }    
    public List<clsAplicacionPerfil> getListadoAplicaciones()
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        List<clsAplicacionPerfil> listadoUsuarios = daoAplicacion.consultaAplicacion();
        return listadoUsuarios;
    }
    public int setBorrarAplicacion(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.borrarAplicacion(aplicacionPerfil);
    }          
    public int setIngresarAplicacion(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.ingresaAplicacion(aplicacionPerfil);
    }              
    public int setModificarAplicacion(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.actualizaAplicacion(aplicacionPerfil);
    }              
}
