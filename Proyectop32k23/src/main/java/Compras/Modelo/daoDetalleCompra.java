/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compras.Modelo;

import Compras.Controlador.clsDetalleCompra;
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
public class daoDetalleCompra {
    private static final String SQL_SELECT = "SELECT id_detalle_compra, id_orden_compra, id_producto, id_bodega, id_clasificacion, cantidad, precio_unitario FROM tbl_Detalle_Compra";
    private static final String SQL_INSERT = "INSERT INTO tbl_Detalle_Compra(id_detalle_compra, id_orden_compra, id_producto, id_bodega, id_clasificacion, cantidad, precio_unitario) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Detalle_Compra SET id_orden_compra=?, id_producto=?, id_bodega=?, id_clasificacion=?, id_clasificacion=?, cantidad=?, precio_unitario=? WHERE id_detalle_compra = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Detalle_Compra WHERE id_detalle_compra=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_detalle_compra, id_orden_compra, id_producto, id_bodega, id_clasificacion, cantidad, precio_unitario FROM tbl_Detalle_Compra WHERE id_detalle_compra = ?";
    private static final String SQL_SELECT_ID = "SELECT id_detalle_compra, id_orden_compra, id_producto, id_bodega, id_clasificacion, cantidad, precio_unitario FROM tbl_Detalle_Compra WHERE id_detalle_compra = ?";    

    public List<clsDetalleCompra> consultaDetalleCompra() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsDetalleCompra> DetalleCompra = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_detalle_compra");
                int idp = rs.getInt("id_producto");
                int idb = rs.getInt("id_bodega");
                int idc = rs.getInt("id_clasificacion");
                int cantidad = rs.getInt("cantidad");
                Double total = rs.getDouble("precio_unitario");
                clsDetalleCompra detalleCompra = new clsDetalleCompra();
                detalleCompra.setid_detalle_compra(id);
                detalleCompra.setid_producto(idp);
                detalleCompra.setid_bodega(idb);
                detalleCompra.setid_clasificacion(idc);
                detalleCompra.setcantidad(cantidad);
                detalleCompra.setprecio_unitario(total);
                detalleCompra.add(detalleCompra);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return DetalleCompra;
    }

    public int ingresaDetalleCompra(clsDetalleCompra detalleCompra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, detalleCompra.getid_detalle_compra());
            stmt.setInt(3, detalleCompra.getid_producto());
            stmt.setInt(4, detalleCompra.getid_bodega());
            stmt.setInt(5, detalleCompra.getid_clasificacion());
            stmt.setInt(6, detalleCompra.getcantidad());
            stmt.setDouble(7, detalleCompra.getprecio_unitario());

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

    public int actualizaDetalleCompra(clsDetalleCompra detalleCompra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, detalleCompra.getid_detalle_compra());
            stmt.setInt(3, detalleCompra.getid_producto());
            stmt.setInt(4, detalleCompra.getid_bodega());
            stmt.setInt(5, detalleCompra.getid_clasificacion());
            stmt.setInt(6, detalleCompra.getcantidad());
            stmt.setDouble(7, detalleCompra.getprecio_unitario());

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

    public int borrarDetalleCompra(clsDetalleCompra detalleCompra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, detalleCompra.getid_detalle_compra());
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

    public clsDetalleCompra consultaDetalleCompraPorId(clsDetalleCompra detalleCompra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + detalleCompra);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setInt(1, detalleCompra.getid_detalle_compra());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_detalle_compra");
                int idp = rs.getInt("id_producto");
                int idb = rs.getInt("id_bodega");
                int idc = rs.getInt("id_clasificacion");
                int cantidad = rs.getInt("cantidad");
                Double total = rs.getDouble("precio_unitario");

                //aplicacion = new clsAplicacion();
                detalleCompra.setid_detalle_compra(id);
                detalleCompra.setid_producto(idp);
                detalleCompra.setid_bodega(idb);
                detalleCompra.setid_clasificacion(idc);
                detalleCompra.setcantidad(cantidad);
                detalleCompra.setprecio_unitario(total);
                System.out.println(" registro consultado: " + detalleCompra);                
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
        return detalleCompra;
    }
    public clsDetalleCompra setconsultaFacturaPorId(clsDetalleCompra detalleCompra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + detalleCompra);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, detalleCompra.getid_detalle_compra());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_detalle_compra");
                int idp = rs.getInt("id_producto");
                int idb = rs.getInt("id_bodega");
                int idc = rs.getInt("id_clasificacion");
                int cantidad = rs.getInt("cantidad");
                Double total = rs.getDouble("precio_unitario");

                //aplicacion = new clsAplicacion();
                detalleCompra.setid_detalle_compra(id);
                detalleCompra.setid_producto(idp);
                detalleCompra.setid_bodega(idb);
                detalleCompra.setid_clasificacion(idc);
                detalleCompra.setcantidad(cantidad);
                detalleCompra.setprecio_unitario(total);
                System.out.println(" registro consultado: " + detalleCompra);                
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
        return detalleCompra;
    }    

    
}


