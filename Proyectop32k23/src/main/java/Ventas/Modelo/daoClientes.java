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
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoClientes {


private static final String SQL_SELECT = "SELECT clId, clNombre, cldireccion, cltelefono, clemail, clNit, clHaber, clDebe FROM tbl_cliente";
private static final String SQL_INSERT = "INSERT INTO tbl_cliente(clNombre, cldireccion, cltelefono, clemail, clNit, clHaber, clDebe) VALUES(?, ?, ?, ?, ?, ?, ?)";
private static final String SQL_UPDATE = "UPDATE tbl_cliente SET clNombre=?, cldireccion=?, cltelefono=?, clemail=?, clNit=?, clHaber=?, clDebe=? WHERE clId = ?";
private static final String SQL_DELETE = "DELETE FROM tbl_cliente WHERE clId=?";
private static final String SQL_SELECT_NOMBRE = "SELECT clId, clNombre, cldireccion, cltelefono, clemail, clNit, clHaber, clDebe FROM tbl_cliente WHERE clNombre = ?";
private static final String SQL_SELECT_ID = "SELECT clId, clNombre, cldireccion, cltelefono, clemail, clNit, clHaber, clDebe FROM tbl_cliente WHERE clId = ?";

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

                int Id = rs.getInt("clId");
                String Nombre = rs.getString("clNombre");
                String Direccion = rs.getString("cldireccion");
                String Telefono = rs.getString("cltelefono");
                String Email = rs.getString("clemail");
                String Nit = rs.getString("clNit");
                double Haber = rs.getDouble("clHaber");
                double Debe = rs.getDouble("clDebe");
                
                clsClientes cliente = new clsClientes();
                cliente.setIdCliente(Id);
                cliente.setNombreCliente(Nombre);
                cliente.setEstatusCliente(Direccion);
                cliente.setTelefonoCliente(Telefono);
                cliente.setEmailCliente(Email);
                cliente.setNitCliente(Nit);
                cliente.setHaberCliente(Haber);
                cliente.setDebeCliente(Debe);
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
            stmt.setString(3, cliente.getTelefonoCliente());
            stmt.setString(4, cliente.getEmailCliente());
            stmt.setString(5, cliente.getNitCliente());
            stmt.setDouble(6, cliente.getHaberCliente());
            stmt.setDouble(7, cliente.getDebeCliente());

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
        stmt.setString(3, cliente.getTelefonoCliente());
        stmt.setString(4, cliente.getEmailCliente());
        stmt.setString(5, cliente.getNitCliente());
        stmt.setDouble(6, cliente.getHaberCliente());
        stmt.setDouble(7, cliente.getDebeCliente());
        stmt.setInt(8, cliente.getIdCliente());

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
            int id = rs.getInt("clId");
            String nombre = rs.getString("clNombre");
            String direccion = rs.getString("cldireccion");
            String telefono = rs.getString("cltelefono");
            String email = rs.getString("clemail");
            String nit = rs.getString("clNit");
            Double haber = rs.getDouble("clHaber");
            Double debe = rs.getDouble("clDebe");

            cliente.setIdCliente(id);
            cliente.setNombreCliente(nombre);
            cliente.setEstatusCliente(direccion);
            cliente.setTelefonoCliente(telefono);
            cliente.setEmailCliente(email);
            cliente.setNitCliente(nit);
            cliente.setHaberCliente(haber);
            cliente.setDebeCliente(debe);

            System.out.println("Registro consultado: " + cliente);                

        }

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }

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
    rs = stmt.executeQuery();
    while (rs.next()) {
        int Id = rs.getInt("clId");
        String Nombre = rs.getString("clNombre");
        String direccion = rs.getString("cldireccion");
        String Telefono = rs.getString("cltelefono");
        String Email = rs.getString("clemail");
        String Nit = rs.getString("clNit");
        Double Haber = rs.getDouble("clHaber");
        Double Debe = rs.getDouble("clDebe");

        cliente.setIdCliente(Id);
        cliente.setNombreCliente(Nombre);
        cliente.setEstatusCliente(direccion);
        cliente.setTelefonoCliente(Telefono);
        cliente.setEmailCliente(Email);
        cliente.setNitCliente(Nit);
        cliente.setHaberCliente(Haber);
        cliente.setDebeCliente(Debe);

        System.out.println("registro consultado: " + cliente);                
    }
} catch (SQLException ex) {
    ex.printStackTrace(System.out);
} finally {
    Conexion.close(rs);
    Conexion.close(stmt);
    Conexion.close(conn);
}

return cliente;


    }    
}
