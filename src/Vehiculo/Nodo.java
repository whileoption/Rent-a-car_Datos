/*
 */
package Vehiculo;

/**
 *
 * @author Karina Madrigal
 */
public class Nodo {

    private Vehiculo dato;
    private Nodo next;
    private Nodo back;

    public Nodo() {
    }

    public Nodo(Vehiculo dato) {
        this.dato = dato;
    }

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getBack() {
        return back;
    }

    public void setBack(Nodo back) {
        this.back = back;
    }
    
    
    @Override
    public String toString() {
        return "" + this.dato;
    }

}
