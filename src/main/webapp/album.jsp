<%
    //if (session.getAttribute("login") != "OK") {
      //  response.sendRedirect("login.jsp");
    //}
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
        <title>Soul</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="album"/>
        </jsp:include>
        <div class="container">
            
            <h1>Álbum</h1>
            <!-- <a href="Logout" class="btn btn-danger"> Cerrar sesión</a> -->
            <br>
            <a href="AlbumControlador?action=add" class="btn btn-primary btn-sm"> <i class="fa-solid fa-circle-plus"></i> Nuevo álbum</a>

            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Título</th>
                    <th>Artista</th>
                    <th>Género</th>
                    <th>Fecha lanzamiento</th>
                    <th>Imagen de Portada</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${album}">
                     <tr>
                        <td>${item.album_id}</td>
                        <td>${item.titulo}</td>
                        <td>${item.artista}</td>
                        <td>${item.genero}</td>
                        <td>${item.fecha_lanzamiento}</td>
                        <td>${item.portada_img}</td>
                        <td><a href="AlbumControlador?action=edit&album_id=${item.album_id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                        <td><a href="AlbumControlador?action=delete&album_id=${item.album_id}" onclick="return(confirm('¿Esta seguro?'))">
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
