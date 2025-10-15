/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
// Importa la clase Producto para poder trabajar con objetos Producto en el repositorio
import model.Producto;

// Importa la excepción personalizada para manejar casos donde no se encuentra un producto
import model.ExcepcionProdNoEncontrado;

// Importa clases de utilidades de Java:
// Map, List, Optional, ArrayList
import java.util.*;

// Importa ConcurrentHashMap, un Map seguro para hilos, usado para almacenar productos
import java.util.concurrent.ConcurrentHashMap;
/**
 * Repositorio en memoria para almacenar productos.
 * 
 * Implementa la interfaz genérica Repositorio<T, ID>, donde:
 * T = Producto
 * ID = Integer
 *
 * Principios de POO aplicados:
 * Encapsulamiento: los datos se guardan en un Map privado.
 * Abstracción: los métodos CRUD proporcionan una interfaz clara para manipular productos.
 * Polimorfismo: implementa la interfaz genérica Repositorio.
 *
 * @author Emir Alvarado
 */


public class RepositorioMemoria implements Repositorio<Producto, Integer> {
    // Almacena los productos en memoria usando un Map.
    // Clave = ID del producto, Valor = objeto Producto
    // ConcurrentHashMap permite acceso seguro si se usan múltiples hilos (opcional en este caso)
   private final Map<Integer, Producto> data = new ConcurrentHashMap<>();

   
     //Agrega un producto al repositorio.
     //Si ya existe un producto con el mismo ID, se sobrescribe.
    @Override
    public void agregar(Producto producto) {
        data.put(producto.getId(), producto);
    }

     //Actualiza un producto existente en el repositorio.
     //Si el producto no existe, lanza ExcepcionProdNoEncontrado.

    @Override
    public void actualizar(Producto producto) {
        if (!data.containsKey(producto.getId())) {
            throw new ExcepcionProdNoEncontrado("No se puede actualizar: producto no encontrado (id=" + producto.getId() + ")");
        }
        data.put(producto.getId(), producto);
    }
       //Elimina un producto por su ID.
       //Si no existe, lanza ExcepcionProdNoEncontrado.
    @Override
    public void eliminar(Integer id) {
        if (data.remove(id) == null) {
            throw new ExcepcionProdNoEncontrado("No se puede eliminar: producto no encontrado (id=" + id + ")");
        }
    }

    /**
     * Busca un producto por su ID.
     * Devuelve un Optional<Producto> que puede estar vacío si no se encuentra.
     * Uso de Optional evita retornar null directamente.
     */
    @Override
    public Optional<Producto> buscarPorId(Integer id) {
        return Optional.ofNullable(data.get(id));
    }
 
     //Lista todos los productos del repositorio.
     //Devuelve una copia en ArrayList para que no se pueda modificar el Map original directamente.    
    @Override
    public List<Producto> listar() {
        return new ArrayList<>(data.values());
    }
}