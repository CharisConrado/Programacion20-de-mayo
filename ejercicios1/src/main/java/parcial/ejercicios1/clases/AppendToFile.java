
package parcial.ejercicios1.clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class AppendToFile {
    private File file; 

    public AppendToFile(File file) {
        this.file = file;
    }
    
    public void addLineToEOF(String line){
        try (FileWriter writer = new FileWriter(file, true)) {            
            PrintWriter printerWriter = new PrintWriter(writer);
            printerWriter.println(line);
            writer.close();
        }
        catch (IOException e) {
            System.out.println("File is being used by another program!");
        }
        
    }
    
}
