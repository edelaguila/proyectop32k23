/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega TODO el codigo para la parte del modelo del mantenimiento de Productos.
//Victor Josué Jerez Mijangos 9959-21-2081

package Inventarios.Modelo;

import Seguridad.Modelo.*;
import Inventarios.Controlador.clsProductos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProductos {

    private static final String SQL_SELECT = "SELECT proCodigo, linCodigo, marCodigo, proNombre, proPrecios, proExistencias, proEstatus FROM tbl_productos";
    private static final String SQL_INSERT = "INSERT INTO tbl_productos(linCodigo, marCodigo, proNombre, proPrecios, proExistencias, proEstatus) VALUES(?, ? , ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_productos SET linCodigo=?, marCodigo=?, proNombre=?, proPrecios=?, proExistencias=?, proEstatus=? WHERE proCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_productos WHERE proCodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT proCodigo, linCodigo, marCodigo, proNombre, proPrecios, proExistencias, proEstatus FROM tbl_productos WHERE proNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT proCodigo, linCodigo, marCodigo, proNombre, proPrecios, proExistencias, proEstatus FROM tbl_productos WHERE proCodigo = ?";    

    public List<clsProductos> consultaProductos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsProductos> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int proID = rs.getInt("proCodigo");
                int linID = rs.getInt("linCodigo");
                int marID = rs.getInt("marCodigo");
                String nombre = rs.getString("proNombre");
                double precios = rs.getDouble("proPrecios");
                int existencias = rs.getInt("proExistencias");
                String estatus = rs.getString("proEstatus");
                
                clsProductos Productos = new clsProductos();
                Productos.setIdProductos(proID);
                Productos.setIdLinea(linID);
                Productos.setIdMarca(marID);
                Productos.setNombreProductos(nombre);
                Productos.setPreciosProductos(precios);
                Productos.setExistenciasProductos(existencias);
                Productos.setEstatusProductos(estatus);
         
                productos.add(Productos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }

    public int ingresaProductos(clsProductos productos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, productos.getIdLinea());
            stmt.setInt(2, productos.getIdMarca());
            stmt.setString(3, productos.getNombreProductos());
            stmt.setDouble(4, productos.getPreciosProductos());
            stmt.setInt(5, productos.getExistenciasProductos());
            stmt.setString(6, productos.getEstatusProductos());

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

    public int actualizaProductos(clsProductos productos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, productos.getIdLinea());
            stmt.setInt(2, productos.getIdMarca());
            stmt.setString(3, productos.getNombreProductos());
            stmt.setDouble(4, productos.getPreciosProductos());
            stmt.setInt(5, productos.getExistenciasProductos());
            stmt.setString(6, productos.getEstatusProductos());
            stmt.setInt(7, productos.getIdProductos());
            
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

    public int borrarProductos(clsProductos productos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, productos.getIdProductos());
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

    public clsProductos consultaProductosPorNombre(clsProductos productos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + productos);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, productos.getNombreProductos());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int proID = rs.getInt("proCodigo");
                int linID = rs.getInt("linCodigo");
                int marID = rs.getInt("marCodigo");
                String nombre = rs.getString("proNombre");
                double precios = rs.getDouble("proPrecios");
                int existencias = rs.getInt("proExistencias");
                String estatus = rs.getString("proEstatus");
                
                //aplicacion = new clsAplicacion();
                productos.setIdProductos(proID);
                productos.setIdLinea(linID);
                productos.setIdMarca(marID);
                productos.setNombreProductos(nombre);
                productos.setPreciosProductos(precios);
                productos.setExistenciasProductos(existencias);
                productos.setEstatusProductos(estatus);

                System.out.println(" registro consultado: " + productos);                
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
        return productos;
    }
    public clsProductos consultaProductosPorId(clsProductos productos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + productos);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, productos.getIdProductos());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int proID = rs.getInt("proCodigo");
                int linID = rs.getInt("linCodigo");
                int marID = rs.getInt("marCodigo");
                String nombre = rs.getString("proNombre");
                double precios = rs.getDouble("proPrecios");
                int existencias = rs.getInt("proExistencias");
                String estatus = rs.getString("proEstatus");

                //aplicacion = new clsAplicacion();
                productos.setIdProductos(proID);
                productos.setIdLinea(linID);
                productos.setIdMarca(marID);
                productos.setNombreProductos(nombre);
                productos.setPreciosProductos(precios);
                productos.setExistenciasProductos(existencias);
                productos.setEstatusProductos(estatus);

                System.out.println(" registro consultado: " + productos);                
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
        return productos;
    }    
}
