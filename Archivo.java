import java.io.*;
import java.util.*;

public class Archivo {

    public List<String[]> leerTxt(String direccion) {
        List<String[]> lineas = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String linea;
            int numeroLinea = 1;

            while ((linea = bf.readLine()) != null) {
                String[] palabras = linea.split(",\\s+");
                for (int i = 0; i < palabras.length; i++) {
                    String palabra = palabras[i];
                    lineas.add(new String[]{palabra, String.valueOf(numeroLinea)});
                }
                numeroLinea++;
            }
            bf.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return lineas;
    }
}