<%-- 
    Document   : mensaje
    Created on : 12/11/2018, 12:45:57 PM
    Author     : Sebastian Castro C
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje</title>
    </head>
    <body>
        <h1 align="center">
            <%
                if (request.getParameter("men") != null) {
                    out.println(request.getParameter("men"));
                }
            %>
        </h1><br>
        <h2 align="center">
            <a href="index.jsp">Volver a principal</a>
        </h2>
    </body>
</html>
