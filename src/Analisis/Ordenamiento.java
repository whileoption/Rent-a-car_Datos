package Analisis;

import java.util.Comparator;

/**
 * Contiene el metodo de comparacion en un ArrayList con dos parametros
 *
 * @author Karina Madrigal Este codigo fue tomado de
 * https://jarroba.com/ordenar-un-arraylist-en-java/
 */
public class Ordenamiento implements Comparator<SeleccionVehiculo> {

    @Override
    public int compare(SeleccionVehiculo o1, SeleccionVehiculo o2) {
        return new Integer(o2.getAcc()).compareTo(new Integer(o1.getAcc()));
    }
}
