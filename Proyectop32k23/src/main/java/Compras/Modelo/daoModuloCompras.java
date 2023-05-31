/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compras.Modelo;

import Compras.Controlador.clsModuloCompras;
import Seguridad.Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan Illescas 9959-20-273
 */
public class daoModuloCompras {
    private static final String SQL_SELECT = "SELECT id_compra, id_proveedor, fecha_compra, total_compra FROM tbl_Compra";
    private static final String SQL_INSERT = "INSERT INTO tbl_Compra(id_compra, id_proveedor, fecha_compra, total_compra) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Compra SET id_proveedor=?, fecha_compra=?, total_compra=? WHERE id_compra = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Compra WHERE id_compra=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_compra, id_proveedor, fecha_compra, total_compra FROM tbl_Compra WHERE fecha_compra = ?";
    private static final String SQL_SELECT_ID = "SELECT id_compra, id_proveedor, fecha_compra, total_compra FROM tbl_Compra WHERE id_compra = ?";    

    public List<clsModuloCompras> consultaModuloCompras() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsModuloCompras> Compra = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_compra");
                int idp = rs.getInt("id_proveedor");
                String fecha = rs.getString("fecha_compra");
                Double total = rs.getDouble("total_compra");
                clsModuloCompras compra = new clsModuloCompras();
                compra.setid_compra(id);
                compra.setid_proveedor(idp);
                compra.setfecha_compra(fecha);
                compra.settotal_compra(total);
                compra.add(compra);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return Compra;
    }

    public int ingresaCompra(clsModuloCompras compra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, compra.getfecha_compra());
            stmt.setDouble(2, compra.gettotal_compra());

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

    public int actualizaCompra(clsModuloCompras compra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, compra.getfecha_compra());
            stmt.setDouble(2, compra.gettotal_compra());
            stmt.setInt(3, compra.getid_compra());

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

    public int borrarCompra(clsModuloCompras compra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, compra.getid_compra());
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

    public clsModuloCompras consultaModuloCompraPorId(clsModuloCompras compra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + compra);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, compra.getfecha_compra());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_compra");
                String fecha = rs.getString("fecha_compra");
                Double total = rs.getDouble("total_compra");

                //aplicacion = new clsAplicacion();
                compra.setid_compra(id);
                compra.setfecha_compra(fecha);
                compra.settotal_compra(total);
                System.out.println(" registro consultado: " + compra);                
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
        return compra;
    }
    public clsModuloCompras setconsultaModuloCompraPorId(clsModuloCompras compra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + compra);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, compra.getid_compra());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_compra");
                String fecha = rs.getString("fecha_compra");
                Double total = rs.getDouble("total_compra");

                //aplicacion = new clsAplicacion();
                compra.setid_compra(id);
                compra.setfecha_compra(fecha);
                compra.settotal_compra(total);
                System.out.println(" registro consultado: " + compra);                
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
        return compra;
    }    

    
}

