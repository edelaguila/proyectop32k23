/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compras.Modelo;

import Compras.Controlador.clsFactura;
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
public class daoFactura {
    private static final String SQL_SELECT = "SELECT id_factura, id_compra, fecha_factura, total_factura FROM tbl_Factura";
    private static final String SQL_INSERT = "INSERT INTO tbl_Factura(id_factura, id_compra, fecha_factura, total_factura) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Factura SET id_compra=?, fecha_factura=?, total_factura=? WHERE id_factura = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Factura WHERE id_factura=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_factura, id_compra, fecha_factura, total_factura FROM tbl_Factura WHERE fecha_factura = ?";
    private static final String SQL_SELECT_ID = "SELECT id_factura, id_compra, fecha_factura, total_factura FROM tbl_Factura WHERE id_factura = ?";    

    public List<clsFactura> consultaFactura() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsFactura> Factura = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_factura");
                int idc = rs.getInt("id_compra");
                String fecha = rs.getString("fecha_factura");
                Double total = rs.getDouble("total_factura");
                clsFactura factura = new clsFactura();
                factura.setid_factura(id);
                factura.setid_compra(idc);
                factura.setfecha_factura(fecha);
                factura.settotal_factura(total);
                factura.add(factura);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return Factura;
    }

    public int ingresaFactura(clsFactura factura) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, factura.getfecha_factura());
            stmt.setDouble(2, factura.gettotal_factura());

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

    public int actualizaFactura(clsFactura factura) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, factura.getfecha_factura());
            stmt.setDouble(2, factura.gettotal_factura());
            stmt.setInt(3, factura.getid_factura());

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

    public int borrarFactura(clsFactura factura) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, factura.getid_factura());
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

    public clsFactura consultaFacturaPorFecha(clsFactura factura) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + factura);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, factura.getfecha_factura());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_factura");
                String fecha = rs.getString("fecha_factura");
                Double total = rs.getDouble("total_factura");

                //aplicacion = new clsAplicacion();
                factura.setid_factura(id);
                factura.setfecha_factura(fecha);
                factura.settotal_factura(total);
                System.out.println(" registro consultado: " + factura);                
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
        return factura;
    }
    public clsFactura setconsultaFacturaPorId(clsFactura factura) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + factura);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, factura.getid_factura());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_compra");
                String fecha = rs.getString("fecha_factura");
                Double total = rs.getDouble("total_factura");

                //aplicacion = new clsAplicacion();
                factura.setid_factura(id);
                factura.setfecha_factura(fecha);
                factura.settotal_factura(total);
                System.out.println(" registro consultado: " + factura);                
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
        return factura;
    }    

    
}


