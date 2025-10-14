/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 * Clase que representa un Producto en el inventario. Esta clase es un ejemplo
 * de Programación Orientada a Objetos (POO), aplicando los principios de
 * encapsulamiento, abstracción y uso de métodos sobrescritos.
 *
 * @author Emir Alvarado
 */
public class Producto {

    // Atributos privados (Encapsulamiento)
    // Solo se accede a ellos mediante getters y setters
    private Integer id;
    private String nombre;
    private double precio;
    private int stock;

    /**
     * Constructor de la clase Producto Permite crear un objeto Producto con
     * todos sus atributos.
     *
     * @param id Identificador único
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param stock Cantidad disponible
     */
    public Producto(Integer id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

   // ---------------- toString ----------------
    // Permite representar el objeto Producto como una cadena de texto legible
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // toString
    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio + ", stock=" + stock + "}";
    }

   // ---------------- equals y hashCode ----------------
    // Se sobrescriben para que dos productos se consideren iguales **solo por su ID**
    // Esto es útil para colecciones como List, Set o al buscar productos en el repositorio
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;  // Si es el mismo objeto
        }
        if (!(o instanceof Producto)) {
            return false; // Si no es un Producto, devuelve false
        }
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Genera código hash basado en el ID
    }
}
