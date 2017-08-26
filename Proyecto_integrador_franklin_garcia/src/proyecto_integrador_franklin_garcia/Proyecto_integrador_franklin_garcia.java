package proyecto_integrador_franklin_garcia;

import java.util.ArrayList;
import java.util.Scanner;
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
        ArrayList<Jugador> lista = new ArrayList();
        Scanner lectura = new Scanner(System.in);
        Rey r = new Rey();
        Duques d = new Duques();
        Rebeldes re = new Rebeldes();
        while (!opcion.equalsIgnoreCase("3")) {
            opcion = JOptionPane.showInputDialog("Opcion \n"
                    + "1-Crear jugador \n"
                    + "2-Jugar \n"
                    + "3-Salir \n");
            switch (opcion) {
                case "1": {
                    String nombre = JOptionPane.showInputDialog("Nombre");
                    lista.add(new Jugador(nombre, 0));
                    JOptionPane.showMessageDialog(null, "Hecho");
                }
                break;
                case "2": {
                    int res = 0, cont = 0, fila1, columna1, fila2, columna2;
                    String elementos = "";
                    for (Jugador i : lista) {
                        elementos += "\n" + lista.indexOf(i) + " " + i;
                    }
                    int player1 = Integer.parseInt(JOptionPane.showInputDialog(elementos + "\n" + "Jugador-1 "));
                    int player2 = Integer.parseInt(JOptionPane.showInputDialog(elementos + "\n" + "Jugador-2"));

                    JOptionPane.showMessageDialog(null, "Jugadores \n"
                            + "Turno 1----rey y duques pertenece a: " + lista.get(player1).getNombre() + "\n"
                            + "Turno 2----Rebeldes pertenece a: " + lista.get(player2).getNombre() + "\n"
                            + "Rey & \n"
                            + "Duques + \n"
                            + "Rebelde  0 \n");
                    String tablero[][] = tablero();
                    impTablero(tablero, 0, 0);
                    System.out.println("");//salto de linea
                    while (res < 1000000000) {//////////////////////////////////////////////validacion general del juego
//...........................................Jugador1..............................................................                        
                        if (cont == 0) {
                            System.out.println("Turno 1 " + lista.get(player1).getNombre() + "\n");
                            System.out.println("Ingrese fila-1");
                            fila1 = lectura.nextInt();
                            System.out.println("Ingrese columna-1");
                            columna1 = lectura.nextInt();
//------------------------------------------Validacion de pertenencia-------------------------------------------------
                            while (pertenencia_player1(tablero, fila1, columna1) == 2) {
                                JOptionPane.showMessageDialog(null, "Esa pieza no te pertenece o es es vacio\n"
                                        + "Intentalo de nuevo");
                                System.out.println("Ingrese fila-1");
                                fila1 = lectura.nextInt();
                                System.out.println("Ingrese columna-1");
                                columna1 = lectura.nextInt();
                            }
//--------------------------------------------------------------------------------------------------------------------                            
                            System.out.println("Ingrese fila-2");
                            fila2 = lectura.nextInt();
                            System.out.println("Ingrse columna-2");
                            columna2 = lectura.nextInt();
//-------------------------------validaciones de movimientos jugador1---------------------------------------------------
                            while (tablero[fila1][columna1].equals("[+]") && d.movimientos(tablero, fila1, columna1, fila2, columna2) == 2) {
                                JOptionPane.showMessageDialog(null, "Movimeinto incorrecto intentalo de nuevo");
                                System.out.println("Ingrese fila-2");
                                fila2 = lectura.nextInt();
                                System.out.println("Ingrse columna-2");
                                columna2 = lectura.nextInt();
                            }
                            while (tablero[fila1][columna1].equals("[&]") && r.movimientos(tablero, fila1, columna1, fila2, columna2) == 2) {
                                JOptionPane.showMessageDialog(null, "Movimeinto incorrecto intentalo de nuevo");
                                System.out.println("Ingrese fila-2");
                                fila2 = lectura.nextInt();
                                System.out.println("Ingrse columna-2");
                                columna2 = lectura.nextInt();
                            }
                            while (pasar_player(tablero, fila1, columna1, fila2, columna2) == 2) {
                                JOptionPane.showMessageDialog(null, "Movimiento incorrecto hay una pieza de por medio intentalo de nuevo");
                                System.out.println("Ingrese fila-2");
                                fila2 = lectura.nextInt();
                                System.out.println("Ingrse columna-2");
                                columna2 = lectura.nextInt();
                            }
                            while (esquina(tablero, fila2, columna2, fila1, columna1) == 2) {
                                JOptionPane.showMessageDialog(null, "No se puede mover hacia las esquinas intentalo de nuevo");
                                System.out.println("Ingrese fila-2");
                                fila2 = lectura.nextInt();
                                System.out.println("Ingrse columna-2");
                                columna2 = lectura.nextInt();
                            }
//-----------------------------------------------------------------------------------------------------------------------                            
                            tablero[fila2][columna2] = tablero[fila1][columna1];
                            tablero[fila1][columna1] = "[ ]";
                            tablero = comer_player1(tablero);//comer
                            impTablero(tablero, 0, 0);
                            System.out.println("");//salto de linea

                            cont = 1;
                        }
//.........................................Jugador2.........................................................                        
                        if (cont == 1) {
                            System.out.println("Turno 2" + lista.get(player2).getNombre() + "\n");
                            System.out.println("Ingrese fila-1");
                            fila1 = lectura.nextInt();
                            System.out.println("Ingrese columna-1");
                            columna1 = lectura.nextInt();
//------------------------------------------Validacion de pertenencia-------------------------------------------------
                            while (pertenencia_player2(tablero, fila1, columna1) == 2) {
                                JOptionPane.showMessageDialog(null, "Esa pieza no te pertenece o es es vacio\n"
                                        + "Intentalo de nuevo");
                                System.out.println("Ingrese fila-1");
                                fila1 = lectura.nextInt();
                                System.out.println("Ingrese columna-1");
                                columna1 = lectura.nextInt();
                            }
//--------------------------------------------------------------------------------------------------------------------                            
                            System.out.println("Ingrese fila-2");
                            fila2 = lectura.nextInt();
                            System.out.println("Ingrse columna-2");
                            columna2 = lectura.nextInt();
//-------------------------------validaciones de movimientos jugador2---------------------------------------------------
                            while (tablero[fila1][columna1].equals("[0]") && re.movimientos(tablero, fila1, columna1, fila2, columna2) == 2) {
                                JOptionPane.showMessageDialog(null, "Movimeinto incorrecto intentalo de nuevo");
                                System.out.println("Ingrese fila-2");
                                fila2 = lectura.nextInt();
                                System.out.println("Ingrse columna-2");
                                columna2 = lectura.nextInt();
                            }
                            while (pasar_player(tablero, fila1, columna1, fila2, columna2) == 2) {
                                JOptionPane.showMessageDialog(null, "Movimiento incorrecto hay una pieza de por medio intentalo de nuevo");
                                System.out.println("Ingrese fila-2");
                                fila2 = lectura.nextInt();
                                System.out.println("Ingrse columna-2");
                                columna2 = lectura.nextInt();
                            }
                            while (esquina(tablero, fila2, columna2, fila1, columna1) == 2) {
                                JOptionPane.showMessageDialog(null, "No se puede mover hacia las esquinas intentalo de nuevo");
                                System.out.println("Ingrese fila-2");
                                fila2 = lectura.nextInt();
                                System.out.println("Ingrse columna-2");
                                columna2 = lectura.nextInt();
                            }
//-----------------------------------------------------------------------------------------------------------------------                            
                            tablero[fila2][columna2] = tablero[fila1][columna1];
                            tablero[fila1][columna1] = "[ ]";

                            tablero = comer_player2(tablero);//comer 
                            impTablero(tablero, 0, 0);
                            System.out.println("");//salto de linea
                            cont = 0;
                        }//fin jugador 2F
                        if (Ganar_player1(tablero)==2) {
                            System.out.println("Felicidades ha ganado: "+lista.get(player1).getNombre()); 
                            break;
                        }
                        if (Ganar_player2(tablero)==2) {
                            System.out.println("Felicidades ha ganado: "+lista.get(player2).getNombre());
                            break;
                        }
                        res++;
                    }
                }///fin de la programacion del juego
                break;
            }
        }
    }//fin del main

    public static String[][] tablero() {
        Rey r = new Rey();
        Duques d = new Duques();
        Rebeldes re = new Rebeldes();
        String temporal[][] = new String[19][19];
        for (int i = 0; i < temporal.length; i++) {
            for (int j = 0; j < temporal[i].length; j++) {
                temporal[i][j] = "[ ]";
            }
        }
        //Rebeldes
        temporal[0][2] = "[" + re.toString() + "]";
        temporal[0][5] = "[" + re.toString() + "]";
        temporal[0][13] = "[" + re.toString() + "]";
        temporal[0][16] = "[" + re.toString() + "]";
        temporal[2][0] = "[" + re.toString() + "]";
        temporal[2][5] = "[" + re.toString() + "]";
        temporal[2][13] = "[" + re.toString() + "]";
        temporal[2][18] = "[" + re.toString() + "]";
        temporal[3][7] = "[" + re.toString() + "]";
        temporal[3][9] = "[" + re.toString() + "]";
        temporal[3][11] = "[" + re.toString() + "]";
        temporal[4][6] = "[" + re.toString() + "]";
        temporal[4][12] = "[" + re.toString() + "]";
        temporal[5][5] = "[" + re.toString() + "]";
        temporal[5][13] = "[" + re.toString() + "]";
        temporal[6][4] = "[" + re.toString() + "]";
        temporal[6][14] = "[" + re.toString() + "]";
        temporal[5][0] = "[" + re.toString() + "]";
        temporal[5][2] = "[" + re.toString() + "]";
        temporal[5][16] = "[" + re.toString() + "]";
        temporal[5][18] = "[" + re.toString() + "]";
        temporal[7][3] = "[" + re.toString() + "]";
        temporal[7][15] = "[" + re.toString() + "]";
        temporal[9][3] = "[" + re.toString() + "]";
        temporal[9][15] = "[" + re.toString() + "]";
        temporal[11][3] = "[" + re.toString() + "]";
        temporal[11][15] = "[" + re.toString() + "]";
        temporal[12][4] = "[" + re.toString() + "]";
        temporal[12][14] = "[" + re.toString() + "]";
        temporal[13][0] = "[" + re.toString() + "]";
        temporal[13][2] = "[" + re.toString() + "]";
        temporal[13][5] = "[" + re.toString() + "]";
        temporal[13][13] = "[" + re.toString() + "]";
        temporal[13][16] = "[" + re.toString() + "]";
        temporal[13][18] = "[" + re.toString() + "]";
        temporal[14][6] = "[" + re.toString() + "]";
        temporal[14][12] = "[" + re.toString() + "]";
        temporal[15][7] = "[" + re.toString() + "]";
        temporal[15][11] = "[" + re.toString() + "]";
        temporal[15][9] = "[" + re.toString() + "]";
        temporal[16][0] = "[" + re.toString() + "]";
        temporal[16][5] = "[" + re.toString() + "]";
        temporal[16][13] = "[" + re.toString() + "]";
        temporal[16][18] = "[" + re.toString() + "]";
        temporal[18][2] = "[" + re.toString() + "]";
        temporal[18][13] = "[" + re.toString() + "]";
        temporal[18][16] = "[" + re.toString() + "]";
        temporal[18][5] = "[" + re.toString() + "]";

        //rey 
        temporal[9][9] = "[" + r.toString() + "]";

        //Equis
        temporal[0][0] = "[x]";
        temporal[0][1] = "[x]";
        temporal[1][0] = "[x]";
        temporal[1][1] = "[x]";
        temporal[0][18] = "[x]";
        temporal[0][17] = "[x]";
        temporal[1][17] = "[x]";
        temporal[1][18] = "[x]";
        temporal[17][0] = "[x]";
        temporal[17][1] = "[x]";
        temporal[18][0] = "[x]";
        temporal[18][1] = "[x]";
        temporal[17][17] = "[x]";
        temporal[17][18] = "[x]";
        temporal[18][18] = "[x]";
        temporal[18][17] = "[x]";

        //Duques
        temporal[4][8] = "[" + d.toString() + "]";
        temporal[4][10] = "[" + d.toString() + "]";
        temporal[6][9] = "[" + d.toString() + "]";
        temporal[7][8] = "[" + d.toString() + "]";
        temporal[7][10] = "[" + d.toString() + "]";
        temporal[8][4] = "[" + d.toString() + "]";
        temporal[8][7] = "[" + d.toString() + "]";
        temporal[8][9] = "[" + d.toString() + "]";
        temporal[8][11] = "[" + d.toString() + "]";
        temporal[8][14] = "[" + d.toString() + "]";
        temporal[9][6] = "[" + d.toString() + "]";
        temporal[9][8] = "[" + d.toString() + "]";
        temporal[9][10] = "[" + d.toString() + "]";
        temporal[9][12] = "[" + d.toString() + "]";
        temporal[10][4] = "[" + d.toString() + "]";
        temporal[10][7] = "[" + d.toString() + "]";
        temporal[10][9] = "[" + d.toString() + "]";
        temporal[10][11] = "[" + d.toString() + "]";
        temporal[10][14] = "[" + d.toString() + "]";
        temporal[11][8] = "[" + d.toString() + "]";
        temporal[11][10] = "[" + d.toString() + "]";
        temporal[12][9] = "[" + d.toString() + "]";
        temporal[13][8] = "[" + d.toString() + "]";
        temporal[13][10] = "[" + d.toString() + "]";
        return temporal;
    }

    public static void impTablero(String[][] temporal, int filas, int columnas) {
        if (filas == temporal.length - 1 && columnas == temporal[0].length - 1) {
            System.out.print(temporal[filas][columnas]);
        } else if (columnas == temporal[0].length - 1) {
            System.out.println(temporal[filas][columnas]);
            impTablero(temporal, filas + 1, 0);
        } else {
            System.out.print(temporal[filas][columnas]);
            impTablero(temporal, filas, columnas + 1);
        }

    }

    public static int pertenencia_player1(String[][] tablero, int fila, int columna) {
        if (tablero[fila][columna].equals("[+]") || tablero[fila][columna].equals("[&]")) {
            return 1;
        } else {
            return 2;
        }
    }

    public static int pertenencia_player2(String[][] tablero, int fila, int columna) {
        if (tablero[fila][columna].equals("[0]")) {
            return 1;
        } else {
            return 2;
        }
    }

    public static int pasar_player(String[][] tablero, int fila1, int columna1, int fila2, int columna2) {
        int cont1 = 0, cont2 = 0, retorno = 1;
        if (fila1 == fila2 && columna1 < columna2) {
            cont1 = fila1;
            cont2 = columna1 + 1;
            while (cont2 < columna2) {
                if (tablero[fila2][cont2].equals("[+]")
                        || tablero[fila2][cont2].equals("[0]")
                        || tablero[fila2][cont2].equals("[&]")) {
                    retorno = 2;
                }

                cont2++;
            }
        } else if (fila1 == fila2 && columna1 > columna2) {
            cont1 = fila1;
            cont2 = columna1 - 1;
            while (cont2 > columna2) {
                if (tablero[fila2][cont2].equals("[+]")
                        || tablero[fila2][cont2].equals("[0]")
                        || tablero[fila2][cont2].equals("[&]")) {
                    retorno = 2;
                }
                cont2--;
            }
        } else if (fila1 < fila2 && columna1 == columna2) {
            cont1 = fila1 + 1;
            cont2 = columna1;
            while (cont1 < fila2) {
                if (tablero[cont1][cont1].equals("[+]")
                        || tablero[cont1][columna2].equals("[0]")
                        || tablero[cont1][columna2].equals("[&]")) {
                    retorno = 2;
                }

                cont1++;
            }
        } else if (fila1 > fila2 && columna1 == columna2) {
            cont1 = fila1 - 1;
            cont2 = columna1;
            while (cont1 > fila2) {
                if (tablero[cont1][cont1].equals("[+]")
                        || tablero[cont1][columna2].equals("[0]")
                        || tablero[cont1][columna2].equals("[&]")) {
                    retorno = 2;
                }

                cont1--;
            }
        }
        return retorno;

    }

    public static int Ganar_player1(String tablero[][]) {
        if (tablero[0][0].equals("[&]")
                || tablero[0][1].equals("[&]")
                || tablero[1][0].equals("[&]")
                || tablero[1][1].equals("[&]")
                || tablero[0][18].equals("[&]")
                || tablero[0][17].equals("[&]")
                || tablero[1][17].equals("[&]")
                || tablero[1][18].equals("[&]")
                || tablero[17][0].equals("[&]")
                || tablero[17][1].equals("[&]")
                || tablero[18][0].equals("[&]")
                || tablero[18][1].equals("[&]")
                || tablero[17][17].equals("[&]")
                || tablero[17][18].equals("[&]")
                || tablero[18][18].equals("[&]")
                || tablero[18][17].equals("[&]")) {
            return 2;

        } else {
            return 1;
        }
    }

    public static int Ganar_player2(String tablero[][]) {
        int retorno = 1;
        if (tablero[9][9].equals("[&]")
                && tablero[8][9].equals("[0]")
                && tablero[9][8].equals("[0]")
                && tablero[9][10].equals("[0]")
                && tablero[10][9].equals("[0]")) {
            retorno = 2;
        }
        if (tablero[9][8].equals("[&]")
                && tablero[8][8].equals("[0]")
                && tablero[9][7].equals("[0]")
                && tablero[10][8].equals("[0]")) {
            retorno = 2;
        }
        if (tablero[9][8].equals("[&]")
                && tablero[10][8].equals("[0]")
                && tablero[11][9].equals("[0]")
                && tablero[10][10].equals("[0]")) {
            retorno = 2;
        }
        if (tablero[9][10].equals("[&]")
                && tablero[8][10].equals("[0]")
                && tablero[9][11].equals("[0]")
                && tablero[10][10].equals("[0]")) {
            retorno = 2;
        }
        if (tablero[8][9].equals("[&]")
                && tablero[8][8].equals("[0]")
                && tablero[7][9].equals("[0]")
                && tablero[8][10].equals("[0]")) {
            retorno = 2;
        }
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].equals("[&]") && i > 0 && j > 0) {
                    if (tablero[i + 1][j].equals("[0]")
                            && tablero[i - 1][j].equals("[0]")
                            && tablero[i][j - 1].equals("[0]")
                            && tablero[i][j + 1].equals("[0]")) {
                        retorno = 2;
                    }
                } else if (tablero[0][j].equals("[&]")) {
                    if (tablero[i][j + 1].equals("[0]")
                            && tablero[i][j - 1].equals("[0]")
                            && tablero[i + 1][j].equals("[0]")) {
                        retorno = 2;
                    }

                } else if (tablero[i][0].equals("[&]")) {
                    if (tablero[i + 1][j].equals("[0]")
                            && tablero[i - 1][j].equals("[0]")
                            && tablero[i][j + 1].equals("[0]")) {
                        retorno = 2;
                    }
                } else {
                    retorno = 1;
                }
            }
        }

        return retorno;
    }

    public static String[][] comer_player1(String tablero[][]) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].equals("[0]") && i > 0 && j > 0) {
                    if (tablero[i - 1][j].equals("[+]") && tablero[i + 1][j].equals("[+]")) {
                        tablero[i][j] = "[ ]";
                    }
                    if (tablero[i][j - 1].equals("[+]") && tablero[i][j + 1].equals("[+]")) {
                        tablero[i][j] = "[ ]";
                    }
                } else if (tablero[0][j].equals("[0]") && j > 0) {
                    if (tablero[i][j - 1].equals("[+]") && tablero[i][j + 1].equals("[+]")) {
                        tablero[i][j] = "[ ]";
                    }
                } else if (tablero[i][0].equals("[0]") && i > 0) {
                    if (tablero[i - 1][j].equals("[+]") && tablero[i + 1][j].equals("[+]")) {
                        tablero[i][j] = "[ ]";
                    }
                }
            }
        }
        return tablero;
    }

    public static String[][] comer_player2(String tablero[][]) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].equals("[+]") && i > 0 && j > 0) {
                    if (tablero[i - 1][j].equals("[0]") && tablero[i + 1][j].equals("[0]")) {
                        tablero[i][j] = "[ ]";
                    }
                    if (tablero[i][j - 1].equals("[0]") && tablero[i][j + 1].equals("[0]")) {
                        tablero[i][j] = "[ ]";
                    }
                } else if (tablero[0][j].equals("[0]") && j > 0) {
                    if (tablero[i][j - 1].equals("[0]") && tablero[i][j + 1].equals("[0]")) {
                        tablero[i][j] = "[ ]";
                    }
                } else if (tablero[i][0].equals("[0]") && i > 0) {
                    if (tablero[i - 1][j].equals("[0]") && tablero[i + 1][j].equals("[0]")) {
                        tablero[i][j] = "[ ]";
                    }
                }
            }
        }
        return tablero;
    }

    public static int esquina(String tablero[][], int fila2, int columna2, int fila1, int columna1) {
        if (tablero[fila2][columna2] == tablero[0][0]
                || tablero[fila2][columna2] == tablero[0][1]
                || tablero[fila2][columna2] == tablero[1][0]
                || tablero[fila2][columna2] == tablero[1][1]
                || tablero[fila2][columna2] == tablero[0][0]
                || tablero[fila2][columna2] == tablero[0][18]
                || tablero[fila2][columna2] == tablero[0][17]
                || tablero[fila2][columna2] == tablero[1][17]
                || tablero[fila2][columna2] == tablero[1][18]
                || tablero[fila2][columna2] == tablero[17][0]
                || tablero[fila2][columna2] == tablero[17][1]
                || tablero[fila2][columna2] == tablero[18][0]
                || tablero[fila2][columna2] == tablero[18][1]
                || tablero[fila2][columna2] == tablero[17][17]
                || tablero[fila2][columna2] == tablero[17][18]
                || tablero[fila2][columna2] == tablero[18][18]
                || tablero[fila2][columna2] == tablero[18][17]
                || tablero[fila2][columna2] == tablero[9][9]) {
            return 2;
        } else if (tablero[fila1][columna1].equals("[&]")) {
            return 1;
        } else {
            return 1;
        }
    }
    
}
