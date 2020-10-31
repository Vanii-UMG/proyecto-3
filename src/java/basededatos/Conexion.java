package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import clases.Articulo;
import clases.Empresa;
import clases.Individual;
import clases.Orden;
import clases.Producto;
import clases.Usuario;

public class Conexion {

    Connection miConexion;
    Statement miStatement;
    ResultSet miResultSet;

    public Conexion() throws SQLException, ClassNotFoundException {
//se uso el drive porsgressql
        Class.forName("org.postgresql.Driver");
        this.miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ingresar", "postgres", "vanii123");
        this.miStatement = miConexion.createStatement();
    }

    public Usuario validarUsuario(String usuario, String pass) throws SQLException {
        Usuario tempUser = new Usuario();
        miResultSet = miStatement.executeQuery("SELECT * FROM usuario WHERE usuario='" + usuario + "' AND password='" + pass + "'");

        while (miResultSet.next()) {
            tempUser.setUsuario(miResultSet.getString(1));
            tempUser.setNombre(miResultSet.getString(2));
            tempUser.setPassword(miResultSet.getString(3));
            tempUser.setEmail(miResultSet.getString(4));
        }

        return tempUser;
    }

    public int sumar(String campo, String nombreTabla) throws SQLException {

        ResultSet miResultSet2 = miStatement.executeQuery("SELECT SUM(" + campo + ") AS total FROM " + nombreTabla + ";");
        int contador = 0;
        while (miResultSet2.next()) {

            contador = Integer.parseInt(miResultSet2.getString("total"));
        }

        return contador;
    }

    public ResultSet getTablaData(String tableName) throws SQLException {
        miResultSet = miStatement.executeQuery("SELECT * FROM " + tableName + "");
        return miResultSet;
    }

    public void agregar(Individual c) throws SQLException {

        miStatement.executeUpdate("INSERT INTO cliente(nombre, apellido, nit, tipo, dpi) VALUES('" + c.getNombre() + "','" + c.getApellido() + "','" + c.getNit() + "','" + c.getTipo() + "','" + c.getDPI() + "')");

    }

    public void agregar(Empresa c) throws SQLException {

        miStatement.executeUpdate("INSERT INTO cliente(nombre, apellido, nit, tipo, contacto, descuento) VALUES('" + c.getNombre() + "','" + c.getApellido() + "','" + c.getNit() + "','" + c.getTipo() + "','" + c.getContacto() + "','" + c.getDescuento() + "')");

    }

    public void agregar(Producto p) throws SQLException {
        miStatement.executeUpdate("INSERT INTO producto(nombre, precio, marca) VALUES('" + p.getProducto() + "','" + p.getPrecio() + "','" + p.getMarca() + "')");

    }

    public void agregar(Orden o) throws SQLException {
        miStatement.executeUpdate("INSERT INTO orden(id_cliente) VALUES('" + o.getCliente() + "')");

    }

    public void borrar(String q) throws SQLException {

        miStatement.executeUpdate("DELETE FROM cliente WHERE id=" + q + "");
    }

    public void borrar(String q, String table) throws SQLException {

        miStatement.executeUpdate("DELETE FROM " + table + " WHERE codigo=" + q + "");
    }

    public void borrar(String numeroOrden, boolean s) throws SQLException {

        miStatement.executeUpdate("DELETE FROM orden WHERE id_orden=" + numeroOrden + "");
    }

    public void update(Producto p, String q) throws SQLException {
        miStatement.executeUpdate("UPDATE producto SET nombre='" + p.getProducto() + "', precio='" + p.getPrecio() + "', marca='" + p.getMarca() + "' WHERE codigo='" + q + "'");

    }

    public void agregar(Articulo a) throws SQLException {
        int cantidadTemp = Integer.parseInt(a.getCantidad());
        float precioTemp = Float.parseFloat(a.getPrecio());
        float total = (precioTemp * cantidadTemp);
        miStatement.executeUpdate("INSERT INTO detalle(orden_id, producto_id, nombre, precio, cantidad, total) VALUES('" + a.getOrden() + "','" + a.getPrductoID() + "','" + a.getProductoNombre() + "','" + a.getPrecio() + "','" + a.getCantidad() + "','" + total + "')");

    }

}
