package com.emergentes.controlador;

import com.emergentes.dao.ArtistaDAO;
import com.emergentes.dao.ArtistaDAOimpl;
import com.emergentes.modelo.Artista;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ArtistaControlador", urlPatterns = {"/ArtistaControlador"})
public class ArtistaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Artista art = new Artista();
            int id;
            ArtistaDAO dao = new ArtistaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    //art vacio
                    request.setAttribute("artista", art);
                    request.getRequestDispatcher("frmartista.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("artista_id"));
                    art = dao.getById(id);
                    //gen con datos
                    request.setAttribute("artista", art);
                    request.getRequestDispatcher("frmartista.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("artista_id"));
                    dao.delete(id);
                    response.sendRedirect("ArtistaControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Artista> lista = dao.getAll();
                    request.setAttribute("artista", lista);
                    request.getRequestDispatcher("artista.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("artista_id"));
        String nombre = request.getParameter("nombre");
        String genero = request.getParameter("genero");
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
        String nacionalidad = request.getParameter("nacionalidad");
        String artista_img = request.getParameter("artista_img");
        Artista art = new Artista();

        art.setArtista_id(id);
        art.setNombre(nombre);
        art.setGenero(genero);
        art.setFecha_nacimiento(fecha_nacimiento);
        art.setNacionalidad(nacionalidad);
        art.setArtista_img(artista_img);
       

        ArtistaDAO dao = new ArtistaDAOimpl();
        if (id == 0) {
            try {
                //nuevo registro
                dao.insert(art);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            try {
                //editar registro
                dao.update(art);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("ArtistaControlador");
    }

}
