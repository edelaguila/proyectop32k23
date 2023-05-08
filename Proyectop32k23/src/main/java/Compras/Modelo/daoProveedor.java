/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


// Bryan Illescas
//9959-20-273

package Compras.Modelo;

import Seguridad.Controlador.clsProveedor;
import Ventas.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author illescas
 */
public class daoProveedor {
    
    private static final String SQL_SELECT = "SELECT id_proveedor, nombre, direccion FROM tbl_Proveedor";
    private static final String SQL_INSERT = "INSERT INTO tbl_Proveedor(nombre, direccion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Proveedor SET nombre=?, direccion=? WHERE id_proveedor = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Proveedor WHERE id_proveedor=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_proveedor, nombre, direccion FROM Proveedor WHERE nombre = ?";
    private static final String SQL_SELECT_ID = "SELECT id_proveedor, nombre, direccion FROM tbl_Proveedor WHERE id_proveedor = ?";
    
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
                clsProveedor proveedor = new clsProveedor();
                proveedor.setId_proveedor(id);
                proveedor.setNombre(nombre);
                proveedor.setDireccion(direccion);
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

            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getDireccion());


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

            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getDireccion());
            stmt.setInt(3, proveedor.getId_proveedor());


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

            stmt.setInt(1, proveedor.getId_proveedor());

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
            stmt.setString(1, proveedor.getNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("clid");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");

                //proveedor = new clsProveedor();
                proveedor.setId_proveedor(id);
                proveedor.setNombre(nombre);
                proveedor.setDireccion(direccion);
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
            stmt.setInt(1, proveedor.getId_proveedor());            
            //stmt.setString(1, proveedor.getNombreProveedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");

                //proveedor = new clsproveedor();
                proveedor.setId_proveedor(id);
                proveedor.setNombre(nombre);
                proveedor.setDireccion(direccion);
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
}
