/*
 */
package Cliente;

/**
 *
 * @author Karina Madrigal
 */
public class NodoC {

    private Cliente dato;
    private NodoC next;

    public NodoC(Cliente dato) {
        this.dato = dato;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoC getNext() {
        return next;
    }

    public void setNext(NodoC next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + this.dato;
    }

}
