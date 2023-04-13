/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoAplicaciónPerfil;
/**
 *
 * @author visitante
 */
public class clsAplicacionPerfil {
    private int IdAplicacionPerfil;
    private String NombreAplicacionPerfil;
    private String EditarApPerfil;
    private String IngresarApPerfil;
    private String EliminarApPerfil;
    private String VerApPerfil;

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

    public String getEditarApPerfil() {
        return EditarApPerfil;
    }

    public void setEditarApPerfil(String EditarApPerfil) {
        this.EditarApPerfil = EditarApPerfil;
    }

    public String getIngresarApPerfil() {
        return IngresarApPerfil;
    }

    public void setIngresarApPerfil(String IngresarApPerfil) {
        this.IngresarApPerfil = IngresarApPerfil;
    }

    public String getEliminarApPerfil() {
        return EliminarApPerfil;
    }

    public void setEliminarApPerfil(String EliminarApPerfil) {
        this.EliminarApPerfil = EliminarApPerfil;
    }

    public String getVerApPerfil() {
        return VerApPerfil;
    }

    public void setVerApPerfil(String VerApPerfil) {
        this.VerApPerfil = VerApPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacionPerfil, String NombreAplicacionPerfil, String EditarApPerfil, String IngresarApPerfil, String EliminarApPerfil, String VerApPerfil) {
        this.IdAplicacionPerfil = IdAplicacionPerfil;
        this.NombreAplicacionPerfil = NombreAplicacionPerfil;
        this.EditarApPerfil = EditarApPerfil;
        this.IngresarApPerfil = IngresarApPerfil;
        this.EliminarApPerfil = EliminarApPerfil;
        this.VerApPerfil = VerApPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacionPerfil, String NombreAplicacionPerfil, String EditarApPerfil, String IngresarApPerfil, String EliminarApPerfil) {
        this.IdAplicacionPerfil = IdAplicacionPerfil;
        this.NombreAplicacionPerfil = NombreAplicacionPerfil;
        this.EditarApPerfil = EditarApPerfil;
        this.IngresarApPerfil = IngresarApPerfil;
        this.EliminarApPerfil = EliminarApPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacionPerfil, String NombreAplicacionPerfil, String EditarApPerfil, String IngresarApPerfil) {
        this.IdAplicacionPerfil = IdAplicacionPerfil;
        this.NombreAplicacionPerfil = NombreAplicacionPerfil;
        this.EditarApPerfil = EditarApPerfil;
        this.IngresarApPerfil = IngresarApPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacionPerfil, String NombreAplicacionPerfil, String EditarApPerfil) {
        this.IdAplicacionPerfil = IdAplicacionPerfil;
        this.NombreAplicacionPerfil = NombreAplicacionPerfil;
        this.EditarApPerfil = EditarApPerfil;
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
        daoAplicaciónPerfil daoAplicaciónPerfil = new daoAplicaciónPerfil();
        return daoAplicaciónPerfil.consultaAplicacionPorNombre(aplicacionPerfil);
    }
    public clsAplicacionPerfil getBuscarInformacionAplicacionPorId(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicaciónPerfil daoAplicaciónPerfil = new daoAplicaciónPerfil();
        return daoAplicaciónPerfil.consultaAplicacionPorId(aplicacionPerfil);
    }    
    public List<clsAplicacionPerfil> getListadoAplicaciones()
    {
        daoAplicaciónPerfil daoAplicaciónPerfil = new daoAplicaciónPerfil();
        List<clsAplicacionPerfil> listadoUsuarios = daoAplicaciónPerfil.consultaAplicacion();
        return listadoUsuarios;
    }
    public int setBorrarAplicacion(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicaciónPerfil daoAplicaciónPerfil = new daoAplicaciónPerfil();
        return daoAplicaciónPerfil.borrarAplicacion(aplicacionPerfil);
    }          
    public int setIngresarAplicacion(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicaciónPerfil daoAplicaciónPerfil = new daoAplicaciónPerfil();
        return daoAplicaciónPerfil.ingresaAplicacion(aplicacionPerfil);
    }              
    public int setModificarAplicacion(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicaciónPerfil daoAplicaciónPerfil = new daoAplicaciónPerfil();
        return daoAplicaciónPerfil.actualizaAplicacion(aplicacionPerfil);
    }              
}
