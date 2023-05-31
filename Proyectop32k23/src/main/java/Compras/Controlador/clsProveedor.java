/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Compras.Controlador;
import Compras.Modelo.daoProveedor;
import java.util.List;

public class clsProveedor {
    private int id_proveedor;
    private String nombre;
    private String direccion;
    private int telefono;
    private String email;

    public int getid_proveedor() {
        return id_proveedor;
    }

    public void setid_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int gettelefono() {
        return id_proveedor;
    }

    public void settelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }


    public clsProveedor() {
    }

    public clsProveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public clsProveedor(int id_proveedor, String nombre) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
    }
    
    public clsProveedor(int id_proveedor, String nombre, String direccion) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public clsProveedor(int id_proveedor, String nombre, String direccion, int telefono) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public clsProveedor(int id_proveedor, String nombre, String direccion, int telefono, String email) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        return "clsProveedor{" + "id_proveedor=" + id_proveedor + ", nombre=" + nombre + ", direccion=" + direccion + "telefono=" + telefono + "email=" + email + '}';
    }
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
    }

    public void add(clsProveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
