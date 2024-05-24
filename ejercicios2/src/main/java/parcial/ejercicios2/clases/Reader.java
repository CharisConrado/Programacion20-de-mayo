
package parcial.ejercicios2.clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private File archivo;
    private FileReader reader;
    private BufferedReader buffer;

    public Reader(File archivo) throws FileNotFoundException {
        this.archivo = archivo;
        this.reader = new FileReader(archivo);
        this.buffer = new BufferedReader(reader);
    }
    public char read() throws IOException{
        int data = reader.read();
        return (char) data;
    }
    public String readLine() throws IOException{
        return buffer.readLine();
    }
    public void close() throws IOException{
        if (buffer != null) {
            buffer.close();
        }
        if (reader != null) {
            reader.close();
        }
    }
    
    
    
    
}
