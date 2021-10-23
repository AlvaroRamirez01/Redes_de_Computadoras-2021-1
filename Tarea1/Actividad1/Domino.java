package Tarea1.Actividad1;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.Random;

/**
 * @author Alvaro Ramirez Lopez
 * @version 1.0
 * @since 1.0
 * Clase que representa un juego de domino, en el cual se juega con dos jugadores
 * en este caso, un jugador humano y un jugador automatico.
 */
public class Domino {

    /** Generamos las 28 fichas que usaremos para el domino */
    private static Ficha ficha_0_0;
    private static Ficha ficha_0_1;
    private static Ficha ficha_0_2;
    private static Ficha ficha_0_3;
    private static Ficha ficha_0_4;
    private static Ficha ficha_0_5;
    private static Ficha ficha_0_6;
    private static Ficha ficha_1_1;
    private static Ficha ficha_1_2;
    private static Ficha ficha_1_3;
    private static Ficha ficha_1_4;
    private static Ficha ficha_1_5;
    private static Ficha ficha_1_6;
    private static Ficha ficha_2_2;
    private static Ficha ficha_2_3;
    private static Ficha ficha_2_4;
    private static Ficha ficha_2_5;
    private static Ficha ficha_2_6;
    private static Ficha ficha_3_3;
    private static Ficha ficha_3_4;
    private static Ficha ficha_3_5;
    private static Ficha ficha_3_6;
    private static Ficha ficha_4_4;
    private static Ficha ficha_4_5;
    private static Ficha ficha_4_6;
    private static Ficha ficha_5_5;
    private static Ficha ficha_5_6;
    private static Ficha ficha_6_6;
    
    /** 
     * Nos ayudara a modelar el tablero, para poner una ficha a la izquierda
     * agregaremos la ficha al inicio y para agregar a la derecha agregaremos 
     * al final.
     */
    private static LinkedList<Ficha> tablero = new LinkedList<Ficha>();
    /** Esta lista nos ayudara a tener almacenadas las fichas con las que jugara el jugador 1. */
    private static LinkedList<Ficha> fichasJugador1 = new LinkedList<Ficha>();
    /** Esta lista nos ayudara a tener almacenadas las fichas con las que jugara la maquina. */
    private static LinkedList<Ficha> fichasMaquina = new LinkedList<Ficha>();
    /** En esta lista estaran las fichas que estaran disponibles para comer cuando necesitemos. */
    private static LinkedList<Ficha> fichasParaComer = new LinkedList<Ficha>();
    /** Referencia de random que nos ayudara a generar numeros aleatorios. */
    private static Random random = new Random();
    /** ServerSocket del juego */
    private static ServerSocket serverSocket;
    /** Bandera que nos ayudara a saber si el juego ha terminado o no */
    private static boolean juegoTerminado;
    /** ClientSocket del juego */
    private static Socket jugador;

