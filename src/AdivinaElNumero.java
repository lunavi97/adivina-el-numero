import java.util.Scanner;

/**
 * Creado por Luciano Nahuel Vitale
 * Fecha: 23/3/2018
 * Hora: 00:15
 */
public class AdivinaElNumero {

    private Scanner entrada = new Scanner(System.in);
    private boolean juegoActivo = true;

    public void jugar() {
        String nombreJugador = obtenerNombreJugador();
        while(juegoActivo) {
            int intentos = 0;
            int min = 1, max = 100;
            int numeroJuego = obtenerNumeroAleatorio(min, max);

            System.out.printf("%s, he escogido un número entre %d y %d, adivinalo\n\n", nombreJugador, min, max);
            int numeroJugador;

            do {
                numeroJugador = ingresarNumero();
                mensaje(numeroJuego, numeroJugador);
                System.out.print("\n"); // Salto de línea
                intentos++;
            } while(numeroJuego != numeroJugador);

            System.out.println("Has ganado, intentos " + intentos + "\n");

            juegoActivo = jugarNuevamente();
        }
    }

    private int obtenerNumeroAleatorio(int min, int max) {
        return min + (int) (Math.random() * (max-min) + 1);
    }

    private String obtenerNombreJugador() {
        System.out.println("Hola, ¿cuál es tu nombre?");
        String nombreJugador = entrada.nextLine();
        System.out.printf("Bienvenido %s, vamos a comenzar\n\n", nombreJugador);
        return nombreJugador;
    }

    private int ingresarNumero() {
        System.out.println("Ingresá un número");
        return entrada.nextInt();
    }

    private void mensaje(int numeroJuego, int numeroJugador) {
        if (numeroJuego < numeroJugador) {
            System.out.println("Muy alto, adiviná otra vez");
        } else if (numeroJuego > numeroJugador) {
            System.out.println("Muy bajo, adiviná otra vez");
        }
    }

    public boolean jugarNuevamente() {
        System.out.println("¿Jugar nuevamente?");
        System.out.println("0. No");
        System.out.println("1. Si");

        int respuesta = entrada.nextInt();
        if(respuesta == 1) {
            System.out.println("Genial, juguemos otra vez\n");
            return true;
        } else {
            System.out.println("Fin del juego, gracias por participar");
            return false;
        }
    }

}
