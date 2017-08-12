/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_integrador_franklin_garcia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Franklin Garcia
 */
public class Proyecto_integrador_franklin_garcia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String opcion = "";
        ArrayList<Jugador>lista=new ArrayList();
        while (!opcion.equalsIgnoreCase("3")) {
            opcion = JOptionPane.showInputDialog("Opcion \n"
                    + "1-Crear jugador \n"
                    + "2-Jugar \n"
                    + "3-Salir \n");
            switch (opcion) {
                case "1": {
                    String nombre=JOptionPane.showInputDialog("Nombre");
                    lista.add(new Jugador(nombre,0));
                    JOptionPane.showInputDialog("Hecho");
                }
                break;
                case "2": {
                    

                }
                break;
            }
        }
    }//fin del main
    
    public static String [][] tablero(){
     Rey r=new Rey();
     Duques d=new Duques();
     Rebeldes re=new Rebeldes();
        String temporal[][]=new String[20][20];
        for (int i = 0; i < temporal.length-1; i++) {
            for (int j = 0; j < temporal[i].length-1; j++) {
                temporal[i][j]="[ ]";
            }
        }
        //Rebeldes
        temporal[0][2]="["+re.toString() +"]";
        temporal[0][5]="["+re.toString() +"]";
        temporal[0][13]="["+re.toString() +"]";
        temporal[0][16]="["+re.toString() +"]";
        temporal[2][0]="["+re.toString() +"]";
        temporal[2][5]="["+re.toString() +"]";
        temporal[2][13]="["+re.toString() +"]";
        temporal[2][18]="["+re.toString() +"]";
        temporal[3][7]="["+re.toString() +"]";
        temporal[3][9]="["+re.toString() +"]";
        temporal[3][11]="["+re.toString() +"]";
        temporal[4][6]="["+re.toString() +"]";
        temporal[4][12]="["+re.toString() +"]";
        temporal[5][5]="["+re.toString() +"]";
        temporal[5][13]="["+re.toString() +"]";
        temporal[6][4]="["+re.toString() +"]";
        temporal[6][14]="["+re.toString() +"]";
        temporal[5][0]="["+re.toString() +"]";
        temporal[5][2]="["+re.toString() +"]";
        temporal[5][16]="["+re.toString() +"]";
        temporal[5][18]="["+re.toString() +"]";
        temporal[7][3]="["+re.toString() +"]";
        temporal[7][15]="["+re.toString() +"]";
        temporal[9][3]="["+re.toString() +"]";
        temporal[9][15]="["+re.toString() +"]";
        temporal[11][3]="["+re.toString() +"]";
        temporal[11][15]="["+re.toString() +"]";
        temporal[12][4]="["+re.toString() +"]";
        temporal[12][14]="["+re.toString() +"]";
        temporal[13][0]="["+re.toString() +"]";
        temporal[13][2]="["+re.toString() +"]";
        temporal[13][5]="["+re.toString() +"]";
        temporal[13][13]="["+re.toString() +"]";
        temporal[13][16]="["+re.toString() +"]";
        temporal[13][18]="["+re.toString() +"]";
        temporal[14][6]="["+re.toString() +"]";
        temporal[14][12]="["+re.toString() +"]";
        temporal[15][7]="["+re.toString() +"]";
        temporal[15][11]="["+re.toString() +"]";
        temporal[15][9]="["+re.toString() +"]";
        temporal[16][0]="["+re.toString() +"]";
        temporal[16][5]="["+re.toString() +"]";
        temporal[16][13]="["+re.toString() +"]";
        temporal[16][18]="["+re.toString() +"]";
        temporal[18][2]="["+re.toString() +"]";
        temporal[18][13]="["+re.toString() +"]";
        temporal[18][16]="["+re.toString() +"]";
        
        //rey 
        temporal[9][9]="["+r.toString() +"]";
        
        //Equis
        temporal[0][0]="[x]";
        temporal[0][1]="[x]";
        temporal[1][0]="[x]";
        temporal[1][1]="[x]";
        temporal[0][18]="[x]";
        temporal[0][17]="[x]";
        temporal[1][17]="[x]";
        temporal[1][18]="[x]";
        temporal[17][0]="[x]";
        temporal[17][1]="[x]";
        temporal[18][0]="[x]";
        temporal[18][1]="[x]";
        temporal[17][17]="[x]";
        temporal[17][18]="[x]";

        //Duques
        temporal[4][8]="["+d.toString() +"]";
        temporal[4][10]="["+d.toString() +"]";
        temporal[6][9]="["+d.toString() +"]";
        temporal[7][8]="["+d.toString() +"]";
        temporal[7][10]="["+d.toString() +"]";
        temporal[8][4]="["+d.toString() +"]";
        temporal[8][7]="["+d.toString() +"]";
        temporal[8][9]="["+d.toString() +"]";
        temporal[8][11]="["+d.toString() +"]";
        temporal[8][14]="["+d.toString() +"]";
        temporal[9][6]="["+d.toString() +"]";
        temporal[9][8]="["+d.toString() +"]";
        temporal[9][10]="["+d.toString() +"]";
        temporal[9][12]="["+d.toString() +"]";
        temporal[10][4]="["+d.toString() +"]";
        temporal[10][7]="["+d.toString() +"]";
        temporal[10][9]="["+d.toString() +"]";
        temporal[10][11]="["+d.toString() +"]";
        temporal[10][14]="["+d.toString() +"]";
        temporal[11][8]="["+d.toString() +"]";
        temporal[11][10]="["+d.toString() +"]";
        temporal[12][9]="["+d.toString() +"]";
        temporal[13][8]="["+d.toString() +"]";
        temporal[13][10]="["+d.toString() +"]";
        return temporal;
    }
    public static

}
