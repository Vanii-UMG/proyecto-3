
package clases;


public class Individual extends Cliente{
    
    private String DPI;

   

    public Individual(int id, String DPI, String nombre, String apellido, String nit, String tipo) {
        super(id, nombre, apellido, nit, tipo);
        this.DPI = DPI;
    }
   

    public String getDPI() {
        return DPI;
    }
    

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }
}
