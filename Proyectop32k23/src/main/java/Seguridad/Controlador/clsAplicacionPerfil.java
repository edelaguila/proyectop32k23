/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoAplicacionPerfil;
import Seguridad.Modelo.daoAplicacion;
/**
 *
 * @author visitante
 */
public class clsAplicacionPerfil {
    private int IdAplicacion;
    private int  IdPerfil;
    private String EditarApPerfil;
    private String IngresarApPerfil;
    private String EliminarApPerfil;
    private String VerApPerfil;

    public int getIdAplicacion() {
        return IdAplicacion;
    }

    public void setIdAplicacion(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public int getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
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

    public clsAplicacionPerfil(int IdAplicacion, int IdPerfil, String EditarApPerfil, String IngresarApPerfil, String EliminarApPerfil, String VerApPerfil) {
        this.IdAplicacion = IdAplicacion;
        this.IdPerfil = IdPerfil;
        this.EditarApPerfil = EditarApPerfil;
        this.IngresarApPerfil = IngresarApPerfil;
        this.EliminarApPerfil = EliminarApPerfil;
        this.VerApPerfil = VerApPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacion, int IdPerfil, String EditarApPerfil, String IngresarApPerfil, String EliminarApPerfil) {
        this.IdAplicacion = IdAplicacion;
        this.IdPerfil = IdPerfil;
        this.EditarApPerfil = EditarApPerfil;
        this.IngresarApPerfil = IngresarApPerfil;
        this.EliminarApPerfil = EliminarApPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacion, int IdPerfil, String EditarApPerfil, String IngresarApPerfil) {
        this.IdAplicacion = IdAplicacion;
        this.IdPerfil = IdPerfil;
        this.EditarApPerfil = EditarApPerfil;
        this.IngresarApPerfil = IngresarApPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacion, int IdPerfil, String EditarApPerfil) {
        this.IdAplicacion = IdAplicacion;
        this.IdPerfil = IdPerfil;
        this.EditarApPerfil = EditarApPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacion, int IdPerfil) {
        this.IdAplicacion = IdAplicacion;
        this.IdPerfil = IdPerfil;
    }

    public clsAplicacionPerfil(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public clsAplicacionPerfil() {
    }

    
    
    //Metodos de acceso a la capa controlador
    /*public clsAplicacionPerfil getBuscarInformacionAplicacionPorNombre(clsAplicacion aplicacionPerfil)
    {
        daoAplicacionPerfil daoAplicacionPerfil = new daoAplicacionPerfil();
        return daoAplicacionPerfil.consultaAplicacionPerfilPorNombre(aplicacionPerfil);
    }*/
    public clsAplicacionPerfil getBuscarInformacionAplicacionPerfilPorId(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicacionPerfil daoAplicacionPerfil = new daoAplicacionPerfil();
        return daoAplicacionPerfil.consultaPerfilAplicacionPorId(aplicacionPerfil);
    }    
    public List<clsAplicacionPerfil> getListadoAplicaciones()
    {
        daoAplicacionPerfil daoAplicacionPerfil = new daoAplicacionPerfil();
        List<clsAplicacionPerfil> listadoPerfiles = daoAplicacionPerfil.consultaPerfilAplicacion();
        return listadoPerfiles;
    }
    public int setBorrarAplicacion(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicacionPerfil daoAplicacionPerfil = new daoAplicacionPerfil();
        return daoAplicacionPerfil.borrarPerfilAplicacion(aplicacionPerfil);
    }          
    public int setIngresarAplicacion(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicacionPerfil daoAplicacionPerfil = new daoAplicacionPerfil();
        return daoAplicacionPerfil.ingresaPerfilAplicacion(aplicacionPerfil);
    }              
    public int setModificarAplicacion(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicacionPerfil daoAplicacionPerfil = new daoAplicacionPerfil();
        return daoAplicacionPerfil.actualizaPerfilAplicacion(aplicacionPerfil);
    }
    
    public int setBorrarTodoAplicacion(clsAplicacionPerfil aplicacionPerfil)
    {
        daoAplicacionPerfil daoAplicacionPerfil = new daoAplicacionPerfil();
        return daoAplicacionPerfil.borrarTodoAplicacion(aplicacionPerfil);
    }

}

