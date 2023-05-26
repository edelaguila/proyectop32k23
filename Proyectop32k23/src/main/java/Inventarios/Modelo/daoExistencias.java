/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Modelo;

import Seguridad.Modelo.*;
import Inventarios.Controlador.clsExistencias;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoExistencias {

    private static final String SQL_SELECT = "SELECT proCodigo, bodCodigo, exiSaldo FROM tbl_existencias";
    private static final String SQL_INSERT = "INSERT INTO tbl_existencias(proCodigo, bodCodigo, exiSaldo) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_existencias SET proCodigo=?, bodCodigo=?, exiSaldo=? WHERE proCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_existencias WHERE proCodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT proCodigo, bodCodigo, exiSaldo FROM tbl_existencias WHERE proCodigo = ?";
    private static final String SQL_SELECT_ID = "SELECT proCodigo, bodCodigo, exiSaldo FROM tbl_existencias WHERE proCodigo = ?";    

    public List<clsExistencias> consultaExistencias() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsExistencias> existencias = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("proCodigo");
                int id2 = rs.getInt("bodCodigo");
                int saldo = rs.getInt("exiSaldo");
                clsExistencias Existencias = new clsExistencias();
                Existencias.setIdProductos(id1);
                Existencias.setIdBodegas(id2);
                Existencias.setExistenciasSaldo(saldo);
                
                
                existencias.add(Existencias);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return existencias;
    }

    public int ingresaExistencias(clsExistencias existencias) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, existencias.getIdProductos());
            stmt.setInt(2, existencias.getIdBodegas());
            stmt.setInt(3, existencias.getExistenciasSaldo());

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

    public int actualizaExistencias(clsExistencias existencias ) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, existencias.getIdProductos());
            stmt.setInt(2, existencias.getIdBodegas());
            stmt.setInt(3, existencias.getExistenciasSaldo());
            
            

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

    public int borrarExistencias(clsExistencias existencias) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, existencias.getIdProductos());
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

    public clsExistencias consultaExistenciasPorNombre(clsExistencias existencias) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + existencias);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setInt(1, existencias.getIdBodegas());
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("proCodigo");
                int id2 = rs.getInt("bodCodigo");
                int saldo = rs.getInt("exiSaldo");
              

                //aplicacion = new clsAplicacion();
                existencias.setIdProductos(id1);
                existencias.setIdBodegas(id2);
                existencias.setExistenciasSaldo(saldo);
                
                System.out.println(" registro consultado: " + existencias);                
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
        return existencias;
    }
    public clsExistencias consultaExistenciasPorId(clsExistencias existencias) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + existencias);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, existencias.getIdProductos());  
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("proCodigo");
                int id2 = rs.getInt("bodCodigo");
                int saldo = rs.getInt("exiSaldo");

                //aplicacion = new clsAplicacion();
                existencias.setIdProductos(id1);
                existencias.setIdBodegas(id2);
                existencias.setExistenciasSaldo(saldo);
                
                
                System.out.println(" registro consultado: " + existencias);                
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
        return existencias;
    }    
}
