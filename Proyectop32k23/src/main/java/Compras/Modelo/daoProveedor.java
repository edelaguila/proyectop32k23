/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Compras.Modelo;

import Compras.Controlador.clsProveedor;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Bryan Illescas 9959-20-273
 */
public class daoProveedor {
    
    private static final String SQL_SELECT = "SELECT id_proveedor, nombre, direccion, telefono, email FROM tbl_Proveedor";
    private static final String SQL_INSERT = "INSERT INTO tbl_Proveedor(id_proveedor, nombre, direccion, telefono, email) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Proveedor SET nombre=?, direccion=?, telefono=?, email=? WHERE id_proveedor = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Proveedor WHERE id_proveedor=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_proveedor, nombre, direccion, telefono, email FROM Proveedor WHERE nombre = ?";
    private static final String SQL_SELECT_ID = "SELECT id_proveedor, nombre, direccion, telefono, email FROM tbl_Proveedor WHERE id_proveedor = ?";
    
    public List<clsProveedor> consultaProveedor() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsProveedor> Proveedor = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                int telefono = rs.getInt("telefono");
                String correo = rs.getString("email");
                clsProveedor proveedor = new clsProveedor();
                proveedor.setid_proveedor(id);
                proveedor.setnombre(nombre);
                proveedor.setdireccion(direccion);
                proveedor.add(proveedor);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return Proveedor;
    }

    public int ingresaProveedor(clsProveedor proveedor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, proveedor.getnombre());
            stmt.setString(2, proveedor.getdireccion());
            stmt.setInt(2, proveedor.gettelefono());
            stmt.setString(2, proveedor.getemail());

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


    public int actualizaProveedor(clsProveedor proveedor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, proveedor.getnombre());
            stmt.setString(2, proveedor.getdireccion());
            stmt.setInt(3, proveedor.getid_proveedor());
            stmt.setInt(4, proveedor.gettelefono());
            stmt.setString(5, proveedor.getemail());


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


    public int borrarProveedor(clsProveedor proveedor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, proveedor.getid_proveedor());
            stmt.setString(2, proveedor.getnombre());
            stmt.setString(3, proveedor.getdireccion());
            stmt.setInt(4, proveedor.gettelefono());
            stmt.setString(5, proveedor.getemail());

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


    public clsProveedor consultaProveedorPorNombre(clsProveedor proveedor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + proveedor);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, proveedor.getIdProveedor());            
            stmt.setInt(1, proveedor.getid_proveedor());
            stmt.setString(2, proveedor.getnombre());
            stmt.setString(3, proveedor.getdireccion());
            stmt.setInt(4, proveedor.gettelefono());
            stmt.setString(5, proveedor.getemail());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                int telefono = rs.getInt("telefono");
                String correo = rs.getString("email");

                //proveedor = new clsProveedor();
                proveedor.setid_proveedor(id);
                proveedor.setnombre(nombre);
                proveedor.setdireccion(direccion);
                proveedor.settelefono(telefono);
                proveedor.setemail(correo);
                System.out.println(" registro consultado: " + proveedor);                

            }
            //System.out.println("Registros buscado:" + proveedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return proveedor;  // Si se utiliza un ArrayList

        return proveedor;
    }
    public clsProveedor consultaProveedorPorId(clsProveedor proveedor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + proveedor);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, proveedor.getid_proveedor());
            stmt.setString(2, proveedor.getnombre());
            stmt.setString(3, proveedor.getdireccion());
            stmt.setInt(4, proveedor.gettelefono());
            stmt.setString(5, proveedor.getemail());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                int telefono = rs.getInt("telefono");
                String correo = rs.getString("email");

                //proveedor = new clsProveedor();
                proveedor.setid_proveedor(id);
                proveedor.setnombre(nombre);
                proveedor.setdireccion(direccion);
                proveedor.settelefono(telefono);
                proveedor.setemail(correo);
                System.out.println(" registro consultado: " + proveedor);                

            }
            //System.out.println("Registros buscado:" + proveedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return proveedor;  // Si se utiliza un ArrayList

        return proveedor;

    } 

    private static class Conexion {

        private static Connection getConnection() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void close(ResultSet rs) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void close(PreparedStatement stmt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void close(Connection conn) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public Conexion() {
        }
    }
}
