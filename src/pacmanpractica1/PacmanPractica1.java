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
        boolean entrada=false;
        String valor ;
        
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
                            if (fila < 8 && colum < 8) {
                                System.out.println("Las dimensiones son muy pequeñas ingrese nuevamente...");
                            } else if (fila < colum) {
                                colum = fila - 1;
                            } else {
                                System.out.println("Iniciando Juego...");
                            }
                        } while (fila < 8 && colum < 8);
                        //System.out.println("alto: "+ fila +" ancho "+ colum);
                        

                        //Dibujando Matriz
                        punteo[contJugador] = 10;
                        movi[contJugador] = 0;
                       
                        do {
                            System.out.println("\t Nombre:  "+ nombre[contJugador]);
                            System.out.println("\t Punteo:  "+ punteo[contJugador]);
                            System.out.println("\t Movimientos: "+ movi[contJugador]);
                            
                            
                            
                            System.out.print("Seleccione comando:"); 
                            valor = scg.nextLine();
                            if (valor.equalsIgnoreCase("m")) {
                                entrada=true;
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
