import java.util.*;

public class Hash_set {
    private HashSet<String> conjunto;

    public Hash_set() {
        conjunto = new HashSet<>();
    }

    public void agregarPalabras(List<String[]> palabras) {
        for (String[] palabraConLinea : palabras) {
            String palabra = palabraConLinea[0].toLowerCase();
            conjunto.add(palabra);
            System.out.println("Palabra agregada: " + palabra);
        }
    }

    public boolean buscarPalabra(String palabra) {
        return conjunto.contains(palabra.toLowerCase());
    }

    public void eliminarPalabra(String palabra) {
        String palabraLower = palabra.toLowerCase();
        if (conjunto.contains(palabraLower)) {
            conjunto.remove(palabraLower);
            System.out.println("Palabra eliminada con éxito: " + palabraLower);
        } else {
            System.out.println("La palabra '" + palabraLower + "' no se encontró en el conjunto.");
        }
    }
}
