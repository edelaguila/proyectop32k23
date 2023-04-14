/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Meyglin del Rosario Rosales Ochoa Carne: 9959-21-4490
package Seguridad.Modelo;

import Seguridad.Controlador.clsPerfilUsuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author visitante
 */
public class daoPerfilUsuario {

    public ArrayList<String> obtenerNombresUsuarios() {
    ArrayList<String> nombresUsuarios = new ArrayList<>();

    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", "UsuPrueba", "progra123");

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Ejecutar la consulta SQL
        String sql = "SELECT usunombre FROM tbl_usuario";
        ResultSet rs = stmt.executeQuery(sql);

        // 4. Recuperar los resultados
        while (rs.next()) {
            // 5. Agregar los elementos al ArrayList
            nombresUsuarios.add(rs.getString("usunombre"));
        }

        // 6. Cerrar la conexión
        rs.close();
        stmt.close();
        con.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return nombresUsuarios;
}
public void cargarTabla(DefaultTableModel modelo) {
    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", "UsuPrueba", "progra123");

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Ejecutar la consulta SQL
        String sql = "SELECT pernombre FROM tbl_perfil";
        ResultSet rs = stmt.executeQuery(sql);

        // 5. Recuperar los resultados y agregarlos al modelo de datos
        while (rs.next()) {
            Object[] fila = new Object[1];
            fila[0] = rs.getString("pernombre");
            modelo.addRow(fila);
        }

        // 6. Cerrar la conexión
        rs.close();
        stmt.close();
        con.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


public ArrayList<String> obtenerPerfilesUsuario(String usuario) {
    ArrayList<String> perfilesUsuario = new ArrayList<>();

    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", "UsuPrueba", "progra123");

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Obtener el usuid del usuario seleccionado en el combo box
        String sql = "SELECT usuid FROM tbl_usuario WHERE usunombre='" + usuario + "'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int usuid = rs.getInt("usuid");

        // 4. Ejecutar la consulta SQL para obtener los perfiles asociados al usuario
        sql = "SELECT pernombre FROM tbl_perfilusuario pu INNER JOIN tbl_perfil p ON pu.perid=p.perid WHERE pu.usuid=" + usuid;
        rs = stmt.executeQuery(sql);

        // 5. Recuperar los resultados
        while (rs.next()) {
            perfilesUsuario.add(rs.getString("pernombre"));
        }

        // 6. Cerrar la conexión
        rs.close();
        stmt.close();
        con.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return perfilesUsuario;
}







}
