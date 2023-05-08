/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Meyglin del Rosario Rosales Ochoa 
// 9959 - 21 - 4490 

package Ventas.Controlador;
import java.util.List;
import Ventas.Modelo.daoTienda;
/**
 *
 * @author visitante
 */

public class clsTienda {
    private int IdTienda;
    private String NombreTienda;
    private String DireccionTienda;
    private String TipoTienda;
    
    
    public int getIdTienda() {
        return IdTienda;
    }

    public void setIdTienda(int IdTienda) {
        this.IdTienda = IdTienda;
    }

    public String getNombreTienda() {
        return NombreTienda;
    }

    public void setNombreTienda(String NombreTienda) {
        this.NombreTienda = NombreTienda;
    }

    public String getDireccionTienda() {
        return DireccionTienda;
    }

    public void setDireccionTienda(String DireccionTienda) {
        this.DireccionTienda = DireccionTienda;
    }
     public String getTipoTienda() {
        return TipoTienda;
    }

    public void setTipoTienda(String TipoTienda) {
        this.TipoTienda = TipoTienda;
    }
    public clsTienda(int IdTienda, String NombreTienda, String DireccionTienda,String TipoTienda ) {
        this.IdTienda= IdTienda;
        this.NombreTienda = NombreTienda;
        this.DireccionTienda = DireccionTienda;
        this.TipoTienda = TipoTienda;
    }

    public clsTienda(int IdTienda, String NombreTienda, String DireccionTienda) {
        this.IdTienda= IdTienda;
        this.NombreTienda = NombreTienda;
        this.DireccionTienda = DireccionTienda;
    }

    public clsTienda(int IdTienda, String NombreTienda) {
        this.IdTienda = IdTienda;
        this.NombreTienda = NombreTienda;
    }

    public clsTienda(int IdAplicacion) {
        this.IdTienda = IdTienda;
    }

    public clsTienda() {
    }
    
    @Override
    public String toString() {
        return "clsTienda{" + "IdTienda=" + IdTienda + ", NombreTienda=" + NombreTienda + ", DireccionTienda=" + DireccionTienda + ", TipoTienda=" + TipoTienda +'}';
    }
    
    //Metodos de acceso a la capa controlador
    public clsTienda getBuscarInformacionTiendaPorNombre(clsTienda tienda)
    {
        daoTienda daoTienda = new daoTienda();
        return daoTienda.consultaTiendaPorNombre(tienda);
    }
    public clsTienda getBuscarInformacionTiendaPorId(clsTienda tienda)
    {
        daoTienda daoTienda = new daoTienda();
        return daoTienda.consultaTiendaPorId(tienda);
    }    
    public List<clsTienda> getListadoTiendas()
    {
        daoTienda daoTienda = new daoTienda();
        List<clsTienda> listadoUsuarios = daoTienda.consultaTienda();
        return listadoUsuarios;
    }
    public int setBorrarTienda(clsTienda tienda)
    {
        daoTienda daoTienda = new daoTienda();
        return daoTienda.borrarTienda(tienda);
    }          
    public int setIngresarTienda(clsTienda tienda)
    {
        daoTienda daoTienda = new daoTienda();
        return daoTienda.ingresaTienda(tienda);
    }              
    public int setModificarTienda(clsTienda tienda)
    {
        daoTienda daoTienda= new daoTienda();
        return daoTienda.actualizaTienda(tienda);
    }              
}
