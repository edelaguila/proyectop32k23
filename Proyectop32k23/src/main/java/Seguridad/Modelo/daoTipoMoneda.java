/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsTipoMoneda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTipoMoneda {

    private static final String SQL_SELECT = "SELECT tipModId, tipMondNombre, tipMondAbreviacion, tipModValor FROM tbl_tipoMoneda";
    private static final String SQL_INSERT = "INSERT INTO tbl_tipoMoneda(tipModId, tipMondNombre, tipMondAbreviacion, tipModValor) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tipoMoneda SET tipMondNombre=?, tipMondAbreviacion=?,  tipModValor=?  WHERE tipModId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_tipoMoneda WHERE tipModId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT tipModId, tipMondNombre, tipMondAbreviacion, tipModValor  FROM tbl_tipoMoneda WHERE tipMondNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT tipModId, tipMondNombre, tipMondAbreviacion, tipModValor  FROM tbl_tipoMoneda WHERE tipModId = ?";     



   public List<clsTipoMoneda> consultaTipoMoneda() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsTipoMoneda> tipmonedas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tipModId");
                String nombre = rs.getString("tipMondNombre");
                String abreviacion = rs.getString("tipMondAbreviacion");
                float valor = rs.getFloat ("tipModValor");
                clsTipoMoneda tipmoneda = new clsTipoMoneda();
                tipmoneda.setTipModId(id);
                tipmoneda.setTipMondNombre(nombre);
                tipmoneda.setTipMondAbreviacion(abreviacion);
                tipmoneda.setTipModValor(valor);
                tipmonedas.add(tipmoneda);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tipmonedas;
    }


     public int ingresaTipoMoneda (clsTipoMoneda moneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, moneda.getTipModId());
            stmt.setString(2, moneda.getTipMondNombre());
            stmt.setString(3, moneda.getTipMondAbreviacion());
            stmt.setFloat(4, moneda.getTipModValor());
            
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

    public int actualizaTipoMoneda (clsTipoMoneda moneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, moneda.getTipMondNombre());
            stmt.setString(2, moneda.getTipMondAbreviacion());
            stmt.setFloat(3, moneda.getTipModValor());
            stmt.setInt(4, moneda.getTipModId());
            
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
