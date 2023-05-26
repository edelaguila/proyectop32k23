/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Modelo;

import Bancos.Controlador.clsCuentaEmpresa;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCuentaEmpresa {

    private static final String SQL_SELECT = "SELECT cueEmId, cueNumeroEm, cueSaldoEm, cueEstatusEm, codBanco, cueTipoId FROM tbl_cuentaempresabancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_cuentaempresabancos(cueEmId, cueNumeroEm, cueSaldoEm, cueEstatusEm, codBanco, cueTipoId) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cuentaempresabancos SET cueNumeroEm=?, cueSaldoEm=?, cueEstatusEm=?, codBanco=?, cueTipoId=? WHERE cueEmId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cuentaempresabancos WHERE cueEmId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT cueEmId, cueNumeroEm, cueSaldoEm, cueEstatusEm, codBanco, cueTipoId FROM tbl_cuentaempresabancos WHERE cueNumeroEm = ?";
    private static final String SQL_SELECT_ID = "SELECT cueEmId, cueNumeroEm, cueSaldoEm, cueEstatusEm, codBanco, cueTipoId FROM tbl_cuentaempresabancos WHERE cueEmId = ?";

    public List<clsCuentaEmpresa> consultaCuentaEmpresas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<clsCuentaEmpresa> cuentas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueEmId");
                int cuentaN = rs.getInt("cueNumeroEm");
                double saldo = rs.getDouble("cueSaldoEm");
                String estatus = rs.getString("cueEstatusEm");
                int codigo = rs.getInt("codBanco");
                int tipoC = rs.getInt("cueTipoId");
                clsCuentaEmpresa cuentaem = new clsCuentaEmpresa();
                cuentaem.setIdCuentaEm(id);
                cuentaem.setNumeroCuentaEm(cuentaN);
                cuentaem.setSaldoCuentaEm(saldo);
                cuentaem.setEstatusCuentaEm(estatus);
                cuentaem.setCodigoBanco(codigo);
                cuentaem.setCueTipoId(tipoC);
                cuentas.add(cuentaem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cuentas;
    }

    public int setIngresarCuentaEm(clsCuentaEmpresa cuentaem) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cuentaem.getIdCuentaEm());
            stmt.setInt(2, cuentaem.getNumeroCuentaEm());
            stmt.setDouble(3, cuentaem.getSaldoCuentaEm());
            stmt.setString(4, cuentaem.getEstatusCuentaEm());
            stmt.setInt(5, cuentaem.getCodigoBanco());
            stmt.setInt(6, cuentaem.getCueTipoId());
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

    public int actualizaCuentaEm(clsCuentaEmpresa cuentaem) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, cuentaem.getNumeroCuentaEm());
            stmt.setDouble(2, cuentaem.getSaldoCuentaEm());
            stmt.setString(3, cuentaem.getEstatusCuentaEm());
            stmt.setInt(4, cuentaem.getCodigoBanco());
            stmt.setInt(5, cuentaem.getCueTipoId());
            stmt.setInt(6, cuentaem.getIdCuentaEm());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int setBorrarCuentaEm(clsCuentaEmpresa cuentaem) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cuentaem.getIdCuentaEm());
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

    public clsCuentaEmpresa consultaNumeroCuentaEmpresa(clsCuentaEmpresa cuentaem) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuentaem);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            stmt.setInt(1, cuentaem.getNumeroCuentaEm());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueEmId");
                int numero = rs.getInt("cueNumeroEm");
                double saldo = rs.getDouble("cueSaldoEm");
                String estatus = rs.getString("cueEstatusEm");
                int codigo = rs.getInt("codBanco");
                int tipoC = rs.getInt("cueTipoId");
                cuentaem.setIdCuentaEm(id);
                cuentaem.setNumeroCuentaEm(numero);
                cuentaem.setSaldoCuentaEm(saldo);
                cuentaem.setEstatusCuentaEm(estatus);
                cuentaem.setCodigoBanco(codigo);
                cuentaem.setCueTipoId(tipoC);
                System.out.println("Registro consultado: " + cuentaem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cuentaem;
    }

    public clsCuentaEmpresa consultaCuentaEmPorId(clsCuentaEmpresa cuentaem) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuentaem);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, cuentaem.getIdCuentaEm());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueEmId");
                int numero = rs.getInt("cueNumeroEm");
                double saldo = rs.getDouble("cueSaldoEm");
                String estatus = rs.getString("cueEstatusEm");
                int codigo = rs.getInt("codBanco");
                int tipoC = rs.getInt("cueTipoId");
                cuentaem.setIdCuentaEm(id);
                cuentaem.setNumeroCuentaEm(numero);
                cuentaem.setSaldoCuentaEm(saldo);
                cuentaem.setEstatusCuentaEm(estatus);
                cuentaem.setCodigoBanco(codigo);
                cuentaem.setCueTipoId(tipoC);
                System.out.println("Registro consultado: " + cuentaem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cuentaem;
    }
}
