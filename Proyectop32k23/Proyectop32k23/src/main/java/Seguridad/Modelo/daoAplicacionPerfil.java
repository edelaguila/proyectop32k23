/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsAplicacionPerfil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Objeto de acceso de datos hecho por Luis Diego Cortez Mérida
 * @author Usuario
 */
public class daoAplicacionPerfil {
    private static final String SQL_SELECT = "SELECT aplid, perid, perEditar, perIngresar, perEliminar, perVer FROM tbl_aplicacionperfil";
    private static final String SQL_INSERT = "INSERT INTO tbl_aplicacionperfil(aplid, perid, perEditar,perIngresar,perEliminar,perVer) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_aplicacionperfil SET perid=?, perEditar=?, perIngresar=?, perEliminar=?, perVer=? WHERE aplid=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_aplicacionperfil WHERE aplid=? AND usuid=?";
    
    private static final String SQL_SELECT_ID = "SELECT aplid, perid, perEditar, perIngresar, perEliminar, perVer FROM tbl_aplicacionperfil WHERE perid = ?";        
    private static final String SQL_DETELE_ALL = "DELETE FROM tbl_aplicacionperfil WHERE  perid=?";
    
    public List<clsAplicacionPerfil> consultaPerfilAplicacion() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsAplicacionPerfil> aplicaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aplid");
                int idPerfil = rs.getInt("perid");
                String editar = rs.getString("perEditar");
                String ingresar = rs.getString("perIngresar");
                String eliminar = rs.getString("perEliminar");
                String ver = rs.getString("perVer");
                clsAplicacionPerfil aplicacionperfil = new clsAplicacionPerfil();
                aplicacionperfil.setIdAplicacion(id);
                aplicacionperfil.setIdPerfil(idPerfil);
                aplicacionperfil.setEditarApPerfil(editar);
                aplicacionperfil.setIngresarApPerfil(ingresar);
                aplicacionperfil.setEliminarApPerfil(eliminar);
                aplicacionperfil.setVerApPerfil(ver);
                aplicaciones.add(aplicacionperfil);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return aplicaciones;
    }

    public int ingresaPerfilAplicacion(clsAplicacionPerfil aplicacionPerfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, aplicacionPerfil.getIdAplicacion());
            stmt.setInt(2, aplicacionPerfil.getIdPerfil());
            stmt.setString(3, aplicacionPerfil.getEditarApPerfil());
            stmt.setString(4, aplicacionPerfil.getIngresarApPerfil());
            stmt.setString(5, aplicacionPerfil.getEliminarApPerfil());
            stmt.setString(6, aplicacionPerfil.getVerApPerfil());

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
    
    public int actualizaPerfilAplicacion(clsAplicacionPerfil aplicacionPerfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, aplicacionPerfil.getIdAplicacion());
            stmt.setInt(2, aplicacionPerfil.getIdPerfil());
            stmt.setString(3, aplicacionPerfil.getEditarApPerfil());
            stmt.setString(4, aplicacionPerfil.getIngresarApPerfil());
            stmt.setString(5, aplicacionPerfil.getEliminarApPerfil());
            stmt.setString(6, aplicacionPerfil.getVerApPerfil());
            
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
    
    public int borrarPerfilAplicacion(clsAplicacionPerfil aplicacionPerfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacionPerfil.getIdAplicacion());
            stmt.setInt(2, aplicacionPerfil.getIdPerfil());
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
    
    /*public clsAplicacionPerfil consultaPerfilAplicacionPorNombre(clsAplicacionPerfil perfilaplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + perfilaplicacion);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, perfilaplicacion.getIdPerfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aplid");
                int  idperfil = rs.getInt("perid");
                String editar = rs.getString("perEditar");
                String ingresar = rs.getString("perIngresar");
                String eliminar = rs.getString("perEliminar");
                String ver = rs.getString("perVer");

                //aplicacion = new clsAplicacion();
                perfilaplicacion.setIdAplicacionPerfil(id);
                perfilaplicacion.setNombreAplicacionPerfil(idperfil);
                perfilaplicacion.setEditarApPerfil(editar);
                perfilaplicacion.setIngresarApPerfil(ingresar);
                perfilaplicacion.setEliminarApPerfil(eliminar);
                perfilaplicacion.setVerApPerfil(ver);
                System.out.println(" registro consultado: " + perfilaplicacion);                
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
        return perfilaplicacion;
    }*/
    
    public clsAplicacionPerfil consultaPerfilAplicacionPorId(clsAplicacionPerfil aplicacionPerfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_ID + " objeto recibido: " + aplicacionPerfil);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, aplicacionPerfil.getIdPerfil());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aplid");
                int  idperfil = rs.getInt("perid");
                String editar = rs.getString("perEditar");
                String ingresar = rs.getString("perIngresar");
                String eliminar = rs.getString("perEliminar");
                String ver = rs.getString("perVer");

                //aplicacion = new clsAplicacion();
                aplicacionPerfil.setIdAplicacion(id);
                aplicacionPerfil.setIdPerfil(idperfil);
                aplicacionPerfil.setEditarApPerfil(editar);
                aplicacionPerfil.setIngresarApPerfil(ingresar);
                aplicacionPerfil.setEliminarApPerfil(eliminar);
                aplicacionPerfil.setVerApPerfil(ver);
                System.out.println(" registro consultado: " + aplicacionPerfil);                
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
        return aplicacionPerfil;
    }    
    
    public int borrarTodoAplicacion(clsAplicacionPerfil aplicacionPerfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DETELE_ALL);
            stmt = conn.prepareStatement(SQL_DETELE_ALL);
            stmt.setInt(1,aplicacionPerfil.getIdPerfil());
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

    
}
