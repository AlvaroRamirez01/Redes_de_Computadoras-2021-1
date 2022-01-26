// package Tarea1.Actividad1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Alvaro Ramirez Lopez
 * @version 1.0
 * @since 1.0
 * Clase que representa un jugador de una partida de dominó.
 */

public class Jugador {

    /** Atributo que nos ayuda a tener datos de entrada con el jugador */
    private static Scanner teclado = new Scanner(System.in);
    /** Socket para la conexion */
    private static Socket cliente;
    /** Objeto para enviar mensajes al servidor */
    private static DataOutputStream salida;
    /** Objeto para recibir mensajes del servidor */
    private static DataInputStream entrada;

    /**
     * Constructor de la clase Jugador
     * @throws IOException
     */
    public static void main(String[] args) {
        try {
            cliente = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor del juego\n");
            //para escribir hacia el servidor
            //DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            //para leer del servidor
            //DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            entrada = new DataInputStream(cliente.getInputStream());
            String mensajeServidor = entrada.readUTF();
            System.out.println(mensajeServidor+"\n");
            juegoIniciado();
        } catch (IOException e) {
            System.out.println("Error al conectar con el servidor del juego");
            // Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Metodo que se encarga de iniciar el juego
     * @throws IOException
     */
    private static void juegoIniciado() {
        try {
            entrada = new DataInputStream(cliente.getInputStream());
            String fichasJugador = entrada.readUTF();
            System.out.println(fichasJugador);
            menuJugador();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    
    }

    /**
     * Pequeño menu para el jugador, en este menu contiene las acciones principales del domino
     * ya sea que quiera poner una ficha, comer una ficha o rendirse.
     * @throws IOException
     */
    private static void menuJugador(){
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Tirar una ficha");
        System.out.println("2. Comer una ficha");
        System.out.println("3. Redirse");
        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1: 
                try {
                    salida = new DataOutputStream(cliente.getOutputStream());
                    salida.writeInt(1);
                    tirarFicha();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                break;
            case 2: 
                try {
                    salida = new DataOutputStream(cliente.getOutputStream());
                    salida.writeInt(2);
                    comerFicha();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                redirse();
                break;
            default:
                System.out.println("Opcion no valida, abortando juego...");
                break;
        }

    }


    /**
     * Este metodo nos ayuda a tirar una ficha y depsues comunicar al servidor
     * cual ficha fue la que se tiro y su orientacion.
     * @throws IOException
     */
    private static void tirarFicha(){
        try {
            System.out.println("De derecha a izquierda cuente y seleccione cual ficha desea tirar");
            int fichaATirar = teclado.nextInt();
            fichaATirar = fichaATirar - 1;
            salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeInt(fichaATirar);
            System.out.println("¿En que lado quier poner la ficha?(Izq|Der), seleccione L o R");
            teclado = new Scanner(System.in);
            String lado = teclado.nextLine();
            salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF(lado);
            System.out.println("Ficha tirada, ahora le toca al servidor.");
            juegoIniciado();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
    /**
     * Este metodo lo que hace es indicar que se comio una ficha.
     */
    private static void comerFicha(){
        System.out.println("\nSe procede a comer la ficha, se agregara al final...\n");
        juegoIniciado(); 
    }

    /**
     * Metodo que nos ayuda en caso de que el jugador se rinda.
     */
    private static void redirse(){
        System.out.println("Usted se ha rendido, hasta luego.");
        try {
            salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeInt(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
