/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//María José Véliz Ochoa 
//9959-21-5909
//daoVendedores

package Ventas.Modelo;
import Ventas.Controlador.clsFacturas;
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
public class daoFacturas {
    String usuariobd = "root";
    String contrabd = "";
    private static final String SQL_SELECT = "SELECT proCodigo, proNombre, proPrecios, proExistencias FROM tbl_productos";
    private static final String SQL_SELECT_COT = "SELECT facid, pedid, clId, venid, tieid, facfecha, facTotalGeneral, facEstatus FROM tbl_factura";
    private static final String SQL_SELECT_COTDET = "SELECT facid, proCodigo, proPrecios, facprodcantidad, factdescuento, facimpuestos, factotalInd FROM tbl_facturadetalle";
    private static final String SQL_SELECT_COT2 = "SELECT clId, facfecha, facTotalGeneral FROM tbl_factura";
    private static final String SQL_SELECT_COTDET2 = "SELECT proCodigo, proPrecios, cotprodcantidad, cotTotalInd FROM tbl_facturadetalle";
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
      
      public List<clsFacturas> consultaProducto() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsFacturas> productos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int Id = rs.getInt("proCodigo");
                String Nombre = rs.getString("proNombre");
                double Precio = rs.getDouble("proPrecios");
                int Existencias = rs.getInt("proExistencias");
                
                clsFacturas producto = new clsFacturas();
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
  
  public void registrarCotizacion(int idCliente, int idVendedor, String idTienda, LocalDate fecha, double total) {
        try (Connection conn = Conexion.getConnection()) {
            String query = "INSERT INTO tbl_factura (clId, venid, tieid, facfecha, facTotalGeneral, facEstatus) VALUES (?, ?, ?, ?, ?, ?)";
            String query2 = "SELECT tieid FROM tbl_tienda WHERE tienombre = ?";
            String query3 = "SELECT clDebe, clHaber FROM tbl_cliente WHERE clId = ?";
            double clDebe = 0;
            double clHaber = 0;
            String estatus = "Facturado";
            PreparedStatement stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1, idTienda);
            ResultSet resultado = stmt2.executeQuery();
            resultado.next();   
            int tieid = resultado.getInt("tieid");;
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idCliente);
            statement.setInt(2, idVendedor);
            statement.setInt(3, tieid);
            statement.setDate(4, java.sql.Date.valueOf(fecha));
            statement.setDouble(5, total); 
            statement.setString(6, estatus);  
            
            PreparedStatement stmt3 = conn.prepareStatement(query3);
            stmt3.setInt(1, idCliente);
            ResultSet resultado3 = stmt3.executeQuery();
            resultado3.next();
            clDebe = resultado3.getDouble("clDebe");
            clHaber = resultado3.getDouble("clHaber");              
        clDebe += total;
        
