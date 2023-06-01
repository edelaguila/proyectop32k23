/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Modelo;

//Se agrega TODO el codigo para la parte del modelo del mantenimiento de movimientos.
//Victor Josué Jerez Mijangos 9959-21-2081
import Seguridad.Modelo.*;
import Inventarios.Controlador.clsMovimientos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMovimientos {

    private static final String SQL_SELECT = "SELECT movCodigo, movDescripcion, movEfecto, movEstatus FROM tbl_movimientos";
    private static final String SQL_INSERT = "INSERT INTO tbl_movimientos(movDescripcion, movEfecto, movEstatus) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_movimientos SET movDescripcion=?, movEfecto=?, movEstatus=? WHERE movCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_movimientos WHERE movCodigo=?";
   // private static final String SQL_SELECT_EFECTO = "SELECT movCodigo, movDescripcion, movEfecto, movEstatus FROM tbl_movimientos WHERE movEfecto = ?";
    private static final String SQL_SELECT_ID = "SELECT movCodigo, movDescripcion, movEfecto, movEstatus FROM tbl_movimientos WHERE movCodigo = ?";    

    public List<clsMovimientos> consultaMovimientos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsMovimientos> movimientos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("movCodigo");
                String descripcion = rs.getString("movDescripcion");
                String efecto = rs.getString("movEfecto");
                String estatus = rs.getString("movEstatus");
                clsMovimientos Movimientos = new clsMovimientos();
                Movimientos.setIdMovimiento(id);
                Movimientos.setDescripcionMovimiento(descripcion);
                Movimientos.setEfectoMovimiento(efecto);
                Movimientos.setEstatusMovimiento(estatus);
                
                movimientos.add(Movimientos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return movimientos;
    }

    public int ingresaMovimientos(clsMovimientos movimientos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, movimientos.getDescripcionMovimiento());
            stmt.setString(2, movimientos.getEfectoMovimiento());
            stmt.setString(3, movimientos.getEstatusMovimiento());

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

    public int actualizaMovimientos(clsMovimientos movimientos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, movimientos.getDescripcionMovimiento());
            stmt.setString(2, movimientos.getEfectoMovimiento());
            stmt.setString(3, movimientos.getEstatusMovimiento());
            stmt.setInt(4, movimientos.getIdMovimiento());
            

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

    public int borrarMovimientos(clsMovimientos movimientos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, movimientos.getIdMovimiento());
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

    /*public clsMovimientos consultaMovimientosPorEfecto(clsMovimientos movimientos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_EFECTO + " objeto recibido: " + movimientos);
            stmt = conn.prepareStatement(SQL_SELECT_EFECTO);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, movimientos.getEfectoMovimiento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("movCodigo");
                String descripcion = rs.getString("movDescripcion");
                String efecto = rs.getString("movEfecto");
                String estatus = rs.getString("movEstatus");

                //aplicacion = new clsAplicacion();
                movimientos.setIdMovimiento(id);
                movimientos.setDescripcionMovimiento(descripcion);
                movimientos.setEfectoMovimiento(efecto);
                movimientos.setEstatusMovimiento(estatus);
                System.out.println(" registro consultado: " + movimientos);                
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
        return movimientos;
    }*/
    public clsMovimientos consultaMovimientosPorId(clsMovimientos movimientos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_SELECT_EFECTO + " objeto recibido: " + movimientos);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, movimientos.getIdMovimiento());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("movCodigo");
                String descripcion = rs.getString("movDescripcion");
                String efecto = rs.getString("movEfecto");
                String estatus = rs.getString("movEstatus");

                //aplicacion = new clsAplicacion();
                movimientos.setIdMovimiento(id);
                movimientos.setDescripcionMovimiento(descripcion);
                movimientos.setEfectoMovimiento(efecto);
                movimientos.setEstatusMovimiento(estatus);
                System.out.println(" registro consultado: " + movimientos);                
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
        return movimientos;
    }    
}
