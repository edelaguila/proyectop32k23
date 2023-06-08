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

 //Hecho por: Alyson Vannesa Rodríguez Quezada 9959-21-829
public class clsBoletaClientesBancos {
    private int IdBoleta;
    private int CodigoBanco;
    private String FechaEmisionBoleta;
    private int IdCliente;
    private float SaldoBoleta; 
    private int IdTipoMovimiento;
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

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, int IdCliente) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.IdCliente = IdCliente;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, int IdCliente, float SaldoBoleta) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.IdCliente = IdCliente;
        this.SaldoBoleta = SaldoBoleta;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, int IdCliente, float SaldoBoleta, int IdTipoMovimiento) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.IdCliente = IdCliente;
        this.SaldoBoleta = SaldoBoleta;
        this.IdTipoMovimiento = IdTipoMovimiento;
    }

    public clsBoletaClientesBancos(int IdBoleta, int CodigoBanco, String FechaEmisionBoleta, int IdCliente, float SaldoBoleta, int IdTipoMovimiento, int IdTipoMoneda) {
        this.IdBoleta = IdBoleta;
        this.CodigoBanco = CodigoBanco;
        this.FechaEmisionBoleta = FechaEmisionBoleta;
        this.IdCliente = IdCliente;
        this.SaldoBoleta = SaldoBoleta;
        this.IdTipoMovimiento = IdTipoMovimiento;
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

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public float getSaldoBoleta() {
        return SaldoBoleta;
    }

    public void setSaldoBoleta(float SaldoBoleta) {
        this.SaldoBoleta = SaldoBoleta;
    }

    public int getIdTipoMovimiento() {
        return IdTipoMovimiento;
    }

    public void setIdTipoMovimiento(int IdTipoMovimiento) {
        this.IdTipoMovimiento = IdTipoMovimiento;
    }

    public int getIdTipoMoneda() {
        return IdTipoMoneda;
    }

    public void setIdTipoMoneda(int IdTipoMoneda) {
        this.IdTipoMoneda = IdTipoMoneda;
    }

    
@Override
    public String toString() {
        return "clsBoletaClientesBancos{" + "IdBoleta=" + IdBoleta + ", CodigoBanco=" + CodigoBanco + ", FechaEmisionBoleta=" + FechaEmisionBoleta + ", IdCliente=" + IdCliente + ", SaldoBoleta=" + SaldoBoleta +  ", IdTipoMovimiento=" + IdTipoMovimiento +
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
