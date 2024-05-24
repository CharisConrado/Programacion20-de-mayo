
package parcial.ejercicios2.clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Writer {
    private File archivo;
    private FileWriter fw;
    private PrintWriter pw;

    public Writer(File archivo) throws IOException {
        this.archivo = archivo;
        this.fw = new FileWriter(archivo, true);
        this.pw = new PrintWriter(fw);
        
    }
    
    public void println(String texto){
        try{
            pw.println(texto);
        }catch(Exception e){
            System.out.println("Error");
        }
    }
    public void close() throws IOException{
        if(pw != null){
            pw.close();
        }
    }
    
    
    
    
}
