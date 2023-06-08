/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Controlador;
import java.io.File;
import java.sql.Connection;
import Seguridad.Modelo.Conexion;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ll322
 */
public class clsReportes {
    
    private String reportPath;  // Variable para almacenar la ruta del archivo de reporte
    
    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }
    
    public void generateReport() {
        Connection conn = null;        
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            conn = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()+reportPath);
            print = JasperFillManager.fillReport(report, p, conn);
            JasperViewer view = new JasperViewer(print, false);
	    view.setTitle("Reporte Banco");
            view.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
