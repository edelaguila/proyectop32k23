/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoConceptos;
/**
 *
 * @author visitante
 */
public class clsConceptos {
    private int IdConcepto;
    private String nombreConcepto;
    private String descripcionConcepto;
    private String efectoConcepto;
    private String estatusConcepto;

    public clsConceptos() {
    }

    public clsConceptos(int IdConcepto) {
        this.IdConcepto = IdConcepto;
    }

    public clsConceptos(int IdConcepto, String nombreConcepto) {
        this.IdConcepto = IdConcepto;
        this.nombreConcepto = nombreConcepto;
    }

    public clsConceptos(int IdConcepto, String nombreConcepto, String descripcionConcepto) {
        this.IdConcepto = IdConcepto;
        this.nombreConcepto = nombreConcepto;
        this.descripcionConcepto = descripcionConcepto;
    }

    public clsConceptos(int IdConcepto, String nombreConcepto, String descripcionConcepto, String efectoConcepto) {
        this.IdConcepto = IdConcepto;
        this.nombreConcepto = nombreConcepto;
        this.descripcionConcepto = descripcionConcepto;
        this.efectoConcepto = efectoConcepto;
    }

    public clsConceptos(int IdConcepto, String nombreConcepto, String descripcionConcepto, String efectoConcepto, String estatusConcepto) {
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
    public clsConceptos getBuscarInformacionConceptoPorNombre(clsConceptos concepto)
    {
        daoConceptos daoconcepto = new daoConceptos();
        return daoconcepto.consultaConceptoPorNombre(concepto);
    }
    public clsConceptos getBuscarInformacionConceptoPorId(clsConceptos concepto)
    {
        daoConceptos daoconcepto = new daoConceptos();
        return daoconcepto.consultaConceptoPorId(concepto);
    }    
    public List<clsConceptos> getListadoConceptos()
    {
        daoConceptos daoconcepto = new daoConceptos();
        List<clsConceptos> listadoClsConceptos = daoconcepto.consultaConcepto();
        return listadoClsConceptos;
    }
    public int setBorrarConcepto(clsConceptos concepto)
    {
        daoConceptos daoconcepto = new daoConceptos();
        return daoconcepto.borrarConcepto(concepto);
    }          
    public int setIngresarConcepto(clsConceptos concepto)
    {
        daoConceptos daoconcepto = new daoConceptos();
        return daoconcepto.ingresaConcepto(concepto);
    }              
    public int setModificarConcepto(clsConceptos concepto)
    {
        daoConceptos daoconcepto = new daoConceptos();
        return daoconcepto.actualizaConcepto(concepto);
    }              
}
