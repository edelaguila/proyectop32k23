/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compras.Controlador;

import Compras.Modelo.daoModuloCompras;
import java.util.List;

/**
 *
 * @author Bryan Illescas 9959-20-273
 */


public class clsModuloCompras {
    private int id_compra;
    private int id_proveedor;
    private String fecha_compra;
    private double total_compra;
    

    public int getid_compra() {
        return id_compra;
    }

    public void setid_compra(int id_compra) {
        this.id_compra = id_compra;
    }
    
    public int getid_proveedor() {
        return id_proveedor;
    }

    public void setid_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getfecha_compra() {
        return fecha_compra;
    }

    public void setfecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public double gettotal_compra() {
        return total_compra;
    }

    public void settotal_compra(Double total_compra) {
        this.total_compra = total_compra;
    }

    public clsModuloCompras(int id_compra, int id_proveedor, String fecha_compra, Double total_compra) {
        this.id_compra = id_compra;
        this.id_proveedor = id_proveedor;
        this.fecha_compra = fecha_compra;
        this.total_compra = total_compra;
        
    }

    public clsModuloCompras(int id_compra, int id_proveedor, Double total_compra) {
        this.id_compra = id_compra;
        this.id_proveedor = id_proveedor;
        this.total_compra = total_compra;
        
    }

    public clsModuloCompras(int id_compra, int id_proveedor) {
        this.id_compra = id_compra;
        this.id_proveedor = id_proveedor;
        
    }
    
    public clsModuloCompras(int id_compra) {
        this.id_compra = id_compra;
        
    }


    public clsModuloCompras() {
    }
    //Metodos de acceso a la capa controlador
    /*public clsModuloCompras getBuscarInformacionompraPorFecha(clsModuloCompras compra)
    {
        daoModuloCompras daoModuloCompras = new daoModuloCompras();
        return daoModuloCompras.consultaModuloComprasPorFecha(compra);
    }
    public clsModuloCompras getBuscarInformacionModuloComprasPorId(clsModuloCompras compra)
    {
        daoModuloCompras daoModuloCompras = new daoModuloCompras();
        return daoModuloCompras.consultaModuloComprasPorId(compra);
    }   */ 
    public List<clsModuloCompras> getListadoCompra()
    {
        daoModuloCompras daoModuloCompras = new daoModuloCompras();
        List<clsModuloCompras> listadoCompra = daoModuloCompras.consultaModuloCompras();
        return listadoCompra;
    }
    public int setBorrarCompra(clsModuloCompras compra)
    {
        daoModuloCompras daoModuloCompras = new daoModuloCompras();
        return daoModuloCompras.borrarCompra(compra);
    }          
    public int setIngresarCompra(clsModuloCompras compra)
    {
        daoModuloCompras daoModuloCompras = new daoModuloCompras();
        return daoModuloCompras.ingresaCompra(compra);
    }              
    public int setModificarCompra(clsModuloCompras compra)
    {
        daoModuloCompras daoModuloCompras = new daoModuloCompras();
        return daoModuloCompras.actualizaCompra(compra);
    }              

    public void add(clsModuloCompras compra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

