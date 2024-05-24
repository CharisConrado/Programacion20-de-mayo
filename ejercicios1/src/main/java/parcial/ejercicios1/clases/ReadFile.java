
package parcial.ejercicios1.clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ReadFile {
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader; 

    public ReadFile(File file) throws IOException {
        this.file = file;
        this.fileReader= new FileReader(file);
        this.bufferedReader= new BufferedReader(fileReader); 
    }

    public List <String> loadSales(){
        String line; 
        List <String> sales = new ArrayList<>();
        try {
            while ((line = bufferedReader.readLine()) != null){
                sales.add(line);
            }
        } catch (IOException e) {
            
        } finally {
            try {
                if(fileReader !=null){
                    fileReader.close();  
                }
                
            } catch (IOException e2) {
            }
        }
        return sales; 
    }
}
