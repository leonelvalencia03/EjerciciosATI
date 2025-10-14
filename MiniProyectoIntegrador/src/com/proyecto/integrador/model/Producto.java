package com.proyecto.integrador.model;


public class Producto implements Mostrable {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método adicional: Calcula el valor total del inventario de este producto
     */
    public double calcularValorTotal() {
        return precio * cantidad;
    }

    /**
     * INTERFACES: Implementación del método de la interfaz Mostrable
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL PRODUCTO ===");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Valor Total: $" + calcularValorTotal());
        System.out.println("================================");
    }

    /**
     * POLIMORFISMO: Sobrescritura del método toString() de Object
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
