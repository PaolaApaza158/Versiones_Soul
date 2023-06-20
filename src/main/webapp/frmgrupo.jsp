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
            <jsp:param name="opcion" value="grupo"/>
        </jsp:include>
        <div class="container">
            <h1>Formulario de Grupo </h1>

            <br>
            <form action = "GrupoControlador" method="post">
                <input type="hidden" name="grupo_id" value="${grupo.grupo_id}">
                <div class="mb-3">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${grupo.nombre}" placeholder="Escriba el nombre del grupo">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Imagen Grupo</label>
                    <input type="text" class="form-control" name="grupo_img" value="${grupo.grupo_img}" placeholder="Imagen de grupo">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>

