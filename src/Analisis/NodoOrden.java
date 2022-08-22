/*
 */

package Analisis;

/**
 *
 * @author Karina Madrigal
 */
public class NodoOrden {
    
    private Solicitud dato;
    private NodoOrden next;
    private NodoOrden back;

    public NodoOrden() {
    }
    
    public NodoOrden(Solicitud dato) {
        this.dato = dato;
    }

    public Solicitud getDato() {
        return dato;
    }

    public void setDato(Solicitud dato) {
        this.dato = dato;
    }

    public NodoOrden getNext() {
        return next;
    }

    public void setNext(NodoOrden next) {
        this.next = next;
    }

    public NodoOrden getBack() {
        return back;
    }

    public void setBack(NodoOrden back) {
        this.back = back;
    }

    @Override
    public String toString() {
        return "" + dato;
    }
    
    
    

}
