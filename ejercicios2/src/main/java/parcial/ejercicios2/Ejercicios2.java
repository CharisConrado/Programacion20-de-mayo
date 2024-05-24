
package parcial.ejercicios2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ejercicios2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File file = new File("./registro2.txt");
        
        try{
            if(file.createNewFile()){
                System.out.println("Archivo Creado");
            }else{
                System.out.println("Archivo ya existente");
            }
        }catch(IOException e){
            System.out.println("ERROR "+e.getMessage());
        }
        
        FileWriter fw = new FileWriter(file,true);
        PrintWriter pw = new PrintWriter(fw);
        FileReader fr = new FileReader(file);
        BufferedReader buffer = new BufferedReader(fr);
        
        
        ArrayList<String> Lista = new ArrayList<>();
        ArrayList<String> Actividades = new ArrayList<>();
        Actividades.add("Futbol");
        Actividades.add("Basket");
        Actividades.add("Voley");
        
        
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Ingrese su nombre completo:");
        String name = scn.nextLine();
        
        System.out.println("Ingrese el número de su actividad: (1)Futbol (2)Basket (3)Voley");
        int acti = scn.nextInt();
        
        ArrayList <String> iniciales = new ArrayList<>();
        
        for(int i=0;i<name.length();i++){
            char c = name.charAt(i);
            if(i==0){
                iniciales.add(String.valueOf(c));
            }
            if(c == ' '){
                c = name.charAt(i+1);
                iniciales.add(String.valueOf(c));
            }
            
        }
        String num1 = (iniciales.get(0)+iniciales.get(1)+iniciales.get(2)+iniciales.get(3));
        
        Random random = new Random();
        int numero = random.nextInt(1000); 
        String num = num1 +String.format("%03d", numero);
        
        num="SAGQ339";
        String newLine = "";
        String Line;
        do{
            Line = buffer.readLine();
            if(Line != null){
                String[] split3 = Line.split(";");
                System.out.println(split3[2]);
                if(split3[2].equals(num)){
                    System.out.println("Los códigos son iguales");
                    newLine = "";
                    numero = random.nextInt(1000); 
                    num =num1+ String.format("%03d", numero);
                }
                else{
                    newLine = "Agregar";
                    
                }
            }
            else{
                
                if(newLine != ""){
                    String linea = name+";"+Actividades.get(acti - 1)+";"+ num;
                    pw.println(linea);
                    System.out.println("Estudiante agregado");
                    break;
                }
                else{
                    System.out.println("Código repetido");
                    break;
                }
            }
        }while(Line!= "0");
        
        fr.close();
        buffer.close();
        fw.close();
        pw.close();
        
        
        
        
    }
}
