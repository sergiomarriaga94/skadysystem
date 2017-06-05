<%-- 
    Document   : menu
    Created on : 1/06/2017, 11:57:25 AM
    Author     : sergio.marriaga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<nav class="light-blue">
    <div class="nav-wrapper">
        <a href="#!" class="brand-logo">Skady paletas</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="nuevoEmpleado.jsp">Ingresar nuevo empleado</a></li>
            <li><a href="nuevaPaleta.jsp">Ingresar nueva Paleta</a></li>
            <li><a href="venta.jsp">Venta</a></li>
            <li><a href="index.jsp">Logout</a></li>
    </div>
</nav>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <title>Skadi</title>
    </head>
    <body>
        <div class="co1 s12 m7">
            <h2 class="header">
                Bienvenido al sistema ${nombre}
            </h2>
            <div class="card-horizontal"> 
                <div class="card-image">
                    <img class="activator" src="images/14713759_194254301017796_8438491774195838975_n.jpg">
                </div>
                <div class="card-stacked">
                    <div class="card-content center">
                        <p><b></b></p>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>
