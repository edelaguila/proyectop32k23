/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega todo el codigo para la parte del controlador del mantenimiento de lineas
//Victor Josué Jerez Mijangos 9959-21-2081

package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoLineas;
/**
 *
 * @author visitante
 */
public class clsLineas {
    private int IdLineas;
    private String NombreLineas;
    private double PreciosLineas;
    private String EstatusLineas;

    public int getIdLineas() {
        return IdLineas;
    }

    public void setIdLineas(int IdLineas) {
        this.IdLineas = IdLineas;
    }

    public String getNombreLineas() {
        return NombreLineas;
    }

    public void setNombreLineas(String NombreLineas) {
        this.NombreLineas = NombreLineas;
    }

    public double getPreciosLineas() {
        return PreciosLineas;
    }

    public void setPreciosLineas(double PreciosLineas) {
        this.PreciosLineas = PreciosLineas;
    }

    public String getEstatusLineas() {
        return EstatusLineas;
    }

    public void setEstatusLineas(String EstatusLineas) {
        this.EstatusLineas = EstatusLineas;
    }

    public clsLineas(int IdLineas, String NombreLineas, double PreciosLineas) {
        this.IdLineas = IdLineas;
        this.NombreLineas = NombreLineas;
        this.PreciosLineas = PreciosLineas;
    }

    public clsLineas(int IdLineas, String NombreLineas, double PreciosLineas, String EstatusLineas) {
        this.IdLineas = IdLineas;
        this.NombreLineas = NombreLineas;
        this.PreciosLineas = PreciosLineas;
        this.EstatusLineas = EstatusLineas;
    }

    public clsLineas(int IdLineas, String NombreLineas) {
        this.IdLineas = IdLineas;
        this.NombreLineas = NombreLineas;
    }

    public clsLineas(int IdLineas) {
        this.IdLineas = IdLineas;
    }

    public clsLineas() {
    }

    //Metodos de acceso a la capa controlador
    public clsLineas getBuscarInformacionLineasPorNombre(clsLineas Lineas)
    {
        daoLineas daolineas = new daoLineas();
        return daolineas.consultaLineasPorNombre(Lineas);
    }
    public clsLineas getBuscarInformacionLineasPorId(clsLineas Lineas)
    {
        daoLineas daolineas = new daoLineas();
        return daolineas.consultaLineasPorId(Lineas);
    }
    public List<clsLineas> getListadoLineas()
    {
        daoLineas daolineas = new daoLineas();
        List<clsLineas> listadoLineas = daolineas.consultaLineas();
        return listadoLineas;
    }
    public int setBorrarLineas(clsLineas Lineas)
    {
        daoLineas daolineas = new daoLineas();
        return daolineas.borrarLineas(Lineas);
    }
    public int setIngresarLineas(clsLineas Lineas)
    {
        daoLineas daolineas = new daoLineas();
        return daolineas.ingresaLineas(Lineas);
    }              
    public int setModificarLineas(clsLineas Lineas)
    {
        daoLineas daolineas = new daoLineas();
        return daolineas.actualizaLineas(Lineas);
    }

    public void add(List<clsLineas> Lineas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
