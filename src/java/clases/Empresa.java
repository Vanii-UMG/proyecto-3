
package clases;


public class Empresa extends Cliente{
    
    private String contacto;
    private int descuento;

    public Empresa(int id,String contacto, int descuento, String nombre, String apellido,String  nit, String tipo) {
        super(id,nombre, apellido, nit, tipo);
        this.contacto = contacto;
        this.descuento = descuento;
    }

    public String getContacto() {
        return contacto;
    }
    


    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getDescuento() {
        return descuento;
    }
   

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
     
    
}
