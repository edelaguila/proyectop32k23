/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Bancos.Modelo;

import Bancos.Controlador.clsTipoMoneda;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTipoMoneda {

    private static final String SQL_SELECT = "SELECT tipModId, tipMondNombre, tipMondAbreviacion, tipModValor, estatus FROM tbl_monedaBancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_monedaBancos(tipModId, tipMondNombre, tipMondAbreviacion, tipModValor, estatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_monedaBancos SET tipMondNombre=?, tipMondAbreviacion=?,  tipModValor=?, estatus=?  WHERE tipModId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_monedaBancos WHERE tipModId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT tipModId, tipMondNombre, tipMondAbreviacion, tipModValor, estatus  FROM tbl_monedaBancos WHERE tipMondNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT tipModId, tipMondNombre, tipMondAbreviacion, tipModValor, estatus  FROM tbl_monedaBancos WHERE tipModId = ?";     



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
                String Estatus =rs.getString("estatus");
                clsTipoMoneda tipmoneda = new clsTipoMoneda();
                tipmoneda.setTipModId(id);
                tipmoneda.setTipMondNombre(nombre);
                tipmoneda.setTipMondAbreviacion(abreviacion);
                tipmoneda.setTipModValor(valor);
                tipmoneda.setEstatus(Estatus);
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
            stmt.setString(5, moneda.getEstatus());
            
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
            stmt.setString(5, moneda.getEstatus());
            
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

    public int borrarTipoMoneda(clsTipoMoneda moneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, moneda.getTipModId());
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

    public clsTipoMoneda consultaTipoMonedaPorNombre(clsTipoMoneda moneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + moneda);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, moneda.getIdMoneda());            
            stmt.setString(1, moneda.getTipMondNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tipModId");
                String nombre = rs.getString("tipMondNombre");
                String abreviacion = rs.getString("tipMondAbreviacion");
                float valor = rs.getFloat("tipModValor");
                String Estatus = rs.getString("estatus");
                //moneda = new clsTipoMoneda();
                moneda.setTipModId(id);
                moneda.setTipMondNombre(nombre);
                moneda.setTipMondAbreviacion(abreviacion);
                moneda.setTipModValor(valor);
                moneda.setEstatus(Estatus);
                System.out.println(" registro consultado: " + moneda);                
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
        return moneda;
    }
    public clsTipoMoneda consultaTipoMonedaPorId(clsTipoMoneda moneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + moneda);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, moneda.getTipModId());            
            //stmt.setString(1, moneda.getTipMondNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tipModId");
                String nombre = rs.getString("tipMondNombre");
                String abreviacion = rs.getString("tipMondAbreviacion");
                float valor = rs.getFloat("tipModValor");
                String Estatus = rs.getString("estatus");
                //moneda = new clsTipoMoneda();
                moneda.setTipModId(id);
                moneda. setTipMondNombre (nombre);
                moneda. setTipMondAbreviacion (abreviacion);
                moneda. setTipModValor (valor);
                moneda.setEstatus(Estatus);
                System.out.println(" registro consultado: " + moneda);                
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
        return moneda;
    }    
}
