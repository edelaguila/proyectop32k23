/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Meyglin del Rosario Rosales Ochoa 
// 9959 - 21 - 4490 

package Ventas.Controlador;
import java.util.List;
import Ventas.Modelo.daoVendedores;
/**
 *
 * @author visitante
 */

public class clsVendedores {
    private int IdVendedor;
    private String NombreVendedor;
    private String DireccionVendedor;
    private String TelefonoVendedor;
    private String EmailVendedor;
    private String EstatusVendedor;
    
    
    public int getIdVendedor() {
        return IdVendedor;
    }

    public void setIdVendedor(int IdVendedor) {
        this.IdVendedor = IdVendedor;
    }

    public String getNombreVendedor() {
        return NombreVendedor;
    }

    public void setNombreVendedor(String NombreVendedor) {
        this.NombreVendedor = NombreVendedor;
    }

    public String getDireccionVendedor() {
        return DireccionVendedor;
    }

    public void setDireccionVendedor(String DireccionVendedor) {
        this.DireccionVendedor = DireccionVendedor;
    }
     public String getTelefonoVendedor() {
        return TelefonoVendedor;
    }

    public void setTelefonoVendedor(String TelefonoVendedor) {
        this.TelefonoVendedor = TelefonoVendedor;
    }
    
     public String getEmailVendedor() {
        return EmailVendedor;
    }

    public void setEmailVendedor(String EmailVendedor) {
        this.EmailVendedor = EmailVendedor;
    }
    
public String getEstatusVendedor() {
        return EstatusVendedor;
    }

    public void setEstatusVendedor(String EstatusVendedor) {
        this.EstatusVendedor = EstatusVendedor;
    }
    
     public clsVendedores(int IdVendedor, String NombreVendedor, String DireccionVendedor,String TelefonoVendedor, String EmailVendedor ) {
        this.IdVendedor= IdVendedor;
        this.NombreVendedor = NombreVendedor;
        this.DireccionVendedor = DireccionVendedor;
        this.TelefonoVendedor = TelefonoVendedor;
        this.EmailVendedor = EmailVendedor;
    }
   
    public clsVendedores(int IdVendedor, String NombreVendedor, String DireccionVendedor,String TelefonoVendedor) {
        this.IdVendedor = IdVendedor;
        this.NombreVendedor = NombreVendedor;
        this.DireccionVendedor = DireccionVendedor;
        this.TelefonoVendedor = TelefonoVendedor;
    }

    public clsVendedores(int IdVendedor, String NombreVendedor, String DireccionVendedor) {
        this.IdVendedor = IdVendedor;
        this.NombreVendedor = NombreVendedor;
        this.DireccionVendedor = DireccionVendedor;
    }

    public clsVendedores(int IdVendedor, String NombreVendedor) {
        this.IdVendedor = IdVendedor;
        this.NombreVendedor = NombreVendedor;
    }

    public clsVendedores(int IdVendedor) {
        this.IdVendedor = IdVendedor;
    }

    public clsVendedores() {
    }
    
    @Override
    public String toString() {
        return "clsVendedores{" + "IdVendedor=" + IdVendedor + ", NombreVendedor=" + NombreVendedor + ", DireccionVendedor=" + DireccionVendedor + ", TelefonoVendedor=" + TelefonoVendedor + ", EmailVendedor=" + EmailVendedor +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsVendedores getBuscarInformacionVendedorPorNombre(clsVendedores vendedor)
    {
        daoVendedores daovendedores = new daoVendedores();
        return daovendedores.consultaVendedorPorNombre(vendedor);
    }
    public clsVendedores getBuscarInformacionVendedorPorId(clsVendedores vendedor)
    {
        daoVendedores daovendedores = new daoVendedores();
        return daovendedores.consultaVendedorPorId(vendedor);
    }    
    public List<clsVendedores> getListadoVendedores()
    {
        daoVendedores daovendedores = new daoVendedores();
        List<clsVendedores> listadoUsuarios = daovendedores.consultaVendedor();
        return listadoUsuarios;
    }
    public int setBorrarVendedor(clsVendedores vendedor)
    {
        daoVendedores daovendedores = new daoVendedores();
        return daovendedores.borrarVendedor(vendedor);
    }          
    public int setIngresarVendedor(clsVendedores vendedor)
    {
        daoVendedores daovendedores = new daoVendedores();
        return daovendedores.ingresaVendedor(vendedor);
    }              
    public int setModificarVendedor(clsVendedores vendedor)
    {
        daoVendedores daovendedores = new daoVendedores();
        return daovendedores.actualizaVendedor(vendedor);
    }              
}
