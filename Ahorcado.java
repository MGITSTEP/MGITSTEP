import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Ahorcado {

    private static final String ListadoPalabras = "palabras.txt";
    private static String palabraSecreta;
    private static List<Character> letrasCorrectas = new ArrayList<>();
    private static List<Character> letrasIncorrectas = new ArrayList<>();
    private static int intentosRestantes = 3;
    public static void main(String[] args) {
        inicializarPalabras();
        seleccionarPalabraAzar();
        jugarAhorcado();
    }

    private static void inicializarPalabras() {
        String[] palabras = {
                "programacion",
                "software",
                "algoritmo",
                "ahorcado",
                "poo"
        };
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get(ListadoPalabras), String.join("\n", palabras).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void seleccionarPalabraAzar() {
        try (BufferedReader br = new BufferedReader(new FileReader(ListadoPalabras))) {
            String[] palabras = br.lines().toArray(String[]::new);

            Random rand = new Random();
            palabraSecreta = palabras[rand.nextInt(palabras.length)];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void jugarAhorcado() {
   
        System.out.println("Bienvenido al juego del Ahorcado!");
        System.out.println("La palabra tiene " + palabraSecreta.length() + " letras.");

        char[] palabraOculta = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '_';
        }

    
        while (true) {
       
            System.out.println("Palabra: " + String.valueOf(palabraOculta));
            System.out.println("Letras correctas: " + letrasCorrectas);
            System.out.println("Letras incorrectas: " + letrasIncorrectas);
            System.out.println("Intentos restantes: " + intentosRestantes);

     
            char letra = pedirLetra();

            if (palabraSecreta.indexOf(letra) != -1) {
         
                letrasCorrectas.add(letra);
                actualizarPalabraOculta(palabraOculta, letra);
            } else {
              
                letrasIncorrectas.add(letra);
                intentosRestantes--;
            }

            if (esVictoria(palabraOculta)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
                break;
            } else if (intentosRestantes == 0) {
                System.out.println("¡Oh no! Has agotado tus intentos. La palabra era: " + palabraSecreta);
                break;
            }
        }
    }

    private static char pedirLetra() {
        System.out.print("Ingresa una letra: ");
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        try {
            String input = reader.readLine().toLowerCase();

            while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.print("Ingresa una letra válida: ");
                input = reader.readLine().toLowerCase();
            }
            return input.charAt(0);
        } catch (IOException e) {
            e.printStackTrace();
            return ' ';
        }
    }

    private static void actualizarPalabraOculta(char[] palabraOculta, char letra) {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraOculta[i] = letra;
            }
        }
    }

    private static boolean esVictoria(char[] palabraOculta) {
        for (char c : palabraOculta) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}