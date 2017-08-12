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
public abstract class Piezas {

    public Piezas() {
    }
    
    public  abstract int movimientos(String [][] tablero, int fila1,int columna1, int fila2 ,int columna2);
}
