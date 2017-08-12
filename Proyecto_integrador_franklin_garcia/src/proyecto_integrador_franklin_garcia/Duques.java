/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_integrador_franklin_garcia;

/**
 *
 * @author Franklin Garcia
 */
public class Duques extends Piezas {

    public Duques() {
        super();
    }

    @Override
    public String toString() {
        return "+";
    }

    @Override
    public int movimientos(String[][] tablero, int fila1, int columna1, int fila2, int columna2) {
        if (fila1 == fila2 || columna1 == columna2) {
            return 1;
        }else{
            return 2;
        }
    }

}
