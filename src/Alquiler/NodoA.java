package Alquiler;

public class NodoA {
    private Alquiler dato;
    private NodoA next;
    
    public NodoA() {
    }
    
    public NodoA(Alquiler dato) {
        this.dato = dato;
    }

    public Alquiler getDato() {
        return dato;
    }

    public void setDato(Alquiler dato) {
        this.dato = dato;
    }

    public NodoA getNext() {
        return next;
    }

    public void setNext(NodoA next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return "" + this.dato;
    }
}