/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoUsuario {

    private static final String SQL_SELECT = "SELECT usuid, usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion, tipuid FROM tbl_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion, tipuid) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET usunombre=?, usucontrasena=?,  usuultimasesion=?, usuestatus=?, usunombrereal=?, usucorreoe=?, usutelefono=?, usudireccion=?, tipuid=?  WHERE usuid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE usuid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT usuid, usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion, tipuid FROM tbl_usuario WHERE usunombre = ?";
    private static final String SQL_SELECT_ID = "SELECT usuid, usunombre, usucontrasena, usuultimasesion, usuestatus, usunombrereal, usucorreoe, usutelefono, usudireccion, tipuid FROM tbl_usuario WHERE usuid = ?";     

    public List<clsUsuario> consultaUsuarios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsUsuario> usuarios = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                String sesion = rs.getString("usuultimasesion");
		String estatus = rs.getString("usuestatus");
                String nombrereal= rs.getString("usunombrereal");
                String correo= rs.getString("usucorreoe");
                String telefono= rs.getString("usutelefono");
		String direccion= rs.getString("usudireccion");
		int tipoid= rs.getInt("tipuid");
                clsUsuario usuario = new clsUsuario();
                usuario.setIdUsuario(id);
                usuario.setNombreUsuario(nombre);
                usuario.setContrasenaUsuario(contrasena);
                usuario.setUltimaSesionUsuario(sesion);
                usuario.setEstatusUsuario(estatus);
                usuario.setNombreRealUsuario(nombrereal);
                usuario.setCorreoUsuario(correo); 
                usuario.setTelefonoUsuario(telefono);
                usuario.setDireccionUsuario(direccion);
                usuario.setTipoUsuario(tipoid);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }

    public int ingresaUsuarios(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContrasenaUsuario());
            stmt.setString(3, usuario.getUltimaSesionUsuario());
	    stmt.setString(4, usuario.getEstatusUsuario());
            stmt.setString(5, usuario.getNombreRealUsuario());
            stmt.setString(6, usuario.getCorreoUsuario());
            stmt.setString(7, usuario.getTelefonoUsuario());
            stmt.setString(8, usuario.getDireccionUsuario());
            stmt.setInt(9, usuario.getTipoUsuario());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaUsuarios(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContrasenaUsuario());
            stmt.setString(3, usuario.getUltimaSesionUsuario());
	    stmt.setString(4, usuario.getEstatusUsuario());
            stmt.setString(5, usuario.getNombreRealUsuario());
            stmt.setString(6, usuario.getCorreoUsuario());
            stmt.setString(7, usuario.getTelefonoUsuario());
            stmt.setString(8, usuario.getDireccionUsuario());
            stmt.setInt(9, usuario.getTipoUsuario());
            stmt.setInt(10, usuario.getIdUsuario());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarUsuarios(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsUsuario consultaUsuariosPorNombre(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + usuario);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                String sesion = rs.getString("usuultimasesion");
		String estatus = rs.getString("usuestatus");
                String nombrereal= rs.getString("usunombrereal");
		String correo= rs.getString("usucorreoe");
		String telefono= rs.getString("usutelefono");
		String direccion= rs.getString("usudireccion");
		int tipoid= rs.getInt("tipuid");
                //usuario = new clsUsuario();
                usuario.setIdUsuario(id);
                usuario.setNombreUsuario(nombre);
                usuario.setContrasenaUsuario(contrasena);
                usuario.setUltimaSesionUsuario(sesion);
                usuario.setEstatusUsuario(estatus);
                usuario.setNombreRealUsuario(nombrereal);
                usuario.setCorreoUsuario(correo); 
                usuario.setTelefonoUsuario(telefono);
		usuario.setDireccionUsuario(direccion);
                usuario.setTipoUsuario(tipoid);
                System.out.println(" registro consultado: " + usuario);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
    public clsUsuario consultaUsuariosPorId(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + usuario);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, usuario.getIdUsuario());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                String sesion = rs.getString("usuultimasesion");
		String estatus = rs.getString("usuestatus");
                String nombrereal= rs.getString("usunombrereal");
		String correo= rs.getString("usucorreoe");
		String telefono= rs.getString("usutelefono");
		String direccion= rs.getString("usudireccion");
		int tipoid= rs.getInt("tipuid");
                //usuario = new clsUsuario();
                usuario.setIdUsuario(id);
                usuario.setNombreUsuario(nombre);
                usuario.setContrasenaUsuario(contrasena);
                usuario.setUltimaSesionUsuario(sesion);
                usuario.setEstatusUsuario(estatus);
                usuario.setEstatusUsuario(estatus);
                usuario.setNombreRealUsuario(nombrereal);
                usuario.setCorreoUsuario(correo); 
                usuario.setTelefonoUsuario(telefono);
		usuario.setDireccionUsuario(direccion);
                usuario.setTipoUsuario(tipoid);
                System.out.println(" registro consultado: " + usuario);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }    
}
