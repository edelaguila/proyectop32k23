/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoPerfil;
/**
 *
 * @author visitante
 */
 /*Creado por Alyson Rodríguez 9959-21-829 */

public class clsTipoMovimientoBancos {
    private static int TipoMovimiento;
    private static String NombreMovimiento;
    private static String EstatusMovimieto;

    public clsTipoMovimientoBancos() {
    }

    public static int getTipoMovimiento() {
        return TipoMovimiento;
    }

    public static void setTipoMovimiento(int TipoMovimiento) {
        clsTipoMovimientoBancos.TipoMovimiento = TipoMovimiento;
    }

    public static String getNombreMovimiento() {
        return NombreMovimiento;
    }

    public static void setNombreMovimiento(String NombreMovimiento) {
        clsTipoMovimientoBancos.NombreMovimiento = NombreMovimiento;
    }

    public static String getEstatusMovimieto() {
        return EstatusMovimieto;
    }

    public static void setEstatusMovimieto(String EstatusMovimieto) {
        clsTipoMovimientoBancos.EstatusMovimieto = EstatusMovimieto;
    }

    @Override
    public String toString() {
        return "clsTipoMovimientoBancos{" + "TipoMovimiento=" + TipoMovimiento + ", NombreMovimiento=" + NombreMovimiento + ", EstatusMovimieto=" + EstatusMovimieto + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsTipoMovimientoBancos getBuscarInformacionTipoMovimientoPorNombre(clsTipoMovimientoBancos movimiento)
    {
        daoTipoMovimientoBancos daotipoMovimientoBancos = new daoTipoMovimientoBancos();
        return daotipoMovimientoBancos.consultatipoMovimientoPorNombre(movimiento);
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
