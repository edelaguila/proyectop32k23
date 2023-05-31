/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Compras.Controlador;
import Compras.Modelo.daoClasificacionCompras;
import java.util.List;

public class clsClasificacionCompras {
    private int id_clasificacion;
    private String nombre_clasificacion;

    public int getid_clasificacion() {
        return id_clasificacion;
    }

    public void setid_clasificacion(int id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public String getnombre_clasificacion() {
        return nombre_clasificacion;
    }

    public void setnombre_clasificacion(String nombre_clasificacion) {
        this.nombre_clasificacion = nombre_clasificacion;
    }

    public clsClasificacionCompras(int id_clasificacion, String nombre_clasificacion) {
        this.id_clasificacion = id_clasificacion;
        this.nombre_clasificacion = nombre_clasificacion;
    }
    
    public clsClasificacionCompras(int id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public clsClasificacionCompras() {
    }
    //Metodos de acceso a la capa controlador
    public clsClasificacionCompras consultaClasificacionComprasPorNombre(clsClasificacionCompras ccompra)
    {
        daoClasificacionCompras daoClasificacionCompras = new daoClasificacionCompras();
        return daoClasificacionCompras.consultaClasificacionComprasPorNombre(ccompra);
    }
    public clsClasificacionCompras consultaClasificacionComprasPorId(clsClasificacionCompras ccompra)
    {
        daoClasificacionCompras daoClasificacionCompras = new daoClasificacionCompras();
        return daoClasificacionCompras.consultaClasificacionComprasPorId(ccompra);
    }
    public List<clsClasificacionCompras> getListadoClasificacionCompras()
    {
        daoClasificacionCompras daoClasificacionCompras = new daoClasificacionCompras();
        List<clsClasificacionCompras> listadoClasificacionCompras = daoClasificacionCompras.consultaClasificacionCompras();
        return listadoClasificacionCompras;
    }
    public int setBorrarClasificacionCompras(clsClasificacionCompras ccompra)
    {
        daoClasificacionCompras daoClasificacionCompras = new daoClasificacionCompras();
        return daoClasificacionCompras.borrarClasificacionCompras(ccompra);
    }          
    public int setIngresarClasificacionCompras(clsClasificacionCompras ccompra)
    {
        daoClasificacionCompras daoClasificacionCompras = new daoClasificacionCompras();
        return daoClasificacionCompras.ingresaClasificacionCompras(ccompra);
    }              
    public int setModificarClasificacionCompras(clsClasificacionCompras ccompra)
    {
        daoClasificacionCompras daoClasificacionCompras = new daoClasificacionCompras();
        return daoClasificacionCompras.actualizaClasificacionCompras(ccompra);
    }              

    public void add(clsClasificacionCompras ccompra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

