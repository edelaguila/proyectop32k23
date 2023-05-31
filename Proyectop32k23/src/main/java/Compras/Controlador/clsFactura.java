/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compras.Controlador;

import Compras.Modelo.daoFactura;
import java.util.List;

/**
 *
 * @author Bryan Illescas 9959-20-273
 */
public class clsFactura {
    private int id_factura;
    private int id_compra;
    private String fecha_factura;
    private Double total_factura;
    

    public int getid_factura() {
        return id_factura;
    }

    public void setid_factura(int id_factura) {
        this.id_factura = id_factura;
    }
    
    public int getid_compra() {
        return id_compra;
    }

    public void setid_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getfecha_factura() {
        return fecha_factura;
    }

    public void setfecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public double gettotal_factura() {
        return total_factura;
    }

    public void settotal_factura(Double total_factura) {
        this.total_factura = total_factura;
    }

    public clsFactura(int id_factura, int id_compra, String fecha_factura, Double total_factura) {
        this.id_factura = id_factura;
        this.id_compra = id_compra;
        this.fecha_factura = fecha_factura;
        this.total_factura = total_factura;
        
    }

    public clsFactura(int id_factura, int id_compra, Double total_factura) {
        this.id_factura = id_factura;
        this.id_compra = id_compra;
        this.total_factura = total_factura;
        
    }

    public clsFactura(int id_factura, int id_compra) {
        this.id_factura = id_factura;
        this.id_compra = id_compra;
        
    }
    
    public clsFactura(int id_factura) {
        this.id_factura = id_factura;
        
    }


    public clsFactura() {
    }
    //Metodos de acceso a la capa controlador
    /*public clsModuloCompras getconsultaFacturaPorFecha(clsModuloCompras factura)
    {
        daoFactura daoFactura = new daoFactura();
        return daoFactura.consultaFacturaPorFecha(factura);
    }
    public clsModuloCompras getconsultaFacturaPorId(clsFactura factura)
    {
        daoFactura daoFactura = new daoFactura();
        return daoFactura.consultaFacturaPorId(factura);
    }*/
    public List<clsFactura> getListadoFactura()
    {
        daoFactura daoFactura = new daoFactura();
        List<clsFactura> listadoFactura = daoFactura.consultaFactura();
        return listadoFactura;
    }
    public int setBorrarFactura(clsFactura factura)
    {
        daoFactura daoFactura = new daoFactura();
        return daoFactura.borrarFactura(factura);
    }          
    public int setIngresarFactura(clsFactura factura)
    {
        daoFactura daoFactura = new daoFactura();
        return daoFactura.ingresaFactura(factura);
    }              
    public int setModificarFactura(clsFactura factura)
    {
        daoFactura daoFactura = new daoFactura();
        return daoFactura.actualizaFactura(factura);
    }              

    public void add(clsFactura factura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


