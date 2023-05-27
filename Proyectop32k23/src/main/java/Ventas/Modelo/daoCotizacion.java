/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//María José Véliz Ochoa 
//9959-21-5909
//daoVendedores

package Ventas.Modelo;
import Ventas.Controlador.clsCotizacion;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maria
 */
public class daoCotizacion {
    String usuariobd = "root";
    String contrabd = "";
    private static final String SQL_SELECT = "SELECT proCodigo, proNombre, proPrecios, proExistencias FROM tbl_productos";
      public int verificarExistencias(int codigoProducto) {
        try {
            // Establecer la conexión a la base de datos
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC",usuariobd, contrabd);

            // Verificar existencias del producto en la base de datos
            String consulta = "SELECT proExistencias FROM tbl_productos WHERE proCodigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setInt(1, codigoProducto);
            ResultSet resultado = statement.executeQuery();
            resultado.next();
            return resultado.getInt("proExistencias");
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
      
      public List<clsCotizacion> consultaProducto() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsCotizacion> productos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int Id = rs.getInt("proCodigo");
                String Nombre = rs.getString("proNombre");
                double Precio = rs.getDouble("proPrecios");
                int Existencias = rs.getInt("proExistencias");
                
                clsCotizacion producto = new clsCotizacion();
                producto.setIdProducto(Id);
                producto.setNombreProducto(Nombre);
                producto.setPrecioProducto(Precio);
                producto.setExistenciaProducto(Existencias);
                productos.add(producto);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return productos;
    }
      
  public double obtenerPrecioProducto(int codigoProducto) {
    double precio = 0.0;

    try {
        // Establecer la conexión a la base de datos
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC",usuariobd, contrabd);

        // Preparar la consulta SQL para obtener el precio del producto
        String query = "SELECT proPrecios FROM tbl_productos WHERE proCodigo = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, codigoProducto);

        // Ejecutar la consulta
        ResultSet rs = stmt.executeQuery();

        // Verificar si se encontró el producto y obtener su precio
        if (rs.next()) {
            precio = rs.getDouble("proPrecios");
        }

        // Cerrar la conexión y liberar los recursos
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return precio;
}
  
  public void registrarCotizacion(int idCliente, int idVendedor, LocalDate fecha, double total) {
        try (Connection conn = Conexion.getConnection()) {
            String query = "INSERT INTO tbl_cotizacion (clId, venid, cotfecha, cotTotalGeneral) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idCliente);
            statement.setInt(2, idVendedor);
            statement.setDate(3, java.sql.Date.valueOf(fecha));
            statement.setDouble(4, total);
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerUltimoIdCotizacion() {
        int cotizacionId = 0;
        
        try (Connection conn = Conexion.getConnection()) {
            String query = "SELECT MAX(cotid) FROM tbl_cotizacion";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            if (result.next()) {
                cotizacionId = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return cotizacionId;
    }
    
    public void registrarCotizacionDetalle(int cotizacionId, DefaultTableModel model) {
        try (Connection conn = Conexion.getConnection()) {
            String query = "INSERT INTO tbl_cotdetalle (cotid, proCodigo, proPrecios, cotprodcantidad, cotTotalInd) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            
            int rowCount = model.getRowCount();
            
            for (int i = 0; i < rowCount; i++) {
                int codigoProducto = (int) model.getValueAt(i, 0);
                double precioProducto = obtenerPrecioProducto(codigoProducto);
                int cantidadProducto = (int) model.getValueAt(i, 1);
                double totalIndividual = (double) model.getValueAt(i, 2);
                
                statement.setInt(1, cotizacionId);
                statement.setInt(2, codigoProducto);
                statement.setDouble(3, precioProducto);
                statement.setInt(4, cantidadProducto);
                statement.setDouble(5, totalIndividual);
                
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 
