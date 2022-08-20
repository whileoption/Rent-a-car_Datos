/*
 */
package Alquiler;

import Vehiculo.Vehiculo;

/**
 *
 * @author Karina Madrigal
 */
public class NodoA {

    private Vehiculo valor;
    private NodoA siguiente;

    public NodoA() {
        this.valor = null;
        this.siguiente = null;
    }

    public Vehiculo getValor() {
        return valor;
    }

    public void setValor(Vehiculo valor) {
        this.valor = valor;
    }

    public NodoA getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoA siguiente) {
        this.siguiente = siguiente;
    }

}