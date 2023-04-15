/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoTipoUsuario;
/**
 *
 * @author visitante
 */
public class clsTipoUsuario {
    private int IdTipoUsuario;
    private String NombreTipoUsuario;
    private String EstatusTipoUsuario;

    public int getIdTipoUsuario() {
        return IdTipoUsuario;
    }

    public void setIdTipoUsuario(int IdTipoUsuario) {
        this.IdTipoUsuario = IdTipoUsuario;
    }

    public String getNombreTipoUsuario() {
        return NombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String NombreTipoUsuario) {
        this.NombreTipoUsuario = NombreTipoUsuario;
    }

    public String getEstatusTipoUsuario() {
        return EstatusTipoUsuario;
    }

    public void setEstatusTipoUsuario(String EstatusTipoUsuario) {
        this.EstatusTipoUsuario = EstatusTipoUsuario;
    }

    public clsTipoUsuario(int IdTipoUsuario, String NombreTipoUsuario, String EstatusTipoUsuario) {
        this.IdTipoUsuario = IdTipoUsuario;
        this.NombreTipoUsuario = NombreTipoUsuario;
        this.EstatusTipoUsuario = EstatusTipoUsuario;
    }

    public clsTipoUsuario(int IdTipoUsuario, String NombreTipoUsuario) {
        this.IdTipoUsuario = IdTipoUsuario;
        this.NombreTipoUsuario = NombreTipoUsuario;
    }

    public clsTipoUsuario(int IdTipoUsuario) {
        this.IdTipoUsuario = IdTipoUsuario;
    }

    public clsTipoUsuario() {
    }
    
    //Metodos de acceso a la capa controlador
    public clsTipoUsuario getBuscarInformacionTipoUsuarioPorNombre(clsTipoUsuario tipoUsuario)
    {
        daoTipoUsuario daotipoUsuario = new daoTipoUsuario();
        return daotipoUsuario.consultaTipoPorNombre(tipoUsuario);
    }
    public clsTipoUsuario getBuscarInformacionTipoUsuarioPorId(clsTipoUsuario tipoUsuario)
    {
        daoTipoUsuario daotipoUsuario = new daoTipoUsuario();
        return daotipoUsuario.consultaTipoPorId(tipoUsuario);
    }
    public List<clsTipoUsuario> getListadoTipoUsuarios()
    {
        daoTipoUsuario daotipoUsuario = new daoTipoUsuario();
        List<clsTipoUsuario> listadoTipoUsuarios = daotipoUsuario.consultaTipo();
        return listadoTipoUsuarios;
    }
    public int setBorrarTipoUsuario(clsTipoUsuario tipoUsuario)
    {
        daoTipoUsuario daotipoUsuario = new daoTipoUsuario();
        return daotipoUsuario.borrarTipo(tipoUsuario);
    }
    public int setIngresarTipoUsuario(clsTipoUsuario tipoUsuario)
    {
        daoTipoUsuario daotipoUsuario = new daoTipoUsuario();
        return daotipoUsuario.ingresaTipo(tipoUsuario);
    }              
    public int setModificarTipoUsuario(clsTipoUsuario tipoUsuario)
    {
        daoTipoUsuario daotipoUsuario = new daoTipoUsuario();
        return daotipoUsuario.actualizaTipo(tipoUsuario);
    }
}
