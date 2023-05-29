/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoBoletaClientesBancos;
/**
 *
 * @author visitante
 */

 /*Creado por Alyson Rodríguez 9959-21-829 */

public class clsBoletaClientesBancos {
    private int IdBoleta;
    private int CodigoBanco;
    private String FechaEmisionBoleta;
    private String NombreCliente;
    private float SaldoBoleta;
    private int IdConcepto;  
    private int IdTipoMovimiento;
    private int IdCuenta;
    private String EfectoBoleta;
    private int IdTipoMoneda;

    public clsBoletaClientesBancos() {
    }

    public clsBoletaClientesBancos(int IdBoleta) {
        this.IdBoleta = IdBoleta;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, String NombreCliente) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.NombreCliente = NombreCliente;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, String NombreCliente, float SaldoBoleta) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.NombreCliente = NombreCliente;
        this.SaldoBoleta = SaldoBoleta;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, String NombreCliente, float SaldoBoleta, int IdConcepto) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.NombreCliente = NombreCliente;
        this.SaldoBoleta = SaldoBoleta;
        this.IdConcepto = IdConcepto;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, String NombreCliente, float SaldoBoleta, int IdConcepto, int IdTipoMovimiento) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.NombreCliente = NombreCliente;
        this.SaldoBoleta = SaldoBoleta;
        this.IdConcepto = IdConcepto;
        this.IdTipoMovimiento = IdTipoMovimiento;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, String NombreCliente, float SaldoBoleta, int IdConcepto, int IdTipoMovimiento, int IdCuenta) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.NombreCliente = NombreCliente;
        this.SaldoBoleta = SaldoBoleta;
        this.IdConcepto = IdConcepto;
        this.IdTipoMovimiento = IdTipoMovimiento;
        this.IdCuenta = IdCuenta;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, String NombreCliente, float SaldoBoleta, int IdConcepto, int IdTipoMovimiento, int IdCuenta, String EfectoBoleta) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.NombreCliente = NombreCliente;
        this.SaldoBoleta = SaldoBoleta;
        this.IdConcepto = IdConcepto;
        this.IdTipoMovimiento = IdTipoMovimiento;
        this.IdCuenta = IdCuenta;
        this.EfectoBoleta = EfectoBoleta;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, String NombreCliente, float SaldoBoleta, int IdConcepto, int IdTipoMovimiento, int IdCuenta, String EfectoBoleta, int IdTipoMoneda) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.NombreCliente = NombreCliente;
        this.SaldoBoleta = SaldoBoleta;
        this.IdConcepto = IdConcepto;
        this.IdTipoMovimiento = IdTipoMovimiento;
        this.IdCuenta = IdCuenta;
        this.EfectoBoleta = EfectoBoleta;
        this.IdTipoMoneda = IdTipoMoneda;
    }

    public int getIdBoleta() {
        return IdBoleta;
    }

    public void setIdBoleta(int IdBoleta) {
        this.IdBoleta = IdBoleta;
    }

    public int getCodigoBanco() {
        return CodigoBanco;
    }

    public void setCodigoBanco(int CodigoBanco) {
        this.CodigoBanco = CodigoBanco;
    }

    public String getFechaEmisionBoleta() {
        return FechaEmisionBoleta;
    }

    public void setFechaEmisionBoleta(String FechaEmisionBoleta) {
        this.FechaEmisionBoleta = FechaEmisionBoleta;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public float getSaldoBoleta() {
        return SaldoBoleta;
    }

    public void setSaldoBoleta(float SaldoBoleta) {
        this.SaldoBoleta = SaldoBoleta;
    }

    public int getIdConcepto() {
        return IdConcepto;
    }

    public void setIdConcepto(int IdConcepto) {
        this.IdConcepto = IdConcepto;
    }

    public int getIdTipoMovimiento() {
        return IdTipoMovimiento;
    }

    public void setIdTipoMovimiento(int IdTipoMovimiento) {
        this.IdTipoMovimiento = IdTipoMovimiento;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public String getEfectoBoleta() {
        return EfectoBoleta;
    }

    public void setEfectoBoleta(String EfectoBoleta) {
        this.EfectoBoleta = EfectoBoleta;
    }

    public int getIdTipoMoneda() {
        return IdTipoMoneda;
    }

    public void setIdTipoMoneda(int IdTipoMoneda) {
        this.IdTipoMoneda = IdTipoMoneda;
    }
    
@Override
    public String toString() {
        return "clsBoletaClientesBancos{" + "IdBoleta=" + IdBoleta + ", CodigoBanco=" + CodigoBanco + ", FechaEmisionBoleta=" + FechaEmisionBoleta + ", NombreCliente=" + NombreCliente + ", SaldoBoleta=" + SaldoBoleta + ", IdConcepto=" + IdConcepto + ", IdTipoMovimiento=" + IdTipoMovimiento + ", IdCuenta=" + IdCuenta + ", EfectoBoleta=" + EfectoBoleta +
                ", IdTipoMoneda=" + IdTipoMoneda +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsBoletaClientesBancos getBuscarInformacionBoletaPorCodigo(clsBoletaClientesBancos boleta)
    {
        daoBoletaClientesBancos daoboletaClientesBancos = new daoBoletaClientesBancos();
        return daoboletaClientesBancos.consultaBoletaPorCodigo(boleta);
    }
    public clsBoletaClientesBancos getBuscarInformacionBoletaPorId(clsBoletaClientesBancos boleta)
    {
        daoBoletaClientesBancos daoboletaClientesBancos = new daoBoletaClientesBancos();
        return daoboletaClientesBancos.consultaBoletaPorId(boleta);
    }    
    public List<clsBoletaClientesBancos> getListadoBoletas()
    {
        daoBoletaClientesBancos daoboletaClientesBancos = new daoBoletaClientesBancos();
        List<clsBoletaClientesBancos> listadoBoletas = daoboletaClientesBancos.consultaBoleta();
        return listadoBoletas;
    }
    public int setBorrarBoleta(clsBoletaClientesBancos boleta)
    {
        daoBoletaClientesBancos daoboletaClientesBancos = new daoBoletaClientesBancos();
        return daoboletaClientesBancos.borrarBoleta(boleta);
    }          
    public int setIngresarTipoBoleta(clsBoletaClientesBancos boleta)
    {
        daoBoletaClientesBancos daoboletaClientesBancos = new daoBoletaClientesBancos();
        return daoboletaClientesBancos.ingresaBoleta(boleta);
    }              
    public int setModificarBoleta(clsBoletaClientesBancos boleta)
    {
        daoBoletaClientesBancos daoboletaClientesBancos = new daoBoletaClientesBancos();
        return daoboletaClientesBancos.actualizaBoleta(boleta);
    }              
}
