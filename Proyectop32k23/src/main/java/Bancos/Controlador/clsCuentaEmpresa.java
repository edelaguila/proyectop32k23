/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoCuentaEmpresa;
/**
 *
 * @author visitante
 */
public class clsCuentaEmpresa {
    private int IdCuentaEm;
    private int NumeroCuentaEm;
    private double SaldoCuentaEm;
    private int cueTipoId;
    private String EstatusCuentaEm;
    private int CodigoBanco;

    public clsCuentaEmpresa() {
    }

    public clsCuentaEmpresa(int IdCuentaEm) {
        this.IdCuentaEm = IdCuentaEm;
    }

    public clsCuentaEmpresa(int IdCuentaEm, int NumeroCuentaEm) {
        this.IdCuentaEm = IdCuentaEm;
        this.NumeroCuentaEm = NumeroCuentaEm;
    }

    public clsCuentaEmpresa(int IdCuentaEm, int NumeroCuentaEm, double SaldoCuentaEm) {
        this.IdCuentaEm = IdCuentaEm;
        this.NumeroCuentaEm = NumeroCuentaEm;
        this.SaldoCuentaEm = SaldoCuentaEm;
    }

    public clsCuentaEmpresa(int IdCuentaEm, int NumeroCuentaEm, double SaldoCuentaEm, int cueTipoId) {
        this.IdCuentaEm = IdCuentaEm;
        this.NumeroCuentaEm = NumeroCuentaEm;
        this.SaldoCuentaEm = SaldoCuentaEm;
        this.cueTipoId = cueTipoId;
    }

    public clsCuentaEmpresa(int IdCuentaEm, int NumeroCuentaEm, double SaldoCuentaEm, int cueTipoId, String EstatusCuentaEm) {
        this.IdCuentaEm = IdCuentaEm;
        this.NumeroCuentaEm = NumeroCuentaEm;
        this.SaldoCuentaEm = SaldoCuentaEm;
        this.cueTipoId = cueTipoId;
        this.EstatusCuentaEm = EstatusCuentaEm;
    }

    public clsCuentaEmpresa(int IdCuentaEm, int NumeroCuentaEm, double SaldoCuentaEm, int cueTipoId, String EstatusCuentaEm, int CodigoBanco) {
        this.IdCuentaEm = IdCuentaEm;
        this.NumeroCuentaEm = NumeroCuentaEm;
        this.SaldoCuentaEm = SaldoCuentaEm;
        this.cueTipoId = cueTipoId;
        this.EstatusCuentaEm = EstatusCuentaEm;
        this.CodigoBanco = CodigoBanco;
    }

    public int getIdCuentaEm() {
        return IdCuentaEm;
    }

    public void setIdCuentaEm(int IdCuentaEm) {
        this.IdCuentaEm = IdCuentaEm;
    }

    public int getNumeroCuentaEm() {
        return NumeroCuentaEm;
    }

    public void setNumeroCuentaEm(int NumeroCuentaEm) {
        this.NumeroCuentaEm = NumeroCuentaEm;
    }

    public double getSaldoCuentaEm() {
        return SaldoCuentaEm;
    }

    public void setSaldoCuentaEm(double SaldoCuentaEm) {
        this.SaldoCuentaEm = SaldoCuentaEm;
    }

    public int getCueTipoId() {
        return cueTipoId;
    }

    public void setCueTipoId(int cueTipoId) {
        this.cueTipoId = cueTipoId;
    }

    public String getEstatusCuentaEm() {
        return EstatusCuentaEm;
    }

    public void setEstatusCuentaEm(String EstatusCuentaEm) {
        this.EstatusCuentaEm = EstatusCuentaEm;
    }

    public int getCodigoBanco() {
        return CodigoBanco;
    }

    public void setCodigoBanco(int CodigoBanco) {
        this.CodigoBanco = CodigoBanco;
    }

   
    @Override
    public String toString() {
        return "clsCuentaEmpresa{" + "IdCuentaEm=" + IdCuentaEm + ", NumeroCuentaEm=" + NumeroCuentaEm + ", SaldoCuentaEm=" + SaldoCuentaEm + ", cueTipoId=" + cueTipoId + ", EstatusCuentaEm=" + EstatusCuentaEm + ", CodigoBanco=" + CodigoBanco + '}';
    }
    //Metodos de acceso a la capa controlador
    
    public clsCuentaEmpresa getBuscarInformacionNumeroCuenta(clsCuentaEmpresa cuentaem)
    {
        daoCuentaEmpresa daocuentaem = new daoCuentaEmpresa();
        return daocuentaem.consultaNumeroCuentaEmpresa(cuentaem);
    }
    public clsCuentaEmpresa getBuscarInformacionCuentaEmPorId(clsCuentaEmpresa cuentaem)
    {
        daoCuentaEmpresa daocuentaem = new daoCuentaEmpresa();
        return daocuentaem.consultaCuentaEmPorId(cuentaem);
    }    
    public List<clsCuentaEmpresa> getListadoCuentaEmpresas()
    {
        daoCuentaEmpresa daocuentaem = new daoCuentaEmpresa();
        List<clsCuentaEmpresa> listadoCuentaEmpresas = daocuentaem.consultaCuentaEmpresas();
        return listadoCuentaEmpresas;
    }
    public int setBorrarCuentaEm(clsCuentaEmpresa cuentaem)
    {
        daoCuentaEmpresa daocuentaem = new daoCuentaEmpresa();
        return daocuentaem.setBorrarCuentaEm(cuentaem);
    }          
    public int setIngresarCuentaEm(clsCuentaEmpresa cuentaem)
    {
        daoCuentaEmpresa daocuentaem = new daoCuentaEmpresa();
        return daocuentaem.setIngresarCuentaEm(cuentaem);
    }              
    public int setModificarCuentaEm(clsCuentaEmpresa cuentaem)
    {
        daoCuentaEmpresa daocuentaem = new daoCuentaEmpresa();
        return daocuentaem.actualizaCuentaEm(cuentaem);
    }              
}
