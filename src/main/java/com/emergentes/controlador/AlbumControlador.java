package com.emergentes.controlador;

import com.emergentes.dao.AlbumDAO;
import com.emergentes.dao.AlbumDAOimpl;
import com.emergentes.dao.ArtistaDAO;
import com.emergentes.dao.ArtistaDAOimpl;
import com.emergentes.dao.GeneroDAO;
import com.emergentes.dao.GeneroDAOimpl;
import com.emergentes.modelo.Album;
import com.emergentes.modelo.Artista;
import com.emergentes.modelo.Genero;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlbumControlador", urlPatterns = {"/AlbumControlador"})
public class AlbumControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AlbumDAO dao = new AlbumDAOimpl();
            ArtistaDAO daoArtista = new ArtistaDAOimpl();
            GeneroDAO daoGenero = new GeneroDAOimpl();
            int id;
            List<Artista> lista_artista = null;
            List<Genero> lista_genero = null;
            Album album = new Album();
	    
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_artista = daoArtista.getAll();
                    lista_genero = daoGenero.getAll();
                    request.setAttribute("lista_artista",lista_artista);
                    request.setAttribute("lista_genero",lista_genero);
                    request.setAttribute("album", album);
                    request.getRequestDispatcher("frmalbum.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    album = dao.getById(id);
                    lista_artista = daoArtista.getAll();
                    lista_genero = daoGenero.getAll();
                    request.setAttribute("lista_artista",lista_artista);
                    request.setAttribute("lista_genero",lista_genero);
                    request.setAttribute("album", album);
                    request.getRequestDispatcher("frmalbum.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("album_id"));
                    dao.delete(id);
                    response.sendRedirect("AlbumControlador");
                    break;
                case "view":
                    List<Album> lista = dao.getAll();
                    request.setAttribute("album", lista);
                    request.getRequestDispatcher("album.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("album_id"));
        String titulo = request.getParameter("titulo");
        int artista_id = Integer.parseInt(request.getParameter("artista_id"));
        int genero_id = Integer.parseInt(request.getParameter("genero_id"));
        String fecha_lanzamiento = request.getParameter("fecha_lanzamiento");
        String portada_img = request.getParameter("portada_img");
        Album album = new Album();

        album.setAlbum_id(id);
        album.setTitulo(titulo);
        album.setArtista_id(artista_id);
        album.setGenero_id(genero_id);
        album.setFecha_lanzamiento(convierteFecha(fecha_lanzamiento));
        album.setPortada_img(portada_img);

        if (id == 0) {
            AlbumDAO dao = new AlbumDAOimpl();
            try {
                dao.insert(album);
                response.sendRedirect("AlbumControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            AlbumDAO dao = new AlbumDAOimpl();
            try {
                dao.update(album);
                response.sendRedirect("AlbumControlador");
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
    }
    public Date convierteFecha(String fecha){
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(AlbumControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaBD;
    }
}
