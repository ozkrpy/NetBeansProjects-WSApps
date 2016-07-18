/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.reportes.jasperreports.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
 * @author ozkrp
 */
@WebServlet(name = "servletReporte", urlPatterns = {"/servletReporte"})
public class servletReporte extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //indica en la cabecera que se consulte al cliente con que aplicacion desea abrir el reporte.
        response.setHeader("Content-Disposition", "attachment;filename=\"reporte.pdf\";");
        
        //con esto se limita para que el reporte no quede guardado en la cache 
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        
        //define el contenido como pdf
        response.setContentType("application/pdf");
        
        
        ServletOutputStream out = response.getOutputStream();
        
        List<Participante> listaParticipantes = new ArrayList<Participante>();
        for (int i = 1; i <=10; i++) {
            Participante p = new Participante(i, "Participante " + i, "Usuario " + i, "Pass " + i, "Comentarios para " + i, i);
            listaParticipantes.add(p);
        }
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(getServletContext().getRealPath("WEB-INF/actividad2.jasper"));

            Map<String, Object> parametrosMapa = new HashMap<String, Object>();
            Object autor = "Oscar R.";
            Object titulo = "Reporte Actividad 3";
            parametrosMapa.put("autor",autor);
            parametrosMapa.put("titulo",titulo);

            //El metodo fillReport no contaba con manejador para Map de tipo <String, String> por lo que tuve que hacer un objeto autor y titulo
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametrosMapa, new JRBeanCollectionDataSource(listaParticipantes));

            //PDF Exporter
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);

            exporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
                
                
                
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletReporte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletReporte at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
