/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Modelo;

import Bancos.Controlador.clsPersonaBancos;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPersonaBancos {

    private static final String SQL_SELECT = "SELECT perId, perNombre, perTipoId, perEstatus FROM tbl_personasBancos";
private static final String SQL_INSERT = "INSERT INTO tbl_personasBancos (perId, perNombre, perTipoId, perEstatus) VALUES (?, ?, ?, ?)";
private static final String SQL_UPDATE = "UPDATE tbl_personasBancos SET perNombre=?, perTipoId=?, perEstatus=? WHERE perId=?";
private static final String SQL_DELETE = "DELETE FROM tbl_personasBancos WHERE perId=?";
private static final String SQL_SELECT_NOMBRE = "SELECT perId, perNombre, perTipoId, perEstatus FROM tbl_personasBancos WHERE perEstatus = ?";
private static final String SQL_SELECT_ID = "SELECT perId, perNombre, perTipoId, perEstatus FROM tbl_personasBancos WHERE perId = ?";    

    public List<clsPersonaBancos> consultaBancoPersonas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsPersonaBancos> bancos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
               int Id = rs.getInt("perId"); 
                String nombre = rs.getString("perNombre");
                int Tipo = rs.getInt("perTipoId");
                String estatus = rs.getString("perEstatus");
                clsPersonaBancos banco = new clsPersonaBancos();
            banco.setPerId(Id);
            banco.setPerNombre(nombre);
            banco.setPerTipoId(Tipo);
            banco.setPerEstatus(estatus);
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

    public int ingresaBancoPersonas(clsPersonaBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
        stmt.setInt(1, banco.getPerId());
        stmt.setString(2, banco.getPerNombre());
        stmt.setInt(3, banco.getPerTipoId());
        stmt.setString(4, banco.getPerEstatus());

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

    public int actualizaBancoPersonas(clsPersonaBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, banco.getPerNombre());
            stmt.setInt(2, banco.getPerTipoId());
            stmt.setString(3, banco.getPerEstatus());
            stmt.setInt(4, banco.getPerId());
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

    public int borrarBancoPersonas(clsPersonaBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, banco.getPerId());
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

    public clsPersonaBancos consultaBancoPorNombre(clsPersonaBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + banco);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, banco.getPerNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int tipo = rs.getInt("perTipoId"); 
            String nombre = rs.getString("PerNombre");
            String estatus = rs.getString("perEstatus");
            banco.setPerTipoId(tipo);
            banco.setPerNombre(nombre);
            banco.setPerEstatus(estatus);
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
    public clsPersonaBancos consultaBancoPorPersona(clsPersonaBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + banco);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, banco.getPerId());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                  int tipo = rs.getInt("perTipoId"); 
            String nombre = rs.getString("PerNombre");
            String estatus = rs.getString("perEstatus");
            banco.setPerTipoId(tipo);
            banco.setPerNombre(nombre);
            banco.setPerEstatus(estatus);
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
