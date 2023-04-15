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
public class clsAplicacion {
    private int IdAplicacion;
    private String NombreAplicacion;
    private String EstatusAplicacion;

    public int getIdAplicacion() {
        return IdAplicacion;
    }

    public void setIdAplicacion(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public String getNombreAplicacion() {
        return NombreAplicacion;
    }

    public void setNombreAplicacion(String NombreAplicacion) {
        this.NombreAplicacion = NombreAplicacion;
    }

    public String getEstatusAplicacion() {
        return EstatusAplicacion;
    }

    public void setEstatusAplicacion(String EstatusAplicacion) {
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsAplicacion(int IdAplicacion, String NombreAplicacion, String EstatusAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsAplicacion(int IdAplicacion, String NombreAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
    }

    public clsAplicacion(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public clsAplicacion() {
    }

    
    //Metodos de acceso a la capa controlador
    public clsAplicacion getBuscarInformacionAplicacionPorNombre(clsAplicacion aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.consultaAplicacionPorNombre(aplicacion);
    }
    public clsAplicacion getBuscarInformacionAplicacionPorId(clsAplicacion aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.consultaAplicacionPorId(aplicacion);
    }    
    public List<clsAplicacion> getListadoAplicaciones()
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        List<clsAplicacion> listadoUsuarios = daoAplicacion.consultaAplicacion();
        return listadoUsuarios;
    }
    public int setBorrarAplicacion(clsAplicacion aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.borrarAplicacion(aplicacion);
    }          
    public int setIngresarAplicacion(clsAplicacion aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.ingresaAplicacion(aplicacion);
    }              
    public int setModificarAplicacion(clsAplicacion aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.actualizaAplicacion(aplicacion);
    }              
}
