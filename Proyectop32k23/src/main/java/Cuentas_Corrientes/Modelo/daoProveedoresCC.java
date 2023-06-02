package Cuentas_Corrientes.Modelo;

import Cuentas_Corrientes.Controlador.clsProveedoresCC;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author visitante
 Hecho por: LUIS DIEGO CORTEZ MÉRIDA, 9959-20-7425
 */
public class daoProveedoresCC {

    private static final String SQL_SELECT = "SELECT prID, prFecha, prNombre, prNit, prNoFactura, prTotalFactura FROM tbl_Proveedores";
    private static final String SQL_INSERT = "INSERT INTO tbl_proveedores(prId,prFecha,prNombre,prNit,prNoFactura,prTotalFactura) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_proveedores SET prId=?,prFecha=?,prNombre=?,prNit=?,prNoFactura=?,prTotalFactura=? WHERE prId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_proveedores WHERE prId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT prId,prFecha,prNombre,prNit,prNoFactura,prTotalFactura FROM tbl_proveedores WHERE prNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT prId,prFecha,prNombre,prNit,prNoFactura,prTotalFactura FROM tbl_proveedores WHERE prId = ?";    

    public List<clsProveedoresCC> consultaProveedores() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsProveedoresCC> proveedoresCC = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("prID");
                String fecha = rs.getString("prFecha");
                String nombre = rs.getString("prNombre");
                String nit = rs.getString("prNit");
                String noFactura = rs.getString("prNoFactura");
                double TotFactura = rs.getDouble("prTotalFactura");
                
                clsProveedoresCC proveedorCC = new clsProveedoresCC();
                proveedorCC.setIdProv(id);
                proveedorCC.setFechaProv(fecha);
                proveedorCC.setNombreProv(nombre);
                proveedorCC.setNitProv(nit);
                proveedorCC.setFactProv(noFactura);
                proveedorCC.setTotFacturaProv(TotFactura);
                proveedoresCC.add(proveedorCC);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return proveedoresCC;
    }
public int ingresaProveedor(clsProveedoresCC prov) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, prov.getIdProv());
            stmt.setString(2, prov.getFechaProv());
            stmt.setString(3, prov.getNombreProv());
            stmt.setString(4, prov.getNitProv());
            stmt.setString(5, prov.getFactProv());
            stmt.setDouble(6, prov.getTotFacturaProv());
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
public int actualizaProveedor(clsProveedoresCC prov) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, prov.getIdProv());
            stmt.setString(2, prov.getFechaProv());
            stmt.setString(3, prov.getNombreProv());
            stmt.setString(4, prov.getNitProv());
            stmt.setString(5, prov.getFactProv());
            stmt.setDouble(6, prov.getTotFacturaProv());
            stmt.setInt(7, prov.getIdProv());
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
public int borrarProveedor(clsProveedoresCC prov) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, prov.getIdProv());
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
    public clsProveedoresCC consultaProveedorNombre(clsProveedoresCC prov) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + prov);
            stmt = conn.prepareStatement(SQL_SELECT_ID);            
            stmt.setInt(1, prov.getIdProv());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("prID");
                String fecha = rs.getString("prFecha");
                String nombre = rs.getString("prNombre");
                String nit = rs.getString("prNit");
                String noFactura = rs.getString("prNoFactura");
                double TotFactura = rs.getDouble("prTotalFactura");
                prov.setIdProv(id);
                prov.setFechaProv(fecha);
                prov.setNombreProv(nombre);
                prov.setNitProv(nit);
                prov.setFactProv(noFactura);
                prov.setTotFacturaProv(TotFactura);
                System.out.println(" registro consultado: " + prov);                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return prov;
    }   
    public clsProveedoresCC consultaProveedorId(clsProveedoresCC prov) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + prov);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, prov.getIdProv());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("prID");
                String fecha = rs.getString("prFecha");
                String nombre = rs.getString("prNombre");
                String nit = rs.getString("prNit");
                String noFactura = rs.getString("prNoFactura");
                double TotFactura = rs.getDouble("prTotalFactura");
                prov.setIdProv(id);
                prov.setFechaProv(fecha);
                prov.setNombreProv(nombre);
                prov.setNitProv(nit);
                prov.setFactProv(noFactura);
                prov.setTotFacturaProv(TotFactura);
                System.out.println(" registro consultado: " + prov);                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return prov;
    }    
}