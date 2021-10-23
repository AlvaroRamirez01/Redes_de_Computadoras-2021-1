package Tarea1.Actividad1;

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

    /**
     * Constructor de la clase Jugador
     */
    public static void main(String[] args) {
        try {
            cliente = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor");
            System.out.println("Introduzca su nombre de usuario: ");
            String nombre = teclado.nextLine();
            System.out.println("Introduzca su contraseña: ");
            String contrasena = teclado.nextLine();
        } catch (IOException e) {
            System.out.println("Error al conectar con el servidor");
            // Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
