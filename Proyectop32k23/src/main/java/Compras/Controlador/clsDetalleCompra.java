/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compras.Controlador;

import Compras.Modelo.daoDetalleCompra;
import java.util.List;

/**
 *
 * @author Bryan Illescas 9959-20-273
 */
public class clsDetalleCompra {
    private int id_detalle_compra;
    private int id_orden_compra;
    private int id_producto;
    private int id_bodega;
    private int id_clasificacion;
    private int cantidad;
    private Double precio_unitario;
    

    public int getid_detalle_compra() {
        return id_detalle_compra;
    }

    public void setid_detalle_compra(int id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }
    
    public int getid_orden_compra() {
        return id_orden_compra;
    }

    public void setid_orden_compra(int id_orden_compra) {
        this.id_orden_compra = id_orden_compra;
    }

    public int getid_producto() {
        return id_producto;
    }

    public void setid_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getid_bodega() {
        return id_bodega;
    }

    public void setid_bodega(int id_bodega) {
        this.id_bodega = id_bodega;
    }
    
    public int getid_clasificacion() {
        return id_clasificacion;
    }

    public void setid_clasificacion(int id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }
    
    public int getcantidad() {
        return cantidad;
    }

    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public Double getprecio_unitario() {
        return precio_unitario;
    }

    public void setprecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public clsDetalleCompra(int id_detalle_compra, int id_orden_compra, int id_producto, int id_bodega, int id_clasificacion, int cantidad, Double precio_unitario) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_orden_compra = id_orden_compra;
        this.id_producto = id_producto;
        this.id_bodega = id_bodega;
        this.id_clasificacion = id_clasificacion;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        
    }

    public clsDetalleCompra(int id_detalle_compra, int id_orden_compra, int id_producto, int id_bodega, int id_clasificacion, int cantidad) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_orden_compra = id_orden_compra;
        this.id_producto = id_producto;
        this.id_bodega = id_bodega;
        this.id_clasificacion = id_clasificacion;
        this.cantidad = cantidad;
        
    }

    public clsDetalleCompra(int id_detalle_compra, int id_orden_compra, int id_producto, int id_bodega, int id_clasificacion) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_orden_compra = id_orden_compra;
        this.id_producto = id_producto;
        this.id_bodega = id_bodega;
        this.id_clasificacion = id_clasificacion;
        
    }
    
    public clsDetalleCompra(int id_detalle_compra, int id_orden_compra, int id_producto, int id_bodega) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_orden_compra = id_orden_compra;
        this.id_producto = id_producto;
        this.id_bodega = id_bodega;
        
    }
    
    public clsDetalleCompra(int id_detalle_compra, int id_orden_compra, int id_producto) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_orden_compra = id_orden_compra;
        this.id_producto = id_producto;
        
    }
    
    public clsDetalleCompra(int id_detalle_compra, int id_orden_compra) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_orden_compra = id_orden_compra;
        
    }
    
    public clsDetalleCompra(int id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
        
    }


    public clsDetalleCompra() {
    }
    //Metodos de acceso a la capa controlador
    /*public clsDetalleCompras getconsultaDetalleCompraPorId(clsModuloCompras DetalleCompra)
    {
        daoDetalleCompra daoDetalleCompra = new daoDetalleCompra();
        return daoDetalleCompra.consultaDetalleCompraPorId(DetalleCompra);
    }*/
    public clsDetalleCompra getBuscarInformacionDetalleCompraPorId(clsDetalleCompra DetalleCompra)
    {
        daoDetalleCompra daoDetalleCompra = new daoDetalleCompra();
        return daoDetalleCompra.consultaDetalleCompraPorId(DetalleCompra);
    }
    public List<clsDetalleCompra> getListadoDetalleCompra()
    {
        daoDetalleCompra daoDetalleCompra = new daoDetalleCompra();
        List<clsDetalleCompra> listadoDetalleCompra = daoDetalleCompra.consultaDetalleCompra();
        return listadoDetalleCompra;
    }
    public int setBorrarDetalleCompra(clsDetalleCompra DetalleCompra)
    {
        daoDetalleCompra daoDetalleCompra = new daoDetalleCompra();
        return daoDetalleCompra.borrarDetalleCompra(DetalleCompra);
    }          
    public int setIngresarDetalleCompra(clsDetalleCompra DetalleCompra)
    {
        daoDetalleCompra daoDetalleCompra = new daoDetalleCompra();
        return daoDetalleCompra.ingresaDetalleCompra(DetalleCompra);
    }              
    public int setModificarDetalleCompra(clsDetalleCompra DetalleCompra)
    {
        daoDetalleCompra daoDetalleCompra = new daoDetalleCompra();
        return daoDetalleCompra.actualizaDetalleCompra(DetalleCompra);
    }              

    public void add(clsDetalleCompra DetalleCompra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


