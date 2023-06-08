/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoTipoPersonaBancos;
/**
 *
 * @author visitante
 */
//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
//Hecho todo ClsTipo Persona Bancos
public class clsTipoPersonaBancos {
    private int IdTipoPersonaBancos;
    private String TipoDescripcionBancos;
    private String TipoEstatusBancos;

    public clsTipoPersonaBancos(int IdTipoPersonaBancos, String TipoDescripcionBancos, String TipoEstatusBancos) {
        this.IdTipoPersonaBancos = IdTipoPersonaBancos;
        this.TipoDescripcionBancos = TipoDescripcionBancos;
        this.TipoEstatusBancos = TipoEstatusBancos;
    }

    public clsTipoPersonaBancos(String TipoDescripcionBancos, String TipoEstatusBancos) {
        this.TipoDescripcionBancos = TipoDescripcionBancos;
        this.TipoEstatusBancos = TipoEstatusBancos;
    }

    public clsTipoPersonaBancos(int IdTipoPersonaBancos) {
        this.IdTipoPersonaBancos = IdTipoPersonaBancos;
    }

    public clsTipoPersonaBancos() {
    }

    public int getIdTipoPersonaBancos() {
        return IdTipoPersonaBancos;
    }

    public void setIdTipoPersonaBancos(int IdTipoPersonaBancos) {
        this.IdTipoPersonaBancos = IdTipoPersonaBancos;
    }

    public String getTipoDescripcionBancos() {
        return TipoDescripcionBancos;
    }

    public void setTipoDescripcionBancos(String TipoDescripcionBancos) {
        this.TipoDescripcionBancos = TipoDescripcionBancos;
    }

    public String getTipoEstatusBancos() {
        return TipoEstatusBancos;
    }

    public void setTipoEstatusBancos(String TipoEstatusBancos) {
        this.TipoEstatusBancos = TipoEstatusBancos;
    }


  

  @Override
    public String toString() {
        return "clsBancos{" + "IdTipoPersonaBancos=" + IdTipoPersonaBancos+ ", TipoDescripcionBancos=" + TipoDescripcionBancos + ", Estatus=" + TipoEstatusBancos + '}';
    }

    
    //Metodos de acceso a la capa controlador
    public clsTipoPersonaBancos getBuscarInformacionBancoPorDecripcion(clsTipoPersonaBancos banco)
    {
        daoTipoPersonaBancos daoBancos = new daoTipoPersonaBancos();
        return daoBancos.consultaBancoPorDescripcion(banco);
    }
    public clsTipoPersonaBancos getBuscarInformacionBancoPorTipo(clsTipoPersonaBancos banco)
    {
        daoTipoPersonaBancos daoBancos= new daoTipoPersonaBancos();
        return daoBancos.consultaBancoPorTipo(banco);
    }    
    public List<clsTipoPersonaBancos> getListadoBancos()
    {
        daoTipoPersonaBancos daoBancos = new daoTipoPersonaBancos();
        List<clsTipoPersonaBancos> listadoBancos = daoBancos.consultaBanco();
        return listadoBancos;
    }
    public int setBorrarBanco(clsTipoPersonaBancos banco)
    {
        daoTipoPersonaBancos daoBancos = new daoTipoPersonaBancos();
        return daoBancos.borrarBanco(banco);
    }          
    public int setIngresarBanco(clsTipoPersonaBancos banco)
    {
        daoTipoPersonaBancos daoBancos= new daoTipoPersonaBancos();
        return daoBancos.ingresaBanco(banco);
    }              
    public int setModificarBanco(clsTipoPersonaBancos banco)
    {
        daoTipoPersonaBancos daoBancos = new daoTipoPersonaBancos();
        return daoBancos.actualizaBanco(banco);
    }              
}
