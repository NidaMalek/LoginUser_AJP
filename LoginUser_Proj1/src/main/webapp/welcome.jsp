<%-- 
    Document   : welcome
    Created on : Jul 4, 2023, 1:34:18 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>J S P Page</title>
    </head>
    <body>
        <h1>At welcome file</h1>
        Welcome <%=(String)request.getAttribute("u1")%>
    </body>
</html>
