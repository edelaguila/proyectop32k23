/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoTipoMoneda;
/**
 *
 * @author visitante
 */
public class clsTipoMoneda {
    private int tipModId;
    private String tipMondNombre;
    private String tipMondAbreviacion;
    private float tipModValor;
    
    public clsTipoMoneda() {
    }

    public clsTipoMoneda(int tipModId) {
        this.tipModId = tipModId;
    }

    public clsTipoMoneda(int tipModId, String tipMondNombre) {
        this.tipModId = tipModId;
        this.tipMondNombre = tipMondNombre;
    }

    public clsTipoMoneda(int tipModId, String tipMondNombre, String tipMondAbreviacion) {
        this.tipModId = tipModId;
        this.tipMondNombre = tipMondNombre;
        this.tipMondAbreviacion = tipMondAbreviacion;
    }

    public clsTipoMoneda(int tipModId, String tipMondNombre, String tipMondAbreviacion, float tipModValor) {
        this.tipModId = tipModId;
        this.tipMondNombre = tipMondNombre;
        this.tipMondAbreviacion = tipMondAbreviacion;
        this.tipModValor = tipModValor;
    }


    public int getTipModId() {
        return tipModId;
    }

    public void setTipModId(int tipModId) {
        this.tipModId = tipModId;
    }

    public String getTipMondNombre() {
        return tipMondNombre;
    }

    public void setTipMondNombre(String tipMondNombre) {
        this.tipMondNombre = tipMondNombre;
    }

    public String getTipMondAbreviacion() {
        return tipMondAbreviacion;
    }

    public void setTipMondAbreviacion(String tipMondAbreviacion) {
        this.tipMondAbreviacion = tipMondAbreviacion;
    }

    public float getTipModValor() {
        return tipModValor;
    }

    public void setTipModValor(float tipModValor) {
        this.tipModValor = tipModValor;
    }
    

  
    @Override
    public String toString() {
        return "clsTipoMoneda{" + "tipModId =" + tipModId    + ", tipMondNombre=" + tipMondNombre + ", tipMondAbreviacion=" + tipMondAbreviacion + ", tipModValor  =" + tipModValor   + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsTipoMoneda getBuscarInformacionTipoMonedaPorNombre(clsTipoMoneda moneda)
    {
        daoTipoMoneda daoTipoMoneda = new daoTipoMoneda();
        return daoTipoMoneda.consultaTipoMonedaPorNombre(moneda);
    }
    public clsTipoMoneda getBuscarInformacionMonedaPorId(clsTipoMoneda moneda)
    {
        daoTipoMoneda daoTipoMoneda = new daoTipoMoneda();
        return daoTipoMoneda.consultaTipoMonedaPorId(moneda);
    }    
    public List<clsTipoMoneda> getListadoMonedas()
    {
        daoTipoMoneda daoTipoMoneda = new daoTipoMoneda();
        List<clsTipoMoneda> listadoMonedas = daoTipoMoneda.consultaTipoMoneda();
        return listadoMonedas;
    }
    public int setBorrarMoneda(clsTipoMoneda moneda)
    {
        daoTipoMoneda daoTipoMoneda = new daoTipoMoneda();
        return daoTipoMoneda.borrarTipoMoneda(moneda);
    }          
    public int setIngresarMoneda(clsTipoMoneda moneda)
    {
        daoTipoMoneda daoTipoMoneda = new daoTipoMoneda();
        return daoTipoMoneda.ingresaTipoMoneda(moneda);
    }              
    public int setModificarMoneda(clsTipoMoneda moneda)
    {
        daoTipoMoneda daoTipoMoneda = new daoTipoMoneda();
        return daoTipoMoneda.actualizaTipoMoneda(moneda);
    }              

    public void getTipModValor(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTipMondValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
