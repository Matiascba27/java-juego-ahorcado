import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {

        // Crea un objeto scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Bucle que se ejecuta mientras el usuario quiera seguir jugando
        boolean seguirJugando = true;
        while (seguirJugando) {

            // Arreglo de palabras posibles para adivinar
            String[] palabras = { "convicto", "entrometido", "recorrido", "garabato", "rata", "ubre", "infeliz",
                    "hervir", "caracol", "fichero " };

            // Crea un objeto random para seleccionar palabras al azar
            Random random = new Random();

            // Elige una palabra al azar del arreglo como la palabra secreta
            String palabraSecreta = palabras[random.nextInt(palabras.length)];

            // Crea un arreglo para almacenar las letras adivinadas
            char[] letrasAdivinadas = new char[palabraSecreta.length()];

            // establece el numero de intentos que tiene el jugador
            int intentos = 5;

            // Una bandera para controlar el flujo del juego
            boolean juegoTerminado = false;

            // Bucle qiue muestra la cantidad de letras que lleva la palabra secreta
            for (int i = 0; i < letrasAdivinadas.length; i++) {
                letrasAdivinadas[i] = '_';
            }

            // Bucle que se ejecuta mientras el juego no haya terminado
            while (!juegoTerminado) {
                // Muestra el estado actual de la palabra adivinar
                System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
                // Pide al usuario que ingrese una letra y la lee
                System.out.println("Ingresa una letra: ");
                char letra = scanner.next().charAt(0);

                // Bandera para verificar si la letra esta en la palabra secreta
                boolean letraCorrecta = false;
                // Verifica si la letra esta en la palabra secreta y actualiza el arreglo de
                // letras adivinadas
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if (palabraSecreta.charAt(i) == letra) {
                        letrasAdivinadas[i] = letra;
                        letraCorrecta = true;
                    }
                }

                // Si la letra no esta, resta un intento y muestra los intentos restantes
                if (!letraCorrecta) {
                    intentos--;
                    System.out.println("Letra Incorrecta. Intentos restantes: " + intentos);
                }

                // Si los intentos llegan a cero, muestra "Game Over" y revela la palabra
                // secreta
                if (intentos == 0) {
                    System.out.println("Game Over. La palabra secreta era: " + palabraSecreta);
                    juegoTerminado = true;
                }

                // Si se adivina la palabra, muestra un mensaje de felicitacion
                else if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                    System.out.println("¡Felicidades! Descubriste la palabra secreta: " + palabraSecreta);
                    juegoTerminado = true;
                }

            }

            // Pregunta al usuario si quiere seguir jugando
            System.out.println("¿Quieres seguir jugando? (s/n)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("n")) {
                seguirJugando = false;
                System.out.println("¡Hasta Luego!");
            }

        }
        scanner.close();

    }

}
