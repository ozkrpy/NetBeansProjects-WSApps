<%-- 
    Document   : action
    Created on : Jul 8, 2016, 9:35:52 AM
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
        <h1>Hello World!</h1>
    <%-- start web service invocation --%><hr/>
    <%
        String aa = request.getParameter("fst");
        String bb = request.getParameter("snd");
        int a1 = Integer.parseInt(aa);
        int b1 = Integer.parseInt(bb);
    try {
	add.Add_Service service = new add.Add_Service();
	add.Add port = service.getAddPort();
	 // TODO initialize WS operation arguments here
	int a = a1;
	int b = b1;
	// TODO process result here
	int result = port.addOperation(a, b);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
