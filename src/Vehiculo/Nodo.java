/*
 */
package Vehiculo;

/**
 *
 * @author Karina Madrigal
 */
public class Nodo {

    private Vehiculo valor;
    private Nodo siguiente;

    public Nodo() {
        this.valor = null;
        this.siguiente = null;
    }

    public Vehiculo getValor() {
        return valor;
    }

    public void setValor(Vehiculo valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    

}
