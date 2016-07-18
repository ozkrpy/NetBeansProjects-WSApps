package reportedatasource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author ozkrpy
 */
public class ReporteDataSource {
    public static void main(String[] args) throws JRException {
        //FUNCIONAL PARA EL EJEMPLO 1
        //ParticipantesDataSource dataSource = new ParticipantesDataSource();
          
        //FUNCIONAL PARA EL EJEMPLO 2
        List<Participante> listaParticipantes = new ArrayList<Participante>();
        for (int i = 1; i <=10; i++) {
            Participante p = new Participante(i, "Participante " + i, "Usuario " + i, "Pass " + i, "Comentarios para " + i, i);
            //FUNCIONAL PARA EL EJEMPLO 1
            //dataSource.addParticipante(p);
            
            //FUNCIONAL PARA EL EJEMPLO 2
            listaParticipantes.add(p);
        }
        JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("actividad2.jasper");
        /** 
         * EJEMPLO 1, utilizando el datasource como fuente para poblar el reporte
         * JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, dataSource);
         * 
         * EJEMPLO 2, utilizando JRBeanCollectionDataSource como fuente para poblar el reporte
         * Se debe inicializar la lista en el for para que esta sea la referencia
         * JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(listaParticipantes)); 
         * 
         * EJEMPLO 3, uso de parametros. Titulo y Autor
         * JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaParticipantes));
        */
        Map<String, Object> parametrosMapa = new HashMap<String, Object>();
        Object autor = "Oscar R.";
        Object titulo = "Titulo del Reporte como Parametro";
        parametrosMapa.put("autor",autor);
        parametrosMapa.put("titulo",titulo);
        
        //El metodo fillReport no contaba con manejador para Map de tipo <String, String> por lo que tuve que hacer un objeto autor y titulo
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametrosMapa, new JRBeanCollectionDataSource(listaParticipantes));
        
        //PDF Exporter
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporteActividad2PDFEjemplo4.pdf"));
        
        exporter.exportReport();
    }
}