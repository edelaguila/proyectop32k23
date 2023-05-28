/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bancos.Modelo;


import Bancos.Controlador.clsTipoCuentas;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cdavi
 */

//Hecho por Carlos González, 9959-20-6164

public class daoTipoCuentas {
    private static final String SQL_SELECT = "SELECT cueTipoId , cueTipoDescripcion, cueTipoEstatus FROM tbl_tipoCuentasBancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_tipoCuentasBancos(cueTipoId , cueTipoDescripcion, cueTipoEstatus) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tipoCuentasBancos SET cueTipoDescripcion=?, cueTipoEstatus=? WHERE cueTipoId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_tipoCuentasBancos WHERE cueTipoId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT cueTipoId , cueTipoDescripcion, cueTipoEstatus FROM tbl_tipoCuentasBancos WHERE cueTipoDescripcion = ?";
    private static final String SQL_SELECT_ID = "SELECT cueTipoId , cueTipoDescripcion, cueTipoEstatus FROM tbl_tipoCuentasBancos WHERE cueTipoId = ?";    

    public List<clsTipoCuentas> consultaTipoCuenta() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsTipoCuentas> cuentas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueTipoId");
                String des = rs.getString("cueTipoDescripcion");
                String estatus = rs.getString("cueTipoEstatus");
                clsTipoCuentas cuenta = new clsTipoCuentas();
                cuenta.setTipoCueId(id);
                cuenta.setTipoCueDescripcion(des);
                cuenta.setEstatusTipoCue(estatus);
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

    public int ingresaTipoCuenta(clsTipoCuentas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cuenta.getTipoCueId());
            stmt.setString(2, cuenta.getTipoCueDescripcion());
            stmt.setString(3, cuenta.getEstatusTipoCue());

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

    public int actualizaTipoCuenta(clsTipoCuentas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cuenta.getEstatusTipoCue());
            stmt.setString(2, cuenta.getEstatusTipoCue());
            stmt.setInt(3, cuenta.getTipoCueId());

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

    public int borrarTipoCuenta(clsTipoCuentas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cuenta.getTipoCueId());
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

    public clsTipoCuentas consultaTipoCuentaPorNombre(clsTipoCuentas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuenta);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, modulo.getIdModulo());            
            stmt.setString(1, cuenta.getTipoCueDescripcion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueTipoId");
                String des = rs.getString("cueTipoDescripcion");
                String estatus = rs.getString("cueTipoEstatus");

                //movimiento = new clsModulo();
                cuenta.setTipoCueId(id);
                cuenta.setTipoCueDescripcion(des);
                cuenta.setEstatusTipoCue(estatus);
                System.out.println(" registro consultado: " + cuenta);                
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
        return cuenta;
    }
    public clsTipoCuentas consultaTipoCuentaPorId(clsTipoCuentas cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuenta);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, cuenta.getTipoCueId());            
            //stmt.setString(1, modulo.getNombreModulo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueTipoId");
                String des = rs.getString("cueTipoDescripcion");
                String estatus = rs.getString("cueTipoEstatus");

                //modulo = new clsModulo();
                cuenta.setTipoCueId(id);
                cuenta.setTipoCueDescripcion(des);
                cuenta.setEstatusTipoCue(estatus);
                System.out.println(" registro consultado: " + cuenta);                
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
        return cuenta;
    }    
}
