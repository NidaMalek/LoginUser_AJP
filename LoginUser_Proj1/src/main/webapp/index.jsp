<%-- 
    Document   : index
    Created on : Jul 16, 2023, 3:25:32 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
    body{
        margin: 0;
        padding: 0 ;
        backgroung-color:#464034;
        font-family:Arial, Helvetica, sans-serif;
    }
    .login{
        width: 382px;
        overflow: hidden;
        margin: auto;
        margin: 20 0 0 450px;
        padding: 80px;
        background: #11c0db;
        border-radius: 50px;
    }   
 </style>
<!--    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index j s p Page</title>
    </head>-->
    <body>
        <form method="post" action="NewServlet2">
        <div class="login">
        <table cellspacing="5px" cellpadding="5px">
            <tr>
                <td>
                    Username:
                    <input type="text" name="username">
                    <br>
                </td>
            </tr>
            <tr>
                <td>
                    Password:
                    <input type="password" name="password">
                    <br>
                </td>
            </tr>
            <tr>
                <td>
<!--               <td bgcolor="Green">-->
                    <input type="submit" name="submit" value="login">
                    <br>
                </td>
            </tr>
        </table>
    <br>
       
            <p>
                <% String msg=(String)getServletContext().getAttribute("errmsg");
                if(msg!=null)
                {
                    out.println(msg);
                    getServletContext().removeAttribute("errmsg");
                }        
                 %>
           
           </p>
            </div>
        </form>
    </body>
    
</html>
