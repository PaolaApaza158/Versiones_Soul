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
                    <label for="" class="form-label">Título</label>
                    <input type="text" class="form-control" name="titulo" value="${cancion.titulo}" placeholder="Escriba el título de la canción">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Duración</label>
                    <input type="text" class="form-control" name="duracion" value="${cancion.duracion}" placeholder="Escriba la duración de la canción">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Fecha</label>
                    <input type="date" class="form-control" name="fecha" value="${cancion.fecha}" placeholder="Seleccione la fecha de la canción">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Artista ID</label>
                    <input type="number" class="form-control" name="artista_id" value="${cancion.artista_id}" placeholder="Escriba el ID del artista">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Álbum ID</label>
                    <input type="number" class="form-control" name="album_id" value="${cancion.album_id}" placeholder="Escriba el ID del álbum">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Género ID</label>
                    <input type="number" class="form-control" name="genero_id" value="${cancion.genero_id}" placeholder="Escriba el ID del género">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Grupo ID</label>
                    <input type="number" class="form-control" name="grupo_id" value="${cancion.grupo_id}" placeholder="Escriba el ID del grupo">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Imagen</label>
                    <input type="text" class="form-control" name="cancion_img" value="${cancion.cancion_img}" placeholder="Imagen">
                </div>

                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
