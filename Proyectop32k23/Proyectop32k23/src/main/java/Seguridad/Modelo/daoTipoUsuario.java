/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsTipoUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTipoUsuario {

    private static final String SQL_SELECT = "SELECT tipuid, tipunombre, tipuestatus FROM tbl_tipousuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_tipousuario(tipunombre, tipuestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tipousuario SET tipunombre=?, tipuestatus=? WHERE tipuid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_tipousuario WHERE tipuid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT tipuid, tipunombre, tipuestatus FROM tbl_tipousuario WHERE tipunombre = ?";
    private static final String SQL_SELECT_ID = "SELECT tipuid, tipunombre, tipuestatus FROM tbl_tipousuario WHERE tipuid = ?";    

    public List<clsTipoUsuario> consultaTipo() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsTipoUsuario> tiposusuario = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tipuid");
                String nombre = rs.getString("tipunombre");
                String estatus = rs.getString("tipuestatus");
                clsTipoUsuario tipousuario = new clsTipoUsuario();
                tipousuario.setIdTipoUsuario(id);
                tipousuario.setNombreTipoUsuario(nombre);
                tipousuario.setEstatusTipoUsuario(estatus);
                tiposusuario.add(tipousuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tiposusuario;
    }

    public int ingresaTipo(clsTipoUsuario tipousuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tipousuario.getNombreTipoUsuario());
            stmt.setString(2, tipousuario.getEstatusTipoUsuario());

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

    public int actualizaTipo(clsTipoUsuario tipousuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tipousuario.getNombreTipoUsuario());
            stmt.setString(2, tipousuario.getEstatusTipoUsuario());
            stmt.setInt(3, tipousuario.getIdTipoUsuario());

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

    public int borrarTipo(clsTipoUsuario tipousuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tipousuario.getIdTipoUsuario());
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

    public clsTipoUsuario consultaTipoPorNombre(clsTipoUsuario tipousuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + tipousuario);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, tipousuario.getNombreTipoUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tipuid");
                String nombre = rs.getString("tipunombre");
                String estatus = rs.getString("tipuestatus");

                //aplicacion = new clsAplicacion();
                tipousuario.setIdTipoUsuario(id);
                tipousuario.setNombreTipoUsuario(nombre);
                tipousuario.setEstatusTipoUsuario(estatus);
                System.out.println(" registro consultado: " + tipousuario);                
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
        return tipousuario;
    }
    public clsTipoUsuario consultaTipoPorId(clsTipoUsuario tipousuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + tipousuario);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, tipousuario.getIdTipoUsuario());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tipuid");
                String nombre = rs.getString("tipunombre");
                String estatus = rs.getString("tipuestatus");

                //aplicacion = new clsAplicacion();
                tipousuario.setIdTipoUsuario(id);
                tipousuario.setNombreTipoUsuario(nombre);
                tipousuario.setEstatusTipoUsuario(estatus);
                System.out.println(" registro consultado: " + tipousuario);                
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
        return tipousuario;
    }    
}
