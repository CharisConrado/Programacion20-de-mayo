package com.mycompany.libreria;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private File file;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public FileManager(String fileName) throws IOException {
        this.file = new File(fileName);
        this.fileWriter = new FileWriter(file, true);
        this.printWriter = new PrintWriter(fileWriter);
        this.fileReader = new FileReader(file);
        this.bufferedReader = new BufferedReader(fileReader);
    }

    public void createFileIfNotExists() throws IOException {
        if (file.createNewFile()) {
            System.out.println("Archivo creado");
        } else {
            System.out.println("Archivo ya existente");
        }
    }

    public void writeLine(String line) {
        printWriter.println(line);
        printWriter.flush();
    }

    public void writeBooks(List<Libro> libros) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file, false))) {
            for (Libro libro : libros) {
                pw.println(libro.toString());
            }
        }
    }

    public List<Libro> readBooks() throws IOException {
        List<Libro> libros = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            libros.add(Libro.fromString(line));
        }
        return libros;
    }

    public void close() throws IOException {
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (printWriter != null) {
            printWriter.close();
        }
        if (fileWriter != null) {
            fileWriter.close();
        }
        if (fileReader != null) {
            fileReader.close();
        }
    }
}
