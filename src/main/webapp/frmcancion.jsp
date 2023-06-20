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
    <title>Formulario de Canción</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<jsp:include page="META-INF/menu.jsp">
    <jsp:param name="opcion" value="cancion"/>
</jsp:include>
<div class="container">
    <h1>Formulario de Canción</h1>

    <br>
    <form action="CancionControlador" method="post">
        <input type="hidden" name="cancion_id" value="${cancion.cancion_id}">
        <div class="mb-3">
            <label for="titulo" class="form-label">Título</label>
            <input type="text" class="form-control" name="titulo" value="${cancion.titulo}" placeholder="Escriba el título de la canción">
        </div>
        <div class="mb-3">
            <label for="duracion" class="form-label">Duración</label>
            <input type="time" class="form-control" name="duracion" value="${cancion.duracion}" placeholder="HH:mm:ss">
        </div>
        <div class="mb-3">
            <label for="fecha" class="form-label">Fecha</label>
            <input type="date" class="form-control" name="fecha" value="${cancion.fecha}">
        </div>
        <div class="mb-3">
            <label for="artista_id" class="form-label">Artista</label>
            <select name="artista_id" class="form-control">
                <option value="">-- seleccione --</option>
                <c:forEach var="item" items="${lista_artista}">
                    <option value="${item.artista_id}"
                            <c:if test="${cancion.artista_id == item.artista_id}">
                                selected
                            </c:if>
                    >${item.nombre}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="album_id" class="form-label">Álbum</label>
            <select name="album_id" class="form-control">
                <option value="">-- seleccione --</option>
                <c:forEach var="item" items="${lista_album}">
                    <option value="${item.album_id}" 
                            <c:if test="${cancion.album_id == item.album_id}">
                                selected
                            </c:if>
                    >${item.titulo}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="genero_id" class="form-label">Género</label>
            <select name="genero_id" class="form-control">
                <option value="">-- seleccione --</option>
                <c:forEach var="item" items="${lista_genero}">
                    <option value="${item.genero_id}" 
                            <c:if test="${cancion.genero_id == item.genero_id}">
                                selected
                            </c:if>
                    >${item.nombre}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="grupo_id" class="form-label">Grupo</label>
            <select name="grupo_id" class="form-control">
                <option value="">-- seleccione --</option>
                <c:forEach var="item" items="${lista_grupo}">
                    <option value="${item.grupo_id}" 
                            <c:if test="${cancion.grupo_id == item.grupo_id}">
                                selected
                            </c:if>
                    >${item.nombre}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="cancion_img" class="form-label">Imagen</label>
            <input type="text" class="form-control" name="cancion_img" value="${cancion.cancion_img}" placeholder="Imagen">
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
