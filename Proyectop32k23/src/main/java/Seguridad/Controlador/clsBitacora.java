/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;

import Seguridad.Modelo.daoBitacora;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 *
 * @author visitante
 */
public class clsBitacora {
    private int IdBitacora;
    private String FechaBitacora;
    private String AccionBitacora;
    private String IpBitacora;
    private int IdUsuario;
    private int IdAplicacion;
    private String NombrePcBitacora;
    
    public clsBitacora(String FechaBitacora, String AccionBitacora, String IpBitacora, int IdUsuario, int IdAplicacion, String NombrePcBitacora) {
        this.FechaBitacora = FechaBitacora;
        this.AccionBitacora = AccionBitacora;
        this.IpBitacora = IpBitacora;
        this.IdUsuario = IdUsuario;
        this.IdAplicacion = IdAplicacion;
        this.NombrePcBitacora = NombrePcBitacora;
    }


    public clsBitacora() {
    }

    public clsBitacora(int IdBitacora) {
        this.IdBitacora = IdBitacora;
    }    



    public int getIdBitacora() {
        return IdBitacora;
    }

    public void setIdBitacora(int IdBitacora) {
        this.IdBitacora = IdBitacora;
    }

    public String getFechaBitacora() {
        return FechaBitacora;
    }

    public void setFechaBitacora(String FechaBitacora) {
        this.FechaBitacora = FechaBitacora;
    }

    public String getAccionBitacora() {
        return AccionBitacora;
    }

    public void setAccionBitacora(String AccionBitacora) {
        this.AccionBitacora = AccionBitacora;
    }

    public String getIpBitacora() {
        return IpBitacora;
    }

    public void setIpBitacora(String IpBitacora) {
        this.IpBitacora = IpBitacora;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdAplicacion() {
        return IdAplicacion;
    }

    public void setIdAplicacion(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public String getNombrePcBitacora() {
        return NombrePcBitacora;
    }

    public void setNombrePcBitacora(String NombrePcBitacora) {
        this.NombrePcBitacora = NombrePcBitacora;
    }
    
    @Override
    public String toString() {
        return "clsBitacora{" + "IdBitacora=" + IdBitacora + ", FechaBitacora=" + FechaBitacora + ", AccionBitacora=" + AccionBitacora + ", IpBitacora=" + IpBitacora + ", IdUsuario=" + IdUsuario + ", IdAplicacion=" + IdAplicacion + ", NombrePcBitacora=" + NombrePcBitacora + '}';
    }
    public int setIngresarBitacora(int codigoUsuario, int codigoAplicacion, String accion)
    {
        daoBitacora daobitacora = new daoBitacora();
        return daobitacora.insert(codigoUsuario, codigoAplicacion, accion);
    }
    public List<clsBitacora> getListadoBitacora(String primeraFecha, String segundaFecha) throws ParseException
    {
        daoBitacora daobitacora = new daoBitacora();
        List<clsBitacora> listadoBitacora = daobitacora.query(primeraFecha, segundaFecha);
        return listadoBitacora;
    }    
}
