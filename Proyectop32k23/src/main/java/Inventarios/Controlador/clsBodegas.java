/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega TODO el codigo para la parte del controlador del mantenimiento de bodegas
//Victor Josué Jerez Mijangos 9959-21-2081
package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoBodegas;

/**
 *
 * @author visitante
 */
public class clsBodegas {
    private int IdBodegas;
    private String NombreBodegas;
    private String DescripcionBodega;
    private String fIngresoBodega;
    private String fSalidaBodega;
    private String EstatusBodegas;

    public int getIdBodegas() {
        return IdBodegas;
    }

    public void setIdBodegas(int IdBodegas) {
        this.IdBodegas = IdBodegas;
    }

    public String getNombreBodegas() {
        return NombreBodegas;
    }

    public void setNombreBodegas(String NombreBodegas) {
        this.NombreBodegas = NombreBodegas;
    }

    public String getDescripcionBodega() {
        return DescripcionBodega;
    }

    public void setDescripcionBodega(String DescripcionBodega) {
        this.DescripcionBodega = DescripcionBodega;
    }

    public String getfIngresoBodega() {
        return fIngresoBodega;
    }

    public void setfIngresoBodega(String fIngresoBodega) {
        this.fIngresoBodega = fIngresoBodega;
    }

    public String getfSalidaBodega() {
        return fSalidaBodega;
    }

    public void setfSalidaBodega(String fSalidaBodega) {
        this.fSalidaBodega = fSalidaBodega;
    }

    public String getEstatusBodegas() {
        return EstatusBodegas;
    }

    public void setEstatusBodegas(String EstatusBodegas) {
        this.EstatusBodegas = EstatusBodegas;
    }

    public clsBodegas(int IdBodegas, String NombreBodegas, String DescripcionBodega, String fIngresoBodega, String fSalidaBodega) {
        this.IdBodegas = IdBodegas;
        this.NombreBodegas = NombreBodegas;
        this.DescripcionBodega = DescripcionBodega;
        this.fIngresoBodega = fIngresoBodega;
        this.fSalidaBodega = fSalidaBodega;
    }

    public clsBodegas(int IdBodegas, String NombreBodegas, String DescripcionBodega, String fIngresoBodega, String fSalidaBodega, String EstatusBodegas) {
        this.IdBodegas = IdBodegas;
        this.NombreBodegas = NombreBodegas;
        this.DescripcionBodega = DescripcionBodega;
        this.fIngresoBodega = fIngresoBodega;
        this.fSalidaBodega = fSalidaBodega;
        this.EstatusBodegas = EstatusBodegas;
    }

    public clsBodegas(int IdBodegas, String NombreBodegas, String DescripcionBodega, String fIngresoBodega) {
        this.IdBodegas = IdBodegas;
        this.NombreBodegas = NombreBodegas;
        this.DescripcionBodega = DescripcionBodega;
        this.fIngresoBodega = fIngresoBodega;
    }

    public clsBodegas(int IdBodegas, String NombreBodegas, String DescripcionBodega) {
        this.IdBodegas = IdBodegas;
        this.NombreBodegas = NombreBodegas;
        this.DescripcionBodega = DescripcionBodega;
    }

    public clsBodegas(int IdBodegas, String NombreBodegas) {
        this.IdBodegas = IdBodegas;
        this.NombreBodegas = NombreBodegas;
    }

    public clsBodegas(int IdBodegas) {
        this.IdBodegas = IdBodegas;
    }

    public clsBodegas() {
    }

    
    //Metodos de acceso a la capa controlador
    public clsBodegas getBuscarInformacionBodegasPorNombre(clsBodegas Bodegas)
    {
        daoBodegas daobodegas = new daoBodegas();
        return daobodegas.consultaBodegasPorNombre(Bodegas);
    }
    public clsBodegas getBuscarInformacionBodegasPorId(clsBodegas Bodegas)
    {
        daoBodegas daobodegas = new daoBodegas();
        return daobodegas.consultaBodegasPorId(Bodegas);
    }
    public List<clsBodegas> getListadoBodegas()
    {
        daoBodegas daobodegas = new daoBodegas();
        List<clsBodegas> listadoBodegas = daobodegas.consultaBodegas();
        return listadoBodegas;
    }
    public int setBorrarBodegas(clsBodegas Bodegas)
    {
        daoBodegas daobodegas = new daoBodegas();
        return daobodegas.borrarBodegas(Bodegas);
    }
    public int setIngresarBodegas(clsBodegas Bodegas)
    {
        daoBodegas daobodegas = new daoBodegas();
        return daobodegas.ingresaBodegas(Bodegas);
    }              
    public int setModificarBodegas(clsBodegas Bodegas)
    {
        daoBodegas daobodegas = new daoBodegas();
        return daobodegas.actualizaBodegas(Bodegas);
    }

    public void add(List<clsBodegas> Bodegas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
