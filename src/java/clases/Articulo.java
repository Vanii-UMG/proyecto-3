package clases;

public class Articulo {
    
    private String orden;
    private String prductoID;
    private String productoNombre;
    private String precio;
    private String cantidad;

    public Articulo(String orden, String prductoID, String productoNombre, String precio, String cantidad) {
        this.orden = orden;
        this.prductoID = prductoID;
        this.productoNombre = productoNombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getPrductoID() {
        return prductoID;
    }

    public void setPrductoID(String prductoID) {
        this.prductoID = prductoID;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

  
    
    
}
