package pacmanpractica1;

import java.util.Scanner;

public class PacmanPractica1 {

    public static void main(String[] args) {
        //altura
        int fila = 0;
        //ancho
        int colum = 0;

        //Inicializador de contador de jugadores
        int contJugador = 0;
        //Vectores de Datos a guardar
        String nombre[] = new String[10];
        String edad[] = new String[10];
        int punteo[] = new int[10];
        int movi[] = new int[10];
        //Scanner global de cadena de String
        Scanner scg = new Scanner(System.in);
        //Scanner globar de enteros
        Scanner scgd = new Scanner(System.in);

        boolean menu = false;
        boolean entrada = false;
        String valor;

        int posy = 6;
        int posx = 5;

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
                            if (fila < 8 || colum < 8) {
                                System.out.println("Las dimensiones son muy pequeñas ingrese nuevamente...");
                            } else if (fila < colum) {
                                colum = fila;
                            } else {
                                System.out.println("Iniciando Juego...");
                            }
                        } while (fila < 8 || colum < 8);
                        System.out.println("alto: "+ fila +" ancho: "+ colum);

                        //Inicializando Juego
                        punteo[contJugador] = 10;
                        movi[contJugador] = 0;
                        //matriz de tablero
                        int tablero[][] = new int[fila+1][colum+1];

                        do {
                            System.out.println("\t Nombre:  " + nombre[contJugador]);
                            System.out.println("\t Punteo:  " + punteo[contJugador]);
                            System.out.println("\t Movimientos: " + movi[contJugador]);

                            //Dibujando Matriz
                            for (int i = 0; i < tablero.length; i++) {
                                for (int j = 0; j < tablero[i].length; j++) {
                                    
                                    if (tablero[i] == tablero[posy] & tablero[j] == tablero[posx]) {
                                        System.out.print(" V ");
                                    } else if (tablero[i] == tablero[fila / 2] & tablero[j] == tablero[0] || tablero[i] == tablero[(fila / 2) + 1]) {
                                        System.out.print("   ");

                                    } else if (tablero[j] != tablero[0] & tablero[i] != tablero[0]) {
                                        System.out.print("   ");

                                    } else {
                                        System.out.print(" * ");
                                    }
                                }
                                //Segundo if que imprime la última columna
                                if (tablero[i] == tablero[fila / 2] || tablero[i] == tablero[(fila / 2) + 1]) {
                                    System.out.println("  ");
                                } else {
                                    System.out.println(" *");
                                }

                            }
                            //Segundo for fuera para imprimir última línea horizontal.
                            for (int i = 0; i < tablero.length; i++) {
                                System.out.print(" * ");
                            }
                            System.out.println(" *");
                            
                            
                            
                            //Recepcipon de tecla a introducir
                            System.out.print("Seleccione comando:");
                            valor = scg.nextLine();
                            if (valor.equalsIgnoreCase("m")) {
                                entrada = true;
                            }
                        } while (!entrada);

                        //Contador de partida del jugador
                        contJugador++;
                        entrada = false;

                        break;
                    case 2:
                        System.out.println(" ");
                        System.out.println("\t HISTORIAL DE PUNTEO ");
                        for (int i = 0; i < nombre.length; i++) {

                            if (nombre[i] != null) {
                                System.out.println("_____________________________");
                                System.out.println("Nombre: " + nombre[i]);
                                System.out.println("Edad: " + edad[i]);
                                System.out.println("Punteo: " + punteo[i]);
                                System.out.println("Movimientos: " + movi[i]);
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
