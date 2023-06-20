<%
    String opcion = request.getParameter("opcion");
%>
<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Soul</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link <%=(opcion.equals("genero")) ? "active" : ""%>" aria-current="page" href="GeneroControlador">Género</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=(opcion.equals("artista")) ? "active" : ""%>" href="ArtistaControlador">Artista</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=(opcion.equals("album")) ? "active" : ""%>" href="AlbumControlador">Álbum</a>
                    </li>
                      <a class="nav-link <%=(opcion.equals("cancion")) ? "active" : ""%>" aria-current="page" href="CancionControlador">Cancion</a>
                    <li class="nav-item">
                        <a class="nav-link <%=(opcion.equals("grupo")) ? "active" : ""%>" href="GrupoControlador">Grupo</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=(opcion.equals("usuarios") )? "active" : ""%>" href="UsuarioControlador">Usuarios</a>
                    </li>
                </ul>
                <a href="Login?action=logout" class="btn btn-outline-success">Cerrar sesión</a>
            </div>
        </div>
    </nav>
</header>