        String updateQuery = "UPDATE tbl_cliente SET clDebe = ? WHERE clId = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
        updateStmt.setDouble(1, clDebe);
        updateStmt.setInt(2, idCliente);
        updateStmt.executeUpdate();
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerUltimoIdCotizacion() {
        int cotizacionId = 0;
        
        try (Connection conn = Conexion.getConnection()) {
            String query = "SELECT MAX(facid) FROM tbl_factura";
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
    
    public void registrarCotizacionDetalle(int cotizacionId, DefaultTableModel model, double descuento) {
        try (Connection conn = Conexion.getConnection()) {
            String query = "INSERT INTO tbl_facturadetalle (facid, proCodigo, proPrecios, facprodcantidad, factdescuento, facimpuestos, factotalInd) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            PreparedStatement stmtUpdate = null; 
            int rowCount = model.getRowCount();
            
            for (int i = 0; i < rowCount; i++) {
                int codigoProducto = (int) model.getValueAt(i, 0);
                double precioProducto = obtenerPrecioProducto(codigoProducto);
                int cantidadProducto = (int) model.getValueAt(i, 1);
                double descuentoFac = descuento;
                double impuesto = 0.12;
                double totalIndividual = (double) model.getValueAt(i, 4);
                double descuentocalculado = (double) model.getValueAt(i, 2);
                double impuestocalculado = (double) model.getValueAt(i, 3);
                statement.setInt(1, cotizacionId);
                statement.setInt(2, codigoProducto);
                statement.setDouble(3, precioProducto);
                statement.setInt(4, cantidadProducto);
                statement.setDouble(5, descuentocalculado);
                statement.setDouble(6, impuestocalculado);
                statement.setDouble(7, totalIndividual);
                
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
    
    public List<clsFacturas> consultaCotizaciones() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsFacturas> cotizaciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            String estatus = "Facturado";
            stmt = conn.prepareStatement(SQL_SELECT_COT+ " WHERE facEstatus ='"+estatus+"'");
            rs = stmt.executeQuery();
            while (rs.next()) {

                
                int IdFactura = rs.getInt("facid");
                int IdPedido = rs.getInt("pedid");
                int IdCliente = rs.getInt("clId");
                int IdVendedor = rs.getInt("venid");
                int IdTienda = rs.getInt("tieid");
                String Fecha = rs.getString("facfecha");
                double Total = rs.getDouble("facTotalGeneral");
                
                clsFacturas cotizacion = new clsFacturas();
                cotizacion.setIdFactura(IdFactura);
                cotizacion.setIdPedido(IdPedido);
                cotizacion.setIdCliente(IdCliente);
                cotizacion.setIdVendedor(IdVendedor);
                cotizacion.setIdTienda(IdTienda);
                cotizacion.setFechaFactura(Fecha);
                cotizacion.setTotalFactura(Total);
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
    
    public List<clsFacturas> consultaCotizacionesDetalle(int cotid) {

          Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    List<clsFacturas> cotizaciones = new ArrayList<>();

    try {
        conn = Conexion.getConnection();

        // Reemplaza el parámetro en la consulta SQL
        String sql = SQL_SELECT_COTDET + " WHERE facid ='"+cotid+"'";
        stmt = conn.prepareStatement(sql);
        
        rs = stmt.executeQuery();
        
        while (rs.next()) {
            
            int IdFactura = rs.getInt("facid");
            int Codigo = rs.getInt("proCodigo");
            double Precio = rs.getDouble("proPrecios");
            double Cantidad = rs.getInt("facprodcantidad");
            double Descuento = rs.getDouble("factdescuento");
            double Impuestos = rs.getDouble("facimpuestos");
            double Total = rs.getDouble("factotalInd");

            
            clsFacturas cotizacion = new clsFacturas();
            cotizacion.setIdFactura(IdFactura);
            cotizacion.setCodigoProducto(Codigo);
            cotizacion.setPrecioProducto(Precio);
            cotizacion.setCantidadProducto(Cantidad);
            cotizacion.setDescuentoFactura(Descuento);
            cotizacion.setImpuestosFactura(Impuestos);
            
            
            cotizacion.setTotalIndividualFactura(Total);
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
    String sqlInsert = "INSERT INTO tbl_pedido (clid, pedfecha, pedTotalGeneral) VALUES (?, ?, ?)";
    stmtInsert = conn.prepareStatement(sqlInsert);
    // Obtener la fecha actual
LocalDate fechaActual = LocalDate.now();

// Convertir LocalDate a java.sql.Date
java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaActual);
    // Establece los valores en los parámetros de la sentencia INSERT
    stmtInsert.setInt(1, Id);
    stmtInsert.setDate(2, fechaSQL);
    stmtInsert.setDouble(3, Tot);
    
    // Ejecuta la sentencia INSERT
    int filasInsertadas = stmtInsert.executeUpdate();
    
    // Verifica el resultado de la inserción
    if (filasInsertadas > 0) {
        System.out.println("Inserción exitosa");
    } else {
        System.out.println("No se pudo insertar");
    }
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

public ArrayList<String> obtenerNombresUsuarios() {
    ArrayList<String> nombresUsuarios = new ArrayList<>();

    try {
        // 2. Crear el objeto Statement
        try ( // 1. Conectar a la base de datos
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", usuariobd, contrabd); // 2. Crear el objeto Statement
                Statement stmt = con.createStatement()) {
            
            // 3. Ejecutar la consulta SQL
            String sql = "SELECT tienombre FROM tbl_tienda";
            // 4. Recuperar los resultados
            try (ResultSet rs = stmt.executeQuery(sql)) {
                // 4. Recuperar los resultados
                while (rs.next()) {
                    // 5. Agregar los elementos al ArrayList
                    nombresUsuarios.add(rs.getString("tienombre"));
                }
                // 6. Cerrar la conexión
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return nombresUsuarios;
}

   
        public void cancelarPedido(int cotid, int idcliente) {

    Connection conn = null;
    ResultSet rs = null;
    double haber = 0.0;
    PreparedStatement updateStmt = null;
    PreparedStatement clienteStmt = null;
    PreparedStatement clienteStmt2 = null;
    PreparedStatement productoStmt = null;
    
    try {
        conn = Conexion.getConnection();
        
        clienteStmt2 = conn.prepareStatement("SELECT clHaber FROM tbl_cliente WHERE clid = ?");
        clienteStmt2.setInt(1, idcliente);
        rs = clienteStmt2.executeQuery();
        
        if (rs.next()) {
            haber = rs.getDouble("clHaber");
        }
        
        String estatus = "Devolución";
        String updateQuery = "UPDATE tbl_factura SET facEstatus = ? WHERE facid = ?";
        updateStmt = conn.prepareStatement(updateQuery);
        updateStmt.setString(1, estatus);
        updateStmt.setInt(2, cotid);
        int rowsUpdated = updateStmt.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("La columna se ha actualizado correctamente.");
        } else {
            System.out.println("No se encontró ninguna fila para actualizar.");
        }
        
        String facturaQuery = "SELECT facTotalGeneral FROM tbl_factura WHERE facid = ?";
        PreparedStatement facturaStmt = conn.prepareStatement(facturaQuery);
        facturaStmt.setInt(1, cotid);
        ResultSet facturaRs = facturaStmt.executeQuery();
        
        double facTotalGeneral = 0.0;
        if (facturaRs.next()) {
            facTotalGeneral = facturaRs.getDouble("facTotalGeneral");
        }
        
        String clienteUpdateQuery = "UPDATE tbl_cliente SET clHaber = clHaber + ? WHERE clid = ?";
        clienteStmt = conn.prepareStatement(clienteUpdateQuery);
        clienteStmt.setDouble(1, facTotalGeneral);
        clienteStmt.setInt(2, idcliente);
        int rowsUpdated2 = clienteStmt.executeUpdate();
        
        if (rowsUpdated2 > 0) {
            System.out.println("La columna se ha actualizado correctamente.");
        } else {
            System.out.println("No se encontró ninguna fila para actualizar.");
        }
        
        String detalleQuery = "SELECT proCodigo, facprodcantidad FROM tbl_facturadetalle WHERE facid = ?";
        PreparedStatement detalleStmt = conn.prepareStatement(detalleQuery);
        detalleStmt.setInt(1, cotid);
        ResultSet detalleRs = detalleStmt.executeQuery();
        
        String productoUpdateQuery = "UPDATE tbl_productos SET proExistencias = proExistencias + ? WHERE proCodigo = ?";
        productoStmt = conn.prepareStatement(productoUpdateQuery);
        
        while (detalleRs.next()) {
            int proCodigo = detalleRs.getInt("proCodigo");
            int facprodcantidad = detalleRs.getInt("facprodcantidad");

            productoStmt.setInt(1, facprodcantidad);
            productoStmt.setInt(2, proCodigo);
            productoStmt.executeUpdate();
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(updateStmt);
        Conexion.close(conn);
    }
        }

}
 
