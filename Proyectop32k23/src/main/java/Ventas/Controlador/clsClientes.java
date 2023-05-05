/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.Controlador;
import java.util.List;
import Ventas.Modelo.daoClientes;
/**
 *
 * @author visitante
 */
//Carlos Javier Sandoval Catalán
//9959-21-1324
//clsClientes

public class clsClientes {
    private int IdCliente;
    private String NombreCliente;
    private String EstatusCliente;

    public clsClientes() {
    }

    public clsClientes(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public clsClientes(String NombreCliente, String EstatusCliente) {
        this.NombreCliente = NombreCliente;
        this.EstatusCliente = EstatusCliente;
    }

    public clsClientes(int IdCliente, String NombreCliente, String EstatusCliente) {
        this.IdCliente = IdCliente;
        this.NombreCliente = NombreCliente;
        this.EstatusCliente = EstatusCliente;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getEstatusCliente() {
        return EstatusCliente;
    }

    public void setEstatusCliente(String EstatusCliente) {
        this.EstatusCliente = EstatusCliente;
    }

    
    @Override
    public String toString() {
        return "clsClientes{" + "IdCliente=" + IdCliente + ", NombreCliente=" + NombreCliente + ", EstatusCliente=" + EstatusCliente + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsClientes getBuscarInformacionClientePorNombre(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.consultaClientePorNombre(cliente);
    }
    public clsClientes getBuscarInformacionClientePorId(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.consultaClientePorId(cliente);
    }    
    public List<clsClientes> getListadoClientes()
    {
        daoClientes daocliente = new daoClientes();
        List<clsClientes> listadoClientes = daocliente.consultaCliente();
        return listadoClientes;
    }
    public int setBorrarCliente(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.borrarCliente(cliente);
    }          
    public int setIngresarCliente(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.ingresaCliente(cliente);
    }              
    public int setModificarCliente(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.actualizaCliente(cliente);
    }              
}
