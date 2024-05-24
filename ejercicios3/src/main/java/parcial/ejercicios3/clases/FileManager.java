package parcial.ejercicios3.clases;
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

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void close() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
        }
        if (fileReader != null) {
            fileReader.close();
        }
    }
}
