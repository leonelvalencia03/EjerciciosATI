/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Define que esta clase pertenece al paquete 'service'.
// Los paquetes organizan el código y separan la lógica de negocio de otras capas.
package service;

// Importa la clase Producto para poder trabajar con objetos Producto en el repositorio
import model.Producto;

// Importa Comparator, que permite comparar objetos de forma personalizada.
// Se utiliza para encontrar el producto con mayor stock.
import java.util.Comparator;

// Importa List, la interfaz para listas de objetos.
// Permite almacenar y recorrer múltiples productos en colecciones.
import java.util.List;

// Importa OptionalDouble, que puede contener un valor double o estar vacío.
// Se utiliza al calcular el promedio de precios, para manejar listas vacías sin errores.
import java.util.OptionalDouble;

/**
 * Clase de utilidad para calcular estadísticas del inventario.
 * 
 * Esta clase aplica principios de Programación Orientada a Objetos (POO):
 * Encapsulamiento: los métodos son estáticos y la clase no mantiene estado, encapsulando la lógica de cálculo de estadísticas.
 * Abstracción: el usuario solo necesita llamar a los métodos sin preocuparse por la implementación interna.
 * Uso de Streams: permite operaciones funcionales sobre colecciones (map, max, average, sum).
 * 
 * @author Emir Alvarado
 */


 /**
     * Calcula el valor total del inventario.
     * Se multiplica el precio por el stock de cada producto y se suman todos.
     * @param productos Lista de productos del inventario.
     * @return Valor total como double.
     */
public class EstadisticasInventario {
    public static double calcularValorTotal(List<Producto> productos) {
        return productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getStock())
                .sum();
    }
/**
     * Obtiene el producto con mayor stock en el inventario.
     * 
     * @param productos Lista de productos del inventario.
     * @return Producto con mayor stock o null si la lista está vacía.
     */
    public static Producto productoConMayorStock(List<Producto> productos) {
        return productos.stream()
                .max(Comparator.comparingInt(Producto::getStock)) // compara por stock
                .orElse(null); // devuelve null si no hay productos
    }
/**
     * Calcula el promedio de precios de todos los productos.
     * 
     * @param productos Lista de productos del inventario.
     * @return Promedio de precios, 0 si la lista está vacía.
     */
    public static double promedioDePrecios(List<Producto> productos) {
        OptionalDouble promedio = productos.stream()
                .mapToDouble(Producto::getPrecio) // obtiene el precio de cada producto
                .average(); // calcula el promedio
        return promedio.orElse(0); // si la lista está vacía, devuelve 0
    }
}

