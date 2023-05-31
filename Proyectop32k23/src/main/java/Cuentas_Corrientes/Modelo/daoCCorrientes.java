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
// REALIZADO POR : DANIEL ALEXANDER HALL ALVAREZ;9959-21-1395 Y MONICA GABRIELA PEREZ VELÁSQUEZ; 9959-21-1840.
    
    private static final String SQL_SELECT = "SELECT ccid,clid,ccnombre,ccfecha,NoFactura,cchaber,ccdebe,ccsaldo FROM tbl_cCorrientes";
    private static final String SQL_INSERT = "INSERT INTO tbl_cCorrientes(clid,ccnombre,ccfecha,NoFactura,cchaber,ccdebe,ccsaldo) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cCorrientes SET clid=?,ccnombre=?,ccfecha=?,NoFactura=?,cchaber=?,ccdebe=?,ccsaldo=? WHERE ccid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cCorrientes WHERE ccid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT ccid,clid,ccnombre,ccfecha,NoFactura,cchaber,ccdebe,ccsaldo FROM tbl_cCorrientes WHERE clid=?";
    private static final String SQL_SELECT_ID = "SELECT ccid,clid,ccnombre,ccfecha,NoFactura,cchaber,ccdebe,ccsaldo FROM tbl_cCorrientes WHERE ccid=?";    

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
                int idcli = rs.getInt("clid");
                String nombre = rs.getString("ccnombre");
                String fecha = rs.getString("ccfecha");
                String factura = rs.getString("NoFactura");
                int haber = rs.getInt("cchaber");
                int debe = rs.getInt("ccdebe");
                int saldo = rs.getInt("ccsaldo");
                clsCCorrientes cuenta = new clsCCorrientes();
                cuenta.setIdCCorriente(id);
                cuenta.setIdCCliente(idcli);
                cuenta.setNombreCCliente(nombre);
                cuenta.setFechaCCorriente(fecha);
                cuenta.setNofacturaCCorriente(factura);
                cuenta.setHaberCCorriente(haber);
                cuenta.setDebeCCorriente(debe);
                cuenta.setSaldoCCorriente(saldo);
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
            stmt.setInt(1, cuenta.getIdCCliente());
            stmt.setString(2, cuenta.getNombreCCliente());
            stmt.setString(3, cuenta.getFechaCCorriente());
            stmt.setString(4, cuenta.getNofacturaCCorriente());
            stmt.setInt(5, cuenta.getHaberCCorriente());
            stmt.setInt(6, cuenta.getDebeCCorriente());
            stmt.setInt(7, cuenta.getSaldoCCorriente());
            
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
            stmt.setInt(1, cuenta.getIdCCliente());
            stmt.setString(2, cuenta.getNombreCCliente());
            stmt.setString(3, cuenta.getFechaCCorriente());
            stmt.setString(4, cuenta.getNofacturaCCorriente());
            stmt.setInt(5, cuenta.getHaberCCorriente());
            stmt.setInt(6, cuenta.getDebeCCorriente());
            stmt.setInt(7, cuenta.getSaldoCCorriente());
            stmt.setInt(8, cuenta.getIdCCorriente());
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
            stmt.setInt(1, cuenta.getIdCCliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ccid");
                int idcli = rs.getInt("clid");
                String nombre = rs.getString("ccnombre");
                String fecha = rs.getString("ccfecha");
                String factura = rs.getString("NoFactura");
                int haber = rs.getInt("cchaber");
                int debe = rs.getInt("ccdebe");
                int saldo = rs.getInt("ccsaldo");
                cuenta.setIdCCorriente(id);
                cuenta.setIdCCliente(idcli);
                cuenta.setNombreCCliente(nombre);
                cuenta.setFechaCCorriente(fecha);
                cuenta.setNofacturaCCorriente(factura);
                cuenta.setHaberCCorriente(haber);
                cuenta.setDebeCCorriente(debe);
                cuenta.setSaldoCCorriente(saldo);
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
                int idcli = rs.getInt("clid");
                String nombre = rs.getString("ccnombre");
                String fecha = rs.getString("ccfecha");
                String factura = rs.getString("NoFactura");
                int haber = rs.getInt("cchaber");
                int debe = rs.getInt("ccdebe");
                int saldo = rs.getInt("ccsaldo");
                cuenta.setIdCCorriente(id);
                cuenta.setIdCCliente(idcli);
                cuenta.setNombreCCliente(nombre);
                cuenta.setFechaCCorriente(fecha);
                cuenta.setNofacturaCCorriente(factura);
                cuenta.setHaberCCorriente(haber);
                cuenta.setDebeCCorriente(debe);
                cuenta.setSaldoCCorriente(saldo);
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
