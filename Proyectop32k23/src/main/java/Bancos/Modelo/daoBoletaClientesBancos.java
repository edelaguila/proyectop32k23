/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Alyson Vannesa Rodríguez Quezada 9959-21-829
package Bancos.Modelo;

import Bancos.Controlador.clsBoletaClientesBancos;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoBoletaClientesBancos {
    private static final String SQL_SELECT = "SELECT bolId, codBanco, bolFechaEmision, bolNombreCliente, bolSaldo, concId, tipMovId, cueId, bolEfecto, tipModId FROM tbl_boletaClientesBancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_boletaClientesBancos(bolId, codBanco, bolFechaEmision, bolNombreCliente, bolSaldo, concId, tipMovId, cueId, bolEfecto, tipModId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_boletaClientesBancos SET codBanco=?, bolFechaEmision=?, bolNombreCliente=?, bolSaldo=?, concId=?, tipMovId=?, cueId=?, bolEfecto=?, tipModId=? WHERE bolId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_boletaClientesBancos WHERE bolId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT bolId, bolFechaEmision, bolNombreCliente, bolSaldo, concId, tipMovId, cueId, bolEfecto, tipModId FROM tbl_boletaClientesBancos WHERE codBanco = ?";
    private static final String SQL_SELECT_ID = "SELECT bolId, codBanco, bolFechaEmision, bolNombreCliente, bolSaldo, concId, tipMovId, cueId, bolEfecto, tipModId FROM tbl_boletaClientesBancos WHERE bolId = ?";    

    public List<clsBoletaClientesBancos> consultaBoleta() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsBoletaClientesBancos> boletas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_boleta = rs.getInt("bolId");
                int codigo_banco = rs.getInt("codBanco");
                String fecha_emision = rs.getString("bolFechaEmision");
                String nombre_cliente = rs.getString("bolNombreCliente");
                float saldo_boleta = rs.getFloat("bolSaldo");
                int id_concepto = rs.getInt("conId");
                int id_tipoMovimiento = rs.getInt("tipMovId");
                int id_cuenta = rs.getInt("cueId");
                String efecto_boleta = rs.getString("bolEfecto");
                int id_tipoMoneda = rs.getInt("tipModId");
                clsBoletaClientesBancos boleta = new clsBoletaClientesBancos();
                boleta.setIdBoleta(id_boleta);
                boleta.setCodigoBanco(codigo_banco);
                boleta.setFechaEmisionBoleta(fecha_emision);
                boleta.setNombreCliente(nombre_cliente);
                boleta.setSaldoBoleta(saldo_boleta);
                boleta.setIdConcepto(id_concepto);
                boleta.setIdTipoMovimiento(id_tipoMovimiento);
                boleta.setIdCuenta(id_cuenta);
                boleta.setEfectoBoleta(efecto_boleta);
                boleta.setIdTipoMoneda(id_tipoMoneda);
                boletas.add(boleta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return boletas;
    }

    public int ingresaBoleta(clsBoletaClientesBancos boleta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, boleta.getIdBoleta());
            stmt.setInt(2, boleta.getCodigoBanco());
            stmt.setString(3, boleta.getFechaEmisionBoleta());
            stmt.setString(4, boleta.getNombreCliente());
            stmt.setDouble(5, boleta.getSaldoBoleta());
            stmt.setInt(6, boleta.getIdConcepto());
            stmt.setInt(7, boleta.getIdTipoMovimiento());
            stmt.setInt(8, boleta.getIdCuenta());
            stmt.setString(9, boleta.getEfectoBoleta());
            stmt.setInt(10, boleta.getIdTipoMoneda());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaCuenta(clsCuentasBancos cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, cuenta.getNumeroCuenta());
            stmt.setDouble(2, cuenta.getSaldoCuenta());
            stmt.setInt(3, cuenta.getIdPersona());
	    stmt.setInt(4, cuenta.getIdTipoCuenta());
            stmt.setString(5, cuenta.getEstatusCuenta());
            stmt.setInt(6, cuenta.getIdCuenta());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarCuenta(clsCuentasBancos cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cuenta.getIdCuenta());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsCuentasBancos consultaNumeroCuenta(clsCuentasBancos cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuenta);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setInt(1, cuenta.getNumeroCuenta());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueId");
                int numero = rs.getInt("cueNumero");
                double saldo = rs.getDouble("cueSaldo");
                int persona = rs.getInt("perId");
                int tipoC = rs.getInt("cueTipoId");
                String estatus = rs.getString("cueEstatus");
                //cuenta = new clsCuentaBancos();
                cuenta.setIdCuenta(id);
                cuenta.setNumeroCuenta(numero);
                cuenta.setSaldoCuenta(saldo);
                cuenta.setIdPersona(persona);
                cuenta.setIdTipoCuenta(tipoC);
                cuenta.setEstatusCuenta(estatus);
                System.out.println(" registro consultado: " + cuenta);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return cuenta;
    }
    public clsCuentasBancos consultaCuentaPorId(clsCuentasBancos cuenta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuenta);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, cuenta.getIdCuenta());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueId");
                int numero = rs.getInt("cueNumero");
                double saldo = rs.getDouble("cueSaldo");
                int persona = rs.getInt("perId");
                int tipoC = rs.getInt("cueTipoId");
		String estatus = rs.getString("cueestatus");
                //usuario = new clsUsuario();
                cuenta.setIdCuenta(id);
                cuenta.setNumeroCuenta(numero);
                cuenta.setSaldoCuenta(saldo);
                cuenta.setIdPersona(persona);
                cuenta.setIdTipoCuenta(tipoC);
                cuenta.setEstatusCuenta(estatus);
                System.out.println(" registro consultado: " + cuenta);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return cuenta;
    }    
}
