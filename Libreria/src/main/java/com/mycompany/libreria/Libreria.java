
package com.mycompany.libreria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Libreria {

   public static void main(String[] args) {
        try {
            FileManager fileManager = new FileManager("libros.txt");
            fileManager.createFileIfNotExists();
            Scanner scn = new Scanner(System.in);
            boolean running = true;
            List<Libro> libros = fileManager.readBooks();

            while (running) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Añadir libro");
                System.out.println("2. Ver lista de libros");
                System.out.println("3. Buscar libro por título");
                System.out.println("4. Actualizar libro");
                System.out.println("5. Eliminar libro");
                System.out.println("6. Salir");
                int option = scn.nextInt();
                scn.nextLine(); // consumir el salto de línea

                switch (option) {
                    case 1:
                        System.out.println("Ingrese el título del libro:");
                        String titulo = scn.nextLine();
                        System.out.println("Ingrese el autor del libro:");
                        String autor = scn.nextLine();
                        System.out.println("Ingrese el ISBN del libro:");
                        String isbn = scn.nextLine();
                        libros.add(new Libro(titulo, autor, isbn));
                        fileManager.writeBooks(libros);
                        System.out.println("Libro añadido.");
                        break;
                    case 2:
                        for (Libro libro : libros) {
                            System.out.println(libro);
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese el título del libro a buscar:");
                        String buscarTitulo = scn.nextLine();
                        for (Libro libro : libros) {
                            if (libro.getTitulo().equalsIgnoreCase(buscarTitulo)) {
                                System.out.println(libro);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese el título del libro a actualizar:");
                        String actualizarTitulo = scn.nextLine();
                        for (Libro libro : libros) {
                            if (libro.getTitulo().equalsIgnoreCase(actualizarTitulo)) {
                                System.out.println("Ingrese el nuevo título:");
                                libro.setTitulo(scn.nextLine());
                                System.out.println("Ingrese el nuevo autor:");
                                libro.setAutor(scn.nextLine());
                                System.out.println("Ingrese el nuevo ISBN:");
                                libro.setIsbn(scn.nextLine());
                                fileManager.writeBooks(libros);
                                System.out.println("Libro actualizado.");
                                break;
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Ingrese el título del libro a eliminar:");
                        String eliminarTitulo = scn.nextLine();
                        libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(eliminarTitulo));
                        fileManager.writeBooks(libros);
                        System.out.println("Libro eliminado.");
                        break;
                    case 6:
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
