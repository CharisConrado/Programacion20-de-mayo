package parcial.ficheros_estudio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Ficheros_estudio {

    public static void main(String[] args) throws IOException {
        
        File fichero = new File("../texto.txt");
        //boolean creado = fichero.createNewFile();
        
        
        
        FileReader fr = new FileReader(fichero);
        int letra;
        
        File fichero2 = new File("../texto2.txt");
        FileWriter fw = new FileWriter(fichero2, true);
        //boolean creado = fichero2.createNewFile();
        while( (letra = fr.read())!=-1){
            if(((char)letra) == 'o'){
                        fw.write('0');
            }else if(((char)letra) == 'e'){
                fw.write('3');
            }else{
                fw.write((char)letra);
            } 
        }
        System.out.println("");
        System.out.println("Archivo creado");
        fr.close();
        fw.close();
    }
}
