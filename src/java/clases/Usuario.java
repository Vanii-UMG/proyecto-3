
package clases;

public class Usuario {
    
    
    private String usuario;
    private String nombre;
    private String password;
    private String email;
    
    public Usuario(){}

    public Usuario(String usuario, String nombre, String password, String email) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
