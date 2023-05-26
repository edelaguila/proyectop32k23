/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Meyglin del Rosario Rosales Ochoa Carne: 9959-21-4490
package Seguridad.Modelo;

import Seguridad.Controlador.clsPerfilUsuario;
import Seguridad.Vista.frmMantenimientoPerfilUsuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author visitante
 */


//Conexion de tablas y combo Box a base de datos trabajado por Carlos Sandoval
public class daoPerfilUsuario {
    String usuariobd = "root";
    String contrabd = "";
    public ArrayList<String> obtenerNombresUsuarios() {
    ArrayList<String> nombresUsuarios = new ArrayList<>();

    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

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
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

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
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

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
 //Boton Asignar todo trabajado por Meyglin del Rosario Rosales Ochoa 
public  void asignartodoPerfilesUsuario(DefaultTableModel modelo, String usuario) {
    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Obtener el usuario seleccionado en el combo box

        // 3. Obtener el usuid del usuario seleccionado en el combo box
        String sql = "SELECT usuid FROM tbl_usuario WHERE usunombre='" + usuario + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int usuid = rs.getInt("usuid");

        // 4. Recorrer los perfiles disponibles en la tabla jTable1
        
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            String pernombre = modelo.getValueAt(i, 0).toString();

            // 5. Obtener el perid del perfil
            sql = "SELECT perid FROM tbl_perfil WHERE pernombre='" + pernombre + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            int perid = rs.getInt("perid");

            // 6. Insertar el registro en tbl_perfilusuario
            sql = "INSERT INTO tbl_perfilusuario (perid, usuid) VALUES (" + perid + ", " + usuid + ")";
            stmt.executeUpdate(sql);
        }

        // 7. Cerrar la conexión y actualizar la tabla jTable2
        rs.close();
        stmt.close();
        con.close();
 

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
   
};




 //Boton Eliminar todo trabajado por Carlos Sandoval
public  void eliminarPerfilesUsuario(DefaultTableModel modelo, String usuario) {
    try {
        // 1. Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);

        // 2. Crear el objeto Statement
        Statement stmt = con.createStatement();

        // 3. Obtener el usuid del usuario seleccionado en el combo box
        String sql = "SELECT usuid FROM tbl_usuario WHERE usunombre='" + usuario + "'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int usuid = rs.getInt("usuid");

        // 4. Recorrer la tabla 2 y eliminar los perfiles asociados al usuario
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String pernombre = modelo.getValueAt(i, 0).toString();
            sql = "SELECT perid FROM tbl_perfil WHERE pernombre='" + pernombre + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            int perid = rs.getInt("perid");
            sql = "DELETE FROM tbl_perfilusuario WHERE usuid=" + usuid + " AND perid=" + perid;
            stmt.executeUpdate(sql);
        }

        // 5. Cerrar la conexión
        rs.close();
        stmt.close();
        con.close();

        // 6. Actualizar la tabla 2


    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

 //Boton Asignar un perfil, trabajado por María José Véliz Ochoa
public  void asignarunPerfilesUsuario(String pernombre, String usuario) {   
            
            try {
               // Conectar a la base de datos
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);
                
                 // 2. Crear el objeto Statement
                PreparedStatement stmt = con.prepareStatement("SELECT perid FROM tbl_perfil WHERE pernombre=?");
                stmt.setString(1, pernombre);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                int perid = rs.getInt("perid");
                
                // Obtener el usuid del usuario seleccionado en el combo box
                stmt = con.prepareStatement("SELECT usuid FROM tbl_usuario WHERE usunombre=?");
                stmt.setString(1, usuario);
                rs = stmt.executeQuery();
                rs.next();
                int usuid = rs.getInt("usuid");
                
                // Insertar el nuevo registro en tbl_perfilusuario
                stmt = con.prepareStatement("INSERT INTO tbl_perfilusuario (perid, usuid) VALUES (?, ?)");
                stmt.setInt(1, perid);
                stmt.setInt(2, usuid);
                stmt.executeUpdate();
                
                // Cerrar la conexión
                rs.close();
                stmt.close();
                con.close();
     
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
         
}
public void eliminarunPerfilesUsuario(String pernombre, String usuario) {   
            
            try {
        // Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", usuariobd, contrabd);
        
        // Obtener el perid del perfil seleccionado
        Statement stmt = con.createStatement();
        String sql = "SELECT perid FROM tbl_perfil WHERE pernombre='" + pernombre + "'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int perid = rs.getInt("perid");
        rs.close();
        stmt.close();

        
        // Obtener el usuid del usuario seleccionado en el combo box
        stmt = con.createStatement();
        sql = "SELECT usuid FROM tbl_usuario WHERE usunombre='" + usuario + "'";
        rs = stmt.executeQuery(sql);
        rs.next();
        int usuid = rs.getInt("usuid");
        rs.close();
        stmt.close();

        
        // Eliminar el registro de la tabla tbl_perfilusuario
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM tbl_perfilusuario WHERE usuid=? AND perid=?");
        pstmt.setInt(1, usuid);
        pstmt.setInt(2, perid);
        pstmt.executeUpdate();
        pstmt.close();

        stmt.close();
        
        // Cerrar la conexión
        con.close();
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
         
}

}

