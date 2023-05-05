/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsAplicacion;
import Seguridad.Controlador.clsTipoMovimientoBancos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cdavi
 */
public class daoTipoMovimientoBancos {
    private static final String SQL_SELECT = "SELECT tipmovid, tipmovnombre, tipmovestatus FROM tbl_tipoMovimiento";
    private static final String SQL_INSERT = "INSERT INTO tbl_tipoMovimiento(tipmovnombre, tipmovestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tipoMovimiento SET tipmovnombre, tipmovestatus WHERE tipmovid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_tipoMovimiento WHERE tipmovid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT tipmovid, tipmovnombre, tipmovestatus FROM tbl_tipoMovimiento WHERE tipmovnombre = ?";
    private static final String SQL_SELECT_ID = "SELECT ipmovid, tipmovnombre, tipmovestatus FROM tbl_tipoMovimiento WHERE ipmovid = ?";    

    public List<clsTipoMovimientoBancos> consultaTipoMovimiento() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsTipoMovimientoBancos> movimientos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tipmovid");
                String nombre = rs.getString("tipmovnombre");
                String estatus = rs.getString("tipmovestatus");
                clsTipoMovimientoBancos movimiento = new clsTipoMovimientoBancos();
                movimiento.setTipoMovimiento(id);
                movimiento.setNombreMovimiento(nombre);
                movimiento.setEstatusMovimiento(estatus);
                movimientos.add(movimiento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return movimientos;
    }

    public int ingresaTipoMovimiento(clsTipoMovimientoBancos movimiento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, movimiento.getNombreMovimiento());
            stmt.setString(2, movimiento.getEstatusMovimiento());

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

    public int actualizaTipoMovimiento(clsTipoMovimientoBancos movimiento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, movimiento.getNombreMovimiento());
            stmt.setString(2, movimiento.getEstatusMovimiento());
            stmt.setInt(3, movimiento.getTipoMovimiento());

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

    public int borrarTipoMovimiento(clsTipoMovimientoBancos movimiento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, movimiento.getTipoMovimiento());
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

    public clsModulo consultaModuloPorNombre(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + modulo);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, modulo.getIdModulo());            
            stmt.setString(1, modulo.getNombreModulo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("modid");
                String nombre = rs.getString("modnombre");
                String estatus = rs.getString("modestatus");

                //modulo = new clsModulo();
                modulo.setIdModulo(id);
                modulo.setNombreModulo(nombre);
                modulo.setEstatusModulo(estatus);
                System.out.println(" registro consultado: " + modulo);                
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
        return modulo;
    }
    public clsModulo consultaModuloPorId(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + modulo);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, modulo.getIdModulo());            
            //stmt.setString(1, modulo.getNombreModulo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("modid");
                String nombre = rs.getString("modnombre");
                String estatus = rs.getString("modestatus");

                //modulo = new clsModulo();
                modulo.setIdModulo(id);
                modulo.setNombreModulo(nombre);
                modulo.setEstatusModulo(estatus);
                System.out.println(" registro consultado: " + modulo);                
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
        return modulo;
    }    
}
