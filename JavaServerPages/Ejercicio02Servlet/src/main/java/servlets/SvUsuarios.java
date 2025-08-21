package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Usuario;


@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
/*
    //==== Metodo process Request =============================================
    // el servlet puede mostrar el codigo HTML o conectar HTML con las entidades
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvUsuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvUsuarios at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    //===========================================================================
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    */
    //===========================================================================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <Usuario> listaUsuarios = new ArrayList <>();
        listaUsuarios.add(new Usuario("123","Marcos", "Padilla", "6546545"));
        listaUsuarios.add(new Usuario("14ad5","Marcs", "Padilla", "6546545"));
        listaUsuarios.add(new Usuario("12asd3","Maria", "lobera", "6546545"));
        listaUsuarios.add(new Usuario("12asd3","Mtos", "Paasdla", "654asd5"));
        
        
       //---------------------------------------------------------------------
       HttpSession misesion = request.getSession();
       misesion.setAttribute("listaUsuarios", listaUsuarios);
       
       response.sendRedirect("exito.jsp");
        
        //---------------------------------------------------------------------
        
       
    }

    //===========================================================================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");

        //==== Hacemos comprobacion de si están llegando los datos==============
        System.out.println("dni"+dni);
        System.out.println("nombre"+nombre);
        System.out.println("apellido"+apellido);
        System.out.println("telefono"+telefono);
        
        // Por ahora, redireccionamos a una página JSP con mensaje
        response.sendRedirect("exito.jsp");   
    }
    //===========================================================================
}
