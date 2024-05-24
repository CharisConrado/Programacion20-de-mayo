package parcial.ejercicios3.clases;

import java.util.Random;
public class CodigoGenerator {
    public static String generateCodigo(String name) {
        String iniciales = "";
        String[] palabras = name.split(" ");
        for (String palabra : palabras) {
            iniciales += palabra.charAt(0);
        }
        Random random = new Random();
        int numero = random.nextInt(1000); 
        return iniciales + String.format("%03d", numero);
    }
}
