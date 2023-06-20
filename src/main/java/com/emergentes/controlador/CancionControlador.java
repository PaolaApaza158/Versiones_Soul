package com.emergentes.controlador;

import com.emergentes.dao.AlbumDAO;
import com.emergentes.dao.AlbumDAOimpl;
import com.emergentes.dao.ArtistaDAO;
import com.emergentes.dao.ArtistaDAOimpl;
import com.emergentes.dao.CancionDAO;
import com.emergentes.dao.CancionDAOimpl;
import com.emergentes.dao.GeneroDAO;
import com.emergentes.dao.GeneroDAOimpl;
import com.emergentes.dao.GrupoDAO;
import com.emergentes.dao.GrupoDAOimpl;
import com.emergentes.modelo.Album;
import com.emergentes.modelo.Artista;
import com.emergentes.modelo.Cancion;
import com.emergentes.modelo.Genero;
import com.emergentes.modelo.Grupo;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CancionControlador", urlPatterns = {"/CancionControlador"})
public class CancionControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CancionDAO dao = new CancionDAOimpl();

            AlbumDAO daoAlbum = new AlbumDAOimpl();
            ArtistaDAO daoArtista = new ArtistaDAOimpl();
            GeneroDAO daoGenero = new GeneroDAOimpl();
            GrupoDAO daoGrupo = new GrupoDAOimpl();

            int id;

            List<Album> lista_album = null;
            List<Artista> lista_artista = null;
            List<Genero> lista_genero = null;
            List<Grupo> lista_grupo = null;

            Cancion cancion = new Cancion();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_artista = daoArtista.getAll();
                    lista_album = daoAlbum.getAll();
                    lista_genero = daoGenero.getAll();
                    lista_grupo = daoGrupo.getAll();

                    request.setAttribute("lista_artista", lista_artista);
                    request.setAttribute("lista_album", lista_album);
                    request.setAttribute("lista_genero", lista_genero);
                    request.setAttribute("lista_grupo", lista_grupo);

                    request.setAttribute("cancion", cancion);

                    request.getRequestDispatcher("frmcancion.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("cancion_id"));
                    cancion = dao.getById(id);

                    lista_artista = daoArtista.getAll();
                    lista_album = daoAlbum.getAll();
                    lista_genero = daoGenero.getAll();
                    lista_grupo = daoGrupo.getAll();

                    request.setAttribute("lista_artista", lista_artista);
                    request.setAttribute("lista_album", lista_album);
                    request.setAttribute("lista_genero", lista_genero);
                    request.setAttribute("lista_grupo", lista_grupo);

                    request.setAttribute("cancion", cancion);

                    request.getRequestDispatcher("frmcancion.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("cancion_id"));
                    dao.delete(id);
                    response.sendRedirect("CancionControlador");
                    break;
                case "view":
                    List<Cancion> lista = dao.getAll();
                    request.setAttribute("cancion", lista);
                    request.getRequestDispatcher("cancion.jsp").forward(request, response);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("cancion_id"));
    String titulo = request.getParameter("titulo");
    String duracionStr = request.getParameter("duracion");
    String fecha = request.getParameter("fecha");

    int artista_id = Integer.parseInt(request.getParameter("artista_id"));
    int album_id = Integer.parseInt(request.getParameter("album_id"));
    int genero_id = Integer.parseInt(request.getParameter("genero_id"));
    int grupo_id = Integer.parseInt(request.getParameter("grupo_id"));
    String cancion_img = request.getParameter("cancion_img");

    Cancion cancion = new Cancion();

    cancion.setCancion_id(id);
    cancion.setTitulo(titulo);
    cancion.setFecha(fecha);
    cancion.setArtista_id(artista_id);
    cancion.setAlbum_id(album_id);
    cancion.setGenero_id(genero_id);
    cancion.setGrupo_id(grupo_id);
    cancion.setCancion_img(cancion_img);

    try {
        // Manejo de la duración de la canción
        String[] duracionParts = duracionStr.split(":");
        int horas = Integer.parseInt(duracionParts[0]);
        int minutos = Integer.parseInt(duracionParts[1]);
        int segundos = Integer.parseInt(duracionParts[2]);
        int duracion = horas * 3600 + minutos * 60 + segundos;
        cancion.setDuracion(duracion);

        CancionDAO dao = new CancionDAOimpl();

        if (id == 0) {
            dao.insert(cancion);
        } else {
            dao.update(cancion);
        }

        response.sendRedirect("CancionControlador");
    } catch (Exception ex) {
        System.out.println("Error al procesar la solicitud: " + ex.getMessage());
    }
}


}
