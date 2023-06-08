/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoMovimientoDetallesBancos;
import Bancos.Modelo.daoMovimientosEncabezadoBancos;
/**
 *
 * @author visitante
 */
//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
//Todo en ClsMovimientoDetallesBancos.
public class clsMovimientoDetallesBancos {
    private int IdMovimientoDetalles;
    private int IdMovimiento;
    private float MovimientoCosto;
    private int IdConcepto;
    private float MovimientoSaldo;
    private int IdTipoMovimiento;
    private double AbonoCargo;

    

    public clsMovimientoDetallesBancos() {
    }

    public clsMovimientoDetallesBancos(int IdMovimientoDetalles, int IdMovimiento, float MovimientoCosto, int IdConcepto, float MovimientoSaldo, int IdTipoMovimiento, double AbonoCargo) {
        this.IdMovimientoDetalles = IdMovimientoDetalles;
        this.IdMovimiento = IdMovimiento;
        this.MovimientoCosto = MovimientoCosto;
        this.IdConcepto = IdConcepto;
        this.MovimientoSaldo = MovimientoSaldo;
        this.IdTipoMovimiento = IdTipoMovimiento;
        this.AbonoCargo=AbonoCargo;
    }

    public clsMovimientoDetallesBancos(int IdConcepto, float MovimientoSaldo, int IdTipoMovimiento) {
        this.IdConcepto = IdConcepto;
        this.MovimientoSaldo = MovimientoSaldo;
        this.IdTipoMovimiento = IdTipoMovimiento;
    }

    public clsMovimientoDetallesBancos(int IdMovimientoDetalles, int IdMovimiento, float MovimientoCosto) {
        this.IdMovimientoDetalles = IdMovimientoDetalles;
        this.IdMovimiento = IdMovimiento;
        this.MovimientoCosto = MovimientoCosto;
    }

    public int getIdMovimientoDetalles() {
        return IdMovimientoDetalles;
    }

    public void setIdMovimientoDetalles(int IdMovimientoDetalles) {
        this.IdMovimientoDetalles = IdMovimientoDetalles;
    }

    public int getIdMovimiento() {
        return IdMovimiento;
    }

    public void setIdMovimiento(int IdMovimiento) {
        this.IdMovimiento = IdMovimiento;
    }

    public float getMovimientoCosto() {
        return MovimientoCosto;
    }

    public void setMovimientoCosto(float MovimientoCosto) {
        this.MovimientoCosto = MovimientoCosto;
    }

    public int getIdConcepto() {
        return IdConcepto;
    }

    public void setIdConcepto(int IdConcepto) {
        this.IdConcepto = IdConcepto;
    }

    public float getMovimientoSaldo() {
        return MovimientoSaldo;
    }

    public void setMovimientoSaldo(float MovimientoSaldo) {
        this.MovimientoSaldo = MovimientoSaldo;
    }

    public int getIdTipoMovimiento() {
        return IdTipoMovimiento;
    }

    public void setIdTipoMovimiento(int IdTipoMovimiento) {
        this.IdTipoMovimiento = IdTipoMovimiento;
    }

  
public double getAbonoCargo() {
        return AbonoCargo;
    }

    public void setAbonoCargo(double AbonoCargo) {
        this.AbonoCargo = AbonoCargo;
    }
    

  

  @Override
    public String toString() {
        return "clsBancos{" + "IdMovimientoDetalles=" + IdMovimientoDetalles+ ", IdMovimiento=" + IdMovimiento + ", MovimientoCosto=" + MovimientoCosto + ", IdConcepto=" + IdConcepto +
          ",MovimientoSaldo="+ MovimientoSaldo + ", IdTipoMovimiento=" + IdTipoMovimiento + ", AbonoCargo=" + AbonoCargo +  '}';
    }

    
    //Metodos de acceso a la capa controlador
    public clsMovimientoDetallesBancos getBuscarInformacionBancoPorMovimientoDetalles(clsMovimientoDetallesBancos banco)
    {
        daoMovimientoDetallesBancos daoBancos = new daoMovimientoDetallesBancos();
        return daoBancos.consultaBancoPorMovimientoDetalles(banco);
    }
    public clsMovimientoDetallesBancos getBuscarInformacionBancoPorTipoMovimiento(clsMovimientoDetallesBancos banco)
    {
        daoMovimientoDetallesBancos daoBancos= new daoMovimientoDetallesBancos();
        return daoBancos.consultaBancoPorTipoMovimiento(banco);
    } 
    public clsMovimientoDetallesBancos getBuscarInformacionBancoPorTipoMovimientoSaldo(clsMovimientoDetallesBancos banco, clsMovimientosEncabezadoBancos encabezado )
    {
        daoMovimientoDetallesBancos daoBancos= new daoMovimientoDetallesBancos();
        return daoBancos.consultaBancoPorTipoMovimientoSaldo(banco, encabezado);
    }  
    public List<clsMovimientoDetallesBancos> getListadoMovimiento()
    {
        daoMovimientoDetallesBancos daoBancos = new daoMovimientoDetallesBancos();
        List<clsMovimientoDetallesBancos> listadoBancos = daoBancos.consultaBancoMovimiento();
        return listadoBancos;
    }
    public int setBorrarMovimiento(clsMovimientoDetallesBancos banco)
    {
        daoMovimientoDetallesBancos daoBancos = new daoMovimientoDetallesBancos();
        return daoBancos.borrarBanco(banco);
    }          
    public int setIngresarMovimiento(clsMovimientoDetallesBancos banco)
    {
        daoMovimientoDetallesBancos daoBancos= new daoMovimientoDetallesBancos();
        return daoBancos.ingresaBanco(banco);
    }              
    public int setModificarMovimiento(clsMovimientoDetallesBancos banco)
    {
        daoMovimientoDetallesBancos daoBancos = new daoMovimientoDetallesBancos();
        return daoBancos.actualizaBanco(banco);

    }   
    public int setModificarMovimientoSaldo(clsMovimientoDetallesBancos banco , clsMovimientosEncabezadoBancos encabezado)
    {
        daoMovimientoDetallesBancos daoBancos = new daoMovimientoDetallesBancos();
        return daoBancos.actualizaBancoSaldo(banco, encabezado);

    }   
}
