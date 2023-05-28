/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Modelo;

import Bancos.Controlador.clsMovimientoDetallesBancos;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
//TODO dao Movmiento Detalles Bancos.
/**
 *
 * @author visitante
 */
public class daoMovimientoDetallesBancos {
    
private static final String SQL_SELECT = "SELECT movDetId, movId, movCosto, concId, movSaldo, tipModId FROM tbl_movimientosDetalleBancos";
private static final String SQL_INSERT = "INSERT INTO tbl_movimientosDetalleBancos (movDetId, movId, movCosto, concId, movSaldo, tipModId) VALUES (?, ?, ?, ?, ?, ?)"; 
private static final String SQL_UPDATE = "UPDATE tbl_movimientosDetalleBancos SET movCosto=?, movSaldo=?, concId=?, tipModId=?  WHERE movDetId = ?";
private static final String SQL_DELETE = "DELETE FROM tbl_movimientosDetalleBancos WHERE movDetId=?";
private static final String SQL_SELECT_NOMBRE = "SELECT movDetId, movId, movCosto, concId, movSaldo, tipModId  FROM tbl_movimientosDetalleBancos WHERE movId = ?";
private static final String SQL_SELECT_ID = "SELECT movDetId, movId, movCosto, concId, movSaldo, tipModId  FROM tbl_movimientosDetalleBancos WHERE movDetId = ?";  


    public List<clsMovimientoDetallesBancos> consultaBancoMovimiento() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<clsMovimientoDetallesBancos> bancos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int movDetId = rs.getInt("movDetId");
                int movId = rs.getInt("movId");
                float movCosto = rs.getFloat("movCosto");
                int concId = rs.getInt("concId");
                float movSaldo = rs.getFloat("movSaldo");
                int tipModId = rs.getInt("tipModId");

                clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
                banco.setIdMovimientoDetalles(movDetId);
                banco.setIdMovimiento(movId);
                banco.setMovimientoCosto(movCosto);
                banco.setIdConcepto(concId);
                banco.setMovimientoSaldo(movSaldo);
                banco.setIdTipoMovimiento(tipModId);
                bancos.add(banco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return bancos;
    }

    public int ingresaBanco(clsMovimientoDetallesBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, banco.getIdMovimientoDetalles());
             stmt.setInt(2, banco.getIdMovimiento());
            stmt.setFloat(3, banco.getMovimientoCosto());
             stmt.setInt(4, banco.getIdConcepto());
           stmt.setFloat(5, banco.getMovimientoSaldo());
            stmt.setInt(6, banco.getIdTipoMovimiento());
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

    public int actualizaBanco(clsMovimientoDetallesBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setFloat(1, banco.getMovimientoCosto());
            stmt.setFloat(2, banco.getMovimientoSaldo());
            stmt.setInt(3,banco.getIdConcepto()) ;
            stmt.setInt(4, banco.getIdTipoMovimiento());
            stmt.setInt(5, banco.getIdMovimientoDetalles());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarBanco(clsMovimientoDetallesBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, banco.getIdMovimientoDetalles());
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

    public clsMovimientoDetallesBancos consultaBancoPorMovimientoDetalles(clsMovimientoDetallesBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + banco);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            stmt.setInt(1, banco.getIdTipoMovimiento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int movDetId = rs.getInt("movDetId");
                int movId = rs.getInt("movId");
                float movCosto = rs.getFloat("movCosto");
                int concId = rs.getInt("concId");
                float movSaldo = rs.getFloat("movSaldo");
                int tipModId = rs.getInt("tipModId");

                banco.setIdMovimientoDetalles(movDetId);
                banco.setIdMovimiento(movId);
                banco.setMovimientoCosto(movCosto);
                banco.setIdConcepto(concId);
                banco.setMovimientoSaldo(movSaldo);
                banco.setIdTipoMovimiento(tipModId);

                System.out.println("Registro consultado: " + banco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return banco;
    }

    public clsMovimientoDetallesBancos consultaBancoPorTipoMovimiento(clsMovimientoDetallesBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_ID + " objeto recibido: " + banco);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, banco.getIdMovimientoDetalles());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int movDetId = rs.getInt("movDetId");
                int movId = rs.getInt("movId");
                float movCosto = rs.getFloat("movCosto");
                int concId = rs.getInt("concId");
                float movSaldo = rs.getFloat("movSaldo");
                int tipModId = rs.getInt("tipModId");

                banco.setIdMovimientoDetalles(movDetId);
                banco.setIdMovimiento(movId);
                banco.setMovimientoCosto(movCosto);
                banco.setIdConcepto(concId);
                banco.setMovimientoSaldo(movSaldo);
                banco.setIdTipoMovimiento(tipModId);

                System.out.println("Registro consultado: " + banco);
            } 
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return banco;
    }
}