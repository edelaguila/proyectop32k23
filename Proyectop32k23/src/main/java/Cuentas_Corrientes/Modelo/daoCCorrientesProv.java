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

    //CAMBIOS HECHOS POR: MONICA GABRIELA PEREZ VELASQUEZ; 9959-21-1840
    private static final String SQL_SELECT = "SELECT cpid,cptipo,cpidprov,cpfecha,cpnombretipo,NpFactura,cpTotalFactura,cpconcelación,cpSaldo FROM tbl_cCorrientesProv";
    private static final String SQL_INSERT = "INSERT INTO tbl_cCorrientesProv(cptipo,cpidprov,cpfecha,cpnombretipo,NpFactura,cpTotalFactura,cpconcelación,cpSaldo) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cCorrientesProv SET cptipo=?,cpidprov=?,cpfecha=?,cpnombretipo=?,NpFactura=?,cpTotalFactura=?,cpconcelación=?,cpSaldo=? WHERE cpid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cCorrientesProv WHERE cpid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT cpid,cptipo,cpidprov,cpfecha,cpnombretipo,NpFactura,cpTotalFactura,cpconcelación,cpSaldo FROM tbl_cCorrientesProv WHERE cpid=?";
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
                int id = rs.getInt("cpid");
                String nombre = rs.getString("cptipo");
                int tipo = rs.getInt("cpidprov");
                String fecha = rs.getString("cpfecha");
                String nombretipo = rs.getString("cpnombretipo");
                String factura = rs.getString("NpFactura");
                String total = rs.getString("cpTotalFactura");
                String saldo = rs.getString("cpconcelación");
                String deuda = rs.getString("cpSaldo");
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
            stmt = conn.prepareStatement(SQL_SELECT_ID);            
            stmt.setInt(1, cuenta.getIdCCorrienteProv());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cpid");
                String nombre = rs.getString("cptipo");
                int tipo = rs.getInt("cpidprov");
                String fecha = rs.getString("cpfecha");
                String nombretipo = rs.getString("cpnombretipo");
                String factura = rs.getString("NpFactura");
                String total = rs.getString("cpTotalFactura");
                String saldo = rs.getString("cpconcelación");
                String deuda = rs.getString("cpSaldo");
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
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cpid");
                String nombre = rs.getString("cptipo");
                int tipo = rs.getInt("cpidprov");
                String fecha = rs.getString("cpfecha");
                String nombretipo = rs.getString("cpnombretipo");
                String factura = rs.getString("NpFactura");
                String total = rs.getString("cpTotalFactura");
                String saldo = rs.getString("cpconcelación");
                String deuda = rs.getString("cpSaldo");
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