/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package Ventas.Modelo;
import Ventas.Controlador.clsCotizacion;
import Seguridad.Modelo.Conexion;
import Ventas.Vista.frmConsultaCotizacion;
import Ventas.Vista.frmConsultaCotizacionDetalle;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private static final String SQL_SELECT_COT = "SELECT cotid, clId, venid, cotfecha, cotTotalGeneral, cotEstatus FROM tbl_cotizacion";
    private static final String SQL_SELECT_COTDET = "SELECT cotid, proCodigo, proPrecios, cotprodcantidad, cotTotalInd FROM tbl_cotdetalle";
    private static final String SQL_SELECT_COT2 = "SELECT clId, cotfecha, cotTotalGeneral FROM tbl_cotizacion";
    private static final String SQL_SELECT_COTDET2 = "SELECT proCodigo, proPrecios, cotprodcantidad, cotTotalInd FROM tbl_cotdetalle";
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
            String query = "INSERT INTO tbl_cotizacion (clId, venid, cotfecha, cotTotalGeneral, cotEstatus) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            String estatus = "Registrada";
            statement.setInt(1, idCliente);
            statement.setInt(2, idVendedor);
            statement.setDate(3, java.sql.Date.valueOf(fecha));
            statement.setDouble(4, total);
            statement.setString(5, estatus);
            
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
    
    public List<clsCotizacion> consultaCotizaciones() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsCotizacion> cotizaciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            String estatus = "Registrada";
            stmt = conn.prepareStatement(SQL_SELECT_COT+ " WHERE cotEstatus ='"+estatus+"'");
            rs = stmt.executeQuery();
            while (rs.next()) {

                int IdCot = rs.getInt("cotid");
                int IdCliente = rs.getInt("clId");
                int IdVendedor = rs.getInt("venid");
                String Fecha = rs.getString("cotFecha");
                double Total = rs.getDouble("cotTotalGeneral");
                String status = rs.getString("cotEstatus");
                
                clsCotizacion cotizacion = new clsCotizacion();
                cotizacion.setIdCot(IdCot);
                cotizacion.setIdCliente(IdCliente);
                cotizacion.setIdVendedor(IdVendedor);
                cotizacion.setFechaCot(Fecha);
                cotizacion.setTotalCot(Total);
                cotizacion.setEstatusCot(status);
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
    
    public List<clsCotizacion> consultaCotizacionesDetalle(int cotid) {

          Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    List<clsCotizacion> cotizaciones = new ArrayList<>();

    try {
        conn = Conexion.getConnection();

        // Reemplaza el parámetro en la consulta SQL
        String sql = SQL_SELECT_COTDET + " WHERE cotid ='"+cotid+"'";
        stmt = conn.prepareStatement(sql);
        
        rs = stmt.executeQuery();
        
        while (rs.next()) {
            
            int IdCot = rs.getInt("cotid");
            int Codigo = rs.getInt("proCodigo");
            double Precio = rs.getDouble("proPrecios");
            int Cantidad = rs.getInt("cotprodcantidad");
            double Total = rs.getDouble("cotTotalInd");

            
            clsCotizacion cotizacion = new clsCotizacion();
            cotizacion.setIdCot(IdCot);
            cotizacion.setIdProducto(Codigo);
            cotizacion.setPrecioProducto(Precio);
            cotizacion.setCantidadProducto(Cantidad);
            cotizacion.setTotalCot(Total);
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
    public void registroPedidoCot(int cotid) {

        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtUpdate = null;
        ResultSet rs = null;
        int Id = 0;
        String fechita = "";
        double Tot = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_COT2+ " WHERE cotid ='"+cotid+"'");
            rs = stmt.executeQuery();
                if (rs.next()) {
        int IdCliente = rs.getInt("clId");
        String Fecha = rs.getString("cotFecha");
        double Total = rs.getDouble("cotTotalGeneral");
        Id = IdCliente;
        fechita = Fecha;
        Tot = Total;}
            /*String sqlInsert = "INSERT INTO tbl_pedido (clid, pedfecha, pedTotalGeneral) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sqlInsert);
            stmt.setInt(1, IdCliente);
            stmt.setDate(2, java.sql.Date.valueOf(Fecha));
            stmt.setDouble(3, Total);*/
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        PreparedStatement stmtInsert = null;
        try {
    conn = Conexion.getConnection();
    String sqlInsert = "INSERT INTO tbl_pedido (clid, pedfecha, pedTotalGeneral, pedEstatus) VALUES (?, ?, ?, ?)";
    stmtInsert = conn.prepareStatement(sqlInsert);
    // Obtener la fecha actual
LocalDate fechaActual = LocalDate.now();
String status = "Pendiente";
// Convertir LocalDate a java.sql.Date
java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaActual);
    // Establece los valores en los parámetros de la sentencia INSERT
    stmtInsert.setInt(1, Id);
    stmtInsert.setDate(2, fechaSQL);
    stmtInsert.setDouble(3, Tot);
    stmtInsert.setString(4, status);
    
    // Ejecuta la sentencia INSERT
    int filasInsertadas = stmtInsert.executeUpdate();
    
    // Verifica el resultado de la inserción
    if (filasInsertadas > 0) {
        System.out.println("Inserción exitosa");
    } else {
        System.out.println("No se pudo insertar");
    }
    String estatus = "Pedido";
    stmtUpdate = conn.prepareStatement("UPDATE tbl_cotizacion SET cotEstatus = ?  WHERE cotid ='"+cotid+"'");
                stmtUpdate.setString(1, estatus);
                stmtUpdate.executeUpdate();
            
} catch (SQLException ex) {
    ex.printStackTrace(System.out);
} finally {
    Conexion.close(stmtInsert);
    Conexion.close(conn);
}

    }
    
        public void registroPedidoCotDet(int cotid) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PreparedStatement stmtInsert = null;
        PreparedStatement stmtUpdate = null;
        int Id = 0;
        double precio =0;
        int quantity = 0;
        double Tot = 0;
        boolean suficientesExistencias = true; // Variable para realizar seguimiento de las existencias
            try {
        conn = Conexion.getConnection();
        conn.setAutoCommit(false); // Desactivar el modo de autocommit

        // Verificar existencias preliminarmente
        stmt = conn.prepareStatement(SQL_SELECT_COTDET2 + " WHERE cotid = ?");
        stmt.setInt(1, cotid);
        rs = stmt.executeQuery();
        while (rs.next()) {
            int IdCliente = rs.getInt("proCodigo");
            int cantidad = rs.getInt("cotprodcantidad");

            // Verificar existencias del producto
            int existencias = verificarExistencias(IdCliente);
            if (existencias < cantidad) {
                suficientesExistencias = false;
                break; // Detener el bucle si un producto no tiene suficientes existencias
            }
        }

        if (!suficientesExistencias) {
            JOptionPane.showMessageDialog(null, "No hay existencias suficientes para realizar este pedido", "Error", JOptionPane.ERROR_MESSAGE);
            // Eliminar el registro en tbl_pedido
            stmt = conn.prepareStatement("DELETE FROM tbl_pedido WHERE pedid = ?");
            stmt.setInt(1, obtenerUltimoIdPedido());
            stmt.executeUpdate();
        } else {
            // Todos los productos tienen suficientes existencias, proceder con el registro
            stmtInsert = conn.prepareStatement("INSERT INTO tbl_pedidodetalle (pedid, proCodigo, proPrecios, prodcantidad, pedTotalInd) VALUES (?, ?, ?, ?, ?)");

            stmt = conn.prepareStatement(SQL_SELECT_COTDET2 + " WHERE cotid = ?");
            stmt.setInt(1, cotid);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int IdCliente = rs.getInt("proCodigo");
                double price = rs.getDouble("proPrecios");
                int cantidad = rs.getInt("cotprodcantidad");
                double Total = rs.getDouble("cotTotalInd");
                Id = IdCliente;
                precio = price;
                quantity = cantidad;
                Tot = Total;

                // Establece los valores en los parámetros de la sentencia INSERT
                int IdPedido = obtenerUltimoIdPedido();
                stmtInsert.setInt(1, IdPedido);
                stmtInsert.setInt(2, Id);
                stmtInsert.setDouble(3, precio);
                stmtInsert.setInt(4, quantity);
                stmtInsert.setDouble(5, Tot);

                // Ejecuta la sentencia INSERT
                int filasInsertadas = stmtInsert.executeUpdate();

                // Verifica el resultado de la inserción
                if (filasInsertadas > 0) {
                    
                    System.out.println("Inserción exitosa");
                } else {
                    System.out.println("No se pudo insertar");
                }

                // Actualiza las existencias en la tabla tbl_productos
                stmtUpdate = conn.prepareStatement("UPDATE tbl_productos SET proExistencias = proExistencias - ? WHERE proCodigo = ?");
                stmtUpdate.setInt(1, quantity);
                stmtUpdate.setInt(2, Id);
                stmtUpdate.executeUpdate();
            }
            int IdPedido = obtenerUltimoIdPedido();
            JOptionPane.showMessageDialog(null, "Pedido #" + IdPedido + " registrado con éxito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        }

        // Realiza el commit explícito
        conn.commit();
    } catch (SQLException ex) {
        ex.printStackTrace();
        // En caso de excepción, realizar rollback y eliminar el registro en tbl_pedido
        try {
            if (conn != null) {
                conn.rollback();
                stmt = conn.prepareStatement("DELETE FROM tbl_pedido WHERE pedid = ?");
                stmt.setInt(1, obtenerUltimoIdPedido());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(stmtUpdate);
        Conexion.close(stmtInsert);
        Conexion.close(conn);
    }

}
public int obtenerUltimoIdPedido() {
        int cotizacionId = 0;
        
        try (Connection conn = Conexion.getConnection()) {
            String query = "SELECT MAX(pedid) FROM tbl_pedido";
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

}