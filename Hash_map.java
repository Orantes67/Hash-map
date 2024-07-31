import java.util.*;

public class Hash_map {
    private HashMap<String, List<Integer>> mapa;

    public Hash_map() {
        mapa = new HashMap<>();
    }

    public void agregarPalabras(List<String[]> palabras) {
        for (int i = 0; i < palabras.size(); i++) {
            String palabra = palabras.get(i)[0].toLowerCase(); // Convertir a minúsculas para evitar problemas de comparación
            int numeroLinea = Integer.parseInt(palabras.get(i)[1]);
            if (!mapa.containsKey(palabra)) {
                mapa.put(palabra, new ArrayList<>());
            }
            mapa.get(palabra).add(numeroLinea);
            System.out.println("Palabra agregada: " + palabra + " en la línea " + numeroLinea);
        }
    }

    public boolean buscarPalabra(String palabra) {
        return mapa.containsKey(palabra.toLowerCase());
    }

    public void eliminarPalabra(String palabra) {
        mapa.remove(palabra.toLowerCase());
    }

    public List<Integer> obtenerLineas(String palabra) {
        return mapa.getOrDefault(palabra.toLowerCase(), null);
    }
}