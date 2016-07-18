/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteconexion;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author ozkrp
 */
public class ReporteConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, JRException {
        // TODO code application logic here
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba_reportes?zeroDateTimeBehavior=convertToNull","tester","123456");
        
      
        
        JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("report1.jasper");
        
        System.out.println("Informacion del reporte " + reporte.toString());
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
        
        //PDF Exporter
        //JRExporter exporter = new JRPdfExporter();
        //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reportePDF.pdf"));
        
        //HTML Exporter
        JRExporter exporter = new JRHtmlExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporteHTML.html"));
        
        //Executes the process
        exporter.exportReport();
        
        conexion.close();
    }
    
}
