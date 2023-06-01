/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega TODO el codigo para la parte del controlador del mantenimiento de movimientos
//Victor Josué Jerez Mijangos 9959-21-2081
package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoMovimientos;
/**
 *
 * @author visitante
 */
public class clsMovimientos {
    private int IdMovimiento;
    private String DescripcionMovimiento;
    private String EfectoMovimiento;
    private String EstatusMovimiento;

    public int getIdMovimiento() {
        return IdMovimiento;
    }

    public void setIdMovimiento(int IdMovimiento) {
        this.IdMovimiento = IdMovimiento;
    }

    public String getDescripcionMovimiento() {
        return DescripcionMovimiento;
    }

    public void setDescripcionMovimiento(String DescripcionMovimiento) {
        this.DescripcionMovimiento = DescripcionMovimiento;
    }

    public String getEfectoMovimiento() {
        return EfectoMovimiento;
    }

    public void setEfectoMovimiento(String EfectoMovimiento) {
        this.EfectoMovimiento = EfectoMovimiento;
    }

    public String getEstatusMovimiento() {
        return EstatusMovimiento;
    }

    public void setEstatusMovimiento(String EstatusMovimiento) {
        this.EstatusMovimiento = EstatusMovimiento;
    }

    public clsMovimientos(int IdMovimiento, String DescripcionMovimiento, String EfectoMovimiento) {
        this.IdMovimiento = IdMovimiento;
        this.DescripcionMovimiento = DescripcionMovimiento;
        this.EfectoMovimiento = EfectoMovimiento;
    }

    public clsMovimientos(int IdMovimiento, String DescripcionMovimiento, String EfectoMovimiento, String EstatusMovimiento) {
        this.IdMovimiento = IdMovimiento;
        this.DescripcionMovimiento = DescripcionMovimiento;
        this.EfectoMovimiento = EfectoMovimiento;
        this.EstatusMovimiento = EstatusMovimiento;
    }

    public clsMovimientos(int IdMovimiento, String DescripcionMovimiento) {
        this.IdMovimiento = IdMovimiento;
        this.DescripcionMovimiento = DescripcionMovimiento;
    }

    public clsMovimientos(int IdMovimiento) {
        this.IdMovimiento = IdMovimiento;
    }

    public clsMovimientos() {
    }

    //Metodos de acceso a la capa controlador
    /*public clsMovimientos getBuscarInformacionMovimientoPorEfecto(clsMovimientos Movimientos)
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        return daomovimientos.consultaMovimientosPorEfecto(Movimientos);
    }*/
    public clsMovimientos getBuscarInformacionMovimientosPorId(clsMovimientos Movimientos)
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        return daomovimientos.consultaMovimientosPorId(Movimientos);
    }
    public List<clsMovimientos> getListadoMovimientos()
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        List<clsMovimientos> listadoMovimientos = daomovimientos.consultaMovimientos();
        return listadoMovimientos;
    }
    public int setBorrarMovimientos(clsMovimientos Movimientos)
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        return daomovimientos.borrarMovimientos(Movimientos);
    }
    public int setIngresarMovimientos(clsMovimientos Movimientos)
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        return daomovimientos.ingresaMovimientos(Movimientos);
    }              
    public int setModificarMovimientos(clsMovimientos Movimientos)
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        return daomovimientos.actualizaMovimientos(Movimientos);
    }

    public void add(List<clsMovimientos> Movimientos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
