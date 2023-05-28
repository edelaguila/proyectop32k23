/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoComprobanteProveedoresBancos;
/**
 *
 * @author visitante
 */
public class clsComprobanteProveedoresBancos {
    private int comId;
    private String conFechaEmision;
    private int tipMovid;
    private int cueId;
    private int concId ;
    private int codBanco;
    private int movDetId;
    private int cpid ;

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getConFechaEmision() {
        return conFechaEmision;
    }

    public void setConFechaEmision(String conFechaEmision) {
        this.conFechaEmision = conFechaEmision;
    }

    public int getTipMovid() {
        return tipMovid;
    }

    public void setTipMovid(int tipMovid) {
        this.tipMovid = tipMovid;
    }

    public int getCueId() {
        return cueId;
    }

    public void setCueId(int cueId) {
        this.cueId = cueId;
    }

    public int getConcId() {
        return concId;
    }

    public void setConcId(int concId) {
        this.concId = concId;
    }

    public int getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(int codBanco) {
        this.codBanco = codBanco;
    }

    public int getMovDetId() {
        return movDetId;
    }

    public void setMovDetId(int movDetId) {
        this.movDetId = movDetId;
    }

    public int getcpid () {
        return cpid ;
    }

    public void setcpid (int cpid ) {
        this.cpid  = cpid ;
    }

    public clsComprobanteProveedoresBancos() {
    }

    public clsComprobanteProveedoresBancos(int comId) {
        this.comId = comId;
    }

    public clsComprobanteProveedoresBancos(int comId, String conFechaEmision) {
        this.comId = comId;
        this.conFechaEmision = conFechaEmision;
    }

    public clsComprobanteProveedoresBancos(int comId, String conFechaEmision, int tipMovid) {
        this.comId = comId;
        this.conFechaEmision = conFechaEmision;
        this.tipMovid = tipMovid;
    }

    public clsComprobanteProveedoresBancos(int comId, String conFechaEmision, int tipMovid, int cueId) {
        this.comId = comId;
        this.conFechaEmision = conFechaEmision;
        this.tipMovid = tipMovid;
        this.cueId = cueId;
    }

    public clsComprobanteProveedoresBancos(int comId, String conFechaEmision, int tipMovid, int cueId, int concId) {
        this.comId = comId;
        this.conFechaEmision = conFechaEmision;
        this.tipMovid = tipMovid;
        this.cueId = cueId;
        this.concId = concId;
    }

    public clsComprobanteProveedoresBancos(int comId, String conFechaEmision, int tipMovid, int cueId, int concId, int codBanco) {
        this.comId = comId;
        this.conFechaEmision = conFechaEmision;
        this.tipMovid = tipMovid;
        this.cueId = cueId;
        this.concId = concId;
        this.codBanco = codBanco;
    }

    public clsComprobanteProveedoresBancos(int comId, String conFechaEmision, int tipMovid, int cueId, int concId, int codBanco, int movDetId) {
        this.comId = comId;
        this.conFechaEmision = conFechaEmision;
        this.tipMovid = tipMovid;
        this.cueId = cueId;
        this.concId = concId;
        this.codBanco = codBanco;
        this.movDetId = movDetId;
    }

    public clsComprobanteProveedoresBancos(int comId, String conFechaEmision, int tipMovid, int cueId, int concId, int codBanco, int movDetId, int cpid ) {
        this.comId = comId;
        this.conFechaEmision = conFechaEmision;
        this.tipMovid = tipMovid;
        this.cueId = cueId;
        this.concId = concId;
        this.codBanco = codBanco;
        this.movDetId = movDetId;
        this.cpid  = cpid;
    }

    @Override
    public String toString() {
        return "clsComprobanteProveedoresBancos{" + "comId =" + comId    + ", conFechaEmision  =" + conFechaEmision   + ", tipMovid  =" + tipMovid + ", cueId=" + cueId + ", concId  =" + concId    + ", banId  =" + codBanco +  ", movdetId  =" + movDetId +  ", cpid   =" + cpid  + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsComprobanteProveedoresBancos getBuscarInformacionComprobanteProveedoresPorNombre(clsComprobanteProveedoresBancos comprobante)
    {
        daoComprobanteProveedoresBancos daoComprobanteProveedoresBancos = new daoComprobanteProveedoresBancos();
        return daoComprobanteProveedoresBancos.consultaTComprobanteProveedoresPorNombre(comprobante);
    }
    public clsComprobanteProveedoresBancos getBuscarInformacionComprobanteProveedoresPorId(clsComprobanteProveedoresBancos comprobante)
    {
        daoComprobanteProveedoresBancos daoComprobanteProveedoresBancos = new daoComprobanteProveedoresBancos();
        return daoComprobanteProveedoresBancos.consultaComprobanteProveedoresPorId(comprobante);
    }    
    public List<clsComprobanteProveedoresBancos> getListadoComprobantesProveedores()
    {
        daoComprobanteProveedoresBancos daoComprobanteProveedoresBancos = new daoComprobanteProveedoresBancos();
        List<clsComprobanteProveedoresBancos> listadoComprobanteProveedor = daoComprobanteProveedoresBancos.consultaComprobanteProveedores();
        return listadoComprobanteProveedor;
    }
    public int setBorrarComprobanteProveedores(clsComprobanteProveedoresBancos comprobante)
    {
        daoComprobanteProveedoresBancos daoComprobanteProveedoresBancos = new daoComprobanteProveedoresBancos();
        return daoComprobanteProveedoresBancos.borrarComprobanteProveedores(comprobante);
    }          
    public int setIngresarComprobanteProveedores(clsComprobanteProveedoresBancos comprobante)
    {
        daoComprobanteProveedoresBancos daoComprobanteProveedoresBancos = new daoComprobanteProveedoresBancos();
        return daoComprobanteProveedoresBancos.ingresaComprobanteProveedores(comprobante);
    }              
    public int setModificarComprobanteProveedores(clsComprobanteProveedoresBancos comprobante)
    {
        daoComprobanteProveedoresBancos daoComprobanteProveedoresBancos = new daoComprobanteProveedoresBancos();
        return daoComprobanteProveedoresBancos.actualizaComprobanteProveedores(comprobante);
    }              

    public void getComprobantePrCosto(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getComprobantePrdCosto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
