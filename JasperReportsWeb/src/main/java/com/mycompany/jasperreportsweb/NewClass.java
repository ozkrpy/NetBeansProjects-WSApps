/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jasperreportsweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author ozkrp
 */
public class NewClass {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, JRException {
        System.out.println("entro al main");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nutriciondb?zeroDateTimeBehavior=convertToNull", "reports", "jasper123456");
        if (conexion != null) {
            System.out.println("creo la conexion");
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("reportTest.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reportePDF.pdf"));
            exporter.exportReport();
        }

    }

}
