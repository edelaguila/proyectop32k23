/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuentas_Corrientes.Controlador;
import Seguridad.Controlador.*;
import java.util.List;
import Seguridad.Modelo.daoAplicacion;
/**
 *
 * @author visitante
 */

public class clsCCorrientes {
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

    public clsCCorrientes(int IdAplicacion, String NombreAplicacion, String EstatusAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsCCorrientes(int IdAplicacion, String NombreAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
    }

    public clsCCorrientes(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public clsCCorrientes() {
    }
    //Metodos de acceso a la capa controlador
    public clsCCorrientes getBuscarInformacionAplicacionPorNombre(clsCCorrientes aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.consultaAplicacionPorNombre(aplicacion);
    }
    public clsCCorrientes getBuscarInformacionAplicacionPorId(clsCCorrientes aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.consultaAplicacionPorId(aplicacion);
    }    
    public List<clsCCorrientes> getListadoAplicaciones()
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        List<clsCCorrientes> listadoUsuarios = daoAplicacion.consultaAplicacion();
        return listadoUsuarios;
    }
    public int setBorrarAplicacion(clsCCorrientes aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.borrarAplicacion(aplicacion);
    }          
    public int setIngresarAplicacion(clsCCorrientes aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.ingresaAplicacion(aplicacion);
    }              
    public int setModificarAplicacion(clsCCorrientes aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.actualizaAplicacion(aplicacion);
    }              
}
