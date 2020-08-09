package web;

import datos.RegistroDaoJDBC;
import dominio.Registro;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Registro> registros = new RegistroDaoJDBC().listar();
        System.out.println("registros = " + registros);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("registros", registros);
        sesion.setAttribute("totalClientes", registros.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(registros));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }

    private double calcularSaldoTotal(List<Registro> registros) {
        double saldoTotal = 0;
        for (Registro cliente : registros) {
            saldoTotal += cliente.getPercioVenta();
        }
        return saldoTotal;
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        int id = Integer.parseInt(request.getParameter("id"));
        Registro registro = new RegistroDaoJDBC().encontrar(new Registro(id));
        request.setAttribute("registro", registro);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarCliente
        String fechaAlta = request.getParameter("fechaAlta");
        String tipo = request.getParameter("tipo");
        String operacion = request.getParameter("operacion");
        String provincia = request.getParameter("provincia");
        int superficie = 0;
        String superficieString = request.getParameter("superficie");
        if (superficieString != null && !"".equals(superficieString)) {
            superficie = Integer.parseInt(superficieString);
        }
        int precioVenta = 0;
        String precioVentaString = request.getParameter("precioVenta");
        if (precioVentaString != null && !"".equals(precioVentaString)) {
            precioVenta = Integer.parseInt(precioVentaString);
        }
        String fechaVenta = request.getParameter("fechaVenta");
        String vendedor = request.getParameter("vendedor");

        //Creamos el objeto de registro (modelo)
        Registro registro = new Registro(fechaAlta, tipo,
                operacion, provincia, superficie, precioVenta, fechaVenta, vendedor);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new RegistroDaoJDBC().insertar(registro);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int id = Integer.parseInt(request.getParameter("id"));
        String fechaAlta = request.getParameter("fechaAlta");
        String tipo = request.getParameter("tipo");
        String operacion = request.getParameter("operacion");
        String provincia = request.getParameter("provincia");
        int superficie = 0;
        String superficieString = request.getParameter("superficie");
        if (superficieString != null && !"".equals(superficieString)) {
            superficie = Integer.parseInt(superficieString);
        }
        int precioVenta = 0;
        String precioVentaString = request.getParameter("precioVenta");
        if (precioVentaString != null && !"".equals(precioVentaString)) {
            precioVenta = Integer.parseInt(precioVentaString);
        }
        String fechaVenta = request.getParameter("fechaVenta");
        String vendedor = request.getParameter("vendedor");

        //Creamos el objeto de cliente (modelo)
        Registro registro = new Registro(id, fechaAlta, tipo,
                operacion, provincia, superficie, precioVenta, fechaVenta, vendedor);

        //Modificar el  objeto en la base de datos
        int registrosModificados = new RegistroDaoJDBC().actualizar(registro);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarRegistro
        int id = Integer.parseInt(request.getParameter("id"));

        //Creamos el objeto de cliente (modelo)
        Registro registro = new Registro(id);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new RegistroDaoJDBC().eliminar(registro);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

}
