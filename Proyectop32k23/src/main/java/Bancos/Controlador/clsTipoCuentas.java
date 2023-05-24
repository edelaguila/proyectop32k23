/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Controlador;
import java.util.List;

import Bancos.Modelo.daoTipoCuentas;
import Bancos.Modelo.daoTipoMovimientoBancos;
/**
 *
 * @author visitante
 */
 /*Creado por Alyson Rodríguez 9959-21-829 */

public class clsTipoCuentas {
    private int tipoCueId;
    private String tipoCueDescripcion;
    private String estatusTipoCue;

    public clsTipoCuentas() {
    }

    public clsTipoCuentas(int tipoCueId) {
        this.tipoCueId = tipoCueId;
    }

    public clsTipoCuentas(int tipoCueId, String tipoCueDescripcion) {
        this.tipoCueId = tipoCueId;
        this.tipoCueDescripcion = tipoCueDescripcion;
    }

    public clsTipoCuentas(int tipoCueId, String tipoCueDescripcion, String estatusTipoCue) {
        this.tipoCueId = tipoCueId;
        this.tipoCueDescripcion = tipoCueDescripcion;
        this.estatusTipoCue = estatusTipoCue;
    }

    public int getTipoCueId() {
        return tipoCueId;
    }

    public void setTipoCueId(int tipoCueId) {
        this.tipoCueId = tipoCueId;
    }

    public String getTipoCueDescripcion() {
        return tipoCueDescripcion;
    }

    public void setTipoCueDescripcion(String tipoCueDescripcion) {
        this.tipoCueDescripcion = tipoCueDescripcion;
    }

    public String getEstatusTipoCue() {
        return estatusTipoCue;
    }

    public void setEstatusTipoCue(String estatusTipoCue) {
        this.estatusTipoCue = estatusTipoCue;
    }

    
    @Override
    public String toString() {
        return "clsTipoCuentas{" + "tipoCueId=" + tipoCueId + ", tipoCueDescripcion=" + tipoCueDescripcion + ", estatusTipoCue=" + estatusTipoCue + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsTipoCuentas getBuscarInformacionTipoCuentaPorNombre(clsTipoCuentas cuenta)
    {
        daoTipoCuentas daotipoCuenta = new daoTipoCuentas();
        return daotipoCuenta.consultaTipoCuentaPorNombre(cuenta);
    }
    public clsTipoCuentas getBuscarInformacionTipoCuentaPorId(clsTipoCuentas cuenta)
    {
        daoTipoCuentas daotipocuenta = new daoTipoCuentas();
        return daotipocuenta.consultaTipoCuentaPorId(cuenta);
    }    
    public List<clsTipoCuentas> getListadoTipoCuentas()
    {
        daoTipoCuentas daotipocuenta = new daoTipoCuentas();
        List<clsTipoCuentas> listadoTipoCuenta = daotipocuenta.consultaTipoCuenta();
        return listadoTipoCuenta;
    }
    public int setBorrarTipoCuenta(clsTipoCuentas cuenta)
    {
        daoTipoCuentas daotipoccuenta = new daoTipoCuentas();
        return daotipoccuenta.borrarTipoCuenta(cuenta);
    }          
    public int setIngresarTipoCuenta(clsTipoCuentas cuenta)
    {
        daoTipoCuentas daotipocuenta = new daoTipoCuentas();
        return daotipocuenta.ingresaTipoCuenta(cuenta);
    }              
    public int setModificarTipoCuenta(clsTipoCuentas cuenta)
    {
        daoTipoCuentas daotipocuenta = new daoTipoCuentas();
        return daotipocuenta.actualizaTipoCuenta(cuenta);
    }              
}
