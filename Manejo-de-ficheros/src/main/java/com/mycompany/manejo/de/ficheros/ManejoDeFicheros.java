package com.mycompany.manejo.de.ficheros;

import java.io.IOException;
import java.util.Scanner;

public class ManejoDeFicheros {

    
    public static void main(String[] args) {
        try {
            FileManager fileManager = new FileManager("contactos.txt");
            fileManager.createFileIfNotExists();
            Scanner scn = new Scanner(System.in);
            boolean running = true;

            while (running) {
               System.out.println("1. Agregar contacto");
                System.out.println("2. Ver contactos");
                System.out.println("3. Salir");
                int option = scn.nextInt();
                scn.nextLine(); // consumir el salto de línea

                switch (option) {
                    case 1:
                        System.out.println("Ingrese el nombre:");
                        String nombre = scn.nextLine();
                        System.out.println("Ingrese el número de teléfono:");
                        String telefono = scn.nextLine();
                        String contacto = nombre + ";" + telefono;
                        fileManager.writeLine(contacto);
                        System.out.println("Contacto agregado.");
                        break;
                    case 2:
                        fileManager.readFile();
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }

            fileManager.close();
            scn.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    
}
