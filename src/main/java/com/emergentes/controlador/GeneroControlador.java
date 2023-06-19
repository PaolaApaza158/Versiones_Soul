package com.emergentes.controlador;

import com.emergentes.dao.GeneroDAO;
import com.emergentes.dao.GeneroDAOimpl;
import com.emergentes.modelo.Genero;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GeneroControlador", urlPatterns = {"/GeneroControlador"})
public class GeneroControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Genero gen = new Genero();
            int id;
            GeneroDAO dao = new GeneroDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    //gen vacio
                    request.setAttribute("genero", gen);
                    request.getRequestDispatcher("frmgenero.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("genero_id"));
                    gen = dao.getById(id);
                    //gen con datos
                    request.setAttribute("genero", gen);
                    request.getRequestDispatcher("frmgenero.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("genero_id"));
                    dao.delete(id);
                    response.sendRedirect("GeneroControlador");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Genero> lista = dao.getAll();
                    request.setAttribute("genero", lista);
                    request.getRequestDispatcher("genero.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("genero_id"));
        String nombre = request.getParameter("nombre");
        Genero gen = new Genero();

        gen.setGenero_id(id);
        gen.setNombre(nombre);
       

        GeneroDAO dao = new GeneroDAOimpl();
        if (id == 0) {
            try {
                //nuevo registro
                dao.insert(gen);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            try {
                //editar registro
                dao.update(gen);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("GeneroControlador");
    }
}
