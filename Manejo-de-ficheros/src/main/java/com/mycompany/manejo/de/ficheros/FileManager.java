package com.mycompany.manejo.de.ficheros;

import java.io.*;

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

    public void readFile() throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
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
