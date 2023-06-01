/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega TODO el codigo para la parte del modelo del mantenimiento de Bodegas.
//Victor Josué Jerez Mijangos 9959-21-2081
package Inventarios.Modelo;

import Seguridad.Modelo.*;
import Inventarios.Controlador.clsBodegas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoBodegas {

    private static final String SQL_SELECT = "SELECT bodCodigo, bodNombre, bodDescripcion, bodFechaIngreso, bodFechaSalida, bodEstatus FROM tbl_bodegas";
    private static final String SQL_INSERT = "INSERT INTO tbl_bodegas(bodNombre, bodDescripcion, bodFechaIngreso, bodFechaSalida, bodEstatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_bodegas SET bodNombre=?, bodDescripcion=?, bodFechaIngreso=?, bodFechaSalida=?, bodEstatus=? WHERE bodCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_bodegas WHERE bodCodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT bodCodigo, bodNombre, bodDescripcion, bodFechaIngreso, bodFechaSalida, bodEstatus FROM tbl_bodegas WHERE bodNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT bodCodigo, bodNombre, bodDescripcion, bodFechaIngreso, bodFechaSalida, bodEstatus FROM tbl_bodegas WHERE bodCodigo = ?";    

    public List<clsBodegas> consultaBodegas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsBodegas> bodegas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bodCodigo");
                String nombre = rs.getString("bodNombre");
                String descripcion = rs.getString("bodDescripcion");
                String fIngreso = rs.getString("bodFechaIngreso");
                String fSalida = rs.getString("bodFechaSalida");
                String estatus = rs.getString("bodEstatus");
                
                clsBodegas Bodegas = new clsBodegas();
                Bodegas.setIdBodegas(id);
                Bodegas.setNombreBodegas(nombre);
                Bodegas.setDescripcionBodega(descripcion);
                Bodegas.setfIngresoBodega(fIngreso);
                Bodegas.setfSalidaBodega(fSalida);
                Bodegas.setEstatusBodegas(estatus);
                
                bodegas.add(Bodegas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return bodegas;
    }

    public int ingresaBodegas(clsBodegas bodegas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, bodegas.getNombreBodegas());
            stmt.setString(2, bodegas.getDescripcionBodega());
            stmt.setString(3, bodegas.getfIngresoBodega());
            stmt.setString(4, bodegas.getfSalidaBodega());
            stmt.setString(5, bodegas.getEstatusBodegas());

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

    public int actualizaBodegas(clsBodegas bodegas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, bodegas.getNombreBodegas());
            stmt.setString(2, bodegas.getDescripcionBodega());
            stmt.setString(3, bodegas.getfIngresoBodega());
            stmt.setString(4, bodegas.getfSalidaBodega());
            stmt.setString(5, bodegas.getEstatusBodegas());
            stmt.setInt(6, bodegas.getIdBodegas());

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

    public int borrarBodegas(clsBodegas bodegas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, bodegas.getIdBodegas());
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

    public clsBodegas consultaBodegasPorNombre(clsBodegas bodegas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + bodegas);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, bodegas.getNombreBodegas());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bodCodigo");
                String nombre = rs.getString("bodNombre");
                String descripcion = rs.getString("bodDescripcion");
                String fIngreso = rs.getString("bodFechaIngreso");
                String fSalida = rs.getString("bodFechaSalida");
                String estatus = rs.getString("bodEstatus");

                //aplicacion = new clsAplicacion();
                bodegas.setIdBodegas(id);
                bodegas.setNombreBodegas(nombre);
                bodegas.setDescripcionBodega(descripcion);
                bodegas.setfIngresoBodega(fIngreso);
                bodegas.setfSalidaBodega(fSalida);
                bodegas.setEstatusBodegas(estatus);
                System.out.println(" registro consultado: " + bodegas);                
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
        return bodegas;
    }
    public clsBodegas consultaBodegasPorId(clsBodegas bodegas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + bodegas);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, bodegas.getIdBodegas());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bodCodigo");
                String nombre = rs.getString("bodNombre");
                String descripcion = rs.getString("bodDescripcion");
                String fIngreso = rs.getString("bodFechaIngreso");
                String fSalida = rs.getString("bodFechaSalida");
                String estatus = rs.getString("bodEstatus");

                //aplicacion = new clsAplicacion();
                bodegas.setIdBodegas(id);
                bodegas.setNombreBodegas(nombre);
                bodegas.setDescripcionBodega(descripcion);
                bodegas.setfIngresoBodega(fIngreso);
                bodegas.setfSalidaBodega(fSalida);
                bodegas.setEstatusBodegas(estatus);
                System.out.println(" registro consultado: " + bodegas);                
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
        return bodegas;
    }    
}
