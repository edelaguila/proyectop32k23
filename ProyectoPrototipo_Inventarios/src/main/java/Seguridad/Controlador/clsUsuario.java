/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoUsuario;
/**
 *
 * @author visitante
 */
public class clsUsuario {
    private int IdUsuario;
    private String NombreUsuario;
    private String ContrasenaUsuario;
    private String UltimaSesionUsuario;
    private String EstatusUsuario;
    private String NombreRealUsuario;
    private String CorreoUsuario;
    private String TelefonoUsuario;
    private String DireccionUsuario;
    private int TipoUsuario;

    public clsUsuario() {
    }

    public clsUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, String UltimaSesionUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, String UltimaSesionUsuario, String EstatusUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
        this.EstatusUsuario = EstatusUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, String UltimaSesionUsuario, String EstatusUsuario, String NombreRealUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
        this.EstatusUsuario = EstatusUsuario;
        this.NombreRealUsuario = NombreRealUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, String UltimaSesionUsuario, String EstatusUsuario, String NombreRealUsuario, String CorreoUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
        this.EstatusUsuario = EstatusUsuario;
        this.NombreRealUsuario = NombreRealUsuario;
        this.CorreoUsuario = CorreoUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, String UltimaSesionUsuario, String EstatusUsuario, String NombreRealUsuario, String CorreoUsuario, String TelefonoUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
        this.EstatusUsuario = EstatusUsuario;
        this.NombreRealUsuario = NombreRealUsuario;
        this.CorreoUsuario = CorreoUsuario;
        this.TelefonoUsuario = TelefonoUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, String UltimaSesionUsuario, String EstatusUsuario, String NombreRealUsuario, String CorreoUsuario, String TelefonoUsuario, String DireccionUsuario, int TipoUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
        this.EstatusUsuario = EstatusUsuario;
        this.NombreRealUsuario = NombreRealUsuario;
        this.CorreoUsuario = CorreoUsuario;
        this.TelefonoUsuario = TelefonoUsuario;
        this.DireccionUsuario = DireccionUsuario;
        this.TipoUsuario = TipoUsuario;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContrasenaUsuario() {
        return ContrasenaUsuario;
    }

    public void setContrasenaUsuario(String ContrasenaUsuario) {
        this.ContrasenaUsuario = ContrasenaUsuario;
    }

    public String getUltimaSesionUsuario() {
        return UltimaSesionUsuario;
    }

    public void setUltimaSesionUsuario(String UltimaSesionUsuario) {
        this.UltimaSesionUsuario = UltimaSesionUsuario;
    }

    public String getEstatusUsuario() {
        return EstatusUsuario;
    }

    public void setEstatusUsuario(String EstatusUsuario) {
        this.EstatusUsuario = EstatusUsuario;
    }

    public String getNombreRealUsuario() {
        return NombreRealUsuario;
    }

    public void setNombreRealUsuario(String NombreRealUsuario) {
        this.NombreRealUsuario = NombreRealUsuario;
    }

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String CorreoUsuario) {
        this.CorreoUsuario = CorreoUsuario;
    }

    public String getTelefonoUsuario() {
        return TelefonoUsuario;
    }

    public void setTelefonoUsuario(String TelefonoUsuario) {
        this.TelefonoUsuario = TelefonoUsuario;
    }

    public String getDireccionUsuario() {
        return DireccionUsuario;
    }

    public void setDireccionUsuario(String DireccionUsuario) {
        this.DireccionUsuario = DireccionUsuario;
    }
    
    public int getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(int TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }
    
    @Override
    public String toString() {
        return "clsUsuario{" + "IdUsuario=" + IdUsuario + ", NombreUsuario=" + NombreUsuario + ", ContrasenaUsuario=" + ContrasenaUsuario + ", UltimaSesionUsuario=" + UltimaSesionUsuario + ", EstatusUsuario=" + EstatusUsuario + ", NombreRealUsuario=" + NombreRealUsuario + ", CorreoUsuario=" + CorreoUsuario + ", TelefonoUsuario=" + TelefonoUsuario + ", DireccionUsuario=" + DireccionUsuario + ", TipoUsuario=" + TipoUsuario +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsUsuario getBuscarInformacionUsuarioPorNombre(clsUsuario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.consultaUsuariosPorNombre(usuario);
    }
    public clsUsuario getBuscarInformacionUsuarioPorId(clsUsuario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.consultaUsuariosPorId(usuario);
    }    
    public List<clsUsuario> getListadoUsuarios()
    {
        daoUsuario daousuario = new daoUsuario();
        List<clsUsuario> listadoUsuarios = daousuario.consultaUsuarios();
        return listadoUsuarios;
    }
    public int setBorrarUsuario(clsUsuario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.borrarUsuarios(usuario);
    }          
    public int setIngresarUsuario(clsUsuario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.ingresaUsuarios(usuario);
    }              
    public int setModificarUsuario(clsUsuario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.actualizaUsuarios(usuario);
    }              
}
