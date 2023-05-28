/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Bancos.Modelo;

import Bancos.Controlador.clsComprobanteProveedoresBancos;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoComprobanteProveedoresBancos {

    private static final String SQL_SELECT = "SELECT comId, conFechaEmision, tipMovid, cueId, concId, codBanco , movDetId, cpid    FROM tbl_comprobanteProveedoresBancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_comprobanteProveedoresBancos(conFechaEmision, tipMovid, cueId, concId, codBanco , movDetId, cpid ) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_comprobanteProveedoresBancos SET conFechaEmision=?, tipMovid=?, cueId=?, concId=?, codBanco=?, movDetId=?, cpid=? WHERE comId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_comprobanteProveedoresBancos WHERE comId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT comId, conFechaEmision, tipMovid, cueId, concId, codBanco , movDetId, cpid  FROM tbl_comprobanteProveedoresBancos WHERE conFechaEmision = ?";
    private static final String SQL_SELECT_ID = "SELECT comId, conFechaEmision, tipMovid, cueId, concId, codBanco , movDetId, cpid   FROM tbl_comprobanteProveedoresBancos WHERE tipModId = ?";     



   public List<clsComprobanteProveedoresBancos> consultaComprobanteProveedores() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsComprobanteProveedoresBancos> ComprobanteProveedor = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("comId");
                String fechaE = rs.getString("conFechaEmision");
                int tipoMovId = rs.getInt("tipMovid");
                int cuentaId = rs.getInt("cueId");
                int conceptoId = rs.getInt("concId");
                int bancoId = rs.getInt("codBanco");
                int movDId = rs.getInt("movDetId");
                int cpid  = rs.getInt("cpid ");
                clsComprobanteProveedoresBancos ComprobanteProv = new clsComprobanteProveedoresBancos();
                ComprobanteProv.setComId(id);
                ComprobanteProv.setConFechaEmision(fechaE);
                ComprobanteProv.setTipMovid(tipoMovId);
                ComprobanteProv.setCueId(cuentaId);
                ComprobanteProv.setConcId(conceptoId);
                ComprobanteProv.setCodBanco(bancoId);
                ComprobanteProv.setMovDetId(movDId);
                ComprobanteProv.setcpid (cpid );
                ComprobanteProveedor.add(ComprobanteProv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ComprobanteProveedor;
    }

