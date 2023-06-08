/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bancos.Modelo;


import Bancos.Controlador.clsBancoExterno;
import Bancos.Controlador.clsTipoMovimientoBancos;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cdavi
 */
//Hecho por: Alyson Vannesa Rodríguez Quezada 9959-21-829
public class daoTipoMovimientoBancos {
    private static final String SQL_SELECT = "SELECT tipMovId , tipMovNombre, tipMovEstatus FROM tbl_tipomovimientoBancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_tipomovimientoBancos(tipMovId, tipMovNombre, tipMovEstatus) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tipomovimientoBancos SET tipMovNombre=?, tipMovEstatus=? WHERE tipMovId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_tipomovimientoBancos WHERE tipMovId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT tipMovId, tipMovNombre, tipMovEstatus FROM tbl_tipomovimientoBancos WHERE tipMovNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT tipMovId, tipMovNombre, tipMovEstatus FROM tbl_tipomovimientoBancos WHERE tipMovId = ?";    

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
                int tipo = rs.getInt("tipMovId");
                String nombre = rs.getString("tipMovNombre");
                String estatus = rs.getString("tipMovEstatus");
                clsTipoMovimientoBancos movimiento = new clsTipoMovimientoBancos();
                movimiento.setTipoMovimientoId(tipo);
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
            stmt.setInt(1, movimiento.getTipoMovimientoId());
            stmt.setString(2, movimiento.getNombreMovimiento());
            stmt.setString(3, movimiento.getEstatusMovimiento());

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
            stmt.setInt(3, movimiento.getTipoMovimientoId());

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
            stmt.setInt(1, movimiento.getTipoMovimientoId());
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

    public clsTipoMovimientoBancos consultaTipoMovimientoPorNombre(clsTipoMovimientoBancos movimiento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + movimiento);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, modulo.getIdModulo());            
            stmt.setString(1, movimiento.getNombreMovimiento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tipMovId");
                String nombre = rs.getString("tipMovNombre");
                String estatus = rs.getString("tipMovEstatus");

                //movimiento = new clsModulo();
                movimiento.setTipoMovimientoId(id);
                movimiento.setNombreMovimiento(nombre);
                movimiento.setEstatusMovimiento(estatus);
                System.out.println(" registro consultado: " + movimiento);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return movimiento;  // Si se utiliza un ArrayList
        return movimiento;
    }
    public clsTipoMovimientoBancos consultaTipoMovimientoPorId(clsTipoMovimientoBancos movimiento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + movimiento);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, movimiento.getTipoMovimientoId());            
            //stmt.setString(1, modulo.getNombreModulo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tipMovId");
                String nombre = rs.getString("tipMovNombre");
                String estatus = rs.getString("tipMovEstatus");

                //modulo = new clsModulo();
                movimiento.setTipoMovimientoId(id);
                movimiento.setNombreMovimiento(nombre);
                movimiento.setEstatusMovimiento(estatus);
                System.out.println(" registro consultado: " + movimiento);                
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
        return movimiento;
    }    
}
