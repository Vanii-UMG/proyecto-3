package Servelets;

import basededatos.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Consultar extends HttpServlet {

    private String cliente;
    private Conexion cn;
    private String numeroOrden;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     

        numeroOrden = request.getParameter("orden");
        cliente = request.getParameter("cliente_id");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int descuento = 0;
            cn = new Conexion();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>detalles de orden</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
            out.println("</head>");
            out.println("<body style='width:60%; margin:auto;'>");

            out.println("<div class='w3-card w3-padding-large w3-pink'>");
            out.println("<p style='text-align:left; font-weight: bold;'> Fatura No A-" + numeroOrden + "</p>");

            ResultSet clienteinfo = cn.getTablaData("cliente WHERE id=" + cliente + "");

            out.print("<div style=\"text-align:center;\">");
            while (clienteinfo.next()) {

                out.print("<p>Cliente: " + clienteinfo.getString(2) + "</p>");

                out.print("<p>Nit: " + clienteinfo.getString(4) + "</p>");
                out.print("<p>Guatemala, Guatemala</p>");
                if (clienteinfo.getString(8) != null) {
                    descuento = Integer.parseInt(clienteinfo.getString(8));
                }
            }
            out.print("</div>");
            out.println("<hr/>");

            ResultSet articulos = cn.getTablaData("detalle WHERE orden_id=" + numeroOrden + "");
            out.println("<div class=\"container\">");
            out.println("<table class=\"w3-table w3-bordered\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>No.</th>");
            out.println("<th>Descripcion</th>");
            out.println("<th>Precio</th>");
            out.println("<th>Cantidad</th>");
            out.println("<th>Sub total</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            int contador = 1;
            while (articulos.next()) {

                out.println("<tr>");
                out.println("<td>" + contador + "</td>");
                out.println("<td>" + articulos.getString(3) + "</td>");
                out.println("<td>Q " + articulos.getString(4) + ".00</td>");
                out.println("<td>" + articulos.getString(5) + "</td>");
                out.println("<td>Q " + articulos.getString(6) + ".00</td>");
                out.println("</tr>");
                contador++;

            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("<hr/>");
            int totalFactura = cn.sumar("total", "detalle WHERE orden_id=" + numeroOrden + "");
            int neto = (totalFactura * descuento) / 100;
            if (descuento > 0) {
                out.println("<p> Descuento: Q " + neto + ".00</p>");
                out.println("<p> Total: Q " + (totalFactura - neto) + ".00</p>");
            } else {
                out.println("<h3> Total: Q " + totalFactura + ".00</h3>");
            }

            out.println("<hr/>");
            out.println("</div>");
            out.print("<p><a href=\"reporte_de_ordenes.jsp\" class=\"w3-button w3-pink w3-block w3-hover-brown w3-padding-16\">Ver otra orden</a></p>");
            out.print("<p><a href=\"principal.jsp\" class=\"w3-button w3-pink w3-block w3-hover-brown w3-padding-16\">Menu principal</a></p>");

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            response.sendRedirect("orden.jsp?msg='failed'");
        } finally {
            cn = null;
        }

    }

}
