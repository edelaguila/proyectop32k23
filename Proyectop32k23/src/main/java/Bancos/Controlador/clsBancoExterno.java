/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bancos.Controlador;
import java.util.List;
import java.util.prefs.BackingStoreException;

import Bancos.Modelo.daoBancoExterno;
import Bancos.Modelo.daoTipoMoneda;
/**
 *
 * @author visitante
 */
public class clsBancoExterno {
    private int codigoBanco;
    private String nombreBanco;
    private String paisBanco;
    private int tipoMonedaId;
    private String estatus;

    public clsBancoExterno() {
    }

    public clsBancoExterno(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public clsBancoExterno(int codigoBanco, String nombreBanco) {
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
    }

    public clsBancoExterno(int codigoBanco, String nombreBanco, String paisBanco) {
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
        this.paisBanco = paisBanco;
    }

    public clsBancoExterno(int codigoBanco, String nombreBanco, String paisBanco, int tipoMonedaId) {
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
        this.paisBanco = paisBanco;
        this.tipoMonedaId = tipoMonedaId;
    }

    public clsBancoExterno(int codigoBanco, String nombreBanco, String paisBanco, int tipoMonedaId, String estatus) {
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
        this.paisBanco = paisBanco;
        this.tipoMonedaId = tipoMonedaId;
        this.estatus = estatus;
    }

    public int getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getPaisBanco() {
        return paisBanco;
    }

    public void setPaisBanco(String paisBanco) {
        this.paisBanco = paisBanco;
    }

    public int getTipoMonedaId() {
        return tipoMonedaId;
    }

    public void setTipoMonedaId(int tipoMonedaId) {
        this.tipoMonedaId = tipoMonedaId;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    
    @Override
    public String toString() {
        return "clsBancoExterno{" + "codigoBanco =" + codigoBanco    + ", nombreBanco=" + nombreBanco + ", paisBanco=" + paisBanco + ", tipoMonedaId  =" + tipoMonedaId + ", estatus  =" + estatus + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsBancoExterno getBuscarInformacionBancoPorNombre(clsBancoExterno banco)
    {
        daoBancoExterno daobancoexterno = new daoBancoExterno();
        return daobancoexterno.consultaBancoPorNombre(banco);
    }
    public clsBancoExterno getBuscarInformacionBancoPorId(clsBancoExterno banco)
    {
        daoBancoExterno daobancoexterno = new daoBancoExterno();
        return daobancoexterno.consultaBancoPorId(banco);
    }    
    public List<clsBancoExterno> getListadoBancosExternos()
    {
        daoBancoExterno daobancoexterno = new daoBancoExterno();
        List<clsBancoExterno> listadoBancosExternos = daobancoexterno.consultaBanco();
        return listadoBancosExternos;
    }
    public int setBorrarBancoExterno(clsBancoExterno banco)
    {
        daoBancoExterno daobancoexterno = new daoBancoExterno();
        return daobancoexterno.borrarBancoExterno(banco);
    }          
    public int setIngresarBancoExterno(clsBancoExterno banco)
    {
        daoBancoExterno daobancoexterno = new daoBancoExterno();
        return daobancoexterno.ingresarBancoExterno(banco);
    }              
    public int setModificarBancoExterno(clsBancoExterno banco)
    {
        daoBancoExterno daobancoexterno = new daoBancoExterno();
        return daobancoexterno.actualizaBancoExterno(banco);
    }              

}
