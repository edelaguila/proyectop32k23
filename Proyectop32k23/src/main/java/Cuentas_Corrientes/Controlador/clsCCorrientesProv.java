/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuentas_Corrientes.Controlador;
import Cuentas_Corrientes.Modelo.daoCCorrientesProv;
import Seguridad.Controlador.*;
import java.util.List;
/**
 *
 * @author visitante
 */

public class clsCCorrientesProv {
    private int idCCorrienteProv;
    private String tipoCCorrienteProv;
    private int idTipoCCorrienteProv;
    private String fechaCCorrienteProv;
    private String nombreCCorrienteProv;
    private String nofacturaCCorrienteProv;
    private String facturaCCorrienteProv;
    private String CancelaciónProv;
    private String SaldoCCorrienteProv;

    public int getIdCCorrienteProv() {
        return idCCorrienteProv;
    }

    public void setIdCCorrienteProv(int idCCorrienteProv) {
        this.idCCorrienteProv = idCCorrienteProv;
    }

    public String getTipoCCorrienteProv() {
        return tipoCCorrienteProv;
    }

    public void setTipoCCorrienteProv(String tipoCCorrienteProv) {
        this.tipoCCorrienteProv = tipoCCorrienteProv;
    }

    public int getIdTipoCCorrienteProv() {
        return idTipoCCorrienteProv;
    }

    public void setIdTipoCCorrienteProv(int idTipoCCorrienteProv) {
        this.idTipoCCorrienteProv = idTipoCCorrienteProv;
    }

    public String getFechaCCorrienteProv() {
        return fechaCCorrienteProv;
    }

    public void setFechaCCorrienteProv(String fechaCCorrienteProv) {
        this.fechaCCorrienteProv = fechaCCorrienteProv;
    }

    public String getNombreCCorrienteProv() {
        return nombreCCorrienteProv;
    }

    public void setNombreCCorrienteProv(String nombreCCorrienteProv) {
        this.nombreCCorrienteProv = nombreCCorrienteProv;
    }

    public String getNofacturaCCorrienteProv() {
        return nofacturaCCorrienteProv;
    }

    public void setNofacturaCCorrienteProv(String nofacturaCCorrienteProv) {
        this.nofacturaCCorrienteProv = nofacturaCCorrienteProv;
    }

    public String getFacturaCCorrienteProv() {
        return facturaCCorrienteProv;
    }

    public void setFacturaCCorrienteProv(String facturaCCorrienteProv) {
        this.facturaCCorrienteProv = facturaCCorrienteProv;
    }

    public String getCancelacionProv() {
        return CancelaciónProv;
    }

    public void setCancelacionProv(String CancelaciónProv) {
        this.CancelaciónProv = CancelaciónProv;
    }

    public String getSaldoCCorrienteProv() {
        return SaldoCCorrienteProv;
    }

    public void setSaldoCCorrienteProv(String SaldoCCorrienteProv) {
        this.SaldoCCorrienteProv = SaldoCCorrienteProv;
    }

    public clsCCorrientesProv(int idCCorrienteProv, String tipoCCorrienteProv, int idTipoCCorrienteProv, String fechaCCorrienteProv, String nombreCCorrienteProv, String nofacturaCCorrienteProv, String facturaCCorrienteProv, String CancelaciónProv, String SaldoCCorrienteProv) {
        this.idCCorrienteProv = idCCorrienteProv;
        this.tipoCCorrienteProv = tipoCCorrienteProv;
        this.idTipoCCorrienteProv = idTipoCCorrienteProv;
        this.fechaCCorrienteProv = fechaCCorrienteProv;
        this.nombreCCorrienteProv = nombreCCorrienteProv;
        this.nofacturaCCorrienteProv = nofacturaCCorrienteProv;
        this.facturaCCorrienteProv = facturaCCorrienteProv;
        this.CancelaciónProv = CancelaciónProv;
        this.SaldoCCorrienteProv = SaldoCCorrienteProv;
    }

    public clsCCorrientesProv(int idCCorrienteProv, String tipoCCorrienteProv, int idTipoCCorrienteProv, String fechaCCorrienteProv, String nombreCCorrienteProv, String nofacturaCCorrienteProv, String facturaCCorrienteProv, String CancelaciónProv) {
        this.idCCorrienteProv = idCCorrienteProv;
        this.tipoCCorrienteProv = tipoCCorrienteProv;
        this.idTipoCCorrienteProv = idTipoCCorrienteProv;
        this.fechaCCorrienteProv = fechaCCorrienteProv;
        this.nombreCCorrienteProv = nombreCCorrienteProv;
        this.nofacturaCCorrienteProv = nofacturaCCorrienteProv;
        this.facturaCCorrienteProv = facturaCCorrienteProv;
        this.CancelaciónProv = CancelaciónProv;
    }

