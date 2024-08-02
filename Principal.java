import java.util.*;

public class Principal {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner leer = new Scanner(System.in);
        Hash_set hashSet = new Hash_set();
        Archivo archivo = new Archivo();

        while (true) {
            System.out.println("Elige un número de lo que necesites hacer:");
            System.out.println("1: Ingrese la dirección del archivo txt");
            System.out.println("2: Buscar Palabra");
            System.out.println("3: Eliminar Palabra");
            System.out.println("4: Salir");

            int opc = -1;
            boolean inputValido = false;

            while (!inputValido) {
                try {
                    opc = leer.nextInt();
                    leer.nextLine(); 
                    inputValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingresa un número.");
                    leer.nextLine();
                }
            }

            switch (opc) {
                case 1:
                    System.out.println("Ingrese la dirección del archivo txt:");
                    String direccion = leer.nextLine().trim(); 
                    System.out.println("Intentando leer el archivo en la ruta: " + direccion);
                    List<String[]> palabras = archivo.leerTxt(direccion);
                    if (!palabras.isEmpty()) {
                        hashSet.agregarPalabras(palabras);
                        System.out.println("Palabras agregadas con éxito.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la palabra a buscar:");
                    String palabraBuscar = leer.nextLine();
                    if (hashSet.buscarPalabra(palabraBuscar)) {
                        System.out.println("La palabra se encuentra en el conjunto.");
                    } else {
                        System.out.println("La palabra no se encontró.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la palabra a eliminar:");
                    String palabraEliminar = leer.nextLine();
                    hashSet.eliminarPalabra(palabraEliminar);
                    break;
                case 4:
                    leer.close();
                    return;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}
