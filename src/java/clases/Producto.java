package clases;

public class Producto {
    
    private String producto;
    private String precio;
    private String marca;

    public Producto(String producto, String precio, String marca) {
        this.producto = producto;
        this.precio = precio;
        this.marca = marca;
    }
    
    
    
    public Producto(){}

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    
}
