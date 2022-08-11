/*
 */
package rentacar;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Karina Madrigal
 */
public class PilaVehiculo {

    private NodoVehiculo cima;
    private int longitud;

    public PilaVehiculo() {
        this.cima = null;
        this.longitud = 0;
    }

    public boolean Vacia() {
        return cima == null;
    }

    public int tamano() {
        return longitud;
    }

    //se agregan nodos
    public void push(Vehiculo valor) {
        NodoVehiculo newNode = new NodoVehiculo();
        newNode.setValor(valor);
        if (this.Vacia()) {
            this.cima = newNode;
        } else {
            newNode.setSiguiente(this.cima);
            this.cima = newNode;
        }
        this.longitud++;
    }

    //elimina el nodo de la cima
    public void pop() {
        if (!Vacia()) {
            //Asigna como primer nodo al siguiente de la pila
            this.cima = this.cima.getSiguiente();
            //Decrementa el contador del tamaño de la pila
            this.longitud--;
        }
    }

    //Busca el nodo segun valor y retorna true si exise y false si no existe
    public boolean search(String reference) {
        NodoVehiculo aux = cima;
        boolean exist = false;
        while (exist != true && aux != null) {
            if (reference.toLowerCase().
                    equals(aux.getValor().getPlaca().toLowerCase())) {
                exist = true;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return exist;
    }

    //Elimina según referencia
    public void delete(String reference) {
        //Consulta si el valor existe en la pila
        if (search(reference)) {
            NodoVehiculo cimaPilaAux = null;
            //Recorre la pila hasta llegar al nodo que tenga el valor 
            //igual que el de reference
            while (!reference.toLowerCase()
                    .equals(cima.getValor().getPlaca().toLowerCase())) {
                //Cra un nodo temporal para agregarlos a la pila auxiliar
                NodoVehiculo temp = new NodoVehiculo();
                //Ingresa el valor al node temmporal
                temp.setValor(cima.getValor());
                //Consulta si la pila auxiliar no ha sido inicializada
                if (cimaPilaAux == null) {
                    //Inicializa la pila auxiliar
                    cimaPilaAux = temp;
                } //Caso contrario si la pila auxiliar ya contiene elementos
                //los agrega
                else {
                    temp.setSiguiente(cimaPilaAux);
                    cimaPilaAux = temp;
                }
                //Elimina el nodo del tope de la pila hasta llegar al nodo
                //que se desea eliminar
                pop();
            }
            //Elimina el nodo que coincide con el de reference
            pop();
            //Regresa los valores de la pila auxiliar a la pila original
            //mientras la pila auxiliar tenga elementos
            while (cimaPilaAux != null) {
                //Utiliza el metodo push para regresar elementos a la pila original
                push(cimaPilaAux.getValor());
            }
            //Libera la memoria utilizada por la pila auxiliar
            cimaPilaAux = null;
            JOptionPane.showMessageDialog(null, "El registro se eliminó "
                    + "exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "La placa indicada no esta "
                    + "registrada");
        }
    }

    //Busca el nodo segun valor y retorna true si exise y false si no existe
    public Vehiculo obtain(String reference) {
        NodoVehiculo aux = cima;
        Vehiculo exist = null;

        while (search(reference)
                && aux.getValor().getPlaca().equals(reference.toLowerCase())) {
            exist = new Vehiculo(aux.getValor().getPlaca(),
                    aux.getValor().getMarca(), aux.getValor().getModelo(),
                    aux.getValor().getAnno(), aux.getValor().getColor(),
                    aux.getValor().getCilindrada(), aux.getValor().getCombustible(),
                    aux.getValor().getPasajeros(), aux.getValor().getAlquiler(),
                    aux.getValor().getEstado(), aux.getValor().getExtras());
            aux = aux.getSiguiente();
        }
        return exist;
    }

    //La idea es que vaya en una tabla! OJO
    public String Listar() {
        String cad = "";
        //Crea una copia de la pila
        NodoVehiculo aux = cima;
        //Recorre la pila hasta el ultimo node
        while (aux != null) {
            cad += ("|\t" + aux.getValor() + "|\t");
            cad += ("-----------------");
            aux = aux.getSiguiente();
        }
        return cad;
    }

}
