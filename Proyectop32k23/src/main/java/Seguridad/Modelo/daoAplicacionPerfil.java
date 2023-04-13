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
    private static final String SQL_SELECT = "SELECT perId, perEditar, perIngresar, perEliminar, perVer FROM tbl_aplicacionperfil";
    private static final String SQL_INSERT = "INSERT INTO tbl_aplicacionperfil(perEditar,perIngresar,perEliminar,perVer) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_aplicacionperfil SET perEditar=?, perIngresar=?, perEliminar=?, perVer=? WHERE perId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_aplicacionperfil WHERE perId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT perId, perEditar, perEditar, perVer FROM tbl_aplicacionperfil WHERE perVer = ?";
    private static final String SQL_SELECT_ID = "SELECT perId, perEditar, perIngresar, perEliminar, perVer FROM tbl_aplicacionperfil WHERE perId = ?";
    
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
                String editar = rs.getString("aplnombre");
                String ingresar = rs.getString("aplestatus");
                String eliminar = rs.getString("aplestatus");
                String ver = rs.getString("aplestatus");
                clsAplicacionPerfil aplicacionperfil = new clsAplicacionPerfil();
                aplicacionperfil.setPerId(id);
                aplicacionperfil.setPerEditar(editar);
                aplicacionperfil.setPerIngresar(ingresar);
                aplicacionperfil.setPerEliminar(eliminar);
                aplicacionperfil.setPerVer(ver);
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

    public int ingresaPerfilAplicacion(clsAplicacionPerfil perfilaplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfilaplicacion.getPerEditar());
            stmt.setString(2, perfilaplicacion.getPerIngresar());
            stmt.setString(1, perfilaplicacion.getPerEliminar());
            stmt.setString(2, perfilaplicacion.getPerVer());

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
    
    public int actualizaPerfilAplicacion(clsAplicacionPerfil perfilaplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, perfilaplicacion.getPerEditar());
            stmt.setString(2, perfilaplicacion.getPerIngresar());
            stmt.setString(3, perfilaplicacion.getPerEliminar());
            stmt.setString(3, perfilaplicacion.getPerVer());

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
    
    public int borrarPerfilAplicacion(clsAplicacionPerfil perfilaplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfilaplicacion.getPerId());
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
    public clsAplicacionPerfil consultaAplicacionPerfilPorVer(clsAplicacionPerfil perfilaplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + perfilaplicacion);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, perfilaplicacion.getPerVer());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aplid");
                String editar = rs.getString("perEditar");
                String ingresar = rs.getString("perIngresar");
                String eliminar = rs.getString("perEliminar");
                String ver = rs.getString("perVer");

                //aplicacion = new clsAplicacion();
                perfilaplicacion.setPerId(id);
                perfilaplicacion.setPerEditar(editar);
                perfilaplicacion.setPerIngresar(ingresar);
                perfilaplicacion.setPerEliminar(eliminar);
                perfilaplicacion.setPerVer(ver);
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
        return aplicacion;
    }
}
