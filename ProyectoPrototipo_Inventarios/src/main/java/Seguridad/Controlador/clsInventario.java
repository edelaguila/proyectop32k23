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
public class clsInventario {
    private int inv_nombre;
    private String inv_status;
    private String inv_departamento;
    private String inv_cantidades;

    public int getInv_nombre() {
        return inv_nombre;
    }

    public void setInv_nombre(int inv_nombre) {
        this.inv_nombre = inv_nombre;
    }

    public String getInv_status() {
        return inv_status;
    }

    public void setInv_status(String inv_status) {
        this.inv_status = inv_status;
    }

    public String getInv_departamento() {
        return inv_departamento;
    }

    public void setInv_departamento(String inv_departamento) {
        this.inv_departamento = inv_departamento;
    }

    public String getInv_cantidades() {
        return inv_cantidades;
    }

    public void setInv_cantidades(String inv_cantidades) {
        this.inv_cantidades = inv_cantidades;
    }

    public clsInventario(int inv_nombre, String inv_status, String inv_departamento, String inv_cantidades) {
        this.inv_nombre = inv_nombre;
        this.inv_status = inv_status;
        this.inv_departamento = inv_departamento;
        this.inv_cantidades = inv_cantidades;
    }

    public clsInventario(int inv_nombre, String inv_status, String inv_departamento) {
        this.inv_nombre = inv_nombre;
        this.inv_status = inv_status;
        this.inv_departamento = inv_departamento;
    }

    public clsInventario(int inv_nombre, String inv_status) {
        this.inv_nombre = inv_nombre;
        this.inv_status = inv_status;
    }

    public clsInventario(int inv_nombre) {
        this.inv_nombre = inv_nombre;
    }

    public clsInventario() {
    }
  

   
    
    @Override
    public String toString() {
        return "clsInventario{" + "inv_nombre=" + inv_nombre + ", inv_status=" + inv_status + ", inv_departamento=" + inv_departamento + ", inv_cantidades=" + inv_cantidades +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsInventario getBuscarInformacionUsuarioPorNombre(clsInventario Inventario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.consultaUsuariosPorNombre(Inventario);
    }
    public clsInventario getBuscarInformacionUsuarioPorId(clsInventario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.consultaUsuariosPorId(usuario);
    }    
    public List<clsInventario> getListadoUsuarios()
    {
        daoUsuario daousuario = new daoUsuario();
        List<clsInventario> listadoUsuarios = daousuario.consultaUsuarios();
        return listadoUsuarios;
    }
    public int setBorrarUsuario(clsInventario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.borrarUsuarios(usuario);
    }          
    public int setIngresarUsuario(clsInventario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.ingresaUsuarios(usuario);
    }              
    public int setModificarUsuario(clsInventario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.actualizaUsuarios(usuario);
    }              
}
