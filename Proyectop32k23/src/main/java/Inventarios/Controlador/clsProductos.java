/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega TODO el codigo para la parte del controlador del mantenimiento de productos
//Victor Josué Jerez Mijangos 9959-21-2081

package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoProductos;
/**
 *
 * @author visitante
 */
public class clsProductos {
    private int IdProductos;
    private int IdLinea;
    private int IdMarca;
    private String NombreProductos;
    private double PreciosProductos;
    private int ExistenciasProductos;
    private String EstatusProductos;

    public int getIdProductos() {
        return IdProductos;
    }

    public void setIdProductos(int IdProductos) {
        this.IdProductos = IdProductos;
    }

    public int getIdLinea() {
        return IdLinea;
    }

    public void setIdLinea(int IdLinea) {
        this.IdLinea = IdLinea;
    }

    public int getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }

    public String getNombreProductos() {
        return NombreProductos;
    }

    public void setNombreProductos(String NombreProductos) {
        this.NombreProductos = NombreProductos;
    }

    public double getPreciosProductos() {
        return PreciosProductos;
    }

    public void setPreciosProductos(double PreciosProductos) {
        this.PreciosProductos = PreciosProductos;
    }

    public int getExistenciasProductos() {
        return ExistenciasProductos;
    }

    public void setExistenciasProductos(int ExistenciasProductos) {
        this.ExistenciasProductos = ExistenciasProductos;
    }

    public String getEstatusProductos() {
        return EstatusProductos;
    }

    public void setEstatusProductos(String EstatusProductos) {
        this.EstatusProductos = EstatusProductos;
    }

    public clsProductos(int IdProductos, int IdLinea, int IdMarca, String NombreProductos, double PreciosProductos, int ExistenciasProductos, String EstatusProductos) {
        this.IdProductos = IdProductos;
        this.IdLinea = IdLinea;
        this.IdMarca = IdMarca;
        this.NombreProductos = NombreProductos;
        this.PreciosProductos = PreciosProductos;
        this.ExistenciasProductos = ExistenciasProductos;
        this.EstatusProductos = EstatusProductos;
    }

    public clsProductos(int IdProductos, int IdLinea, int IdMarca, String NombreProductos, double PreciosProductos, int ExistenciasProductos) {
        this.IdProductos = IdProductos;
        this.IdLinea = IdLinea;
        this.IdMarca = IdMarca;
        this.NombreProductos = NombreProductos;
        this.PreciosProductos = PreciosProductos;
        this.ExistenciasProductos = ExistenciasProductos;
    }

    public clsProductos(int IdProductos, int IdLinea, int IdMarca, String NombreProductos, double PreciosProductos) {
        this.IdProductos = IdProductos;
        this.IdLinea = IdLinea;
        this.IdMarca = IdMarca;
        this.NombreProductos = NombreProductos;
        this.PreciosProductos = PreciosProductos;
    }

    public clsProductos(int IdProductos, int IdLinea, int IdMarca, String NombreProductos) {
        this.IdProductos = IdProductos;
        this.IdLinea = IdLinea;
        this.IdMarca = IdMarca;
        this.NombreProductos = NombreProductos;
    }

    public clsProductos(int IdProductos, int IdLinea, int IdMarca) {
        this.IdProductos = IdProductos;
        this.IdLinea = IdLinea;
        this.IdMarca = IdMarca;
    }

    public clsProductos(int IdProductos, int IdLinea) {
        this.IdProductos = IdProductos;
        this.IdLinea = IdLinea;
    }

    public clsProductos(int IdProductos) {
        this.IdProductos = IdProductos;
    }

    public clsProductos() {
    }
   
    //Metodos de acceso a la capa controlador
    public clsProductos getBuscarInformacionProductosPorNombre(clsProductos Productos)
    {
        daoProductos daoproductos = new daoProductos();
        return daoproductos.consultaProductosPorNombre(Productos);
    }
    public clsProductos getBuscarInformacionProductosPorId(clsProductos Productos)
    {
        daoProductos daoproductos = new daoProductos();
        return daoproductos.consultaProductosPorId(Productos);
    }
    public List<clsProductos> getListadoProductos()
    {
        daoProductos daoproductos = new daoProductos();
        List<clsProductos> listadoProductos = daoproductos.consultaProductos();
        return listadoProductos;
    }
    public int setBorrarProductos(clsProductos Productos)
    {
        daoProductos daoproductos = new daoProductos();
        return daoproductos.borrarProductos(Productos);
    }
    public int setIngresarProductos(clsProductos Productos)
    {
        daoProductos daoproductos = new daoProductos();
        return daoproductos.ingresaProductos(Productos);
    }              
    public int setModificarProductos(clsProductos Productos)
    {
        daoProductos daoproductos = new daoProductos();
        return daoproductos.actualizaProductos(Productos);
    }

    public void add(List<clsProductos> Productos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
