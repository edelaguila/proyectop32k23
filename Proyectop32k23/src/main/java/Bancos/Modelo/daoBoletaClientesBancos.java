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
    private static final String SQL_SELECT = "SELECT bolId, codBanco, bolFechaEmision, clId, bolSaldo, tipMovId, cueId, bolEfecto, tipModId FROM tbl_boletaClientesBancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_boletaClientesBancos(bolId, codBanco, bolFechaEmision, clId, bolSaldo, tipMovId, cueId, bolEfecto, tipModId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_boletaClientesBancos SET codBanco=?, bolFechaEmision=?, clId=?, bolSaldo=?, tipMovId=?, cueId=?, bolEfecto=?, tipModId=? WHERE bolId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_boletaClientesBancos WHERE bolId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT bolId, bolFechaEmision, clId, bolSaldo, tipMovId, cueId, bolEfecto, tipModId FROM tbl_boletaClientesBancos WHERE codBanco = ?";
    private static final String SQL_SELECT_ID = "SELECT bolId, codBanco, bolFechaEmision, clId, bolSaldo, tipMovId, cueId, bolEfecto, tipModId FROM tbl_boletaClientesBancos WHERE bolId = ?";    

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
                int nombre_cliente = rs.getInt("clId");
                float saldo_boleta = rs.getFloat("bolSaldo");     
                int id_tipoMovimiento = rs.getInt("tipMovId");
                int id_tipoMoneda = rs.getInt("tipModId");
                clsBoletaClientesBancos boleta = new clsBoletaClientesBancos();
                boleta.setIdBoleta(id_boleta);
                boleta.setCodigoBanco(codigo_banco);
                boleta.setFechaEmisionBoleta(fecha_emision);
                boleta.setIdCliente(nombre_cliente);
                boleta.setSaldoBoleta(saldo_boleta);
                boleta.setIdTipoMovimiento(id_tipoMovimiento);
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
            stmt.setInt(4, boleta.getIdCliente());
            stmt.setDouble(5, boleta.getSaldoBoleta());
            stmt.setInt(7, boleta.getIdTipoMovimiento());
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

     public int actualizaBoleta(clsBoletaClientesBancos boleta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, boleta.getCodigoBanco());
            stmt.setString(2, boleta.getFechaEmisionBoleta());
            stmt.setInt(3, boleta.getIdCliente());
            stmt.setDouble(4, boleta.getSaldoBoleta());
            stmt.setInt(5, boleta.getIdTipoMovimiento());
            stmt.setInt(6, boleta.getIdTipoMoneda());
            stmt.setInt(7, boleta.getIdBoleta());

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

    public int borrarBoleta(clsBoletaClientesBancos boleta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, boleta.getIdBoleta());
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

    public clsBoletaClientesBancos consultaBoletaPorCodigo(clsBoletaClientesBancos boleta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + boleta);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, modulo.getIdModulo());            
            stmt.setInt(1, boleta.getCodigoBanco());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_boleta = rs.getInt("bolId");
                int codigo_banco = rs.getInt("codBanco");
                String fecha_emision = rs.getString("bolFechaEmision");
                int nombre_cliente = rs.getInt("clId");
                float saldo_boleta = rs.getFloat("bolSaldo");
                int id_tipoMovimiento = rs.getInt("tipMovId");
                int id_tipoMoneda = rs.getInt("tip;ovId");
                //boleta = new clsModulo();
                boleta.setIdBoleta(id_boleta);
                boleta.setCodigoBanco(codigo_banco);
                boleta.setFechaEmisionBoleta(fecha_emision);
                boleta.setIdCliente(nombre_cliente);
                boleta.setSaldoBoleta(saldo_boleta);   
                boleta.setIdTipoMovimiento(id_tipoMovimiento);
                boleta.setIdTipoMoneda(id_tipoMoneda);
                System.out.println(" registro consultado: " + boleta);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return movimiento;  // Si se utiliza un ArrayList
        return boleta;
    }
    public clsBoletaClientesBancos consultaBoletaPorId(clsBoletaClientesBancos boleta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + boleta);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, boleta.getIdBoleta());            
            //stmt.setString(1, modulo.getNombreModulo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_boleta = rs.getInt("bolId");
                int codigo_banco = rs.getInt("codBanco");
                String fecha_emision = rs.getString("bolFechaEmision");
                int nombre_cliente = rs.getInt("clId");
                float saldo_boleta = rs.getFloat("bolSaldo");     
                int id_tipoMovimiento = rs.getInt("tipMovId");
                int id_tipoMoneda = rs.getInt("tipModId");

                //modulo = new clsModulo();
                boleta.setIdBoleta(id_boleta);
                boleta.setCodigoBanco(codigo_banco);
                boleta.setFechaEmisionBoleta(fecha_emision);
                boleta.setIdCliente(nombre_cliente);
                boleta.setSaldoBoleta(saldo_boleta);
                boleta.setIdTipoMovimiento(id_tipoMovimiento);
                boleta.setIdTipoMoneda(id_tipoMoneda);
                System.out.println(" registro consultado: " + boleta);                
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
        return boleta;
    }    
}
