import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner leer = new Scanner(System.in);
        Hash_map hashMap = new Hash_map();
        Archivo archivo = new Archivo();

        while (true) {
            System.out.println("Elige un número de lo que necesites hacer:");
            System.out.println("1: Ingrese la dirección del archivo txt");
            System.out.println("2: Buscar Palabra");
            System.out.println("3: Eliminar Palabra");
            System.out.println("4: Salir");

            int opc = leer.nextInt();
            leer.nextLine(); 

            switch (opc) {
                case 1:
                    System.out.println("Ingrese la dirección del archivo txt:");
                    String direccion = leer.nextLine().trim(); // Eliminar espacios en blanco innecesarios
                    System.out.println("Intentando leer el archivo en la ruta: " + direccion);
                    List<String[]> palabras = archivo.leerTxt(direccion);
                    if (!palabras.isEmpty()) {
                        hashMap.agregarPalabras(palabras);
                        System.out.println("Palabras agregadas con éxito.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la palabra a buscar:");
                    String palabraBuscar = leer.nextLine();
                    if (hashMap.buscarPalabra(palabraBuscar)) {
                        System.out.println("La palabra se encuentra en las líneas: " + hashMap.obtenerLineas(palabraBuscar));
                    } else {
                        System.out.println("La palabra no se encontró.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la palabra a eliminar:");
                    String palabraEliminar = leer.nextLine();
                    hashMap.eliminarPalabra(palabraEliminar);
                    System.out.println("Palabra eliminada con éxito.");
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    leer.close();
                    return;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}

