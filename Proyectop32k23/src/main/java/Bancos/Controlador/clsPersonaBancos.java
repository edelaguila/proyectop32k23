/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoPersonaBancos;
/**
 *
 * @author visitante
 */
//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
//Hecho completo ClsPersonasBancos
public class clsPersonaBancos {
    private int PerId;
    private String PerNombre;
    private int perTipoId;
    private String perEstatus;

    public clsPersonaBancos() {
    }

    public clsPersonaBancos(int PerId, String PerNombre, int perTipoId, String perEstatus) {
        this.PerId = PerId;
        this.PerNombre = PerNombre;
        this.perTipoId = perTipoId;
        this.perEstatus = perEstatus;
    }

    public clsPersonaBancos(String PerNombre, int perTipoId, String perEstatus) {
        this.PerNombre = PerNombre;
        this.perTipoId = perTipoId;
        this.perEstatus = perEstatus;
    }

    public clsPersonaBancos(String perEstatus) {
        this.perEstatus = perEstatus;
    }

    public clsPersonaBancos(int PerId, String PerNombre, int perTipoId) {
        this.PerId = PerId;
        this.PerNombre = PerNombre;
        this.perTipoId = perTipoId;
    }

    public int getPerId() {
        return PerId;
    }

    public void setPerId(int PerId) {
        this.PerId = PerId;
    }

    public String getPerNombre() {
        return PerNombre;
    }

    public void setPerNombre(String PerNombre) {
        this.PerNombre = PerNombre;
    }

    public int getPerTipoId() {
        return perTipoId;
    }

    public void setPerTipoId(int perTipoId) {
        this.perTipoId = perTipoId;
    }

    public String getPerEstatus() {
        return perEstatus;
    }

    public void setPerEstatus(String perEstatus) {
        this.perEstatus = perEstatus;
    }
    

  
  

  @Override
    public String toString() {
        return "clsBancos{" + "PerId=" + PerId+ ", PerNombre=" + PerNombre + ", perTipoId=" + perTipoId + ", perEstatus=" + perEstatus + '}';
    }

    
  //Metodos de acceso a la capa controlador
    public clsPersonaBancos getBuscarInformacionBancoPorNombre(clsPersonaBancos banco)
    {
        daoPersonaBancos daoBancos = new daoPersonaBancos();
        return daoBancos.consultaBancoPorNombre(banco);
    }
    public clsPersonaBancos getBuscarInformacionBancoPorPersona(clsPersonaBancos banco)
    {
        daoPersonaBancos daoBancos= new daoPersonaBancos();
        return daoBancos.consultaBancoPorPersona(banco);
    }    
    public List<clsPersonaBancos> getListadoBancoPersonas()
    {
        daoPersonaBancos daoBancos = new daoPersonaBancos();
        List<clsPersonaBancos> listadoBancoPersonas = daoBancos.consultaBancoPersonas();
        return listadoBancoPersonas;
    }
    public int setBorrarBancoPersona(clsPersonaBancos banco)
    {
        daoPersonaBancos daoBancos = new daoPersonaBancos();
        return daoBancos.borrarBancoPersonas(banco);
    }          
    public int setIngresarBancoPersona(clsPersonaBancos banco)
    {
        daoPersonaBancos daoBancos= new daoPersonaBancos();
        return daoBancos.ingresaBancoPersonas(banco);
    }              
    public int setModificarBancoPersona(clsPersonaBancos banco)
    {
        daoPersonaBancos daoBancos = new daoPersonaBancos();
        return daoBancos.actualizaBancoPersonas(banco);
    }   
              
}
