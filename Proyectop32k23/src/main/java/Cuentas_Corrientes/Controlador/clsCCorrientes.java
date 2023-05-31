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
// CAMBIOS HECHOS POR : DANIEL ALEXANDER HALL ALVAREZ;9959-21-1395 Y MONICA GABRIELA PEREZ VELÁSQUEZ; 9959-21-1840.
    private int idCCorriente;
    private int idCCliente;
    private String nombreCCliente;
    private String fechaCCorriente;
    private String nofacturaCCorriente;
    private int haberCCorriente;
    private int debeCCorriente;
    private int saldoCCorriente;

    public void setIdCCorriente(int idCCorriente) {
        this.idCCorriente = idCCorriente;
    }

    public void setIdCCliente(int idCCliente) {
        this.idCCliente = idCCliente;
    }

    public void setNombreCCliente(String nombreCCliente) {
        this.nombreCCliente = nombreCCliente;
    }

    public void setFechaCCorriente(String fechaCCorriente) {
        this.fechaCCorriente = fechaCCorriente;
    }

    public void setNofacturaCCorriente(String nofacturaCCorriente) {
        this.nofacturaCCorriente = nofacturaCCorriente;
    }

    public void setHaberCCorriente(int haberCCorriente) {
        this.haberCCorriente = haberCCorriente;
    }

    public void setDebeCCorriente(int debeCCorriente) {
        this.debeCCorriente = debeCCorriente;
    }

    public void setSaldoCCorriente(int saldoCCorriente) {
        this.saldoCCorriente = saldoCCorriente;
    }

    public int getIdCCorriente() {
        return idCCorriente;
    }

    public int getIdCCliente() {
        return idCCliente;
    }

    public String getNombreCCliente() {
        return nombreCCliente;
    }

    public String getFechaCCorriente() {
        return fechaCCorriente;
    }

    public String getNofacturaCCorriente() {
        return nofacturaCCorriente;
    }

    public int getHaberCCorriente() {
        return haberCCorriente;
    }

    public int getDebeCCorriente() {
        return debeCCorriente;
    }

    public int getSaldoCCorriente() {
        return saldoCCorriente;
    }

    public clsCCorrientes(int idCCorriente, int idCCliente, String nombreCCliente, String fechaCCorriente, String nofacturaCCorriente, int haberCCorriente, int debeCCorriente, int saldoCCorriente) {
        this.idCCorriente = idCCorriente;
        this.idCCliente = idCCliente;
        this.nombreCCliente = nombreCCliente;
        this.fechaCCorriente = fechaCCorriente;
        this.nofacturaCCorriente = nofacturaCCorriente;
        this.haberCCorriente = haberCCorriente;
        this.debeCCorriente = debeCCorriente;
        this.saldoCCorriente = saldoCCorriente;
    }

    public clsCCorrientes(int idCCorriente, int idCCliente, String nombreCCliente, String fechaCCorriente, String nofacturaCCorriente, int haberCCorriente, int debeCCorriente) {
        this.idCCorriente = idCCorriente;
        this.idCCliente = idCCliente;
        this.nombreCCliente = nombreCCliente;
        this.fechaCCorriente = fechaCCorriente;
        this.nofacturaCCorriente = nofacturaCCorriente;
        this.haberCCorriente = haberCCorriente;
        this.debeCCorriente = debeCCorriente;
    }

    public clsCCorrientes(int idCCorriente, int idCCliente, String nombreCCliente, String fechaCCorriente, String nofacturaCCorriente, int haberCCorriente) {
        this.idCCorriente = idCCorriente;
        this.idCCliente = idCCliente;
        this.nombreCCliente = nombreCCliente;
        this.fechaCCorriente = fechaCCorriente;
        this.nofacturaCCorriente = nofacturaCCorriente;
        this.haberCCorriente = haberCCorriente;
    }

    public clsCCorrientes(int idCCorriente, int idCCliente, String nombreCCliente, String fechaCCorriente, String nofacturaCCorriente) {
        this.idCCorriente = idCCorriente;
        this.idCCliente = idCCliente;
        this.nombreCCliente = nombreCCliente;
        this.fechaCCorriente = fechaCCorriente;
        this.nofacturaCCorriente = nofacturaCCorriente;
    }

    public clsCCorrientes(int idCCorriente, int idCCliente, String nombreCCliente, String fechaCCorriente) {
        this.idCCorriente = idCCorriente;
        this.idCCliente = idCCliente;
        this.nombreCCliente = nombreCCliente;
        this.fechaCCorriente = fechaCCorriente;
    }

    public clsCCorrientes(int idCCorriente, int idCCliente, String nombreCCliente) {
        this.idCCorriente = idCCorriente;
        this.idCCliente = idCCliente;
        this.nombreCCliente = nombreCCliente;
    }

    public clsCCorrientes(int idCCorriente, int idCCliente) {
        this.idCCorriente = idCCorriente;
        this.idCCliente = idCCliente;
    }

    public clsCCorrientes(int idCCorriente) {
        this.idCCorriente = idCCorriente;
    }
    public clsCCorrientes() {
    }
    
    //Metodos de acceso a la capa controlador
    public clsCCorrientes getBuscarInformacionCCPorNombre(clsCCorrientes CCorriente)
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        return daoCCorrientes.consultaCCPorNombre(CCorriente);
    }
    public clsCCorrientes getBuscarInformacionCCPorId(clsCCorrientes CCorriente)
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        return daoCCorrientes.consultaCCPorId(CCorriente);
    }    
    public List<clsCCorrientes> getListadoCC()
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        List<clsCCorrientes> listadoCCorrientes = daoCCorrientes.consultaCC();
        return listadoCCorrientes;
    }
    public int setBorrarCC(clsCCorrientes CCorriente)
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        return daoCCorrientes.borrarCC(CCorriente);
    }          
    public int setIngresarCC(clsCCorrientes CCorriente)
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        return daoCCorrientes.ingresaCC(CCorriente);
    }              
    public int setModificarCC(clsCCorrientes CCorriente)
    {
        daoCCorrientes daoCCorrientes = new daoCCorrientes();
        return daoCCorrientes.actualizaCC(CCorriente);
    }
    }
