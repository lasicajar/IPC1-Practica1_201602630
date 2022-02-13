package pacmanpractica1;

import java.util.Scanner;

public class PacmanPractica1 {

    public static void main(String[] args) {
        //altura
        int fila = 0;
        //ancho
        int colum = 0;
        //matriz de tablero
        int tablero[][] = new int[fila + 1][colum];

        //String datos[][] = new String[10][1];
        int contJugador = 0;
        String nombre[] = new String[5];
        String edad[] = new String[5];
        Scanner scg = new Scanner(System.in);
        Scanner scgd = new Scanner(System.in);

        boolean menu = false;

        do {
            try {
                System.out.println("**************************");
                System.out.println("*   1. JUGAR             *");
                System.out.println("*   2. HISTORIAL         *");
                System.out.println("*   3. SALIR             *");
                System.out.println("**************************");
                System.out.print("Ingrese una opción:  ");

                Scanner sc = new Scanner(System.in);
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        //Recibiendo los datos del jugador
                        System.out.print("Ingrese Nombre del Jugador:  ");
                        nombre[contJugador] = scg.nextLine();
                        System.out.print("Ingrese Edad del Jugador:  ");
                        edad[contJugador] = scg.nextLine();
                        
                        //Recibiendo las dimensiones del tablero de juego
                        System.out.println("Ingrese las dimensiones del tablero mayor a 8x8...");
                        do {
                            System.out.print("alto: ");
                            fila = scgd.nextInt();
                            System.out.print("ancho: ");
                            colum = scgd.nextInt();
                            if (fila < 8 && colum < 8) {
                                System.out.println("Las dimensiones son muy pequeñas ingrese nuevamente...");
                            } else {
                                System.out.println("dimensiones guardadas...");
                            }
                        } while (fila < 8 && colum < 8);

                        System.out.println("alto: " + fila + " ancho: " + colum);
                        
                        //Dibujando Matriz
                        

                        //Contador de partida del jugador
                        contJugador++;

                        break;
                    case 2:
                        System.out.println(" ");
                        System.out.println("\t HISTORIAL DE PUNTEO ");
                        for (int i = 0; i < nombre.length; i++) {

                            if (nombre[i] != null) {
                                System.out.println("_____________________________");
                                System.out.println("Nombre: " + nombre[i]);
                                System.out.println("Edad: " + edad[i]);
                            } else {
                                System.out.println(" ");
                            }

                        }

                        break;
                    case 3:
                        System.out.println("Saliendo de la aplicación...");
                        menu = true;
                        break;
                    default:
                        System.out.println("Opción no encontrada....");
                        break;
                }
            } catch (Exception e) {
                System.out.println("INGRESE UNA OPCIÓN CORRECTA!!");
            }

        } while (!menu);

    }

}
