/*
 */

package rentacar;

/**
 *
 * @author Karina Madrigal
 */
public class Cliente {

    private int id;
    private String nombre, nacimiento, correo, categoria;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String nacimiento, 
            String correo, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.correo = correo;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + 
                ", nacimiento=" + nacimiento + ", correo=" + correo + 
                ", categoria=" + categoria + '}';
    }
    
    
    
}
