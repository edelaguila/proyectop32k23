/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuentas_Corrientes.Controlador;
import Cuentas_Corrientes.Modelo.daoCCorrientes;
import Seguridad.Controlador.*;
import java.util.List;
import Seguridad.Modelo.daoAplicacion;
/**
 *
 * @author visitante
 */

public class clsCCorrientes {
    private int idCCorriente;
    private String tipoCCorriente;
    private int idTipoCCorriente;
    private String fechaCCorriente;
    private String nombreCCorriente;
    private String facturaCCorriente;
    private String saldoCCorriente;
    private String deudaCCorriente;

    public int getIdCCorriente() {
        return idCCorriente;
    }

    public void setIdCCorriente(int idCCorriente) {
        this.idCCorriente = idCCorriente;
    }

    public String getTipoCCorriente() {
        return tipoCCorriente;
    }

    public void setTipoCCorriente(String tipoCCorriente) {
        this.tipoCCorriente = tipoCCorriente;
    }

    public int getIdTipoCCorriente() {
        return idTipoCCorriente;
    }

    public void setIdTipoCCorriente(int idTipoCCorriente) {
        this.idTipoCCorriente = idTipoCCorriente;
    }

    public String getFechaCCorriente() {
        return fechaCCorriente;
    }

    public void setFechaCCorriente(String fechaCCorriente) {
        this.fechaCCorriente = fechaCCorriente;
    }

    public String getNombreCCorriente() {
        return nombreCCorriente;
    }

    public void setNombreCCorriente(String nombreCCorriente) {
        this.nombreCCorriente = nombreCCorriente;
    }

    public String getFacturaCCorriente() {
        return facturaCCorriente;
    }

    public void setFacturaCCorriente(String facturaCCorriente) {
        this.facturaCCorriente = facturaCCorriente;
    }

    public String getSaldoCCorriente() {
        return saldoCCorriente;
    }

    public void setSaldoCCorriente(String saldoCCorriente) {
        this.saldoCCorriente = saldoCCorriente;
    }

    public String getDeudaCCorriente() {
        return deudaCCorriente;
    }

    public void setDeudaCCorriente(String deudaCCorriente) {
        this.deudaCCorriente = deudaCCorriente;
    }

    public clsCCorrientes(int idCCorriente, String tipoCCorriente, int idTipoCCorriente, String fechaCCorriente, String nombreCCorriente, String facturaCCorriente, String saldoCCorriente, String deudaCCorriente) {
        this.idCCorriente = idCCorriente;
        this.tipoCCorriente = tipoCCorriente;
        this.idTipoCCorriente = idTipoCCorriente;
        this.fechaCCorriente = fechaCCorriente;
        this.nombreCCorriente = nombreCCorriente;
        this.facturaCCorriente = facturaCCorriente;
        this.saldoCCorriente = saldoCCorriente;
        this.deudaCCorriente = deudaCCorriente;
    }

    public clsCCorrientes(int idCCorriente, String tipoCCorriente, int idTipoCCorriente, String fechaCCorriente, String nombreCCorriente, String facturaCCorriente, String saldoCCorriente) {
        this.idCCorriente = idCCorriente;
        this.tipoCCorriente = tipoCCorriente;
        this.idTipoCCorriente = idTipoCCorriente;
        this.fechaCCorriente = fechaCCorriente;
        this.nombreCCorriente = nombreCCorriente;
        this.facturaCCorriente = facturaCCorriente;
        this.saldoCCorriente = saldoCCorriente;
    }

    public clsCCorrientes(int idCCorriente, String tipoCCorriente, int idTipoCCorriente, String fechaCCorriente, String nombreCCorriente, String facturaCCorriente) {
        this.idCCorriente = idCCorriente;
        this.tipoCCorriente = tipoCCorriente;
        this.idTipoCCorriente = idTipoCCorriente;
        this.fechaCCorriente = fechaCCorriente;
        this.nombreCCorriente = nombreCCorriente;
        this.facturaCCorriente = facturaCCorriente;
    }

    public clsCCorrientes(int idCCorriente, String tipoCCorriente, int idTipoCCorriente, String fechaCCorriente, String nombreCCorriente) {
        this.idCCorriente = idCCorriente;
        this.tipoCCorriente = tipoCCorriente;
        this.idTipoCCorriente = idTipoCCorriente;
        this.fechaCCorriente = fechaCCorriente;
        this.nombreCCorriente = nombreCCorriente;
    }

    public clsCCorrientes(int idCCorriente, String tipoCCorriente, int idTipoCCorriente, String fechaCCorriente) {
        this.idCCorriente = idCCorriente;
        this.tipoCCorriente = tipoCCorriente;
        this.idTipoCCorriente = idTipoCCorriente;
        this.fechaCCorriente = fechaCCorriente;
    }

    public clsCCorrientes(int idCCorriente, String tipoCCorriente, int idTipoCCorriente) {
        this.idCCorriente = idCCorriente;
        this.tipoCCorriente = tipoCCorriente;
        this.idTipoCCorriente = idTipoCCorriente;
    }

    public clsCCorrientes(int idCCorriente, String tipoCCorriente) {
        this.idCCorriente = idCCorriente;
        this.tipoCCorriente = tipoCCorriente;
    }

    public clsCCorrientes(int idCCorriente) {
        this.idCCorriente = idCCorriente;
    }

    public clsCCorrientes() {
    }
    

    
    //Metodos de acceso a la capa controlador
    public clsCCorrientes getBuscarInformacionAplicacionPorNombre(clsCCorrientes CCorriente)
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        return daoCCorrientes.consultaAplicacionPorNombre(CCorriente);
    }
    public clsCCorrientes getBuscarInformacionAplicacionPorId(clsCCorrientes CCorriente)
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        return daoCCorrientes.consultaAplicacionPorId(CCorriente);
    }    
    public List<clsCCorrientes> getListadoAplicaciones()
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        List<clsCCorrientes> listadoCCorrientes = daoCCorrientes.consultaAplicacion();
        return listadoCCorrientes;
    }
    public int setBorrarAplicacion(clsCCorrientes CCorriente)
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        return daoCCorrientes.borrarAplicacion(CCorriente);
    }          
    public int setIngresarAplicacion(clsCCorrientes CCorriente)
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        return daoCCorrientes.ingresaAplicacion(CCorriente);
    }              
    public int setModificarAplicacion(clsCCorrientes CCorriente)
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        return daoCCorrientes.actualizaAplicacion(CCorriente);
    }              
}
