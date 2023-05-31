/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compras.Modelo;

import Compras.Controlador.clsBodega;
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
public class daoBodega {
    private static final String SQL_SELECT = "SELECT id_bodega, nombre_bodega, direccion_bodega, telefono FROM tbl_Bodega";
    private static final String SQL_INSERT = "INSERT INTO tbl_Bodega(id_bodega, nombre_bodega, direccion_bodega, telefono) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Bodega SET id_bodega=?, nombre_bodega=?, direccion_bodega=?, telefono=? WHERE id_bodega = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Bodega WHERE id_bodega=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_bodega, direccion_bodega, telefono FROM tbl_Bodega WHERE nombre_bodega = ?";
    private static final String SQL_SELECT_ID = "SELECT id_bodega, nombre_bodega, direccion_bodega, telefono FROM tbl_Bodega WHERE id_bodega = ?";    

    public List<clsBodega> consultaBodega() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsBodega> Bodega = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_bodega");
                String nombre = rs.getString("nombre_bodega");
                String direccion = rs.getString("direccion_bodega");
                int telefono = rs.getInt("telefono");
                
                clsBodega bodega = new clsBodega();
                bodega.setid_bodega(id);
                bodega.setnombre_bodega(nombre);
                bodega.setdireccion_bodega(direccion);
                bodega.settelefono(telefono);
                bodega.add(bodega);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return Bodega;
    }

    public int ingresaBodega(clsBodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, bodega.getid_bodega());
            stmt.setString(2, bodega.getnombre_bodega());
            stmt.setString(3, bodega.getdireccion_bodega());
            stmt.setInt(1, bodega.gettelefono());
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

    public int actualizaBodega(clsBodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, bodega.getid_bodega());
            stmt.setString(2, bodega.getnombre_bodega());
            stmt.setString(3, bodega.getdireccion_bodega());
            stmt.setInt(1, bodega.gettelefono());
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

    public int borrarBodega(clsBodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, bodega.getid_bodega());
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

    public clsBodega consultaBodegaPorId(clsBodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + bodega);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setInt(1, bodega.getid_bodega());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_bodega");
                String nombre = rs.getString("nombre_bodega");
                String direccion = rs.getString("direccion_bodega");
                int telefono = rs.getInt("telefono");
                
                bodega.setid_bodega(id);
                bodega.setnombre_bodega(nombre);
                bodega.setdireccion_bodega(direccion);
                bodega.settelefono(telefono);
                System.out.println(" registro consultado: " + bodega);                
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
        return bodega;
    }
    public clsBodega consultaBodegaPorNombre(clsBodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + bodega);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, bodega.getid_bodega());            
            //stmt.setString(1, bodega.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_bodega");
                String nombre = rs.getString("nombre_bodega");
                String direccion = rs.getString("direccion_bodega");
                int telefono = rs.getInt("telefono");
                
                bodega.setid_bodega(id);
                bodega.setnombre_bodega(nombre);
                bodega.setdireccion_bodega(direccion);
                bodega.settelefono(telefono);
                System.out.println(" registro consultado: " + bodega);               
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
        return bodega;
    }    

    
}


