<%-- 
    Document   : nuevaPaleta
    Created on : 1/06/2017, 10:15:06 PM
    Author     : sergio.marriaga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="light-blue">
    <div class="nav-wrapper">
        <a href="#!" class="brand-logo">Skady paletas</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="nuevoEmpleado.jsp">Ingresar nuevo empleado</a></li>
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
        <title>Nueva Paleta</title>
        <style>
            .ilike-blue-container {
            @extend .blue, .lighten-4;
          }
        </style>
    </head>
    <body>
        <div class="black-text row center-block">
            <div class="card-content teal ">
            <h1 class="center">Nueva Paleta</h1>
            </div>
            <form class="co1 s6"method="post" action="paletaServlet?action=guardarPaleta">
                <div class="row ">
                    <div class="input-field co1 s6 form-control">
                        <input id="nombre" type="text" class="validate" name="nombre" required="">
                        <label for="nombre">Ingrese nombre de la paleta</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field co1 s6 form-control">
                        <input id="tipoPaleta" type="text" class="validate" name="tipoPaleta" required="" onkeydown="return validNumber()">
                        <label for="tipoPaleta">Ingrese el tipo de paleta</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field co1 s6 form-control">
                        <input id="precio" type="text" class="validate" name="precio" required="" onkeydown="return validNumber()">
                        <label for="precio">Ingrese el valor de la paleta</label>
                    </div>
                </div>
                <div class="center">
            <button class="btn waves-effect waves-light" type="submit" name="action">Guardar
                <i class="material-icons right">send</i>
            </button>
        </div>
            </form>
        </div>
        
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/customize.js"></script>
    </body>
</html>
