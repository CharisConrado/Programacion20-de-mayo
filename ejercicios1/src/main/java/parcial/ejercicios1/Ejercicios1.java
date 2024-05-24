package parcial.ejercicios1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import parcial.ejercicios1.clases.AppendToFile;
import parcial.ejercicios1.clases.ReadFile;

public class Ejercicios1 {

    public static void main(String[] args) throws IOException {
        File file = new File ("./sales.txt");
        
        try {
            if (file.createNewFile()) {
                System.out.println("Archivo creado");
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            System.out.println("error" + e.getMessage());
        }
        
        ReadFile readFile = new ReadFile(file); //ESTA ES MI CLASE, LA QUE CREÉ PARA LEER EL ARCHIVO
        List<String> sales = readFile.loadSales(); 
        
        /* for (String line : sales){
            String [] splited = new String[3];
            splited = line.split(";");
            System.out.println("VENTAS: "+ splited[0] + " " + splited[1] + " " + splited[2]);
            
        } */
        
        for (String line : sales) {
            String[] splited = line.split(";");
            if (splited.length == 3) { //producto, cantidad, precio
                try {
                    String name = splited[0];
                    int quantity = Integer.parseInt(splited[1]);
                    double price = Double.parseDouble(splited[2]);
                    double total = quantity * price;
                    System.out.println("VENTAS: " + name + " " + quantity + " " + price + " " + " Total: " + total);
                } catch (NumberFormatException e) {
                    System.out.println("Error al parsear la línea: " + line);
                }
            } else {
                System.out.println("Formato incorrecto: " + line);
            }
        }
        
        System.out.println("¿Desea agregar alguna actualización de venta al final?");

        AppendToFile appender = new AppendToFile(file);
        appender.addLineToEOF("deTodito;24;3000");
        
        
            
    }
}
