/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoExistencias;
/**
 *
 * @author visitante
 */
public class clsExistencias {
    private int IdProductos;
    private int IdBodegas;   
    private int ExistenciasSaldo;

    public int getIdProductos() {
        return IdProductos;
    }

    public void setIdProductos(int IdProductos) {
        this.IdProductos = IdProductos;
    }

    public int getIdBodegas() {
        return IdBodegas;
    }

    public void setIdBodegas(int IdBodegas) {
        this.IdBodegas = IdBodegas;
    }

    public int getExistenciasSaldo() {
        return ExistenciasSaldo;
    }

    public void setExistenciasSaldo(int ExistenciasSaldo) {
        this.ExistenciasSaldo = ExistenciasSaldo;
    }

    public clsExistencias(int IdProductos, int IdBodegas, int ExistenciasSaldo) {
        this.IdProductos = IdProductos;
        this.IdBodegas = IdBodegas;
        this.ExistenciasSaldo = ExistenciasSaldo;
    }

    public clsExistencias(int IdProductos, int IdBodegas) {
        this.IdProductos = IdProductos;
        this.IdBodegas = IdBodegas;
    }

    public clsExistencias(int IdProductos) {
        this.IdProductos = IdProductos;
    }

    public clsExistencias() {
    }
   

    

    //Metodos de acceso a la capa controlador
    public clsExistencias getBuscarInformacionExistenciasPorNombre(clsExistencias Existencias)
    {
        daoExistencias daoexistencias = new daoExistencias();
        return daoexistencias.consultaExistenciasPorNombre(Existencias);
    }
    public clsExistencias getBuscarInformacionExistenciasPorId(clsExistencias Existencias)
    {
        daoExistencias daoexistencias = new daoExistencias();
        return daoexistencias.consultaExistenciasPorId(Existencias);
    }
    public List<clsExistencias> getListadoExistencias()
    {
        daoExistencias daoexistencias = new daoExistencias();
        List<clsExistencias> listadoExistencias = daoexistencias.consultaExistencias();
        return listadoExistencias;
    }
    public int setBorrarExistencias(clsExistencias Existencias)
    {
        daoExistencias daoexistencias = new daoExistencias();
        return daoexistencias.borrarExistencias(Existencias);
    }
    public int setIngresarExistencias(clsExistencias Existencias)
    {
        daoExistencias daoexistencias = new daoExistencias();
        return daoexistencias.ingresaExistencias(Existencias);
    }              
    public int setModificarExistencias(clsExistencias Existencias)
    {
        daoExistencias daoexistencias = new daoExistencias();
        return daoexistencias.actualizaExistencias(Existencias);
    }

    public void add(List<clsExistencias> Existencias) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
