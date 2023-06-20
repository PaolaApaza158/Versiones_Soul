<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    /* if (session.getAttribute("login") != "OK") {
        response.sendRedirect("login.jsp");
    }*/
%>

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
            <h1>Formulario de Álbum </h1>

            <br>
            <form action = "AlbumControlador" method="post">
                <input type="hidden" name="album_id" value="${album.album_id}">
                <div class="mb-3">
                    <label for="" class="form-label">Título</label>
                    <input type="text" class="form-control" name="titulo" value="${album.titulo}" placeholder="Escriba el titulo del álbum">
                </div>
                
                <div class="mb-3">
                    <label for="" class="form-label">Artista</label>
                    <select name="artista_id" class="form-control">
                        <option value="">-- seleccione --</option>
                        <c:forEach var="item" items="${lista_artista}">
                            <option value="${item.artista_id}"
                                    <c:if test="${album.artista_id == item.artista_id}">
                                        selected
                                    </c:if>
                                    >${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Genero</label>
                    <select name="genero_id" class="form-control">
                        <option value="">-- seleccione --</option>
                        <c:forEach var="item" items="${lista_genero}">
                            <option value="${item.genero_id}" 
                                    <c:if test="${album.genero_id == item.genero_id}">
                                        selected
                                    </c:if>
                                    >${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Fecha de Lanzamiento</label>
                    <input type="date" class="form-control" name="fecha_lanzamiento" value="${album.fecha_lanzamiento}">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Imagen</label>
                    <input type="text" class="form-control" name="portada_img" value="${album.portada_img}" placeholder="Imagen">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>