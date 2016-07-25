<%-- 
    Document   : index
    Created on : Jul 18, 2016, 5:34:15 PM
    Author     : ozkrp
--%>

<%@page import="report.sources.ReportServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Aprobados JR e iReports</h1>
        
        <form action="http://localhost:9999/WebReportExam/ReportServlet" method="post">
            <input type="text" id="ciudad" name="ciudad" placeholder="Filtro por Ciudad" />
            <input type="submit" value="Filtrar"/><br/><br/>
        </form>
        
    </body>
</html>
