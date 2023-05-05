/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoTipoMoneda;
/**
 *
 * @author visitante
 */
public class clsTipoMoneda {
    private int tipModId;
    private String tipMondNombre;
    private String tipMondAbreviacion;
    private float tipModValor;
    
    public clsTipoMoneda() {
    }

    public clsTipoMoneda(int tipModId) {
        this.tipModId = tipModId;
    }

    public clsTipoMoneda(int tipModId, String tipMondNombre) {
        this.tipModId = tipModId;
        this.tipMondNombre = tipMondNombre;
    }

    public clsTipoMoneda(int tipModId, String tipMondNombre, String tipMondAbreviacion) {
        this.tipModId = tipModId;
        this.tipMondNombre = tipMondNombre;
        this.tipMondAbreviacion = tipMondAbreviacion;
    }

    public clsTipoMoneda(int tipModId, String tipMondNombre, String tipMondAbreviacion, float tipModValor) {
        this.tipModId = tipModId;
        this.tipMondNombre = tipMondNombre;
        this.tipMondAbreviacion = tipMondAbreviacion;
        this.tipModValor = tipModValor;
    }

