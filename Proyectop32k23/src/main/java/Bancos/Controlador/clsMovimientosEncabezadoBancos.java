/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoMovimientosEncabezadoBancos;
/**
 *
 * @author visitante
 */
public class clsMovimientosEncabezadoBancos {
    private int movId;
    private int codBanco;
    private int cueId;
    private int tipMovId;
    private String movFecha;
    private int cueEmId;

    public clsMovimientosEncabezadoBancos() {
    }

    public clsMovimientosEncabezadoBancos(int movId) {
        this.movId = movId;
    }

    public clsMovimientosEncabezadoBancos(int movId, int codBanco) {
        this.movId = movId;
        this.codBanco = codBanco;
    }

    public clsMovimientosEncabezadoBancos(int movId, int codBanco, int cueId) {
        this.movId = movId;
        this.codBanco = codBanco;
        this.cueId = cueId;
    }

    public clsMovimientosEncabezadoBancos(int movId, int codBanco, int cueId, int tipMovId) {
        this.movId = movId;
        this.codBanco = codBanco;
        this.cueId = cueId;
        this.tipMovId = tipMovId;
    }

    public clsMovimientosEncabezadoBancos(int movId, int codBanco, int cueId, int tipMovId, String movFecha) {
        this.movId = movId;
        this.codBanco = codBanco;
        this.cueId = cueId;
        this.tipMovId = tipMovId;
        this.movFecha = movFecha;
    }

    public clsMovimientosEncabezadoBancos(int movId, int codBanco, int cueId, int tipMovId, String movFecha, int cueEmId) {
        this.movId = movId;
        this.codBanco = codBanco;
        this.cueId = cueId;
        this.tipMovId = tipMovId;
        this.movFecha = movFecha;
        this.cueEmId = cueEmId;
    }

    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public int getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(int codBanco) {
        this.codBanco = codBanco;
    }

    public int getCueId() {
        return cueId;
    }

    public void setCueId(int cueId) {
        this.cueId = cueId;
    }

    public int getTipMovId() {
        return tipMovId;
    }

    public void setTipMovId(int tipMovId) {
        this.tipMovId = tipMovId;
    }

    public String getMovFecha() {
        return movFecha;
    }

    public void setMovFecha(String movFecha) {
        this.movFecha = movFecha;
    }

    public int getCueEmId() {
        return cueEmId;
    }

    public void setCueEmId(int cueEmId) {
        this.cueEmId = cueEmId;
    }
    
    
    @Override
    public String toString() {
        return "clsMovimientosEncabezadoBancos{" + "movId =" + movId    + ", codBanco=" + codBanco + ", cueId=" + cueId + ", tipMovId  =" + tipMovId   +", movFecha=" + movFecha + ", cueEmId  =" + cueEmId   + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsMovimientosEncabezadoBancos getBuscarMovimientosEncabezadoPorCodigo(clsMovimientosEncabezadoBancos encabezado)
    {
        daoMovimientosEncabezadoBancos daoMovimientosEncabezadoBancos = new daoMovimientosEncabezadoBancos();
        return daoMovimientosEncabezadoBancos.consultaMovimientosEncabezadoPorCodigo(encabezado);
    }
    public clsMovimientosEncabezadoBancos getBuscarMovimientosEncabezadoPorId(clsMovimientosEncabezadoBancos encabezado)
    {
        daoMovimientosEncabezadoBancos daoMovimientosEncabezadoBancos = new daoMovimientosEncabezadoBancos();
        return daoMovimientosEncabezadoBancos.consultaMovimientosEncabezadoPorId(encabezado);
    }    
    public List<clsMovimientosEncabezadoBancos> getListadoMovEncabezado()
    {
        daoMovimientosEncabezadoBancos daoMovimientosEncabezadoBancos = new daoMovimientosEncabezadoBancos();
        List<clsMovimientosEncabezadoBancos> listadoMovimientosEncabezado = daoMovimientosEncabezadoBancos.consultaMovimientosEncabezado();
        return listadoMovimientosEncabezado;
    }
    public int setborrarMovimientosEncabezado(clsMovimientosEncabezadoBancos encabezado)
    {
        daoMovimientosEncabezadoBancos daoMovimientosEncabezadoBancos = new daoMovimientosEncabezadoBancos();
        return daoMovimientosEncabezadoBancos.borrarMovimientosEncabezado(encabezado);
    }          
    public int setingresaMovimientosEncabezado(clsMovimientosEncabezadoBancos encabezado)
    {
        daoMovimientosEncabezadoBancos daoMovimientosEncabezadoBancos = new daoMovimientosEncabezadoBancos();
        return daoMovimientosEncabezadoBancos.ingresaMovimientosEncabezado(encabezado);
    }              
    public int setModificarMovimientosEncabezado(clsMovimientosEncabezadoBancos encabezado)
    {
        daoMovimientosEncabezadoBancos daoMovimientosEncabezadoBancos = new daoMovimientosEncabezadoBancos();
        return daoMovimientosEncabezadoBancos.actualizaMovimientosEncabezado(encabezado);
    }              

    public void getMovimientosEncabezado(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMovimientosEncabezado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
