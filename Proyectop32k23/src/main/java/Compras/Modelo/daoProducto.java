/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras.Modelo;


import Compras.Controlador.clsProducto;
import Seguridad.Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Joshua Aguilar 9959-20-4660
 */
public class daoProducto {
    private static final String SQL_SELECT = "SELECT id_producto, nombre_producto, precio_unitario, existencias_total FROM tbl_Producto";
    private static final String SQL_INSERT = "INSERT INTO tbl_Producto(id_producto, nombre_producto, precio_unitario, existencias_total) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Producto SET nombre_producto=?, precio_unitario=?, existencias_total=? WHERE id_producto = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Producto WHERE id_producto=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_producto, precio_unitario, existencias_total FROM tbl_Producto WHERE nombre_producto = ?";
    private static final String SQL_SELECT_ID = "SELECT nombre_producto, precio_unitario, existencias_total FROM tbl_Producto WHERE id_producto = ?";    

    public List<clsProducto> consultaProducto() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsProducto> Producto = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre_producto");
                Double precio = rs.getDouble("precio_unitario");
                clsProducto producto = new clsProducto();
                producto.setid_producto(id);
                producto.setnombre_producto(nombre);
                producto.setprecio_unitario(precio);
                producto.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return Producto;
    }

    public int ingresaProducto(clsProducto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, producto.getid_producto());
            stmt.setString(1, producto.getnombre_producto());
            stmt.setDouble(2, producto.getprecio_unitario());

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

    public int actualizaProducto(clsProducto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getnombre_producto());
            stmt.setDouble(2, producto.getprecio_unitario());
            stmt.setInt(3, producto.getid_producto());

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

    public int borrarProducto(clsProducto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getid_producto());
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

    public clsProducto consultaProductoPorNombre(clsProducto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + producto);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            stmt.setInt(1, producto.getid_producto());            
            stmt.setString(1, producto.getnombre_producto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre_producto");
                Double precio = rs.getDouble("precio_unitario");

                //aplicacion = new clsAplicacion();
                producto.setid_producto(id);
                producto.setnombre_producto(nombre);
                producto.setprecio_unitario(precio);
                System.out.println(" registro consultado: " + producto);                
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
        return producto;
    }
    public clsProducto setconsultaProductoPorId(clsProducto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + producto);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            stmt.setInt(1, producto.getid_producto());            
            stmt.setString(1, producto.getnombre_producto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre_producto");
                Double precio = rs.getDouble("precio_unitario");

                //aplicacion = new clsAplicacion();
                producto.setid_producto(id);
                producto.setnombre_producto(nombre);
                producto.setprecio_unitario(precio);
                System.out.println(" registro consultado: " + producto);                              
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
        return producto;
    }    

    
}

