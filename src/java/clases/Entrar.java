
package clases;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import basededatos.Conexion;

public class Entrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //esto sirve para...

        Conexion con = null;
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pswd");
        try {
            con = new Conexion();
            Usuario temp = con.validarUsuario(usuario, pass);
            if (temp.getNombre() != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario_uso", temp);
                response.sendRedirect("principal.jsp");
            } else {
                response.sendRedirect("index.jsp?msg='false'");
            }
        } catch (Exception e) {
            response.sendRedirect("index.jsp?msg="+e.getMessage());
        }
    }
}
