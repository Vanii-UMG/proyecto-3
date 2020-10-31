
package Servelets;

import basededatos.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clases.Articulo;
import clases.Orden;


public class Servicio extends HttpServlet {

  private String cliente;
    private String opcion;
    private Conexion cn;
    private String numeroOrden;
    private String cantidad;
    private String id_producto;
    private String nombre_producto;
    private String precio;
    private String id_orden;
    

    

  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            opcion = request.getParameter("option");

            cn = new Conexion();
            switch (opcion) {
                case "crear":
                    if (request.getParameter("cliente") != null) {
                        cliente = request.getParameter("cliente");
                        Orden temp = new Orden();
                        temp.setId("0");
                        temp.setCliente(cliente);
                        cn.agregar(temp);
                        response.sendRedirect("add_producto_orden.jsp?cliente="+cliente+"");
                    } else {
                        response.sendRedirect("generar_orden.jsp?msg='seleciona un cliente'");
                    }
                    break;
                case "borrar":
                    numeroOrden = request.getParameter("orden");
                    cn.borrar(numeroOrden, true);
                    response.sendRedirect("borrar_orden.jsp?msg='true'");

                    break;
                case "agregar_art":

                    cantidad = request.getParameter("cantidad");
                    id_producto = request.getParameter("id_producto");
                    nombre_producto = request.getParameter("nombre_producto");
                    precio = request.getParameter("precio");
                    id_orden = request.getParameter("id_orden");
                    
                    cliente = request.getParameter("cliente");
                    
                    cn.agregar(new Articulo(id_orden,id_producto,nombre_producto,precio,cantidad));
                    response.sendRedirect("add_producto_orden.jsp?cliente="+cliente+"&"+"msg=has agregado " + cantidad + " uni de "+nombre_producto+" a la Orden"+id_orden);

                    break;
                

            }

        } catch (Exception ex) {

        }

    }


   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
