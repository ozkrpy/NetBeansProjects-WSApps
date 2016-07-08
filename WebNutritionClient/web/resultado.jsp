<%-- 
    Document   : resultado
    Created on : Jul 8, 2016, 10:07:14 AM
    Author     : ozkrp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Verificacion exitosa</h1>
        <%-- start web service invocation --%><hr/>
        <%
            String edadTexto = request.getParameter("edad");
            String sexoTexto = request.getParameter("sexo");
            String tallaTexto = request.getParameter("talla");
            String ciaMunecaTexto = request.getParameter("cia_muneca");
            int edadEntero = Integer.parseInt(edadTexto);
            double tallaDoble = Double.parseDouble(tallaTexto);
            int ciaMunecaEntero = Integer.parseInt(ciaMunecaTexto);

        try {
            ws.sources.NutritionServices_Service service = new ws.sources.NutritionServices_Service();
            ws.sources.NutritionServices port = service.getNutritionServicesPort();
             // TODO initialize WS operation arguments here
            int edad = edadEntero;
            java.lang.String sexo = sexoTexto;
            double talla = tallaDoble;
            int circunferenciaMunheca = ciaMunecaEntero;
            // TODO process resul11t here
            java.lang.String result = port.operation(edad, sexo, talla, circunferenciaMunheca);
            out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
        <%-- end web service invocation --%><hr/>
    </body>
</html>
