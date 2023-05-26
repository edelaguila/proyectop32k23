/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Bancos.Modelo;

import Bancos.Controlador.clsMovimientosEncabezadoBancos;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMovimientosEncabezadoBancos {

   private static final String SQL_SELECT = "SELECT movId, codBanco, cueId, tipMovId, movFecha, cueEmId FROM tbl_movimientosEncabezadoBancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_movimientosEncabezadoBancos(movId, codBanco, cueId, tipMovId, movFecha, cueEmId) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_movimientosEncabezadoBancos SET codBanco=?, cueId=?,  tipMovId=?, movFecha=?,  cueEmId=?  WHERE movId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_movimientosEncabezadoBancos WHERE movId=?";
   private static final String SQL_SELECT_NOMBRE = "SELECT movId, codBanco, cueId, tipMovId, movFecha, cueEmId  FROM tbl_movimientosEncabezadoBancos WHERE codBanco = ?";
    private static final String SQL_SELECT_ID = "SELECT movId, codBanco, cueId, tipMovId, movFecha, cueEmId  FROM tbl_movimientosEncabezadoBancos WHERE movId = ?";     



   public List<clsMovimientosEncabezadoBancos> consultaMovimientosEncabezado() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsMovimientosEncabezadoBancos> MovEncabezadoB = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("movId");
                int codigo = rs.getInt("codBanco");
                int idcuenta = rs.getInt("cueId");
                int idTipoMonv = rs.getInt("tipMovId");
                String fecha = rs.getString("movFecha");
                int idCuentaEm = rs.getInt("cueEmId");
                clsMovimientosEncabezadoBancos MovEncabezado = new clsMovimientosEncabezadoBancos();
                MovEncabezado.setMovId(id);
                MovEncabezado.setCodBanco(codigo);
                MovEncabezado.setCueId(idcuenta);
                MovEncabezado.setTipMovId(idTipoMonv);
                MovEncabezado.setMovFecha(fecha);
                MovEncabezado.setCueEmId(idCuentaEm);
                MovEncabezadoB.add(MovEncabezado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return MovEncabezadoB;
    }


     public int ingresaMovimientosEncabezado (clsMovimientosEncabezadoBancos encabezado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, encabezado.getMovId());
            stmt.setInt(2, encabezado.getCodBanco());
            stmt.setInt(3, encabezado.getCueId());
            stmt.setInt(4, encabezado.getTipMovId());
            stmt.setString(5, encabezado.getMovFecha());
            stmt.setInt(6, encabezado.getCueEmId());

            
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

    public int actualizaMovimientosEncabezado (clsMovimientosEncabezadoBancos encabezado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, encabezado.getCodBanco());
            stmt.setInt(2, encabezado.getCueId());
            stmt.setInt(3, encabezado.getTipMovId());
            stmt.setString(4, encabezado.getMovFecha());
            stmt.setInt(5, encabezado.getCueEmId());
            stmt.setInt(6, encabezado.getMovId());
            
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

    public int borrarMovimientosEncabezado(clsMovimientosEncabezadoBancos encabezado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, encabezado.getMovId());
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

   public clsMovimientosEncabezadoBancos consultaMovimientosEncabezadoPorCodigo(clsMovimientosEncabezadoBancos encabezado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + encabezado);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, encabezado.getIdMov());            
            stmt.setInt(1, encabezado.getCodBanco());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("movId");
                int codigo = rs.getInt("codBanco");
                int idcuenta = rs.getInt("cueId");
                int idTipoMonv = rs.getInt("tipMovId");
                String fecha = rs.getString("movFecha");
                int idCuentaEm = rs.getInt("cueEmId");
                //moneda = new clsMovimientosEncabezadoBancos();
                encabezado.setMovId(id);
                encabezado.setCodBanco(codigo);
                encabezado.setCueId(idcuenta);
                encabezado.setTipMovId(idTipoMonv);
                encabezado.setMovFecha(fecha);
                encabezado.setCueEmId(idCuentaEm);
                System.out.println(" registro consultado: " + encabezado);                
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
        return encabezado;
    }

    public clsMovimientosEncabezadoBancos consultaMovimientosEncabezadoPorId(clsMovimientosEncabezadoBancos encabezado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_ID + " objeto recibido: " + encabezado);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, encabezado.getMovId());            
            //stmt.setString(1, moneda.getTipMondNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("movId");
                int codigo = rs.getInt("codBanco");
                int idcuenta = rs.getInt("cueId");
                int idTipoMonv = rs.getInt("tipMovId");
                String fecha = rs.getString("movFecha");
                int idCuentaEm = rs.getInt("cueEmId");
                //moneda = new clsMovimientosEncabezadoBancos();
                encabezado.setMovId(id);
                encabezado.setCodBanco(codigo);
                encabezado.setCueId(idcuenta);
                encabezado.setTipMovId(idTipoMonv);
                encabezado.setMovFecha(fecha);
                encabezado.setCueEmId(idCuentaEm);
                System.out.println(" registro consultado: " + encabezado);                 
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
        return encabezado;
    }    
}
