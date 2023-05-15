/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoAplicacionUsuario;
/**
 *
 * @author visitante
 */
public class clsAplicacionUsuario {
    private int IdAplicacion;
    private int IdUsuario;
    private String RegAplUsu;
    private String ModAplUsu;
    private String EliAplUsu;
    private String ImpAplUsu;

    public clsAplicacionUsuario() {
    }

    public clsAplicacionUsuario(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public clsAplicacionUsuario(int IdAplicacion, int IdUsuario) {
        this.IdAplicacion = IdAplicacion;
        this.IdUsuario = IdUsuario;
    }

    public clsAplicacionUsuario(int IdAplicacion, int IdUsuario, String RegAplUsu) {
        this.IdAplicacion = IdAplicacion;
        this.IdUsuario = IdUsuario;
        this.RegAplUsu = RegAplUsu;
    }

    public clsAplicacionUsuario(int IdAplicacion, int IdUsuario, String RegAplUsu, String ModAplUsu) {
        this.IdAplicacion = IdAplicacion;
        this.IdUsuario = IdUsuario;
        this.RegAplUsu = RegAplUsu;
        this.ModAplUsu = ModAplUsu;
    }

    public clsAplicacionUsuario(int IdAplicacion, int IdUsuario, String RegAplUsu, String ModAplUsu, String EliAplUsu) {
        this.IdAplicacion = IdAplicacion;
        this.IdUsuario = IdUsuario;
        this.RegAplUsu = RegAplUsu;
        this.ModAplUsu = ModAplUsu;
        this.EliAplUsu = EliAplUsu;
    }

    public clsAplicacionUsuario(int IdAplicacion, int IdUsuario, String RegAplUsu, String ModAplUsu, String EliAplUsu, String ImpAplUsu) {
        this.IdAplicacion = IdAplicacion;
        this.IdUsuario = IdUsuario;
        this.RegAplUsu = RegAplUsu;
        this.ModAplUsu = ModAplUsu;
        this.EliAplUsu = EliAplUsu;
        this.ImpAplUsu = ImpAplUsu;
    }

    public int getIdAplicacion() {
        return IdAplicacion;
    }

    public void setIdAplicacion(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getRegAplUsu() {
        return RegAplUsu;
    }

    public void setRegAplUsu(String RegAplUsu) {
        this.RegAplUsu = RegAplUsu;
    }

    public String getModAplUsu() {
        return ModAplUsu;
    }

    public void setModAplUsu(String ModAplUsu) {
        this.ModAplUsu = ModAplUsu;
    }

    public String getEliAplUsu() {
        return EliAplUsu;
    }

    public void setEliAplUsu(String EliAplUsu) {
        this.EliAplUsu = EliAplUsu;
    }

    public String getImpAplUsu() {
        return ImpAplUsu;
    }

    public void setImpAplUsu(String ImpAplUsu) {
        this.ImpAplUsu = ImpAplUsu;
    }

    @Override
    public String toString() {
        return "clsAplicacionUsuario{" + "IdAplicacion=" + IdAplicacion + ", IdUsuario=" + IdUsuario + ", RegAplUsu=" + RegAplUsu + ", ModAplUsu=" + ModAplUsu + ", EliAplUsu=" + EliAplUsu + ", ImpAplUsu=" + ImpAplUsu +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsAplicacionUsuario getBuscarInformacionAplicacionUsuarioPorId(clsAplicacionUsuario aplicacionusuario)
    {
        daoAplicacionUsuario daoaplicacionusuario = new daoAplicacionUsuario();
        return daoaplicacionusuario.consultaAplicacionUsuarioPorId(aplicacionusuario);
    }
    public List<clsAplicacionUsuario> getListadoAplicacionUsuario()
    {
        daoAplicacionUsuario daoaplicacionusuario = new daoAplicacionUsuario();
        List<clsAplicacionUsuario> listadoAplicacionUsuarios = daoaplicacionusuario.consultaAplicacionUsuarios();
        return listadoAplicacionUsuarios;
    }
    public int setBorrarAplicacion(clsAplicacionUsuario aplicacionusuario)
    {
        daoAplicacionUsuario daoaplicacionusuario = new daoAplicacionUsuario();
        return daoaplicacionusuario.borrarAplicacionUsuario(aplicacionusuario);
    }          
    public int setIngresarAplicacionUsuario(clsAplicacionUsuario aplicacionusuario)
    {
        daoAplicacionUsuario daoaplicacionusuario = new daoAplicacionUsuario();
        return daoaplicacionusuario.ingresaAplicacionUsuario(aplicacionusuario);
    }              
     public int setBorrarTodoAplicacion(clsAplicacionUsuario aplicacionusuario)
    {
        daoAplicacionUsuario daoaplicacionusuario = new daoAplicacionUsuario();
        return daoaplicacionusuario.borrarTodoAplicacion(aplicacionusuario);
    }
}
