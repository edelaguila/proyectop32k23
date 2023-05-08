/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Seguridad.Controlador;
import java.util.List;
//import Seguridad.Modelo.daoProveedor;
/**
 *
 * Hecho por Luis Diego Cortez Mérida, 9959-20-7425, Grupo 4
 */
public class clsProveedor {
    private int id_proveedor;
    private String nombre;
    private String direccion;

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public clsProveedor() {
    }

    public clsProveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public clsProveedor(int id_proveedor, String nombre, String direccion) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "clsProveedor{" + "id_proveedor=" + id_proveedor + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
    /*Métodos del Dao
    public clsProveedor getBuscarInformacionProveedorPorNombre(clsProveedor proveedor)
    {
        daoProveedor daoProveedor = new daoProveedor();
        return daoProveedor.consultaProveedorPorNombre(proveedor);
    }
    public clsProveedor getBuscarInformacionProveedorPorId(clsProveedor proveedor)
    {
        daoProveedor daoProveedor = new daoProveedor();
        return daoProveedor.consultaProveedorPorId(proveedor);
    }    
    public List<clsProveedor> getListadoProveedores()
    {
        daoProveedor daoProveedor = new daoProveedor();
        List<clsProveedor> listadoUsuarios = daoProveedor.consultaProveedor();
        return listadoUsuarios;
    }
    public int setBorrarProveedor(clsProveedor proveedor)
    {
        daoProveedor daoProveedor = new daoProveedor();
        return daoProveedor.borrarProveedor(proveedor);
    }          
    public int setIngresarProveedor(clsProveedor proveedor)
    {
        daoProveedor daoProveedor = new daoProveedor();
        return daoProveedor.ingresaProveedor(proveedor);
    }              
    public int setModificarProveedor(clsProveedor proveedor)
    {
        daoProveedor daoProveedor = new daoProveedor();
        return daoProveedor.actualizaProveedor(proveedor);
    }*/

    public void add(clsProveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
