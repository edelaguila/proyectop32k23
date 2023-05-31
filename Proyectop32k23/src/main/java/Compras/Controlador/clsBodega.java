/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compras.Controlador;

import Compras.Modelo.daoBodega;
import java.util.List;

/**
 *
 * @author Bryan Illescas 9959-20-273
 */
public class clsBodega {
    private int id_bodega;
    private String nombre_bodega;
    private String direccion_bodega;
    private int telefono;

    public int getid_bodega() {
        return id_bodega;
    }

    public void setid_bodega(int id_bodega) {
        this.id_bodega = id_bodega;
    }

    public String getnombre_bodega() {
        return nombre_bodega;
    }

    public void setnombre_bodega(String nombre_bodega) {
        this.nombre_bodega = nombre_bodega;
    }

    public String getdireccion_bodega() {
        return direccion_bodega;
    }

    public void setdireccion_bodega(String direccion_bodega) {
        this.direccion_bodega = direccion_bodega;
    }
    
    public int gettelefono() {
        return telefono;
    }

    public void settelefono(int telefono) {
        this.telefono = telefono;
    }

    public clsBodega(int id_bodega, String nombre_bodega, String direccion_bodega, int telefono) {
        this.id_bodega = id_bodega;
        this.nombre_bodega = nombre_bodega;
        this.direccion_bodega = direccion_bodega;
        this.telefono = telefono;
    }
    
    public clsBodega(int id_bodega, String nombre_bodega) {
        this.id_bodega = id_bodega;
        this.nombre_bodega = nombre_bodega;
    }
    
    public clsBodega(int id_bodega) {
        this.id_bodega = id_bodega;
    }
    
    public clsBodega(){
    
}

    @Override
    public String toString() {
        return "clsBodega{" + "id_bodega=" + id_bodega + ", nombre_bodega=" + nombre_bodega + ", direccion_bodega=" + direccion_bodega + "telefono=" + telefono + '}';
    }
    
    public clsBodega getBuscarInformacionBodegaPorNombre(clsBodega bodega)
    {
        daoBodega daoBodega = new daoBodega();
        return daoBodega.consultaBodegaPorNombre(bodega);
    }
    public clsBodega getBuscarInformacionBodegaPorId(clsBodega bodega)
    {
        daoBodega daoBodega = new daoBodega();
        return daoBodega.consultaBodegaPorId(bodega);
    }    
    public List<clsBodega> getListadoBodega()
    {
        daoBodega daoBodega = new daoBodega();
        List<clsBodega> listadoBodega = daoBodega.consultaBodega();
        return listadoBodega;
    }
    public int setBorrarBodega(clsBodega bodega)
    {
        daoBodega daoBodega = new daoBodega();
        return daoBodega.borrarBodega(bodega);
    }          
    public int setIngresarBodega(clsBodega bodega)
    {
        daoBodega daoBodega = new daoBodega();
        return daoBodega.ingresaBodega(bodega);
    }              
    public int setModificarBodega(clsBodega bodega)
    {
        daoBodega daoBodega = new daoBodega();
        return daoBodega.actualizaBodega(bodega);
    }

    public void add(clsBodega bodega) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
