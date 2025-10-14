package app;

import model.Producto;
import model.ExcepcionProdNoEncontrado;
import service.RepositorioMemoria;
import service.EstadisticasInventario;
import util.ExportadorCSV;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
/*
 * Importaciones necesarias:
 * - model.Producto: clase que representa los objetos de Producto con sus atributos y métodos.
 * - model.ExcepcionProdNoEncontrado: excepción personalizada para manejar errores al buscar productos.
 * - service.RepositorioMemoria: clase que implementa el repositorio en memoria (almacenamiento temporal).
 * - service.EstadisticasInventario: clase con métodos estáticos para calcular estadísticas del inventario.
 * - util.ExportadorCSV: clase encargada de exportar los datos a un archivo CSV.
 * 
 * También se importan clases estándar de Java:
 * - java.io.IOException: para manejar errores de entrada/salida al exportar el archivo.
 * - java.util.*: para manejar listas, entrada de usuario, excepciones y opcionales.

 * @author Emir Alvarado
 * Clase principal del sistema de inventario.
 * 
 * Uso de POO:
 * Encapsulamiento: cada clase tiene sus propios atributos y métodos, ocultando los detalles internos.
 * Abstracción: las clases modelan entidades del mundo real (como Producto).
 * Herencia: las interfaces y clases de servicio pueden compartir comportamientos comunes.
 * Polimorfismo: se utiliza al trabajar con interfaces genéricas (por ejemplo, Repositorio<T, ID>).
 * 
 * Funcionalidad general:
 * Permite agregar, listar, actualizar, eliminar, mostrar estadísticas y exportar productos a CSV.
 */
public class InventarioApp {
// Repositorio de productos almacenado en memoria, en paquete service
    private static final RepositorioMemoria repo = new RepositorioMemoria();
    // Escáner para leer datos del usuario desde consola
    private static final Scanner entrada = new Scanner(System.in);
    // Contador estático para generar IDs automáticos
private static int contadorId = 1;


    public static void main(String[] args) {
        boolean salir = false;
// Bucle principal del menú
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    mostrarEstadisticas();
                    break;
                case 6:
                    exportarCSV();
                    break;
                case 0:
                    System.out.println("👋 Saliendo del sistema...");
                    salir = true;
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ INVENTARIO =====");
        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Mostrar estadísticas");
        System.out.println("6. Exportar a CSV");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
/*
     * Lee la opción elegida por el usuario y controla errores de entrada.
     */
    private static int leerOpcion() {
        try {
            return entrada.nextInt();
        } catch (InputMismatchException e) {
            entrada.nextLine(); // limpiar entrada incorrecta
            return -1;
        }
    }
    /*
     * Permite agregar un nuevo producto al inventario.
     * Solicita los datos por consola y los guarda en el repositorio.
     */
   private static void agregarProducto() {
    try {
        int id = contadorId++; // asigna ID y luego lo incrementa

        entrada.nextLine(); // limpiar buffer
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Precio: ");
        double precio = entrada.nextDouble();

        System.out.print("Stock: ");
        int stock = entrada.nextInt();

        Producto p = new Producto(id, nombre, precio, stock);
        repo.agregar(p);
        System.out.println("Producto agregado correctamente.");

    } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Intente de nuevo.");
        entrada.nextLine();
    }
}
//Muestra los productos almacenados
    private static void listarProductos() {
        List<Producto> productos = repo.listar();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n=====LISTA DE PRODUCTOS=====");
            productos.forEach(System.out::println);
        }
    }
//Permite editar los productos a traves de ID
    private static void actualizarProducto() {
        try {
            System.out.print("Ingrese ID del producto a actualizar: ");
            int id = entrada.nextInt();
            entrada.nextLine(); // limpiar
            Optional<Producto> productoOpt = repo.buscarPorId(id);

            if (!productoOpt.isPresent()) {
                throw new ExcepcionProdNoEncontrado("El producto con ID " + id + " no encontrado.");
            }

            Producto p = productoOpt.get();

            System.out.print("Nuevo nombre (" + p.getNombre() + "): ");
            String nombre = entrada.nextLine();
            if (!nombre.isEmpty()) {
                p.setNombre(nombre);
            }

            System.out.print("Nuevo precio (" + p.getPrecio() + "): ");
            String precioStr = entrada.nextLine();
            if (!precioStr.isEmpty()) {
                p.setPrecio(Double.parseDouble(precioStr));
            }

            System.out.print("Nuevo stock (" + p.getStock() + "): ");
            String stockStr = entrada.nextLine();
            if (!stockStr.isEmpty()) {
                p.setStock(Integer.parseInt(stockStr));
            }

            repo.actualizar(p);
            System.out.println("Producto actualizado correctamente.");

        } catch (ExcepcionProdNoEncontrado e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida.");
            entrada.nextLine();
        }
    }
//Elimina productos por ID
    private static void eliminarProducto() {
        try {
            System.out.print("Ingrese ID del producto a eliminar: ");
            int id = entrada.nextInt();
            repo.eliminar(id);
            System.out.println("Producto eliminado correctamente.");
        } catch (ExcepcionProdNoEncontrado e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida.");
            entrada.nextLine();
        }
    }
//Muestra las estadisticas de los productos almacenados
    private static void mostrarEstadisticas() {
        List<Producto> productos = repo.listar();
        if (productos.isEmpty()) {
            System.out.println("No hay productos para calcular estadísticas.");
            return;
        }

        double total = EstadisticasInventario.calcularValorTotal(productos);
        Producto mayorStock = EstadisticasInventario.productoConMayorStock(productos);
        double promedio = EstadisticasInventario.promedioDePrecios(productos);

        System.out.println("\n-----ESTADÍSTICAS DEL INVENTARIO-----");
        System.out.printf("Valor total: %.2f%n", total);
        System.out.println("Producto con mayor stock: " + mayorStock);
        System.out.printf("Promedio de precios: %.2f%n", promedio);
    }
//Exporta los datos en formato CSV
    //PARA VER LOS ARCHOIVOS CSV GENERADOS, REVISE LA CARPETA DEL PROYECTO
    private static void exportarCSV() {
        List<Producto> productos = repo.listar();
        if (productos.isEmpty()) {
            System.out.println("No hay productos para exportar.");
            return;
        }

        try {
            ExportadorCSV.exportar(productos, "inventario.csv"); //Otorga el nombre del archivo CSV
            System.out.println("Archivo 'inventario.csv' exportado correctamente. Revise la carpeta del proyecto");
        } catch (IOException e) {
            System.out.println("Error al exportar el archivo CSV: " + e.getMessage());
        }
    }
}
