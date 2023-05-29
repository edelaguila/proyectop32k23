/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package Cuentas_Corrientes.Modelo;

import Cuentas_Corrientes.Controlador.clsTransaccionesCC;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTransaccionesCC {

    private static final String SQL_SELECT = "SELECT tracodigo, traNombre, traEstatus, traEfecto FROM tbl_transaciones_cc";
    private static final String SQL_INSERT = "INSERT INTO tbl_transaciones_cc(traNombre, traEstatus, traEfecto) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_transaciones_cc SET traNombre=?, traEstatus=?,traEfecto=? WHERE tracodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_transaciones_cc WHERE tracodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT tracodigo, traNombre, traEstatus, traEfecto FROM tbl_transaciones_cc WHERE traNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT tracodigo, traNombre, traEstatus, traEfecto FROM tbl_transaciones_cc WHERE tracodigo = ?";    

    public List<clsTransaccionesCC> consultaT() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsTransaccionesCC> transacciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("tracodigo");
                String nombre = rs.getString("traNombre");
                String estatus = rs.getString("traEstatus");
                String efecto = rs.getString("traEfecto");
                clsTransaccionesCC transaccion = new clsTransaccionesCC();
                transaccion.setCodigoT(id);
                transaccion.setNombreT(nombre);
                transaccion.setEstatusT(estatus);
                transaccion.setEfectoT(efecto);
                transacciones.add(transaccion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return transacciones;
    }

    public int ingresaT(clsTransaccionesCC transaccion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, transaccion.getNombreT());
            stmt.setString(2, transaccion.getEstatusT());
            stmt.setString(3, transaccion.getEfectoT());
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
    public int actualizaT(clsTransaccionesCC transaccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, transaccion.getNombreT());
            stmt.setString(2, transaccion.getEstatusT());
            stmt.setString(3, transaccion.getEfectoT());
            stmt.setInt(4, transaccion.getCodigoT());
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


    public int borrarT(clsTransaccionesCC transaccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, transaccion.getCodigoT());
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

    public clsTransaccionesCC consultaTrPorNombre(clsTransaccionesCC transaccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + transaccion);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, perfil.getIdPerfil());            
            stmt.setString(1, transaccion.getNombreT());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tracodigo");
                String nombre = rs.getString("traNombre");
                String estatus = rs.getString("traEstatus");
                String efecto = rs.getString("traEfecto");
                transaccion.setCodigoT(id);
                transaccion.setNombreT(nombre);
                transaccion.setEstatusT(estatus);
                transaccion.setEfectoT(efecto);
                System.out.println(" registro consultado: " + transaccion);                
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
        return transaccion;
    }
    public clsTransaccionesCC consultaTrPorId(clsTransaccionesCC transaccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + transaccion);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, transaccion.getCodigoT());            
            //stmt.setString(1, perfil.getNombrePerfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tracodigo");
                String nombre = rs.getString("traNombre");
                String estatus = rs.getString("traEstatus");
                String efecto = rs.getString("traEfecto");
                //perfil = new clsPerfil();
                transaccion.setCodigoT(id);
                transaccion.setNombreT(nombre);
                transaccion.setEstatusT(estatus);
                transaccion.setEfectoT(efecto);
                System.out.println(" registro consultado: " + transaccion);                
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
        return transaccion;
    }    
}
