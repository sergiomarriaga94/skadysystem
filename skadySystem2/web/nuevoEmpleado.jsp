<%-- 
    Document   : newjsp
    Created on : 1/06/2017, 11:58:40 AM
    Author     : sergio.marriaga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="light-blue">
    <div class="nav-wrapper">
        <a href="#!" class="brand-logo">Skady paletas</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
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
        <title>Nuevo empleado</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>

        <div class="co1 s3 m4">
            <h2 class="header">Ingreso empleado</h2>
            <div class="row">
                <h4 class="center">
                    ${mensaje}
                </h4>
            </div>
            <div class="card horizontal">
                <div class="card-image">
                    <img src="images/16729084_10154586113284398_8859970940845719272_n.jpg">
                </div>
                <div class="card-stacked">
                    <div class="card-content">
                        <form method="post" action="usuarioServlet?action=guardarEmpleado">
                            <table>
                                <tr>
                                    <th>
                                        <label><b>Nombre: </b></label>
                                    </th>
                                    <th>
                                        <input type="text" placeholder="Ingrese nombre" class="form-control validator" name="nombre" required=""/>                           
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label><b>Cedula: </b></label>
                                    </th>
                                    <th>
                                        <input type="text" placeholder="Ingrese numero de cedula" class="form-control validator" name="cedula" required="" onkeydown="return validNumber()"/>                           
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label><b>Password: </b></label>
                                    </th>
                                    <th>
                                        <input type="Password" placeholder="Ingrese contraseña" class="form-control validator" name="password" required=""/>                           
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label><b>Telefono:</b></label>
                                    </th>
                                    <th>
                                        <input type="text" placeholder="Ingrese numero de telefono" class="form-control validator" name="telefono" required="" onkeydown="return validNumber()"/>                           
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label><b>Celular:</b></label>
                                    </th>
                                    <th>
                                        <input type="text" placeholder="Ingrese numero de celular" class="form-control validator" name="celular" required="" onkeydown="return validNumber()"/>                           
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label><b>Sede:</b></label>
                                    </th>
                                    <th>
                                        <input type="text" placeholder="Ingrese la sede" class="form-control validator" name="sede" required="" onkeydown="return validNumber()"/>                           
                                    </th>
                                </tr>
                                <div class="break"></div>
                                <div class="center">
                                    <tr>
                                        <td colspan="2">
                                            <input class="btn icon-btn btn-success center" type="submit" name="action" value="Agregar" onclick="return theValidator()">
                                            <span class="glyphicon glyphicon-ok-sign"></span>

                                            <input class="btn btn-info btn-lg center" type="reset" name="action" value="Limpiar">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </td>
                                    </tr>
                                </div>
                            </table>               
                        </form>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <script type="text/javascript" src="js/customize.js"></script>
</html>