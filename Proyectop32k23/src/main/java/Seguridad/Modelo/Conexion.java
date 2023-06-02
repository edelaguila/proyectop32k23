    package Seguridad.Modelo;

import java.sql.*;

public class Conexion {

private static final String JDBC_URL = "jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC";    

<<<<<<< HEAD
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Mariano3632";
  
=======
    private static final String JDBC_USER = "UsuPrueba";
    private static final String JDBC_PASS = "123456";

>>>>>>> 5c69f3f4fbc07cde905c19c8877e26fe5693e55a
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
