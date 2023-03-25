/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoModulo;
/**
 *
 * @author visitante
 */
public class clsModulo {
    private int IdModulo;
    private String NombreModulo;
    private String EstatusModulo;

    public int getIdModulo() {
        return IdModulo;
    }

    public void setIdModulo(int IdModulo) {
        this.IdModulo = IdModulo;
    }

    public String getNombreModulo() {
        return NombreModulo;
    }

    public void setNombreModulo(String NombreModulo) {
        this.NombreModulo = NombreModulo;
    }

    public String getEstatusModulo() {
        return EstatusModulo;
    }

    public void setEstatusModulo(String EstatusModulo) {
        this.EstatusModulo = EstatusModulo;
    }

    public clsModulo(int IdModulo, String NombreModulo) {
        this.IdModulo = IdModulo;
        this.NombreModulo = NombreModulo;
    }

    public clsModulo(int IdModulo, String NombreModulo, String EstatusModulo) {
        this.IdModulo = IdModulo;
        this.NombreModulo = NombreModulo;
        this.EstatusModulo = EstatusModulo;
    }

    public clsModulo(int IdModulo) {
        this.IdModulo = IdModulo;
    }

    public clsModulo() {
    }
    
    //Metodos de acceso a la capa controlador
    public clsModulo getBuscarInformacionModuloPorNombre(clsModulo modulo)
    {
        daoModulo daomodulo = new daoModulo();
        return daomodulo.consultaModuloPorNombre(modulo);
    }
    public clsModulo getBuscarInformacionModuloPorId(clsModulo modulo)
    {
        daoModulo daomodulo = new daoModulo();
        return daomodulo.consultaModuloPorId(modulo);
    }    
    public List<clsModulo> getListadoModulo()
    {
        daoModulo daomodulo = new daoModulo();
        List<clsModulo> listadoUsuarios = daomodulo.consultaModulo();
        return listadoUsuarios;
    }
    public int setBorrarModulo(clsModulo modulo)
    {
        daoModulo daomodulo = new daoModulo();
        return daomodulo.borrarModulo(modulo);
    }          
    public int setIngresarModulo(clsModulo modulo)
    {
        daoModulo daomodulo = new daoModulo();
        return daomodulo.ingresaModulo(modulo);
    }              
    public int setModificarModulo(clsModulo modulo)
    {
        daoModulo daomodulo = new daoModulo();
        return daomodulo.actualizaModulo(modulo);
    }              
}
