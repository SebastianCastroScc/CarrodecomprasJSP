
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.*;
import java.util.*;


@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if(accion.equals("insertar")){
            this.RegistrarProducto(request, response);
        }
    }
    
    //Metodo RegistrarProducto || throws es el control de errores
    private void RegistrarProducto(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        Productos p = new Productos();
        p.setNombre(request.getParameter("txtNom"));
        p.setPrecio(Integer.parseInt(request.getParameter("txtPre")));
        p.setImagen(request.getParameter("txtImg"));
        
        boolean rpta = ProductoDB.insertarProducto(p);
        if(rpta == true){
            response.sendRedirect("mensaje.jsp?men=Se registro con Exito");
        }else{
            response.sendRedirect("mensaje.jsp?men=Error al Registrar");
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    //La programación se hace en el doPost puesto que el formulario de registarProducto es tipo post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