    private static DataOutputStream out;
    private static DataInputStream in;


    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(5000);
            jugador = serverSocket.accept();
            System.out.println("------ Jugador conectado ------");
            String mensajeCliente = "--------- Juego Iniciado ---------";
            out = new DataOutputStream(jugador.getOutputStream());
            out.writeUTF(mensajeCliente);
        } catch (IOException e) {
            System.out.println("Error al conectar con el cliente");
        }
        
        juegoTerminado = false;
        // Generamos las 28 fichas que usaremos para el domino
        generaFichas();
        // repartimos las fichas para el jugador 1
        reparteFichas(fichasJugador1,7);
        // repartimos las fichas para la maquina
        reparteFichas(fichasMaquina,7);
        comienzaJuego();
    }

    /**
     * Este metodo nos ayuda a generar las fichas al inicio de una nueva partida.
     */
    private static void generaFichas(){
        // creamos las fichas de domino
        ficha_0_0= new Ficha(0,0);
        ficha_0_1= new Ficha(0,1);
        ficha_0_2= new Ficha(0,2);
        ficha_0_3= new Ficha(0,3);
        ficha_0_4= new Ficha(0,4);
        ficha_0_5= new Ficha(0,5);
        ficha_0_6= new Ficha(0,6);

        ficha_1_1= new Ficha(1,1);
        ficha_1_2= new Ficha(1,2);
        ficha_1_3= new Ficha(1,3);
        ficha_1_4= new Ficha(1,4);
        ficha_1_5= new Ficha(1,5);
        ficha_1_6= new Ficha(1,6);

        ficha_2_2= new Ficha(2,2);
        ficha_2_3= new Ficha(2,3);
        ficha_2_4= new Ficha(2,4);
        ficha_2_5= new Ficha(2,5);
        ficha_2_6= new Ficha(2,6);

        ficha_3_3= new Ficha(3,3);
        ficha_3_4= new Ficha(3,4);
        ficha_3_5= new Ficha(3,5);
        ficha_3_6= new Ficha(3,6);

        ficha_4_4= new Ficha(4,4);
        ficha_4_5= new Ficha(4,5);
        ficha_4_6= new Ficha(4,6);

        ficha_5_5= new Ficha(5,5);
        ficha_5_6= new Ficha(5,6);
        
        ficha_6_6= new Ficha(6,6);

        /**
         * Agregamos las fichas a la lista la cual nos ayudara a 
         * hacer las funciones de revolver fichas y de repartir fichas
         * al inicio de la partida y cuando querramos comer mas fichas.
         */
        fichasParaComer.add(ficha_0_0);
        fichasParaComer.add(ficha_0_1);
        fichasParaComer.add(ficha_0_2);
        fichasParaComer.add(ficha_0_3);
        fichasParaComer.add(ficha_0_4);
        fichasParaComer.add(ficha_0_5);
        fichasParaComer.add(ficha_0_6);

        fichasParaComer.add(ficha_1_1);
        fichasParaComer.add(ficha_1_2);
        fichasParaComer.add(ficha_1_3);
        fichasParaComer.add(ficha_1_4);
        fichasParaComer.add(ficha_1_5);
        fichasParaComer.add(ficha_1_6);

        fichasParaComer.add(ficha_2_2);
        fichasParaComer.add(ficha_2_3);
        fichasParaComer.add(ficha_2_4);
        fichasParaComer.add(ficha_2_5);
        fichasParaComer.add(ficha_2_6);

        fichasParaComer.add(ficha_3_3);
        fichasParaComer.add(ficha_3_4);
        fichasParaComer.add(ficha_3_5);
        fichasParaComer.add(ficha_3_6);

        fichasParaComer.add(ficha_4_4);
        fichasParaComer.add(ficha_4_5);
        fichasParaComer.add(ficha_4_6);

        fichasParaComer.add(ficha_5_5);
        fichasParaComer.add(ficha_5_6);

        tablero.add(ficha_6_6);
    }
 
    /**
     * Este metodo nos ayuda a repartir las fichas
     */
    private static void reparteFichas(LinkedList<Ficha> f, int numeroDeFichas){
        int i = 0;
        int tamano = fichasParaComer.size();

        while (i<numeroDeFichas) {
            int aux = random.nextInt(tamano);
            Ficha ficha = fichasParaComer.get(aux);
            f.add(ficha);
            fichasParaComer.remove(aux);
            tamano--;
            i++;
        }
        System.out.println(String.format("Se repartireron %d fichas",numeroDeFichas));
        for (Ficha ficha : f) {
            System.out.println(ficha.toString());
        }
    }
    /**
     * Este metodo nos ayuda a comenzar el juego, siempre cuando nos 
     * comuniquemos con el cliente mandaremos 2 cadenas, una sera 
     * el tablero del domino y la segunda seran las fichas que tiene la persona.
     * 
     */
    private static void comienzaJuego(){
        while (juegoTerminado == false && fichasParaComer.isEmpty() == false) {
            //imprimimos el tablero
            String tablero = imprimeTablero();
            System.out.println(tablero);
            // enviamos las fichas del jugador 1
            String fichasJugador = imprimeFichasJugador1();
            try {
                out=new DataOutputStream(jugador.getOutputStream());
                out.writeUTF(fichasJugador);
            } catch (IOException e) {
                e.printStackTrace();
            }
            

            // esperamos a que el cliente decida que hacer
            int opcion = 0;
            /* switch (opcion) {
                case 1: agregaFicha(1);   
         */}
    } 


    private static String imprimeTablero(){
        String cadena = "Tablero del domino\n";
        for (Ficha ficha : tablero) {
            cadena = cadena + " "+ficha.toString()+" ";
        }
        return cadena;
    }

    private static String imprimeFichasJugador1(){
        String cadena = "Estas son las fichas del jugador 1\n";
        for (Ficha ficha : fichasJugador1) {
            cadena = cadena + " "+ficha.toString()+" ";
        }
        return cadena;
    }

}
