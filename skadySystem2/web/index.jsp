<%-- 
    Document   : index
    Created on : 1/06/2017, 11:04:50 AM
    Author     : sergio.marriaga
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <title>Skadi</title>
    </head>
    <body>
        <div class="co1 s4 m4">
            <h1 class="header">Ingreso de usuario</h1>
            <c:if test="${param.error==1}">
                <font color="red">Usuario o contraseña incorrecta. Intente de nuevo</font>
            </c:if>
            <div class="card horizontal">
                <div class="co1 s4 m10">
                    <img src="images/14449831_180109369098956_5655260022623528355_n.jpg" height="80%" width="80%">
                </div>
                <div class="card-stacked row">
                    <div class="card-content row">
                        <form method="post" action="usuarioServlet?action=Ingresar">
                            <table>
                                <tr>
                                    <th>
                                        <label><b>Documento: </b></label>
                                    </th>
                                    <th>
                                        <input id="cedula" type="text"  class="form-control" name="cedula"  placeholder="Ingrese su numero de documento" required=""/>
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label><b>Contraseña: </b></label>
                                    </th>
                                    <th>
                                       <input id="password" type="password" class="form-control" name="password" placeholder="Ingrese su contraseña" required=""/>
                                    </th> 
                                </tr>
                                <div class="break"></div>
                                <div class="center">
                                <tr>
                                    <td colspan="2">
                                        <input class="btn icon-btn btn-success" type="submit"  name="action" value="Ingresar"/>      
                                    </td>
                                </tr>
                                </div>
                            </table>
                        </form>
                        </br>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>
