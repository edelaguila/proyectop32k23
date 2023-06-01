    package Seguridad.Modelo;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;

public class Conexion {

private static final String JDBC_URL = "jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC";    
    private static final String JDBC_USER = "usuprueba";
    private static final String JDBC_PASS = "123456";
    Connection conn = null;
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
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
    //Se agrega codigo para obtener los codigos de diversas tablas dentro de un combobox
    //Victor Josué Jerez Mijangos 9959-21-2081
    public ResultSet consulta (String sql){
        ResultSet res = null;
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            res = pstm.executeQuery();
        }catch (SQLException e){
            System.err.println("Error consulta :" + e.getMessage());
        }
        return res;
    }
    //Codigo para obtener los codigos de las lineas en un combobox
    public DefaultComboBoxModel Obt_CodigoL(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Codigo");
        
        ResultSet res = this.consulta("Select * from tbl_lineas");
        
        try{
            while(res.next()){
                ListaModelo.addElement(res.getString("linCodigo"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }
    //Codigo para obtener los codigos de las marcas en un combobox
    public DefaultComboBoxModel Obt_CodigoM(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Codigo");
        
        ResultSet res = this.consulta("Select * from tbl_marcas");
        
        try{
            while(res.next()){
                ListaModelo.addElement(res.getString("marCodigo"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }
    //Codigo para obtener los codigos de los productos en un combobox
    public DefaultComboBoxModel Obt_CodigoP(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Codigo");
        
        ResultSet res = this.consulta("Select * from tbl_productos");
        
        try{
            while(res.next()){
                ListaModelo.addElement(res.getString("proCodigo"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }
    //Codigo para obtener los codigos de las bodegas en un combobox
    public DefaultComboBoxModel Obt_CodigoB(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Codigo");
        
        ResultSet res = this.consulta("Select * from tbl_bodegas");
        
        try{
            while(res.next()){
                ListaModelo.addElement(res.getString("bodCodigo"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }
    
}
