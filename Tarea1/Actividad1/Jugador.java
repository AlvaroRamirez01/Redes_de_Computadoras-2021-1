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
     */
    public static void main(String[] args) {
        try {
            cliente = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor del juego");
            //para escribir hacia el servidor
            //DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            //para leer del servidor
            //DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            entrada = new DataInputStream(cliente.getInputStream());
            String mensajeServidor = entrada.readUTF();
            System.out.println(mensajeServidor);
            juegoIniciado();
        } catch (IOException e) {
            System.out.println("Error al conectar con el servidor del juego");
            // Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static void juegoIniciado() {
        try {
            entrada = new DataInputStream(cliente.getInputStream());
            String fichasJugador = entrada.readUTF();
            System.out.println(fichasJugador);
            System.out.println("mande una orden al servidor");
            int orden = teclado.nextInt();
            salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeInt(orden);

        } catch (IOException e) {
            e.printStackTrace();
        }

    
    }
    
}
