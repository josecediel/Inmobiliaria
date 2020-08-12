package web;

import datos.RegistroDaoJDBC;
import dominio.Registro;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        List<Registro> registros = new RegistroDaoJDBC().listar();
        System.out.println("registros = " + registros);
        request.setAttribute("registros", registros);
        request.getRequestDispatcher("registros.jsp").forward(request, response);
    }
    
}
