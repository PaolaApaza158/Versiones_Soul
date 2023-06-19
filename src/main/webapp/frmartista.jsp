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
            <jsp:param name="opcion" value="artista"/>
        </jsp:include>
        <div class="container">
            <h1>Formulario de Artista </h1>

            <br>
            <form action = "ArtistaControlador" method="post">
                <input type="hidden" name="artista_id" value="${artista.genero_id}">
                <div class="mb-3">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${artista.nombre}" placeholder="Escriba el nombre del artista">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Género</label>
                    <select class="form-select" name="genero">
                        <option value="Hombre">Hombre</option>
                        <option value="Mujer">Mujer</option>

                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Fecha de Nacimiento</label>
                    <input type="date" class="form-control" name="fecha_nacimiento" value="${artista.fecha_nacimiento}" placeholder="Escriba la fecha de nacimiento">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Nacionalidad</label>
                    <input type="text" class="form-control" name="nacionalidad" value="${artista.nacionalidad}" placeholder="Escriba la nacionalidad">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Imagen</label>
                    <input type="text" class="form-control" name="imagen" value="${artista.imagen}" placeholder="Imagen">
                </div>



                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
