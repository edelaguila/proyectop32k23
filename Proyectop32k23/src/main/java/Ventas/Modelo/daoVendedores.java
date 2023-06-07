/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//María José Véliz Ochoa 
//9959-21-5909
//daoVendedores

package Ventas.Modelo;

import Ventas.Controlador.clsClientes;
import Ventas.Controlador.clsVendedores;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class daoVendedores {
   private static final String SQL_SELECT = "SELECT venid, vennombre, vendireccion, ventelefono, venemail, venEstatus FROM tbl_vendedores";
    private static final String SQL_INSERT = "INSERT INTO tbl_vendedores(vennombre, vendireccion, ventelefono, venemail, venEstatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_vendedores SET vennombre=?, vendireccion=?, ventelefono=?, venemail=?, venEstatus=? WHERE venid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_vendedores WHERE venid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT venid, vennombre, vendireccion, ventelefono, venemail, venEstatus FROM tbl_vendedores WHERE vennombre = ?";
    private static final String SQL_SELECT_ID = "SELECT venid, vennombre, vendireccion, ventelefono, venemail, venEstatus  FROM tbl_vendedores WHERE venid = ?";    

    public List<clsVendedores> consultaVendedor() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsVendedores> vendedores = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("venid");
                String nombre = rs.getString("vennombre");
                String direccion = rs.getString("vendireccion");
                String telefono = rs.getString("ventelefono");
                String email = rs.getString("venemail");
                String estatus = rs.getString("venEstatus");
                clsVendedores vendedor = new clsVendedores();
                vendedor.setIdVendedor(id);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireccionVendedor(direccion);
                vendedor.setTelefonoVendedor(telefono);
                vendedor.setEmailVendedor(email);
                vendedor.setEstatusVendedor(estatus);
                vendedores.add(vendedor);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return vendedores;
    }

    public int ingresaVendedor(clsVendedores vendedor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setString(2, vendedor.getDireccionVendedor());
            stmt.setString(3, vendedor.getTelefonoVendedor());
            stmt.setString(4, vendedor.getEmailVendedor());
            stmt.setString(5, vendedor.getEstatusVendedor());

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


    public int actualizaVendedor(clsVendedores vendedor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, vendedor.getNombreVendedor());
            stmt.setString(2, vendedor.getDireccionVendedor());
            stmt.setString(3, vendedor.getTelefonoVendedor());
            stmt.setString(4, vendedor.getEmailVendedor());
            stmt.setString(5, vendedor.getEstatusVendedor());
            stmt.setInt(6, vendedor.getIdVendedor());

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


    public int borrarVendedor (clsVendedores vendedor){

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, vendedor.getIdVendedor());

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


    public clsVendedores consultaVendedorPorNombre(clsVendedores vendedor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + vendedor);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, perfil.getIdPerfil());            
            stmt.setString(1, vendedor.getNombreVendedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("venid");
                String nombre = rs.getString("vennombre");
                String direccion = rs.getString("vendireccion");
                String telefono = rs.getString("ventelefono");
                String email = rs.getString("venemail");
                String estatus = rs.getString("venEstatus");
                //perfil = new clsPerfil();
       
                vendedor.setIdVendedor(id);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireccionVendedor(direccion);
                vendedor.setTelefonoVendedor(telefono);
                vendedor.setEmailVendedor(email);
                vendedor.setEstatusVendedor(estatus);
                System.out.println(" registro consultado: " + vendedor);                

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

        return vendedor;
    }
    public clsVendedores consultaVendedorPorId(clsVendedores vendedor) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + vendedor);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, vendedor.getIdVendedor());            

            rs = stmt.executeQuery();
            while (rs.next()) {
                  int id = rs.getInt("venid");
                String nombre = rs.getString("vennombre");
                String direccion = rs.getString("vendireccion");
                String telefono = rs.getString("ventelefono");
                String email = rs.getString("venemail");
                String estatus = rs.getString("venEstatus");
       
                vendedor.setIdVendedor(id);
                vendedor.setNombreVendedor(nombre);
                vendedor.setDireccionVendedor(direccion);
                vendedor.setTelefonoVendedor(telefono);
                vendedor.setEmailVendedor(email);
                vendedor.setEstatusVendedor(estatus);
                System.out.println(" registro consultado: " + vendedor);                

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

        return vendedor;

    }    
}
 
