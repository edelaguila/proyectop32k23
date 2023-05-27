/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Meyglin del Rosario Rosales Ochoa 
// 9959 - 21 - 4490 

package Ventas.Controlador;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Ventas.Modelo.daoCotizacion;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author visitante
 */

public class clsCotizacion {
    private int IdProducto;
    private String NombreProducto;
    private Double PrecioProducto;
    private int ExistenciaProducto;

    public clsCotizacion() {
    }

    public clsCotizacion(int IdCliente) {
        this.IdProducto = IdCliente;
    }

    public clsCotizacion(String NombreProducto, double PrecioProducto, int ExistenciaProducto) {
        this.NombreProducto = NombreProducto;
        this.PrecioProducto = PrecioProducto;
        this.ExistenciaProducto = ExistenciaProducto;
    }

    public clsCotizacion(int IdProducto, String NombreProducto, double PrecioProducto, int ExistenciaProducto) {
        this.IdProducto = IdProducto;
        this.NombreProducto = NombreProducto;
        this.PrecioProducto = PrecioProducto;
        this.ExistenciaProducto = ExistenciaProducto;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }


public Double getPrecioProducto() {
    return PrecioProducto;
}

public void setPrecioProducto(Double PrecioProducto) {
    this.PrecioProducto = PrecioProducto;
}

public int getExistenciaProducto() {
    return ExistenciaProducto;
}


public void setExistenciaProducto(int ExistenciaProducto) {
    this.ExistenciaProducto = ExistenciaProducto;
}


    @Override
    public String toString() {
        return "clsCotizacion{" + "IdProducto=" + IdProducto + ", NombreProducto=" + NombreProducto + ", PrecioProducto=" + PrecioProducto + ", ExistenciaProducto=" + ExistenciaProducto + '}';
    }
    //Metodos de acceso a la capa controlador
 
    public List<clsCotizacion> getListadoProductos()
    {
        daoCotizacion daoProducto = new daoCotizacion();
        List<clsCotizacion> listadoProductos = daoProducto.consultaProducto();
        return listadoProductos;
    }
    
    
    
    public double obtenerPrecioProducto(int codigoProducto) {
    daoCotizacion dao = new daoCotizacion();
    return dao.obtenerPrecioProducto(codigoProducto);
} 
    public int verificarExistencias(int codigoProducto) {
    daoCotizacion dao = new daoCotizacion();
    return dao.verificarExistencias(codigoProducto);
}   
    public void registrarCotizacionDetalle(int cotizacionId, DefaultTableModel model) {
    daoCotizacion dao = new daoCotizacion();
    dao.registrarCotizacionDetalle( cotizacionId, model);
}   
    public void registrarCotizacion(int idCliente, int idVendedor, LocalDate fecha, double total) {
    daoCotizacion dao = new daoCotizacion();
    dao.registrarCotizacion( idCliente,  idVendedor, fecha, total);
}
    public int obtenerUltimoIdCotizacion() {
    daoCotizacion dao = new daoCotizacion();
    return dao.obtenerUltimoIdCotizacion();
}
    
}
