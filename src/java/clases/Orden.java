
package clases;

import java.util.ArrayList;


public class Orden {
    
    
    private String id;
    private String cliente;
    private ArrayList<Articulo> articulos;

    public Orden() {
    }

    public Orden(String id, String cliente) {
        this.id = id;
        this.cliente = cliente;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    
    
    
}
