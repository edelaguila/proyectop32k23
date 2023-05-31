/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


// Bryan Illescas
//9959-20-273

package Compras.Modelo;

import Compras.Controlador.clsClasificacionCompras;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author illescas
 */
public class daoClasificacionCompras {
    
    private static final String SQL_SELECT = "SELECT id_clasificacion, nombre_clasificacion FROM tbl_Clasificacion";
    private static final String SQL_INSERT = "INSERT INTO tbl_Clasificacion(id_clasificacion, nombre_clasificacion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Clasificacion SET nombre_clasificacion=? WHERE id_clasificacion = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Clasificacion WHERE id_proveedor=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT id_clasificacion, nombre_clasificacion FROM tbl_Clasificacion WHERE nombre_clasificacion = ?";
    private static final String SQL_SELECT_ID = "SELECT id_clasificacion, nombre_clasificacion FROM tbl_Clasificacion WHERE id_clasificacion = ?";
    
    public List<clsClasificacionCompras> consultaClasificacionCompras() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsClasificacionCompras> ClasificacionCompras = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id_clasificacion");
                String nombre = rs.getString("nombre_clasificacion");
                clsClasificacionCompras ccompra = new clsClasificacionCompras();
                ccompra.setid_clasificacion(id);
               ccompra.setnombre_clasificacion(nombre);
                ccompra.add(ccompra);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return ClasificacionCompras;
    }

    public int ingresaClasificacionCompras(clsClasificacionCompras ccompra) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ccompra.getnombre_clasificacion());


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


    public int actualizaClasificacionCompras(clsClasificacionCompras ccompra) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, ccompra.getnombre_clasificacion());
            stmt.setInt(3, ccompra.getid_clasificacion());


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


    public int borrarClasificacionCompras(clsClasificacionCompras ccompra) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, ccompra.getid_clasificacion());

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


    public clsClasificacionCompras consultaClasificacionComprasPorNombre(clsClasificacionCompras ccompra) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + ccompra);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            stmt.setInt(1, ccompra.getid_clasificacion());            
            stmt.setString(1, ccompra.getnombre_clasificacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_clasificacion");
                String nombre = rs.getString("nombre");

                //proveedor = new clsProveedor();
                ccompra.setid_clasificacion(id);
                ccompra.setnombre_clasificacion(nombre);
                System.out.println(" registro consultado: " + ccompra);                

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

        return ccompra;
    }
    public clsClasificacionCompras consultaClasificacionComprasPorId(clsClasificacionCompras ccompra) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + ccompra);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, ccompra.getid_clasificacion());            
            stmt.setString(1, ccompra.getnombre_clasificacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_clasificacion");
                String nombre = rs.getString("nombre_clasificacion");

                //proveedor = new clsproveedor();
               ccompra.setid_clasificacion(id);
                ccompra.setnombre_clasificacion(nombre);
                System.out.println(" registro consultado: " + ccompra);                

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

        return ccompra;

    } 
}
