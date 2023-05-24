/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoTipoMovimientoBancos;
/**
 *
 * @author visitante
 */
 /*Creado por Alyson Rodríguez 9959-21-829 */

public class clsTipoMovimientoBancos {
    private int TipoMovimientoId;
    private String NombreMovimiento;
    private String EstatusMovimiento;

    public clsTipoMovimientoBancos() {
    }

    public clsTipoMovimientoBancos(int TipoMovimientoId) {
        this.TipoMovimientoId = TipoMovimientoId;
    }

    public clsTipoMovimientoBancos(int TipoMovimientoId, String NombreMovimiento) {
        this.TipoMovimientoId = TipoMovimientoId;
        this.NombreMovimiento = NombreMovimiento;
    }

    public clsTipoMovimientoBancos(int TipoMovimientoId, String NombreMovimiento, String EstatusMovimiento) {
        this.TipoMovimientoId = TipoMovimientoId;
        this.NombreMovimiento = NombreMovimiento;
        this.EstatusMovimiento = EstatusMovimiento;
    }

    public int getTipoMovimientoId() {
        return TipoMovimientoId;
    }

    public void setTipoMovimientoId(int TipoMovimientoId) {
        this.TipoMovimientoId = TipoMovimientoId;
    }

    public String getNombreMovimiento() {
        return NombreMovimiento;
    }

    public void setNombreMovimiento(String NombreMovimiento) {
        this.NombreMovimiento = NombreMovimiento;
    }

    public String getEstatusMovimiento() {
        return EstatusMovimiento;
    }

    public void setEstatusMovimiento(String EstatusMovimiento) {
        this.EstatusMovimiento = EstatusMovimiento;
    }

   
    @Override
    public String toString() {
        return "clsTipoMovimientoBancos{" + "TipoMovimiento=" + TipoMovimientoId + ", NombreMovimiento=" + NombreMovimiento + ", EstatusMovimiento=" + EstatusMovimiento + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsTipoMovimientoBancos getBuscarInformacionTipoMovimientoPorNombre(clsTipoMovimientoBancos movimiento)
    {
        daoTipoMovimientoBancos daotipoMovimientoBancos = new daoTipoMovimientoBancos();
        return daotipoMovimientoBancos.consultaTipoMovimientoPorNombre(movimiento);
    }
    public clsTipoMovimientoBancos getBuscarInformacionTipoMovimientoPorId(clsTipoMovimientoBancos movimiento)
    {
        daoTipoMovimientoBancos daotipoMovimientoBancos = new daoTipoMovimientoBancos();
        return daotipoMovimientoBancos.consultaTipoMovimientoPorId(movimiento);
    }    
    public List<clsTipoMovimientoBancos> getListadoTipoMovimiento()
    {
        daoTipoMovimientoBancos daotipoMovimientoBancos = new daoTipoMovimientoBancos();
        List<clsTipoMovimientoBancos> listadoTipoMovimientos = daotipoMovimientoBancos.consultaTipoMovimiento();
        return listadoTipoMovimientos;
    }
    public int setBorrarTipoMovimiento(clsTipoMovimientoBancos movimiento)
    {
        daoTipoMovimientoBancos daotipoMovimientoBancos = new daoTipoMovimientoBancos();
        return daotipoMovimientoBancos.borrarTipoMovimiento(movimiento);
    }          
    public int setIngresarTipoMovimiento(clsTipoMovimientoBancos movimiento)
    {
        daoTipoMovimientoBancos daotipoMovimientoBancos = new daoTipoMovimientoBancos();
        return daotipoMovimientoBancos.ingresaTipoMovimiento(movimiento);
    }              
    public int setModificarTipoMovimiento(clsTipoMovimientoBancos movimiento)
    {
        daoTipoMovimientoBancos daotipoMovimientoBancos = new daoTipoMovimientoBancos();
        return daotipoMovimientoBancos.actualizaTipoMovimiento(movimiento);
    }              
}
