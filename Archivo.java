import java.io.*;
import java.util.*;

public class Archivo {

    public List<String[]> leerTxt(String direccion) {
        List<String[]> palabrasConLineas = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(direccion))) {
            String linea;
            int numeroLinea = 1; 

            while ((linea = bf.readLine()) != null) {
                String[] palabras = linea.split(",\\s*"); 
                
                for (String palabra : palabras) {
                    palabra = palabra.trim(); 
                    if (!palabra.isEmpty()) {
                        palabrasConLineas.add(new String[]{palabra, String.valueOf(numeroLinea)});
                        numeroLinea++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return palabrasConLineas;
    }
}
