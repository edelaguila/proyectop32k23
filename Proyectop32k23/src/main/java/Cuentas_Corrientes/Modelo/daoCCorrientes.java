/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuentas_Corrientes.Modelo;

import Seguridad.Modelo.*;
import Cuentas_Corrientes.Controlador.clsCCorrientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCCorrientes {
// CAMBIOS HECHOS POR : DANIEL ALEXANDER HALL ALVAREZ;9959-21-1395
    private static final String SQL_SELECT = "SELECT ccid,cctipo,ccidtipo,ccfecha,ccnombretipo,NoFactura,ccTotalFactura,ccSaldo,ccDeuda FROM tbl_cCorrientes";
    private static final String SQL_INSERT = "INSERT INTO tbl_cCorrientes(cctipo,ccidtipo,ccfecha,ccnombretipo,NoFactura,ccTotalFactura,ccSaldo,ccDeuda) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cCorrientes SET cctipo=?,ccidtipo=?,ccfecha=?,ccnombretipo=?,NoFactura=?,ccTotalFactura=?,ccSaldo=?,ccDeuda=? WHERE ccid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cCorrientes WHERE ccid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT ccid,cctipo,ccidtipo,ccfecha,ccnombretipo,NoFactura,ccTotalFactura,ccSaldo,ccDeuda FROM tbl_cCorrientes WHERE cctipo=?";
    private static final String SQL_SELECT_ID = "SELECT ccid,cctipo,ccidtipo,ccfecha,ccnombretipo,NoFactura,ccTotalFactura,ccSaldo,ccDeuda FROM tbl_cCorrientes WHERE ccid=?";    

    public List<clsCCorrientes> consultaCC() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsCCorrientes> cuentas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ccid");
                String nombre = rs.getString("cctipo");
                int tipo = rs.getInt("ccidtipo");
                String fecha = rs.getString("ccfecha");
                String nombretipo = rs.getString("ccnombretipo");
                String factura = rs.getString("NoFactura");
                String total = rs.getString("ccTotalFactura");
                String saldo = rs.getString("ccSaldo");
                String deuda = rs.getString("ccDeuda");
                clsCCorrientes cuenta = new clsCCorrientes();
                cuenta.setIdCCorriente(id);
                cuenta.setTipoCCorriente(nombre);
                cuenta.setIdTipoCCorriente(tipo);
                cuenta.setFechaCCorriente(fecha);
                cuenta.setNombreCCorriente(nombretipo);
                cuenta.setNoFacturaCCorriente(factura);
                cuenta.setFacturaCCorriente(total);
                cuenta.setSaldoCCorriente(saldo);
                cuenta.setDeudaCCorriente(deuda);
                cuentas.add(cuenta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cuentas;
    }
    public int ingresaCC(clsCCorrientes cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cuenta.getTipoCCorriente());
            stmt.setInt(2, cuenta.getIdTipoCCorriente());
            stmt.setString(3, cuenta.getFechaCCorriente());
            stmt.setString(4, cuenta.getNombreCCorriente());
            stmt.setString(5, cuenta.getNoFacturaCCorriente());
            stmt.setString(6, cuenta.getFacturaCCorriente());
            stmt.setString(7, cuenta.getSaldoCCorriente());
            stmt.setString(8, cuenta.getDeudaCCorriente());
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

    public int actualizaCC(clsCCorrientes cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cuenta.getTipoCCorriente());
            stmt.setInt(2, cuenta.getIdTipoCCorriente());
            stmt.setString(3, cuenta.getFechaCCorriente());
            stmt.setString(4, cuenta.getNombreCCorriente());
            stmt.setString(5, cuenta.getNoFacturaCCorriente());
            stmt.setString(6, cuenta.getFacturaCCorriente());
            stmt.setString(7, cuenta.getSaldoCCorriente());
            stmt.setString(8, cuenta.getDeudaCCorriente());
            stmt.setInt(9, cuenta.getIdCCorriente());
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

    public int borrarCC(clsCCorrientes cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cuenta.getIdCCorriente());
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

    public clsCCorrientes consultaCCPorNombre(clsCCorrientes cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuenta);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, cuenta.getTipoCCorriente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ccid");
                String nombre = rs.getString("cctipo");
                int tipo = rs.getInt("ccidtipo");
                String fecha = rs.getString("ccfecha");
                String nombretipo = rs.getString("ccnombretipo");
                String factura = rs.getString("NoFactura");
                String total = rs.getString("ccTotalFactura");
                String saldo = rs.getString("ccSaldo");
                String deuda = rs.getString("ccDeuda");
                cuenta.setIdCCorriente(id);
                cuenta.setTipoCCorriente(nombre);
                cuenta.setIdTipoCCorriente(tipo);
                cuenta.setFechaCCorriente(fecha);
                cuenta.setNombreCCorriente(nombretipo);
                cuenta.setNoFacturaCCorriente(factura);
                cuenta.setFacturaCCorriente(total);
                cuenta.setSaldoCCorriente(saldo);
                cuenta.setDeudaCCorriente(deuda);
                System.out.println(" registro consultado: " + cuenta);                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cuenta;
    }
    public clsCCorrientes consultaCCPorId(clsCCorrientes cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuenta);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, cuenta.getIdCCorriente());            
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ccid");
                String nombre = rs.getString("cctipo");
                int tipo = rs.getInt("ccidtipo");
                String fecha = rs.getString("ccfecha");
                String nombretipo = rs.getString("ccnombretipo");
                String factura = rs.getString("NoFactura");
                String total = rs.getString("ccTotalFactura");
                String saldo = rs.getString("ccSaldo");
                String deuda = rs.getString("ccDeuda");
                cuenta.setIdCCorriente(id);
                cuenta.setTipoCCorriente(nombre);
                cuenta.setIdTipoCCorriente(tipo);
                cuenta.setFechaCCorriente(fecha);
                cuenta.setNombreCCorriente(nombretipo);
                cuenta.setNoFacturaCCorriente(factura);
                cuenta.setFacturaCCorriente(total);
                cuenta.setSaldoCCorriente(saldo);
                cuenta.setDeudaCCorriente(deuda);
                System.out.println(" registro consultado: " + cuenta);                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cuenta;
    }    
}
