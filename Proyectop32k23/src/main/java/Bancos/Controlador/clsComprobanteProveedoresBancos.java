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
