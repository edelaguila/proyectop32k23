/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega todo el codigo para la parte del modelo del mantenimiento de marcas.
//Victor Josué Jerez Mijangos 9959-21-2081
package Inventarios.Modelo;

import  Seguridad.Modelo.*;
import Inventarios.Controlador.clsMarcas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMarcas {

    private static final String SQL_SELECT = "SELECT marCodigo, marNombre, marExistencias, marPrecios, marEstatus FROM tbl_marcas";
    private static final String SQL_INSERT = "INSERT INTO tbl_marcas(marNombre, marExistencias, marPrecios, marEstatus) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_marcas SET marNombre=?, marExistencias=?, marPrecios=?, marEstatus=? WHERE marCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_marcas WHERE marCodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT marCodigo, marNombre, marExistencias, marPrecios, marEstatus FROM tbl_marcas WHERE marNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT marCodigo, marNombre, marExistencias, marPrecios, marEstatus FROM tbl_marcas WHERE marCodigo = ?";    

    public List<clsMarcas> consultaMarcas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsMarcas> marcas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marCodigo");
                String nombre = rs.getString("marNombre");
                int existencias = rs.getInt("marExistencias");
                double precio = rs.getDouble("marPrecios");
                String estatus = rs.getString("marEstatus");
                clsMarcas Marcas = new clsMarcas();
                Marcas.setIdMarcas(id);
                Marcas.setNombreMarcas(nombre);
                Marcas.setExistenciasMarcas(existencias);
                Marcas.setPreciosMarcas(precio);
                Marcas.setEstatusMarcas(estatus);
                
                marcas.add(Marcas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return marcas;
    }

    public int ingresaMarcas(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, marcas.getNombreMarcas());
            stmt.setInt(2, marcas.getExistenciasMarcas());
            stmt.setDouble(3, marcas.getPreciosMarcas());
            stmt.setString(4, marcas.getEstatusMarcas());

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

    public int actualizaMarcas(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, marcas.getNombreMarcas());
            stmt.setInt(2, marcas.getExistenciasMarcas());
            stmt.setDouble(3, marcas.getPreciosMarcas());
            stmt.setString(4, marcas.getEstatusMarcas());
            stmt.setInt(5, marcas.getIdMarcas());
            

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

    public int borrarMarcas(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, marcas.getIdMarcas());
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

    public clsMarcas consultaMarcasPorNombre(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + marcas);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, marcas.getNombreMarcas());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marCodigo");
                String nombre = rs.getString("marNombre");
                int existencias = rs.getInt("marExistencias");
                double precios = rs.getDouble("marPrecios");
                String estatus = rs.getString("marEstatus");

                //aplicacion = new clsAplicacion();
                marcas.setIdMarcas(id);
                marcas.setNombreMarcas(nombre);
                marcas.setExistenciasMarcas(existencias);
                marcas.setPreciosMarcas(precios);
                marcas.setEstatusMarcas(estatus);
                System.out.println(" registro consultado: " + marcas);                
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
        return marcas;
    }
    public clsMarcas consultaMarcasPorId(clsMarcas marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + marcas);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, marcas.getIdMarcas());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marCodigo");
                String nombre = rs.getString("marNombre");
                int existencias = rs.getInt("marExistencias");
                double precios = rs.getDouble("marPrecios");
                String estatus = rs.getString("marEstatus");

                //aplicacion = new clsAplicacion();
                marcas.setIdMarcas(id);
                marcas.setNombreMarcas(nombre);
                marcas.setExistenciasMarcas(existencias);
                marcas.setPreciosMarcas(precios);
                marcas.setEstatusMarcas(estatus);
                System.out.println(" registro consultado: " + marcas);                
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
        return marcas;
    }    
}
