/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega todo el codigo para la parte del controlador del mantenimiento de marcas
//Victor Josué Jerez Mijangos 9959-21-2081

package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoMarcas;
/**
 *
 * @author visitante
 */
public class clsMarcas {
    private int IdMarcas;
    private String NombreMarcas;
    private int ExistenciasMarcas;
    private double PreciosMarcas;
    private String EstatusMarcas;

    public int getIdMarcas() {
        return IdMarcas;
    }

    public void setIdMarcas(int IdMarcas) {
        this.IdMarcas = IdMarcas;
    }

    public String getNombreMarcas() {
        return NombreMarcas;
    }

    public void setNombreMarcas(String NombreMarcas) {
        this.NombreMarcas = NombreMarcas;
    }

    public int getExistenciasMarcas() {
        return ExistenciasMarcas;
    }

    public void setExistenciasMarcas(int ExistenciasMarcas) {
        this.ExistenciasMarcas = ExistenciasMarcas;
    }

    public double getPreciosMarcas() {
        return PreciosMarcas;
    }

    public void setPreciosMarcas(double PreciosMarcas) {
        this.PreciosMarcas = PreciosMarcas;
    }

    public String getEstatusMarcas() {
        return EstatusMarcas;
    }

    public void setEstatusMarcas(String EstatusMarcas) {
        this.EstatusMarcas = EstatusMarcas;
    }

    public clsMarcas(int IdMarcas, String NombreMarcas, int ExistenciasMarcas, double PreciosMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
        this.ExistenciasMarcas = ExistenciasMarcas;
        this.PreciosMarcas = PreciosMarcas;
    }

    public clsMarcas(int IdMarcas, String NombreMarcas, int ExistenciasMarcas, double PreciosMarcas, String EstatusMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
        this.ExistenciasMarcas = ExistenciasMarcas;
        this.PreciosMarcas = PreciosMarcas;
        this.EstatusMarcas = EstatusMarcas;
    }

    public clsMarcas(int IdMarcas, String NombreMarcas, int ExistenciasMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
        this.ExistenciasMarcas = ExistenciasMarcas;
    }

    public clsMarcas(int IdMarcas, String NombreMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
    }

    public clsMarcas(int IdMarcas) {
        this.IdMarcas = IdMarcas;
    }

    public clsMarcas() {
    }

    
    
    //Metodos de acceso a la capa controlador
    public clsMarcas getBuscarInformacionMarcasPorNombre(clsMarcas Marcas)
    {
        daoMarcas daomarcas = new daoMarcas();
        return daomarcas.consultaMarcasPorNombre(Marcas);
    }
    public clsMarcas getBuscarInformacionMarcasPorId(clsMarcas Marcas)
    {
        daoMarcas daomarcas = new daoMarcas();
        return daomarcas.consultaMarcasPorId(Marcas);
    }
    public List<clsMarcas> getListadoMarcas()
    {
        daoMarcas daomarcas = new daoMarcas();
        List<clsMarcas> listadoMarcas = daomarcas.consultaMarcas();
        return listadoMarcas;
    }
    public int setBorrarMarcas(clsMarcas Marcas)
    {
        daoMarcas daomarcas = new daoMarcas();
        return daomarcas.borrarMarcas(Marcas);
    }
    public int setIngresarMarcas(clsMarcas Marcas)
    {
        daoMarcas daomarcas = new daoMarcas();
        return daomarcas.ingresaMarcas(Marcas);
    }              
    public int setModificarMarcas(clsMarcas Marcas)
    {
        daoMarcas daomarcas = new daoMarcas();
        return daomarcas.actualizaMarcas(Marcas);
    }

    public void add(List<clsMarcas> Marcas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
