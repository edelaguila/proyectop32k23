/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuentas_Corrientes.Modelo;

import Seguridad.Modelo.*;
import Cuentas_Corrientes.Controlador.clsCCorrientesProv;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCCorrientesProv {

    private static final String SQL_SELECT = "SELECT cpid,cptipo,cpidprov,cpfecha,cpnombretipo,NpFactura,cpTotalFactura,cpconcelación,ccSaldo FROM tbl_cCorrientesProv";
    private static final String SQL_INSERT = "INSERT INTO tbl_cCorrientesProv(cptipo,cpidprov,cpfecha,cpnombretipo,NpFactura,cpTotalFactura,cpconcelación,ccSaldo) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cCorrientesProv SET cptipo=?,cpidprov=?,cpfecha=?,cpnombretipo=?,NpFactura=?,cpTotalFactura=?,cpconcelación=?,ccSaldo=? WHERE cpid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cCorrientesProv WHERE cpid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT cpid,cptipo,cpidprov,cpfecha,cpnombretipo,NpFactura,cpTotalFactura,cpconcelación,ccSaldo FROM tbl_cCorrientesProv WHERE cptipo=?";
    private static final String SQL_SELECT_ID = "SELECT cpid,cptipo,cpidprov,cpfecha,cpnombretipo,NpFactura,cpTotalFactura,cpconcelación,cpSaldo FROM tbl_cCorrientesProv WHERE cpid=?";    

    public List<clsCCorrientesProv> consultaCCProv() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsCCorrientesProv> cuentas = new ArrayList<>();
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
                clsCCorrientesProv cuenta = new clsCCorrientesProv();
                cuenta.setIdCCorrienteProv(id);
                cuenta.setTipoCCorrienteProv(nombre);
                cuenta.setIdTipoCCorrienteProv(tipo);
                cuenta.setFechaCCorrienteProv(fecha);
                cuenta.setNombreCCorrienteProv(nombretipo);
                cuenta.setNofacturaCCorrienteProv(factura);
                cuenta.setFacturaCCorrienteProv(total);
                cuenta.setCancelacionProv(saldo);
                cuenta.setSaldoCCorrienteProv(deuda);
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
    public int ingresaCCProv(clsCCorrientesProv cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cuenta.getTipoCCorrienteProv());
            stmt.setInt(2, cuenta.getIdTipoCCorrienteProv());
            stmt.setString(3, cuenta.getFechaCCorrienteProv());
            stmt.setString(4, cuenta.getNombreCCorrienteProv());
            stmt.setString(5, cuenta.getNofacturaCCorrienteProv());
            stmt.setString(6, cuenta.getFacturaCCorrienteProv());
            stmt.setString(7, cuenta.getCancelacionProv());
            stmt.setString(8, cuenta.getSaldoCCorrienteProv());
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
    public int actualizaCCProv(clsCCorrientesProv cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cuenta.getTipoCCorrienteProv());
            stmt.setInt(2, cuenta.getIdTipoCCorrienteProv());
            stmt.setString(3, cuenta.getFechaCCorrienteProv());
            stmt.setString(4, cuenta.getNombreCCorrienteProv());
            stmt.setString(5, cuenta.getNofacturaCCorrienteProv());
            stmt.setString(6, cuenta.getFacturaCCorrienteProv());
            stmt.setString(7, cuenta.getCancelacionProv());
            stmt.setString(8, cuenta.getSaldoCCorrienteProv());
            stmt.setInt(9, cuenta.getIdCCorrienteProv());
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
    public int borrarCCProv(clsCCorrientesProv cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cuenta.getIdCCorrienteProv());
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
    public clsCCorrientesProv consultaCCProvPorNombre(clsCCorrientesProv cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuenta);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, cuenta.getTipoCCorrienteProv());
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
                cuenta.setIdCCorrienteProv(id);
                cuenta.setTipoCCorrienteProv(nombre);
                cuenta.setIdTipoCCorrienteProv(tipo);
                cuenta.setFechaCCorrienteProv(fecha);
                cuenta.setNombreCCorrienteProv(nombretipo);
                cuenta.setNofacturaCCorrienteProv(factura);
                cuenta.setFacturaCCorrienteProv(total);
                cuenta.setCancelacionProv(saldo);
                cuenta.setSaldoCCorrienteProv(deuda);
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
    public clsCCorrientesProv consultaCCProvPorId(clsCCorrientesProv cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuenta);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, cuenta.getIdCCorrienteProv());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
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
                cuenta.setIdCCorrienteProv(id);
                cuenta.setTipoCCorrienteProv(nombre);
                cuenta.setIdTipoCCorrienteProv(tipo);
                cuenta.setFechaCCorrienteProv(fecha);
                cuenta.setNombreCCorrienteProv(nombretipo);
                cuenta.setNofacturaCCorrienteProv(factura);
                cuenta.setFacturaCCorrienteProv(total);
                cuenta.setCancelacionProv(saldo);
                cuenta.setSaldoCCorrienteProv(deuda);
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