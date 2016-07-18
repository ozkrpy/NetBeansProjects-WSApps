/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportegrafico;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.fill.JRFiller;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author ozkrp
 */
public class ReporteGrafico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JRException {
        int i = 0;
        List<Jugador> listaJugadores = new ArrayList<Jugador>();
        for(i = 1; i <= 49; i++) {
            listaJugadores.add(new Jugador(i, " Jugador nro. " + i, "Wii"));
        }
        for(i = 50; i <= 79; i++) {
            listaJugadores.add(new Jugador(i, " Jugador nro. " + i, "Xbox"));
        }
        for(i = 80; i <= 100; i++) {
            listaJugadores.add(new Jugador(i, " Jugador nro. " + i, "PS4"));
        }

        JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("reporteGrafico.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(listaJugadores));
        
        //PDF Exporter
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporteGrafico.pdf"));
        
        exporter.exportReport();

    }

}
