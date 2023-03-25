/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Meyglin del Rosario Rosales Ochoa Carne: 9959-21-4490
package Seguridad.Modelo;

import Seguridad.Controlador.clsPerfil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPerfil {


    private static final String SQL_SELECT = "SELECT perid, pernombre, perestatus FROM tbl_perfil";
    private static final String SQL_INSERT = "INSERT INTO tbl_perfil(pernombre, perestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_perfil SET pernombre=?, perestatus=? WHERE perid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_perfil WHERE perid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT perid, pernombre, perestatus FROM tbl_perfil WHERE pernombre = ?";
    private static final String SQL_SELECT_ID = "SELECT perid, pernombre, perestatus FROM tbl_perfil WHERE perid = ?";    

    public List<clsPerfil> consultaPerfil() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsPerfil> perfiles = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("perid");
                String nombre = rs.getString("pernombre");
                String estatus = rs.getString("perestatus");
                clsPerfil perfil = new clsPerfil();
                perfil.setIdPerfil(id);
                perfil.setNombrePerfil(nombre);
                perfil.setEstatusPerfil(estatus);
                perfiles.add(perfil);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return perfiles;
    }

    public int ingresaPerfil(clsPerfil perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, perfil.getNombrePerfil());
            stmt.setString(2, perfil.getEstatusPerfil());


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


    public int actualizaPerfil(clsPerfil perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, perfil.getNombrePerfil());
            stmt.setString(2, perfil.getEstatusPerfil());
            stmt.setInt(3, perfil.getIdPerfil());


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


    public int borrarPerfil(clsPerfil perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, perfil.getIdPerfil());

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


    public clsPerfil consultaPerfilPorNombre(clsPerfil perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + perfil);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, perfil.getIdPerfil());            
            stmt.setString(1, perfil.getNombrePerfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("perid");
                String nombre = rs.getString("pernombre");
                String estatus = rs.getString("perestatus");

                //perfil = new clsPerfil();
                perfil.setIdPerfil(id);
                perfil.setNombrePerfil(nombre);
                perfil.setEstatusPerfil(estatus);
                System.out.println(" registro consultado: " + perfil);                

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

        return perfil;
    }
    public clsPerfil consultaPerfilPorId(clsPerfil perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + perfil);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, perfil.getIdPerfil());            
            //stmt.setString(1, perfil.getNombrePerfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("perid");
                String nombre = rs.getString("pernombre");
                String estatus = rs.getString("perestatus");

                //perfil = new clsPerfil();
                perfil.setIdPerfil(id);
                perfil.setNombrePerfil(nombre);
                perfil.setEstatusPerfil(estatus);
                System.out.println(" registro consultado: " + perfil);                

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

        return perfil;

    }    
}
