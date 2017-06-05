<%-- 
    Document   : venta
    Created on : 4/06/2017, 02:55:18 PM
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
            <li><a href="index.jsp">Logout</a></li>
    </div>
</nav>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <title>Venta</title>
    </head>
    <body>
        <h1 class="center">Nueva venta</h1>
        <div class="row">
            <h4 class="center">
                ${mensaje}
            </h4>
        </div>
        <form method="post" action="ventasServlet">
            <div class="row">
                <div class="input-field col s5">
                    <input id="codigoPaleta" name="codigoPaleta" type="text" class="validate validator" onkeydown="return validNumber()">
                    <label for="codigoPaleta">Codigo paleta</label>
                </div>
                <div class="input-field col s5">
                    <input id="cantidad" name="cantidad" type="text" class="validate validator" onkeydown="return validNumber()">
                    <label for="cantidad">Cantidad</label>
                </div>
                <div class="s2">
                    <button class="btn center" type="submit" name="action" value="agregarPaleta" onclick="return theValidator()">Agregar</button>
                </div>
            </div>
            <div >

                <table class="striped">
                    <thead>
                        <tr>
                            <th>Paleta</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                            <th>Total</th>
                        </tr>
                    </thead>

                    <tbody>

                        <c:forEach var="a" items="${paletas}">
                            <tr>
                                <td>${a.nombre}</td>
                                <td>${a.cantidad}</td>
                                <td>${a.precio}</td>
                                <td>${a.cantidad*a.precio}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>-</td>
                            <td>-</td>
                            <td><b>TOTAL VENTA:</b></td>
                            <td><b>${totalVenta}</b></td>
                        </tr>
                    </tbody>
                </table>
                <div class=" row s2 center">
                    <button class="btn center" type="submit" name="action" value="cancelarVenta">Cancelar Venta</button>
                    <button class="btn center" type="submit" name="action" value="venta">Confirmar Venta</button>
                </div> 
            </div>
        </form>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/customize.js"></script>
    </body>
</html>
