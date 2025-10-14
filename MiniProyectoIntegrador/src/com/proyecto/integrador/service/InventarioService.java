package com.proyecto.integrador.service;
import com.proyecto.integrador.model.Producto;
import com.proyecto.integrador.util.ScannerUtil;

import java.util.List;
import java.util.ArrayList;


public class InventarioService implements Gestionable {
    private List<Producto> productos;
    private int nextId;

    public InventarioService() {
        this.productos = new ArrayList<>();
        this.nextId = 1;
    }


    @Override
    public void agregar() {
        agregarProducto();
    }

    public void agregarProducto() {
        System.out.println("--- Agregar Producto ---");
        String nombre = ScannerUtil.leerString("Ingrese el nombre del producto: ");
        double precio = ScannerUtil.leerDouble("Ingrese el precio del producto: ");
        int cantidad = ScannerUtil.leerInt("Ingrese la cantidad del producto: ");

        Producto nuevoProducto = new Producto(nextId++, nombre, precio, cantidad);
        productos.add(nuevoProducto);
        System.out.println("Producto agregado: " + nuevoProducto.getNombre());
    }

    @Override
    public void listar() {
        listarProductos();
    }

    public void listarProductos() {
        System.out.println("--- Lista de Productos ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() +
                               ", Precio: " + producto.getPrecio() + ", Cantidad: " + producto.getCantidad());
        }
    }

    @Override
    public void eliminar() {
        eliminarProducto();
    }

    public void eliminarProducto() {
        System.out.println("--- Eliminar Producto ---");
        int id = ScannerUtil.leerInt("Ingrese el ID del producto a eliminar: ");
        Producto productoAEliminar = null;
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productoAEliminar = producto;
                break;
            }
        }
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("Producto eliminado: " + productoAEliminar.getNombre());
        } else {
            System.out.println("Producto con ID " + id + " no encontrado.");
        }
    }

    @Override
    public void buscar() {
        buscarProducto();
    }

    public Producto buscarProducto() {
        System.out.println("--- Buscar Producto ---");
        String nombre = ScannerUtil.leerString("Ingrese el nombre del producto a buscar: ");
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Producto encontrado: ID: " + producto.getId() + ", Nombre: " + producto.getNombre() +
                                   ", Precio: " + producto.getPrecio() + ", Cantidad: " + producto.getCantidad());
                return producto;
            }
        }
        System.out.println("Producto con nombre " + nombre + " no encontrado.");
        return null;
    }
}
