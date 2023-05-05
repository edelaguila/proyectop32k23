/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Carlos Javier Sandoval Catalán
//9959-21-1324
//DaoClientes
package Ventas.Modelo;

import Ventas.Controlador.clsClientes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoClientes {


    private static final String SQL_SELECT = "SELECT clid, clnombre, clestatus FROM tbl_cliente";
    private static final String SQL_INSERT = "INSERT INTO tbl_cliente(clnombre, clestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cliente SET clnombre=?, clestatus=? WHERE clid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cliente WHERE clid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT clid, clnombre, clestatus FROM tbl_cliente WHERE clnombre = ?";
    private static final String SQL_SELECT_ID = "SELECT clid, clnombre, clestatus FROM tbl_cliente WHERE clid = ?";    

    public List<clsClientes> consultaCliente() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsClientes> clientes = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("clid");
                String nombre = rs.getString("clnombre");
                String estatus = rs.getString("clestatus");
                clsClientes cliente = new clsClientes();
                cliente.setIdCliente(id);
                cliente.setNombreCliente(nombre);
                cliente.setEstatusCliente(estatus);
                clientes.add(cliente);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientes;
    }

    public int ingresaCliente(clsClientes cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, cliente.getNombreCliente());
            stmt.setString(2, cliente.getEstatusCliente());


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


    public int actualizaCliente(clsClientes cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, cliente.getNombreCliente());
            stmt.setString(2, cliente.getEstatusCliente());
            stmt.setInt(3, cliente.getIdCliente());


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


    public int borrarCliente(clsClientes cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, cliente.getIdCliente());

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


    public clsClientes consultaClientePorNombre(clsClientes cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cliente);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, perfil.getIdPerfil());            
            stmt.setString(1, cliente.getNombreCliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("clid");
                String nombre = rs.getString("clnombre");
                String estatus = rs.getString("clestatus");

                //perfil = new clsPerfil();
                cliente.setIdCliente(id);
                cliente.setNombreCliente(nombre);
                cliente.setEstatusCliente(estatus);
                System.out.println(" registro consultado: " + cliente);                

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

        return cliente;
    }
    public clsClientes consultaClientePorId(clsClientes cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cliente);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, cliente.getIdCliente());            
            //stmt.setString(1, perfil.getNombrePerfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("clid");
                String nombre = rs.getString("clnombre");
                String estatus = rs.getString("clestatus");

                //perfil = new clsPerfil();
                cliente.setIdCliente(id);
                cliente.setNombreCliente(nombre);
                cliente.setEstatusCliente(estatus);
                System.out.println(" registro consultado: " + cliente);                

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

        return cliente;

    }    
}
