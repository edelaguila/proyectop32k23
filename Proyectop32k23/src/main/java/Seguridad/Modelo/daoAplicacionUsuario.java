/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsAplicacionUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoAplicacionUsuario {

    private static final String SQL_SELECT = "SELECT aplid, usuid, ins, upd, del, pri FROM tbl_aplicacionusuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_aplicacionusuario(aplid, usuid, ins, upd, del, pri) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_aplicacionusuario SET aplid=?,  ins=?, upd=?, del=?, pri=?  WHERE usuid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_aplicacionusuario WHERE aplid=? AND usuid=?";
    private static final String SQL_SELECT_ID = "SELECT aplid, usuid, ins, upd, del, pri FROM tbl_aplicacionusuario WHERE usuid = ?";        
    private static final String SQL_DETELE_ALL = "DELETE FROM tbl_aplicacionusuario WHERE  usuid=?";
    
    public List<clsAplicacionUsuario> consultaAplicacionUsuarios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsAplicacionUsuario> aplicacionusuarios = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int aid = rs.getInt("aplid");
                int uid = rs.getInt("usuid");
                String registrar = rs.getString("ins");
                String modificar = rs.getString("upd");
		String eliminar = rs.getString("del");
                String imprimir= rs.getString("pri");
                clsAplicacionUsuario aplicacionusuario = new clsAplicacionUsuario();
                aplicacionusuario.setIdAplicacion(aid);
                aplicacionusuario.setIdUsuario(uid);
                aplicacionusuario.setRegAplUsu(registrar);
                aplicacionusuario.setModAplUsu(modificar);
                aplicacionusuario.setEliAplUsu(eliminar);
                aplicacionusuario.setImpAplUsu(imprimir);
                aplicacionusuarios.add(aplicacionusuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return aplicacionusuarios;
    }

    public int ingresaAplicacionUsuario(clsAplicacionUsuario aplicacionusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, aplicacionusuario.getIdAplicacion());
            stmt.setInt(2, aplicacionusuario.getIdUsuario());
            stmt.setString(3, aplicacionusuario.getRegAplUsu());
            stmt.setString(4, aplicacionusuario.getModAplUsu());
            stmt.setString(5, aplicacionusuario.getEliAplUsu());
            stmt.setString(6, aplicacionusuario.getImpAplUsu());

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

    public int actualizaAplicacionUsuario(clsAplicacionUsuario aplicacionusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, aplicacionusuario.getIdAplicacion());
            stmt.setInt(2, aplicacionusuario.getIdUsuario());
            stmt.setString(3, aplicacionusuario.getRegAplUsu());
            stmt.setString(4, aplicacionusuario.getModAplUsu());
            stmt.setString(5, aplicacionusuario.getEliAplUsu());
            stmt.setString(6, aplicacionusuario.getImpAplUsu());
            

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

    public int borrarAplicacionUsuario(clsAplicacionUsuario aplicacionusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacionusuario.getIdAplicacion());
            stmt.setInt(2, aplicacionusuario.getIdUsuario());
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

    public clsAplicacionUsuario consultaAplicacionUsuarioPorId(clsAplicacionUsuario aplicacionusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_ID + " objeto recibido: " + aplicacionusuario);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, aplicacionusuario.getIdUsuario());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int aid = rs.getInt("aplid");
                int uid = rs.getInt("usuid");
                String regAplUsu = rs.getString("ins");
                String modAplUsu = rs.getString("upd");
                String eliAplUsu = rs.getString("del");
                String impAplUsu = rs.getString("pri");

                //aplicacion = new clsAplicacion();
                aplicacionusuario.setIdAplicacion(aid);
                aplicacionusuario.setIdUsuario(uid);
                aplicacionusuario.setRegAplUsu(regAplUsu);
                aplicacionusuario.setModAplUsu(modAplUsu);
                aplicacionusuario.setEliAplUsu(eliAplUsu);
                aplicacionusuario.setImpAplUsu(impAplUsu);
                System.out.println(" registro consultado: " + aplicacionusuario);                
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
        return aplicacionusuario;
    }    
    public int borrarTodoAplicacion(clsAplicacionUsuario aplicacionusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DETELE_ALL);
            stmt = conn.prepareStatement(SQL_DETELE_ALL);
            stmt.setInt(1,aplicacionusuario.getIdUsuario());
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
}
