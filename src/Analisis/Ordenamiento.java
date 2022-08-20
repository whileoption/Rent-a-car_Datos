package Analisis;

import java.util.Comparator;

/**
 * Contiene el metodo de comparacion en un ArrayList con dos parametros
 *
 * @author Karina Madrigal Este codigo es una adaptación de
 * https://www.youtube.com/watch?v=EPQJDGI2pFA y de
 * https://www.geeksforgeeks.org/collections-sort-java-examples/
 * https://jarroba.com/ordenar-un-arraylist-en-java/
 */
public class Ordenamiento implements Comparator<SeleccionVehiculo> {

    @Override
    public int compare(SeleccionVehiculo o1, SeleccionVehiculo o2) {

//        ///*
//        //Compara el accuracy
//        if (o1.getAcc() < o2.getAcc()) { //acc de o1 menor
//            //Si acc de o1 es menor que o2, se ubica antes
//            return o1.getAcc() - o2.getAcc();
//        } //Compara el acc
//        else { //accc de o2 menor
//            //Si acc de o2 es menor que o1, se ubica antes
//            return o1.getAcc() - o2.getAcc();
//        } //acc iguales
        return new Integer(o2.getAcc()).compareTo(new Integer(o1.getAcc()));
    }
}
