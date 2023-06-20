<%@page import="com.emergentes.modelo.Cancion"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
        <title>Lista de Canciones</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
      <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="cancion"/>
        </jsp:include>
        <div class="container">
            <h1>Canciones</h1>
            <!-- <a href="Logout" class="btn btn-danger"> Cerrar sesión</a> -->
            <br>
            <a href="CancionControlador?action=add" class="btn btn-primary btn-sm"> <i class="fa-solid fa-circle-plus"></i> Nueva Canción</a>

            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Título</th>
                    <th>Duración</th>
                    <th>Fecha</th>
                    <th>Artista</th>
                    <th>Álbum</th>
                    <th>Género</th>
                    <th>Grupo</th>
                    <th>Imagen</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="cancion" items="${canciones}">
                    <tr>
                        <td>${cancion.cancion_id}</td>
                        <td>${cancion.titulo}</td>
                        <td>${cancion.duracion}</td>
                        <td>${cancion.fecha}</td>
                        <td>${cancion.artista}</td>
                        <td>${cancion.album}</td>
                        <td>${cancion.genero}</td>
                        <td>${cancion.grupo}</td>
                        <td>${cancion.cancion_img}</td>
                        <td><a href="CancionControlador?action=edit&cancion_id=${cancion.cancion_id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                        <td><a href="CancionControlador?action=delete&cancion_id=${cancion.cancion_id}" onclick="return(confirm('¿Estás seguro?'))">
                                <i class="fa-solid fa-trash"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>