    public clsCCorrientesProv(int idCCorrienteProv, String tipoCCorrienteProv, int idTipoCCorrienteProv, String fechaCCorrienteProv, String nombreCCorrienteProv, String nofacturaCCorrienteProv, String facturaCCorrienteProv) {
        this.idCCorrienteProv = idCCorrienteProv;
        this.tipoCCorrienteProv = tipoCCorrienteProv;
        this.idTipoCCorrienteProv = idTipoCCorrienteProv;
        this.fechaCCorrienteProv = fechaCCorrienteProv;
        this.nombreCCorrienteProv = nombreCCorrienteProv;
        this.nofacturaCCorrienteProv = nofacturaCCorrienteProv;
        this.facturaCCorrienteProv = facturaCCorrienteProv;
    }

    public clsCCorrientesProv(int idCCorrienteProv, String tipoCCorrienteProv, int idTipoCCorrienteProv, String fechaCCorrienteProv, String nombreCCorrienteProv, String nofacturaCCorrienteProv) {
        this.idCCorrienteProv = idCCorrienteProv;
        this.tipoCCorrienteProv = tipoCCorrienteProv;
        this.idTipoCCorrienteProv = idTipoCCorrienteProv;
        this.fechaCCorrienteProv = fechaCCorrienteProv;
        this.nombreCCorrienteProv = nombreCCorrienteProv;
        this.nofacturaCCorrienteProv = nofacturaCCorrienteProv;
    }

    public clsCCorrientesProv(int idCCorrienteProv, String tipoCCorrienteProv, int idTipoCCorrienteProv, String fechaCCorrienteProv, String nombreCCorrienteProv) {
        this.idCCorrienteProv = idCCorrienteProv;
        this.tipoCCorrienteProv = tipoCCorrienteProv;
        this.idTipoCCorrienteProv = idTipoCCorrienteProv;
        this.fechaCCorrienteProv = fechaCCorrienteProv;
        this.nombreCCorrienteProv = nombreCCorrienteProv;
    }

    public clsCCorrientesProv(int idCCorrienteProv, String tipoCCorrienteProv, int idTipoCCorrienteProv, String fechaCCorrienteProv) {
        this.idCCorrienteProv = idCCorrienteProv;
        this.tipoCCorrienteProv = tipoCCorrienteProv;
        this.idTipoCCorrienteProv = idTipoCCorrienteProv;
        this.fechaCCorrienteProv = fechaCCorrienteProv;
    }

    public clsCCorrientesProv(int idCCorrienteProv, String tipoCCorrienteProv, int idTipoCCorrienteProv) {
        this.idCCorrienteProv = idCCorrienteProv;
        this.tipoCCorrienteProv = tipoCCorrienteProv;
        this.idTipoCCorrienteProv = idTipoCCorrienteProv;
    }

    public clsCCorrientesProv(int idCCorrienteProv, String tipoCCorrienteProv) {
        this.idCCorrienteProv = idCCorrienteProv;
        this.tipoCCorrienteProv = tipoCCorrienteProv;
    }

    public clsCCorrientesProv(int idCCorrienteProv) {
        this.idCCorrienteProv = idCCorrienteProv;
    }

    public clsCCorrientesProv() {
    }
    //Metodos de acceso a la capa controlador
    public clsCCorrientesProv getBuscarInformacionCCPorNombre(clsCCorrientesProv CCorrienteProv)
    {
        daoCCorrientesProv daoCCorrientesProv = new daoCCorrientesProv();
        return daoCCorrientesProv.consultaCCProvPorNombre(CCorrienteProv);
    }
    public clsCCorrientesProv getBuscarInformacionCCProvPorId(clsCCorrientesProv CCorrienteProv)
    {
        daoCCorrientesProv daoCCorrientesProv = new daoCCorrientesProv();
        return daoCCorrientesProv.consultaCCProvPorId(CCorrienteProv);
    }    
    public List<clsCCorrientesProv> getListadoCC()
    {
        daoCCorrientesProv daoCCorrientesProv = new daoCCorrientesProv();
        List<clsCCorrientesProv> listadoCCorrientesProv = daoCCorrientesProv.consultaCCProv();
        return listadoCCorrientesProv;
    }
    public int setBorrarCC(clsCCorrientesProv CCorrienteProv)
    {
        daoCCorrientesProv daoCCorrientesProv = new daoCCorrientesProv();
        return daoCCorrientesProv.borrarCCProv(CCorrienteProv);
    }          
    public int setIngresarCC(clsCCorrientesProv CCorrienteProv)
    {
        daoCCorrientesProv daoCCorrientesProv = new daoCCorrientesProv();
        return daoCCorrientesProv.ingresaCCProv(CCorrienteProv);
    }              
    public int setModificarCC(clsCCorrientesProv CCorrienteProv)
    {
        daoCCorrientesProv daoCCorrientesProv = new daoCCorrientesProv();
        return daoCCorrientesProv.actualizaCCProv(CCorrienteProv);
    }
}