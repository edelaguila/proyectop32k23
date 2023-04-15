/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsAplicacion;
import Seguridad.Controlador.clsModulo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cdavi
 */
public class daoModulo {
    private static final String SQL_SELECT = "SELECT modid, modnombre, modestatus FROM tbl_modulo";
    private static final String SQL_INSERT = "INSERT INTO tbl_modulo(modnombre, modestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_modulo SET modnombre=?, modestatus=? WHERE modid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_modulo WHERE modid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT modid, modnombre, modestatus FROM tbl_modulo WHERE modnombre = ?";
    private static final String SQL_SELECT_ID = "SELECT modid, modnombre, modestatus FROM tbl_modulo WHERE modid = ?";    

    public List<clsModulo> consultaModulo() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsModulo> modulos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("modid");
                String nombre = rs.getString("modnombre");
                String estatus = rs.getString("modestatus");
                clsModulo modulo = new clsModulo();
                modulo.setIdModulo(id);
                modulo.setNombreModulo(nombre);
                modulo.setEstatusModulo(estatus);
                modulos.add(modulo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return modulos;
    }

    public int ingresaModulo(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, modulo.getNombreModulo());
            stmt.setString(2, modulo.getEstatusModulo());

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

    public int actualizaModulo(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, modulo.getNombreModulo());
            stmt.setString(2, modulo.getEstatusModulo());
            stmt.setInt(3, modulo.getIdModulo());

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

    public int borrarModulo(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, modulo.getIdModulo());
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

    public clsModulo consultaModuloPorNombre(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + modulo);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, modulo.getIdModulo());            
            stmt.setString(1, modulo.getNombreModulo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("modid");
                String nombre = rs.getString("modnombre");
                String estatus = rs.getString("modestatus");

                //modulo = new clsModulo();
                modulo.setIdModulo(id);
                modulo.setNombreModulo(nombre);
                modulo.setEstatusModulo(estatus);
                System.out.println(" registro consultado: " + modulo);                
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
        return modulo;
    }
    public clsModulo consultaModuloPorId(clsModulo modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + modulo);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, modulo.getIdModulo());            
            //stmt.setString(1, modulo.getNombreModulo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("modid");
                String nombre = rs.getString("modnombre");
                String estatus = rs.getString("modestatus");

                //modulo = new clsModulo();
                modulo.setIdModulo(id);
                modulo.setNombreModulo(nombre);
                modulo.setEstatusModulo(estatus);
                System.out.println(" registro consultado: " + modulo);                
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
        return modulo;
    }    
}
