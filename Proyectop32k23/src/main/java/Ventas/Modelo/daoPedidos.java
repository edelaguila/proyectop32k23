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
    private static final String SQL_SELECT_PED = "SELECT pedid, clId, pedfecha, pedTotalGeneral, pedEstatus FROM tbl_pedido";
    private static final String SQL_SELECT_PEDDET = "SELECT pedid, proCodigo, proPrecios, prodcantidad, pedTotalInd FROM tbl_pedidodetalle";
    private static final String SQL_SELECT_PED2 = "SELECT clId, pedfecha, pedTotalGeneral FROM tbl_pedido";
    private static final String SQL_SELECT_PEDDET2 = "SELECT proCodigo, proPrecios, prodcantidad, pedTotalInd FROM tbl_pedidodetalle";
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
            String estatus = "Pendiente";
            stmt = conn.prepareStatement(SQL_SELECT_PED+ " WHERE pedEstatus ='"+estatus+"'");
            rs = stmt.executeQuery();
            while (rs.next()) {

                int IdPed = rs.getInt("pedid");
                int IdCliente = rs.getInt("clId");
                String Fecha = rs.getString("pedFecha");
                double Total = rs.getDouble("pedTotalGeneral");
                String status = rs.getString("pedEstatus");
                
                clsPedidos cotizacion = new clsPedidos();
                cotizacion.setIdPed(IdPed);
                cotizacion.setIdCliente(IdCliente);
                cotizacion.setFechaPed(Fecha);
                cotizacion.setTotalPed(Total);
                cotizacion.setEstatusPed(estatus);
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
            String query = "INSERT INTO tbl_pedido (clId, pedfecha, pedTotalGeneral, pedEstatus) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            String estatus = "Pendiente";
            statement.setInt(1, idCliente);
            statement.setDate(2, java.sql.Date.valueOf(fecha));
            statement.setDouble(3, total);
            statement.setString(4, estatus);
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
    
        public int obtenerUltimoIdFactura() {
        int PedidoId = 0;
        
        try (Connection conn = Conexion.getConnection()) {
            String query = "SELECT MAX(facid) FROM tbl_factura";
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
                
                
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void registroPedidoCot(int cotid, int idvendedor, String tienda) {

        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtUpdate = null;
        ResultSet rs = null;
        int Id = 0;
        String fechita = "";
        double Tot = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PED2+ " WHERE pedid ='"+cotid+"'");
            String query2 = "SELECT tieid FROM tbl_tienda WHERE tienombre = ?";
            String query3 = "SELECT clDebe, clHaber FROM tbl_cliente WHERE clId = ?";
            double clDebe = 0;
            double clHaber = 0;
            PreparedStatement stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1, tienda);
            
 
            ResultSet resultado = stmt2.executeQuery();
            resultado.next();   
            int tieid = resultado.getInt("tieid");;
            rs = stmt.executeQuery();
                if (rs.next()) {
        int IdCliente = rs.getInt("clId");
        String Fecha = rs.getString("pedFecha");
        double Total = rs.getDouble("pedTotalGeneral");
        Id = IdCliente;
        fechita = Fecha;
        Tot = Total;}
         PreparedStatement stmt3 = conn.prepareStatement(query3);
            stmt3.setInt(1, Id);
            ResultSet resultado3 = stmt3.executeQuery();
            resultado3.next();
            clDebe = resultado3.getDouble("clDebe");
            clHaber = resultado3.getDouble("clHaber");              
        clDebe += Tot;
        
        String updateQuery = "UPDATE tbl_cliente SET clDebe = ? WHERE clId = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
        updateStmt.setDouble(1, clDebe);
        updateStmt.setInt(2, Id);
        updateStmt.executeUpdate();
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
    String sqlInsert = "INSERT INTO tbl_factura (pedid, clid, venid, tieid, facfecha, facTotalGeneral, facEstatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
    stmtInsert = conn.prepareStatement(sqlInsert);
    String query2 = "SELECT tieid FROM tbl_tienda WHERE tienombre = ?";
            PreparedStatement stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1, tienda);
            ResultSet resultado = stmt2.executeQuery();
            resultado.next();   
            int tieid = resultado.getInt("tieid");
    // Obtener la fecha actual
LocalDate fechaActual = LocalDate.now();
String estatus = "Facturado";
// Convertir LocalDate a java.sql.Date
java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaActual);
    // Establece los valores en los parámetros de la sentencia INSERT
    stmtInsert.setInt(1, cotid);
    stmtInsert.setInt(2, Id);
    stmtInsert.setInt(3, idvendedor);
    stmtInsert.setInt(4, tieid);
    stmtInsert.setDate(5, fechaSQL);
    stmtInsert.setDouble(6, Tot);
    stmtInsert.setString(7, estatus);
    
    // Ejecuta la sentencia INSERT
    int filasInsertadas = stmtInsert.executeUpdate();
    
    // Verifica el resultado de la inserción
    if (filasInsertadas > 0) {
        System.out.println("Inserción exitosa");
    } else {
        System.out.println("No se pudo insertar");
    }
    String estatusped = "Completado";
    stmtUpdate = conn.prepareStatement("UPDATE tbl_pedido SET pedEstatus = ?  WHERE pedid ='"+cotid+"'");
                stmtUpdate.setString(1, estatusped);
                stmtUpdate.executeUpdate();
            
} catch (SQLException ex) {
    ex.printStackTrace(System.out);
} finally {
    Conexion.close(stmtInsert);
    Conexion.close(conn);
}

    }
    
        public void registroPedidoCotDet(int cotid, double descuento) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PreparedStatement stmtInsert = null;
        PreparedStatement stmtUpdate = null;
        int Id = 0;
        double precio =0;
        int quantity = 0;
        double Tot = 0;
        double impuesto = 0.12;
        boolean suficientesExistencias = true; // Variable para realizar seguimiento de las existencias
            try {
        conn = Conexion.getConnection();
        conn.setAutoCommit(false); // Desactivar el modo de autocommit

        // Verificar existencias preliminarmente
        stmt = conn.prepareStatement(SQL_SELECT_PEDDET2 + " WHERE pedid = ?");
        stmt.setInt(1, cotid);
        rs = stmt.executeQuery();
        while (rs.next()) {
            int IdCliente = rs.getInt("proCodigo");
            int cantidad = rs.getInt("prodcantidad");

            // Verificar existencias del producto
            int existencias = verificarExistencias(IdCliente);
            if (existencias < cantidad) {
                suficientesExistencias = false;
                break; // Detener el bucle si un producto no tiene suficientes existencias
            }
        }

        if (!suficientesExistencias) {
            JOptionPane.showMessageDialog(null, "No hay existencias suficientes para realizar esta venta", "Error", JOptionPane.ERROR_MESSAGE);
            // Eliminar el registro en tbl_pedido
            stmt = conn.prepareStatement("DELETE FROM tbl_factura WHERE facid = ?");
            stmt.setInt(1, obtenerUltimoIdPedido());
            stmt.executeUpdate();
        } else {
            // Todos los productos tienen suficientes existencias, proceder con el registro
            stmtInsert = conn.prepareStatement("INSERT INTO tbl_facturadetalle (facid, proCodigo, proPrecios, facprodcantidad, factdescuento, facimpuestos, facTotalInd) VALUES (?, ?, ?, ?, ?, ?, ?)");

            stmt = conn.prepareStatement(SQL_SELECT_PEDDET2 + " WHERE pedid = ?");
            stmt.setInt(1, cotid);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int IdCliente = rs.getInt("proCodigo");
                double price = rs.getDouble("proPrecios");
                int cantidad = rs.getInt("prodcantidad");
                double Total = rs.getDouble("pedTotalInd");
                Id = IdCliente;
                precio = price;
                quantity = cantidad;
                double impuestocalculado = Total * impuesto;
                double descuentocalculado = (Total + impuestocalculado) * descuento;
                Tot = (Total + impuestocalculado)-descuentocalculado;

                // Establece los valores en los parámetros de la sentencia INSERT
                int IdPedido = obtenerUltimoIdFactura();
                stmtInsert.setInt(1, IdPedido);
                stmtInsert.setInt(2, Id);
                stmtInsert.setDouble(3, precio);
                stmtInsert.setInt(4, quantity);
                stmtInsert.setDouble(5, descuentocalculado);
                stmtInsert.setDouble(6, impuestocalculado);
                stmtInsert.setDouble(7, Tot);

                // Ejecuta la sentencia INSERT
                int filasInsertadas = stmtInsert.executeUpdate();

                // Verifica el resultado de la inserción
                if (filasInsertadas > 0) {
                    
                    System.out.println("Inserción exitosa");
                } else {
                    System.out.println("No se pudo insertar");
                }

                // Actualiza las existencias en la tabla tbl_productos
                /*stmtUpdate = conn.prepareStatement("UPDATE tbl_productos SET proExistencias = proExistencias - ? WHERE proCodigo = ?");
                stmtUpdate.setInt(1, quantity);
                stmtUpdate.setInt(2, Id);
                stmtUpdate.executeUpdate();*/
            }
            int IdPedido = obtenerUltimoIdPedido();
            JOptionPane.showMessageDialog(null, "Factura #" + IdPedido + " registrada con éxito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        }

        // Realiza el commit explícito
        conn.commit();
    } catch (SQLException ex) {
        ex.printStackTrace();
        // En caso de excepción, realizar rollback y eliminar el registro en tbl_pedido
        try {
            if (conn != null) {
                conn.rollback();
                stmt = conn.prepareStatement("DELETE FROM tbl_factura WHERE facid = ?");
                stmt.setInt(1, obtenerUltimoIdPedido());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(stmtInsert);
        Conexion.close(conn);
    }
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
   
        public void cancelarPedido(int cotid) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
        String estatus = "Cancelado";
        String updateQuery = "UPDATE tbl_pedido SET pedEstatus ='"+estatus+"' WHERE pedid = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
        updateStmt.setInt(1, cotid);
        updateStmt.executeUpdate();
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
        

    }
        
}
 
