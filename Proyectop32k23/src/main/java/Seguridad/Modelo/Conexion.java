    package Seguridad.Modelo;

import java.sql.*;

public class Conexion {
<<<<<<< HEAD
private static final String JDBC_URL = "jdbc:mysql://localhost/bdprueba?useSSL=false&serverTimezone=UTC";    
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "12345";
=======

private static final String JDBC_URL = "jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC";    
<<<<<<< HEAD
    private static final String JDBC_USER = "usuprueba";
    private static final String JDBC_PASS = "123456";
  
=======
    private static final String JDBC_USER = "UsuPrueba";
    private static final String JDBC_PASS = "123456";
>>>>>>> 57dc5dc0f34dbaa44fb8c76fb0811adfd8fd3635
   
>>>>>>> 7583f9e4abeb4770049a3adf614c472969544871
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
}
