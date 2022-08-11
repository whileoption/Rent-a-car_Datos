/*
 */
package rentacar;


/**
 *
 * @author Karina Madrigal
 */
public class NodoVehiculo {

    private Vehiculo valor;
    private NodoVehiculo siguiente;

    public NodoVehiculo() {
        this.valor = null;
        this.siguiente = null;
    }

    public Vehiculo getValor() {
        return valor;
    }

    public void setValor(Vehiculo valor) {
        this.valor = valor;
    }

    public NodoVehiculo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVehiculo siguiente) {
        this.siguiente = siguiente;
    }
    
    

}
