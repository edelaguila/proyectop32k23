/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoConceptosBancos;
/**
 *
 * @author visitante
 */

//Hecho por Carlos González, 9959-20-6164

public class clsConceptosBancos {
    private int IdConcepto;
    private String nombreConcepto;
    private String descripcionConcepto;
    private String efectoConcepto;
    private String estatusConcepto;

    public clsConceptosBancos() {
    }

    public clsConceptosBancos(int IdConcepto) {
        this.IdConcepto = IdConcepto;
    }

    public clsConceptosBancos(int IdConcepto, String nombreConcepto) {
        this.IdConcepto = IdConcepto;
        this.nombreConcepto = nombreConcepto;
    }

    public clsConceptosBancos(int IdConcepto, String nombreConcepto, String descripcionConcepto) {
        this.IdConcepto = IdConcepto;
        this.nombreConcepto = nombreConcepto;
        this.descripcionConcepto = descripcionConcepto;
    }

    public clsConceptosBancos(int IdConcepto, String nombreConcepto, String descripcionConcepto, String efectoConcepto) {
        this.IdConcepto = IdConcepto;
        this.nombreConcepto = nombreConcepto;
        this.descripcionConcepto = descripcionConcepto;
        this.efectoConcepto = efectoConcepto;
    }

    public clsConceptosBancos(int IdConcepto, String nombreConcepto, String descripcionConcepto, String efectoConcepto, String estatusConcepto) {
        this.IdConcepto = IdConcepto;
        this.nombreConcepto = nombreConcepto;
        this.descripcionConcepto = descripcionConcepto;
        this.efectoConcepto = efectoConcepto;
        this.estatusConcepto = estatusConcepto;
    }

    public int getIdConcepto() {
        return IdConcepto;
    }

    public void setIdConcepto(int IdConcepto) {
        this.IdConcepto = IdConcepto;
    }

    public String getNombreConcepto() {
        return nombreConcepto;
    }

    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    public String getDescripcionConcepto() {
        return descripcionConcepto;
    }

    public void setDescripcionConcepto(String descripcionConcepto) {
        this.descripcionConcepto = descripcionConcepto;
    }

    public String getEfectoConcepto() {
        return efectoConcepto;
    }

    public void setEfectoConcepto(String efectoConcepto) {
        this.efectoConcepto = efectoConcepto;
    }

    public String getEstatusConcepto() {
        return estatusConcepto;
    }

    public void setEstatusConcepto(String estatusConcepto) {
        this.estatusConcepto = estatusConcepto;
    }

    @Override
    public String toString() {
        return "clsConcepto{" + "IdConcepto=" + IdConcepto + ", nombreConcepto=" + nombreConcepto + ", descripcionConcepto=" + descripcionConcepto + ", efectoConcepto=" + efectoConcepto + ", estatusConcepto=" + estatusConcepto +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsConceptosBancos getBuscarInformacionConceptoPorNombre(clsConceptosBancos concepto)
    {
        daoConceptosBancos daoconcepto = new daoConceptosBancos();
        return daoconcepto.consultaConceptoPorNombre(concepto);
    }
    public clsConceptosBancos getBuscarInformacionConceptoPorId(clsConceptosBancos concepto)
    {
        daoConceptosBancos daoconcepto = new daoConceptosBancos();
        return daoconcepto.consultaConceptoPorId(concepto);
    }    
    public List<clsConceptosBancos> getListadoConceptos()
    {
        daoConceptosBancos daoconcepto = new daoConceptosBancos();
        List<clsConceptosBancos> listadoClsConceptos = daoconcepto.consultaConcepto();
        return listadoClsConceptos;
    }
    public int setBorrarConcepto(clsConceptosBancos concepto)
    {
        daoConceptosBancos daoconcepto = new daoConceptosBancos();
        return daoconcepto.borrarConcepto(concepto);
    }          
    public int setIngresarConcepto(clsConceptosBancos concepto)
    {
        daoConceptosBancos daoconcepto = new daoConceptosBancos();
        return daoconcepto.ingresaConcepto(concepto);
    }              
    public int setModificarConcepto(clsConceptosBancos concepto)
    {
        daoConceptosBancos daoconcepto = new daoConceptosBancos();
        return daoconcepto.actualizaConcepto(concepto);
    }              
}
