/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Alyson Vannesa Rodríguez Quezada 9959-21-829
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoCuentasBancos;
/**
 *
 * @author visitante
 */
public class clsCuentasBancos {
    private int IdCuenta;
    private double SaldoCuenta;
    private int IdPersona;
    private int IdTipoCuenta;
    private String EstatusCuenta;
    private int tipModId;
    private int codBanco;

    public clsCuentasBancos() {
    }

    public clsCuentasBancos(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public clsCuentasBancos(int IdCuenta, double SaldoCuenta) {
        this.IdCuenta = IdCuenta;
        this.SaldoCuenta = SaldoCuenta;
    }

    public clsCuentasBancos(int IdCuenta, double SaldoCuenta, int IdPersona) {
        this.IdCuenta = IdCuenta;
        this.SaldoCuenta = SaldoCuenta;
        this.IdPersona = IdPersona;
    }

    public clsCuentasBancos(int IdCuenta, double SaldoCuenta, int IdPersona, int IdTipoCuenta) {
        this.IdCuenta = IdCuenta;
        this.SaldoCuenta = SaldoCuenta;
        this.IdPersona = IdPersona;
        this.IdTipoCuenta = IdTipoCuenta;
    }

    public clsCuentasBancos(int IdCuenta, double SaldoCuenta, int IdPersona, int IdTipoCuenta, String EstatusCuenta) {
        this.IdCuenta = IdCuenta;
        this.SaldoCuenta = SaldoCuenta;
        this.IdPersona = IdPersona;
        this.IdTipoCuenta = IdTipoCuenta;
        this.EstatusCuenta = EstatusCuenta;
    }

    public clsCuentasBancos(int IdCuenta, double SaldoCuenta, int IdPersona, int IdTipoCuenta, String EstatusCuenta, int tipModId) {
        this.IdCuenta = IdCuenta;
        this.SaldoCuenta = SaldoCuenta;
        this.IdPersona = IdPersona;
        this.IdTipoCuenta = IdTipoCuenta;
        this.EstatusCuenta = EstatusCuenta;
        this.tipModId = tipModId;
    }

    public clsCuentasBancos(int IdCuenta, double SaldoCuenta, int IdPersona, int IdTipoCuenta, String EstatusCuenta, int tipModId, int codBanco) {
        this.IdCuenta = IdCuenta;
        this.SaldoCuenta = SaldoCuenta;
        this.IdPersona = IdPersona;
        this.IdTipoCuenta = IdTipoCuenta;
        this.EstatusCuenta = EstatusCuenta;
        this.tipModId = tipModId;
        this.codBanco = codBanco;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public double getSaldoCuenta() {
        return SaldoCuenta;
    }

    public void setSaldoCuenta(double SaldoCuenta) {
        this.SaldoCuenta = SaldoCuenta;
    }

    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public int getIdTipoCuenta() {
        return IdTipoCuenta;
    }

    public void setIdTipoCuenta(int IdTipoCuenta) {
        this.IdTipoCuenta = IdTipoCuenta;
    }

    public String getEstatusCuenta() {
        return EstatusCuenta;
    }

    public void setEstatusCuenta(String EstatusCuenta) {
        this.EstatusCuenta = EstatusCuenta;
    }

    public int getTipModId() {
        return tipModId;
    }

    public void setTipModId(int tipModId) {
        this.tipModId = tipModId;
    }

    public int getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(int codBanco) {
        this.codBanco = codBanco;
    }

    
    @Override
    public String toString() {
        return "clsCuentas{" + "IdCuenta=" + IdCuenta + ", NumeroCuenta=" + NumeroCuenta + ", SaldoCuenta=" + SaldoCuenta + ", IdPersona=" + IdPersona + ", IdTipoCuenta=" + IdTipoCuenta + ", EstatusCuenta=" + EstatusCuenta + '}';
    }
    //Metodos de acceso a la capa controlador
    
    public clsCuentasBancos getBuscarInformacionNumeroCuenta(clsCuentasBancos cuenta)
    {
        daoCuentasBancos daocuentas = new daoCuentasBancos();
        return daocuentas.consultaNumeroCuenta(cuenta);
    }
    public clsCuentasBancos getBuscarInformacionCuentaPorId(clsCuentasBancos cuenta)
    {
        daoCuentasBancos daocuentas = new daoCuentasBancos();
        return daocuentas.consultaCuentaPorId(cuenta);
    }    
    public List<clsCuentasBancos> getListadoCuentas()
    {
        daoCuentasBancos daocuentas = new daoCuentasBancos();
        List<clsCuentasBancos> listadoClsCuentas = daocuentas.consultaCuenta();
        return listadoClsCuentas;
    }
    public int setBorrarCuenta(clsCuentasBancos cuenta)
    {
        daoCuentasBancos daocuentas = new daoCuentasBancos();
        return daocuentas.borrarCuenta(cuenta);
    }          
    public int setIngresarCuenta(clsCuentasBancos cuenta)
    {
        daoCuentasBancos daocuentas = new daoCuentasBancos();
        return daocuentas.ingresaCuenta(cuenta);
    }              
    public int setModificarCuenta(clsCuentasBancos cuenta)
    {
        daoCuentasBancos daocuentas = new daoCuentasBancos();
        return daocuentas.actualizaCuenta(cuenta);
    }              
}
