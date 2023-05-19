/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//María José Véliz Ochoa 
//9959-21-5909
//daoTienda

package Ventas.Modelo;

import Ventas.Controlador.clsClientes;
import Ventas.Controlador.clsTienda;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class daoTienda {
   private static final String SQL_SELECT = "SELECT tieid, tienombre, tiedireccion, tietipo FROM tbl_tienda";
    private static final String SQL_INSERT = "INSERT INTO tbl_tienda(tienombre, tiedireccion, tietipo) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tienda SET tienombre=?, tiedireccion=?, tietipo=? WHERE tieid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_tienda WHERE tieid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT tieid, tienombre, tiedireccion, tietipo FROM tbl_tienda WHERE tienombre = ?";
    private static final String SQL_SELECT_ID = "SELECT tieid, tienombre, tiedireccion, tietipo  FROM tbl_tienda WHERE tieid = ?";    

    public List<clsTienda> consultaTienda() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsTienda> tiendas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tieid");
                String nombre = rs.getString("tienombre");
                String direccion = rs.getString("tiedireccion");
                String tipo = rs.getString("tietipo");
                clsTienda tienda = new clsTienda();
                tienda.setIdTienda(id);
                tienda.setNombreTienda(nombre);
                tienda.setDireccionTienda(direccion);
                tienda.setTipoTienda(tipo);
                tiendas.add(tienda);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return tiendas;
    }

    public int ingresaTienda(clsTienda tienda) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, tienda.getNombreTienda());
            stmt.setString(2, tienda.getDireccionTienda());
            stmt.setString(3, tienda.getTipoTienda());


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


    public int actualizaTienda(clsTienda tienda) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, tienda.getNombreTienda());
            stmt.setString(2, tienda.getDireccionTienda());
            stmt.setString(3, tienda.getTipoTienda());
            stmt.setInt(4, tienda.getIdTienda());


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


    public int borrarTienda(clsTienda tienda){

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, tienda.getIdTienda());

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


    public clsTienda consultaTiendaPorNombre(clsTienda tienda) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + tienda);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, perfil.getIdPerfil());            
            stmt.setString(1, tienda.getNombreTienda());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tieid");
                String nombre = rs.getString("tienombre");
                String direccion = rs.getString("tiedireccion");
                String tipo = rs.getString("tietipo");
                //perfil = new clsPerfil();
       
                tienda.setIdTienda(id);
                tienda.setNombreTienda(nombre);
                tienda.setDireccionTienda(direccion);
                tienda.setTipoTienda(tipo);
                System.out.println(" registro consultado: " + tienda);                

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

        return tienda;
    }
    public clsTienda consultaTiendaPorId(clsTienda tienda) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + tienda);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, tienda.getIdTienda());            

            rs = stmt.executeQuery();
            while (rs.next()) {
                    int id = rs.getInt("tieid");
                String nombre = rs.getString("tienombre");
                String direccion = rs.getString("tiedireccion");
                String tipo = rs.getString("tietipo");

                tienda.setIdTienda(id);
                tienda.setNombreTienda(nombre);
                tienda.setDireccionTienda(direccion);
                tienda.setTipoTienda(tipo);
                System.out.println(" registro consultado: " + tienda);                

            }
            //System.out.println("Registros buscado:" + tienda);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList

        return tienda;

    }    
}
 
