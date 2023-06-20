
package com.emergentes.controlador;

import com.emergentes.dao.GrupoDAO;
import com.emergentes.dao.GrupoDAOimpl;
import com.emergentes.modelo.Grupo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GrupoControlador", urlPatterns = {"/GrupoControlador"})
public class GrupoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Grupo gru = new Grupo();
            int id;
            GrupoDAO dao = new GrupoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    request.setAttribute("grupo", gru);
                    request.getRequestDispatcher("frmgrupo.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("grupo_id"));
                    gru = dao.getById(id);
                    request.setAttribute("grupo", gru);
                    request.getRequestDispatcher("frmgrupo.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("grupo_id"));
                    dao.delete(id);
                    response.sendRedirect("GrupoControlador");
                    break;
                case "view":
                    List<Grupo> lista = dao.getAll(); 
                    request.setAttribute("grupo", lista);
                    request.getRequestDispatcher("grupo.jsp").forward(request, response);
                    break;
            }
        
        }catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("grupo_id"));
        String nombre = request.getParameter("nombre");
        String grupo_img = request.getParameter("grupo_img");
        
        Grupo gru = new Grupo();
        
        gru.setGrupo_id(id);
        gru.setNombre(nombre);
        gru.setGrupo_img(grupo_img);
        
        GrupoDAO dao = new GrupoDAOimpl();
        if(id == 0){
            try {
                dao.insert(gru);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }else{
            try {
                dao.update(gru);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        response.sendRedirect("GrupoControlador");
    }
}
