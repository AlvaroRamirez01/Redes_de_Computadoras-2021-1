package Tarea1.Actividad1;

import java.net.Socket;
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
    /** ClientSocket del juego */
    // private static Socket jugador;

    public static void main(String[] args) {

        generaFichas();
        reparteFichas(fichasJugador1,2);
        reparteFichas(fichasMaquina,1);
        System.out.println("las fichas que quedan son");
        for (Ficha ficha : fichasParaComer) {
            System.out.println(ficha.toString());
        }
        
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

}
