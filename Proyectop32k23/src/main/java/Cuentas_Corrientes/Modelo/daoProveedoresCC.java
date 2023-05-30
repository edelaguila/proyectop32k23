package Cuentas_Corrientes.Modelo;

import Cuentas_Corrientes.Controlador.clsProveedoresCC;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author visitante
 */
public class daoProveedoresCC {

    private static final String SQL_SELECT = "SELECT prID, prFecha, prNombre, prNit, prNoFactura, prTotalFactura FROM tbl_Proveedores";
    private static final String SQL_INSERT = "INSERT INTO tbl_transaciones_cc(traNombre, traEstatus, traEfecto) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_transaciones_cc SET traNombre=?, traEstatus=?,traEfecto=? WHERE tracodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_transaciones_cc WHERE tracodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT tracodigo, traNombre, traEstatus, traEfecto FROM tbl_transaciones_cc WHERE traNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT tracodigo, traNombre, traEstatus, traEfecto FROM tbl_transaciones_cc WHERE tracodigo = ?";    

    public List<clsProveedoresCC> consultaProveedores() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsProveedoresCC> proveedoresCC = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("prID");
                String fecha = rs.getString("prFecha");
                String nombre = rs.getString("prNombre");
                String nit = rs.getString("prNit");
                String noFactura = rs.getString("prNoFactura");
                double TotFactura = rs.getDouble("prTotalFactura");
                
                clsProveedoresCC proveedorCC = new clsProveedoresCC();
                proveedorCC.setIdProv(id);
                proveedorCC.setFechaProv(fecha);
                proveedorCC.setNombreProv(nombre);
                proveedorCC.setNitProv(nit);
                proveedorCC.setFactProv(noFactura);
                proveedorCC.setTotFacturaProv(TotFactura);
                proveedoresCC.add(proveedorCC);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return proveedoresCC;
    }
}