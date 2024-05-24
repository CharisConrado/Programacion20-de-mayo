package parcial.ejercicios3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import parcial.ejercicios3.clases.FileManager;
import parcial.ejercicios3.clases.CodigoGenerator;

public class Ejercicios3 {

    public static void main(String[] args) {
        try {
            FileManager fileManager = new FileManager("./registro2.txt");
            fileManager.createFileIfNotExists();
            Scanner scn = new Scanner(System.in);
        
            System.out.println("Ingrese su nombre completo:");
            String name = scn.nextLine();
            
            System.out.println("Ingrese el número de su actividad: (1)Futbol (2)Basket (3)Voley");
            int acti = scn.nextInt();
        
            String num = CodigoGenerator.generateCodigo(name);

            ArrayList<String> Lista = new ArrayList<>();
            ArrayList<String> Actividades = new ArrayList<>();
            Actividades.add("Futbol");
            Actividades.add("Basket");
            Actividades.add("Voley");

            String newLine = "";
            String Line;
            do {
                Line = fileManager.getBufferedReader().readLine();
                if (Line != null) {
                    String[] split3 = Line.split(";");
                    System.out.println(split3[2]);
                    if (split3[2].equals(num)) {
                        System.out.println("Los códigos son iguales");
                        newLine = "";
                        num = CodigoGenerator.generateCodigo(name);
                    } else {
                        newLine = "Agregar";
                    }
                } else {
                    if (!newLine.equals("")) {
                        String linea = name + ";" + Actividades.get(acti - 1) + ";" + num;
                        fileManager.getPrintWriter().println(linea);
                        System.out.println("Estudiante agregado");
                        break;
                    } else {
                        System.out.println("Código repetido");
                        break;
                    }
                }
            } while (Line != "0");

            fileManager.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
