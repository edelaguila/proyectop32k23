/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega todo el codigo para la parte del modelo del mantenimiento de lineas.
//Victor Josué Jerez Mijangos 9959-21-2081

package Inventarios.Modelo;

import Seguridad.Modelo.*;
import Inventarios.Controlador.clsLineas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoLineas {

    private static final String SQL_SELECT = "SELECT linCodigo, linNombre, linPrecios, linEstatus FROM tbl_lineas";
    private static final String SQL_INSERT = "INSERT INTO tbl_lineas(linNombre, linPrecios, linEstatus) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_lineas SET linNombre=?, linPrecios=?, linEstatus=? WHERE linCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_lineas WHERE linCodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT linCodigo, linNombre, linPrecios, linEstatus FROM tbl_lineas WHERE linNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT linCodigo, linNombre, linPrecios, linEstatus FROM tbl_lineas WHERE linCodigo = ?";    

    public List<clsLineas> consultaLineas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsLineas> lineas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("linCodigo");
                String nombre = rs.getString("linNombre");
                double precio = rs.getDouble("linPrecios");
                String estatus = rs.getString("linEstatus");
                clsLineas Lineas = new clsLineas();
                Lineas.setIdLineas(id);
                Lineas.setNombreLineas(nombre);
                Lineas.setPreciosLineas(precio);
                Lineas.setEstatusLineas(estatus);
                
                lineas.add(Lineas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return lineas;
    }

    public int ingresaLineas(clsLineas lineas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, lineas.getNombreLineas());
            stmt.setDouble(2, lineas.getPreciosLineas());
            stmt.setString(3, lineas.getEstatusLineas());

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

    public int actualizaLineas(clsLineas lineas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, lineas.getNombreLineas());
            stmt.setDouble(2, lineas.getPreciosLineas());
            stmt.setString(3, lineas.getEstatusLineas());
            stmt.setInt(4, lineas.getIdLineas());
            

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

    public int borrarLineas(clsLineas lineas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, lineas.getIdLineas());
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

    public clsLineas consultaLineasPorNombre(clsLineas lineas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + lineas);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, lineas.getNombreLineas());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("linCodigo");
                String nombre = rs.getString("linNombre");
                double precios = rs.getDouble("linPrecios");
                String estatus = rs.getString("linEstatus");

                //aplicacion = new clsAplicacion();
                lineas.setIdLineas(id);
                lineas.setNombreLineas(nombre);
                lineas.setPreciosLineas(precios);
                lineas.setEstatusLineas(estatus);
                System.out.println(" registro consultado: " + lineas);                
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
        return lineas;
    }
    public clsLineas consultaLineasPorId(clsLineas lineas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + lineas);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, lineas.getIdLineas());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("linCodigo");
                String nombre = rs.getString("linNombre");
                double precios = rs.getDouble("linPrecios");
                String estatus = rs.getString("linEstatus");

                //aplicacion = new clsAplicacion();
                lineas.setIdLineas(id);
                lineas.setNombreLineas(nombre);
                lineas.setPreciosLineas(precios);
                lineas.setEstatusLineas(estatus);
                System.out.println(" registro consultado: " + lineas);                
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
        return lineas;
    }    
}
