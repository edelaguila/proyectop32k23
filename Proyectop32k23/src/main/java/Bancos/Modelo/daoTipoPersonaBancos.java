/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Modelo;

import Bancos.Controlador.clsTipoPersonaBancos;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTipoPersonaBancos {

    private static final String SQL_SELECT = "SELECT perTipoId, tipPerDescripcion, tipPerEstatus FROM tbl_tipoPersona";
    private static final String SQL_INSERT = "INSERT INTO tbl_tipoPersona (perTipoId, tipPerDescripcion,  tipPerEstatus) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tipoPersona SET tipPerDescripcion=?, tipPerEstatus=? WHERE perTipoId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_tipoPersona WHERE perTipoId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT perTipoId, tipPerDescripcion,  tipPerEstatus FROM tbl_tipoPersona WHERE tipPerEstatus = ?";
    private static final String SQL_SELECT_ID = "SELECT perTipoId, tipPerDescripcion, tipPerEstatus FROM tbl_tipoPersona WHERE perTipoId = ?";    

    public List<clsTipoPersonaBancos> consultaBanco() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsTipoPersonaBancos> bancos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
               int tipo = rs.getInt("perTipoId"); 
                String nombre = rs.getString("tipPerDescripcion");
                String estatus = rs.getString("tipPerEstatus");
                clsTipoPersonaBancos banco = new clsTipoPersonaBancos();
                banco.setIdTipoPersonaBancos(tipo);
                banco.setTipoDescripcionBancos(nombre);
                banco.setTipoEstatusBancos(estatus);
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

    public int ingresaBanco(clsTipoPersonaBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, banco.getIdTipoPersonaBancos());
            stmt.setString(2, banco.getTipoDescripcionBancos());
            stmt.setString(3, banco.getTipoEstatusBancos());

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

    public int actualizaBanco(clsTipoPersonaBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, banco.getTipoDescripcionBancos());
            stmt.setString(2, banco.getTipoEstatusBancos());
            stmt.setInt(3, banco.getIdTipoPersonaBancos());
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

    public int borrarBanco(clsTipoPersonaBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, banco.getIdTipoPersonaBancos());
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

    public clsTipoPersonaBancos consultaBancoPorDescripcion(clsTipoPersonaBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + banco);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, banco.getTipoDescripcionBancos());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int tipo = rs.getInt("perTipoId"); 
                String nombre = rs.getString("tipPerDescripcion");
                String estatus = rs.getString("tipPerEstatus");

                //aplicacion = new clsAplicacion();
                banco.setIdTipoPersonaBancos(tipo);
                banco.setTipoDescripcionBancos(nombre);
                banco.setTipoEstatusBancos(estatus);
                System.out.println(" registro consultado: " + banco);                
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
        return banco;
    }
    public clsTipoPersonaBancos consultaBancoPorTipo(clsTipoPersonaBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + banco);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, banco.getIdTipoPersonaBancos());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int tipo = rs.getInt("perTipoId"); 
                String nombre = rs.getString("tipPerDescripcion");
                String estatus = rs.getString("tipPerEstatus");

                //aplicacion = new clsAplicacion();
                banco.setIdTipoPersonaBancos(tipo);
                banco.setTipoDescripcionBancos(nombre);
                banco.setTipoEstatusBancos(estatus);
                System.out.println(" registro consultado: " + banco);                     
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
        return banco;
    }    
}
