/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//María José Véliz Ochoa 
//9959-21-5909
//daoVendedores

package Ventas.Modelo;
import Ventas.Controlador.clsPedidos;
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
public class daoPedidos {
    String usuariobd = "root";
    String contrabd = "";
    private static final String SQL_SELECT = "SELECT proCodigo, proNombre, proPrecios, proExistencias FROM tbl_productos";
    private static final String SQL_SELECT_PED = "SELECT pedid, clId, pedfecha, pedTotalGeneral FROM tbl_pedido";
    private static final String SQL_SELECT_PEDDET = "SELECT pedid, proCodigo, proPrecios, prodcantidad, pedTotalInd FROM tbl_pedidodetalle";
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
      
      public List<clsPedidos> consultaProducto() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsPedidos> productos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int Id = rs.getInt("proCodigo");
                String Nombre = rs.getString("proNombre");
                double Precio = rs.getDouble("proPrecios");
                int Existencias = rs.getInt("proExistencias");
                
                clsPedidos producto = new clsPedidos();
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
      
       public List<clsPedidos> consultaPedidos() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsPedidos> cotizaciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PED);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int IdPed = rs.getInt("pedid");
                int IdCliente = rs.getInt("clId");
                String Fecha = rs.getString("pedFecha");
                double Total = rs.getDouble("pedTotalGeneral");
                
                clsPedidos cotizacion = new clsPedidos();
                cotizacion.setIdPed(IdPed);
                cotizacion.setIdCliente(IdCliente);
                cotizacion.setFechaPed(Fecha);
                cotizacion.setTotalPed(Total);
                cotizaciones.add(cotizacion);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cotizaciones;
    }
    
    public List<clsPedidos> consultaPedidosDetalle(int cotid) {

          Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    List<clsPedidos> cotizaciones = new ArrayList<>();

    try {
        conn = Conexion.getConnection();

        // Reemplaza el parámetro en la consulta SQL
        String sql = SQL_SELECT_PEDDET + " WHERE pedid ='"+cotid+"'";
        stmt = conn.prepareStatement(sql);
        
        rs = stmt.executeQuery();
        
        while (rs.next()) {
            
            int IdCot = rs.getInt("pedid");
            int Codigo = rs.getInt("proCodigo");
            double Precio = rs.getDouble("proPrecios");
            int Cantidad = rs.getInt("prodcantidad");
            double Total = rs.getDouble("pedTotalInd");

            
            clsPedidos cotizacion = new clsPedidos();
            cotizacion.setIdPed(IdCot);
            cotizacion.setIdProducto(Codigo);
            cotizacion.setPrecioProducto(Precio);
            cotizacion.setCantidadProducto(Cantidad);
            cotizacion.setTotalPed(Total);
            cotizaciones.add(cotizacion);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return cotizaciones;
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
  
  public void registrarPedido(int idCliente, LocalDate fecha, double total) {
        try (Connection conn = Conexion.getConnection()) {
            String query = "INSERT INTO tbl_pedido (clId, pedfecha, pedTotalGeneral) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idCliente);
            statement.setDate(2, java.sql.Date.valueOf(fecha));
            statement.setDouble(3, total);
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerUltimoIdPedido() {
        int PedidoId = 0;
        
        try (Connection conn = Conexion.getConnection()) {
            String query = "SELECT MAX(pedid) FROM tbl_pedido";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            if (result.next()) {
                PedidoId = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return PedidoId;
    }
    
    public void registrarPedidoDetalle(int pedidoId, DefaultTableModel model) {
        try (Connection conn = Conexion.getConnection()) {
            String query = "INSERT INTO tbl_pedidodetalle (pedid, proCodigo, proPrecios, prodcantidad, pedTotalInd) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            PreparedStatement stmtUpdate = null;            
            int rowCount = model.getRowCount();
            
            for (int i = 0; i < rowCount; i++) {
                int codigoProducto = (int) model.getValueAt(i, 0);
                double precioProducto = obtenerPrecioProducto(codigoProducto);
                int cantidadProducto = (int) model.getValueAt(i, 1);
                double totalIndividual = (double) model.getValueAt(i, 2);
                
                statement.setInt(1, pedidoId);
                statement.setInt(2, codigoProducto);
                statement.setDouble(3, precioProducto);
                statement.setInt(4, cantidadProducto);
                statement.setDouble(5, totalIndividual);
                
                
                // Actualiza las existencias en la tabla tbl_productos
                stmtUpdate = conn.prepareStatement("UPDATE tbl_productos SET proExistencias = proExistencias - ? WHERE proCodigo = ?");
                stmtUpdate.setInt(1, cantidadProducto);
                stmtUpdate.setInt(2, codigoProducto);
                stmtUpdate.executeUpdate();
                
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 
