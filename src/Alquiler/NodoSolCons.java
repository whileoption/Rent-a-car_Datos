/*
 */
package Alquiler;

import Analisis.Solicitud;

/**
 *
 * @author Karina Madrigal
 */
public class NodoSolCons {

    private Solicitud dato;
    private NodoSolCons atras;

    public NodoSolCons(Solicitud dato) {
        this.dato = dato;
    }

    public Solicitud getDato() {
        return dato;
    }

    public void setDato(Solicitud dato) {
        this.dato = dato;
    }

    public NodoSolCons getAtras() {
        return atras;
    }

    public void setAtras(NodoSolCons atras) {
        this.atras = atras;
    }
    
    @Override
    public String toString() {
        return "" +this.dato;
    }

}
