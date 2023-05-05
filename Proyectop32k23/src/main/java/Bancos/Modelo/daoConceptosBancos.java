/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Modelo;

import Bancos.Controlador.clsConceptosBancos;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoConceptosBancos {

    private static final String SQL_SELECT = "SELECT concId, concNombre, concDescripcion, concEfecto, concEstatus FROM tbl_conceptos";
    private static final String SQL_INSERT = "INSERT INTO tbl_conceptos(concId, concNombre, concDescripcion, concEfecto, concEstatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_conceptos SET concNombre=?, concDescripcion=?,  concEfecto=?, concEstatus=?  WHERE concId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_conceptos WHERE concId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT concId, concNombre, concDescripcion, concEfecto, concEstatus FROM tbl_conceptos WHERE concNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT concId, concNombre, concDescripcion, concEfecto, concEstatus FROM tbl_conceptos WHERE concId = ?";
     

    public List<clsConceptosBancos> consultaConcepto() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsConceptosBancos> conceptos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("concId");
                String nombre = rs.getString("concNombre");
                String descripcion = rs.getString("concDescripcion");
                String efecto = rs.getString("concEfecto");
		String estatus = rs.getString("concEstatus");
                clsConceptosBancos concepto = new clsConceptosBancos();
                concepto.setIdConcepto(id);
                concepto.setNombreConcepto(nombre);
                concepto.setDescripcionConcepto(descripcion);
                concepto.setEfectoConcepto(efecto);
                concepto.setEstatusConcepto(estatus);
                conceptos.add(concepto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return conceptos;
    }

    public int ingresaConcepto(clsConceptosBancos concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, concepto.getIdConcepto());
            stmt.setString(2, concepto.getNombreConcepto());
            stmt.setString(3, concepto.getDescripcionConcepto());
            stmt.setString(4, concepto.getEfectoConcepto());
	    stmt.setString(5, concepto.getEstatusConcepto());
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

    public int actualizaConcepto(clsConceptosBancos concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, concepto.getNombreConcepto());
            stmt.setString(2, concepto.getDescripcionConcepto());
            stmt.setString(3, concepto.getEfectoConcepto());
	    stmt.setString(4, concepto.getEstatusConcepto());
            stmt.setInt(5, concepto.getIdConcepto());
            
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

    public int borrarConcepto(clsConceptosBancos concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, concepto.getIdConcepto());
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

    public clsConceptosBancos consultaConceptoPorNombre(clsConceptosBancos concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + concepto);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, concepto.getNombreConcepto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("concId");
                String nombre = rs.getString("concNombre");
                String descripcion = rs.getString("concDescripcion");
                String efecto = rs.getString("concEfecto");
		String estatus = rs.getString("concEstatus");
                //usuario = new clsUsuario();
                concepto.setIdConcepto(id);
                concepto.setNombreConcepto(nombre);
                concepto.setDescripcionConcepto(descripcion);
                concepto.setEfectoConcepto(efecto);
                concepto.setEstatusConcepto(estatus);
                System.out.println(" registro consultado: " + concepto);                
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
        return concepto;
    }
    public clsConceptosBancos consultaConceptoPorId(clsConceptosBancos concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + concepto);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, concepto.getIdConcepto());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("concId");
                String nombre = rs.getString("concNombre");
                String descripcion = rs.getString("concDescripcion");
                String efecto = rs.getString("concEfecto");
		String estatus = rs.getString("concEstatus");
                //usuario = new clsUsuario();
                concepto.setIdConcepto(id);
                concepto.setNombreConcepto(nombre);
                concepto.setDescripcionConcepto(descripcion);
                concepto.setEfectoConcepto(efecto);
                concepto.setEstatusConcepto(estatus);
                System.out.println(" registro consultado: " + concepto);                
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
        return concepto;
    }    
}
