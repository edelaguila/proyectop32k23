/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras.Controlador;

import Compras.Modelo.daoProducto;
import java.util.List;

/**
 *
 * @author Joshua Aguilar 9959-20-4660
 */
public class clsProducto {
    private int id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private Double precio_unitario;
    private int existencias_total;
    

    public int getid_producto() {
        return id_producto;
    }

    public void setid_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    public String getnombre_producto() {
        return nombre_producto;
    }

    public void setnombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    
    public String getdescripcion_producto() {
        return descripcion_producto;
    }

    public void setdescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public Double getprecio_unitario() {
        return precio_unitario;
    }

    public void setprecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getexistencias_total() {
        return existencias_total;
    }

    public void setexistencias_total(int existencias_total) {
        this.existencias_total = existencias_total;
    }

    public clsProducto(int id_producto, String nombre_producto, String descripcion_producto, Double precio_unitario, int existencias_total) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.precio_unitario = precio_unitario;
        this.existencias_total = existencias_total;
        
    }

    public clsProducto(int id_producto, String nombre_producto, Double precio_unitario) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.precio_unitario = precio_unitario;
    }

   public clsProducto(int id_producto, String nombre_producto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
    }
    
    public clsProducto(int id_producto) {
        this.id_producto = id_producto;
    }


    public clsProducto() {
    }
    
    @Override
    public String toString() {
        return "clsProducto{" + "id_producto=" + id_producto + ", nombre_producto=" + nombre_producto + ", descripcion_producto=" + descripcion_producto + "precio_unitario=" + precio_unitario + "existencias_total=" + existencias_total + '}';
    }
    
    //Metodos de acceso a la capa controlador
    public clsProducto getconsultaProductoPorNombre(clsProducto producto)
    {
        daoProducto daoProducto = new daoProducto();
        return daoProducto.consultaProductoPorNombre(producto);
    }
    public clsProducto getconsultaProductoPorId(clsProducto producto)
    {
        daoProducto daoProducto = new daoProducto();
        return daoProducto.consultaProductoPorId(producto);
    }
    public List<clsProducto> getListadoProducto()
    {
        daoProducto daoProducto = new daoProducto();
        List<clsProducto> listadoProducto = daoProducto.consultaProducto();
        return listadoProducto;
    }
    public int setborrarProducto(clsProducto producto)
    {
        daoProducto daoProducto = new daoProducto();
        return daoProducto.borrarProducto(producto);
    }          
    public int setingresaProducto(clsProducto producto)
    {
        daoProducto daoProducto = new daoProducto();
        return daoProducto.ingresaProducto(producto);
    }              
    public int setactualizaProducto(clsProducto producto)
    {
        daoProducto daoProducto = new daoProducto();
        return daoProducto.actualizaProducto(producto);
    }              

    public void add(clsProducto daoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}



