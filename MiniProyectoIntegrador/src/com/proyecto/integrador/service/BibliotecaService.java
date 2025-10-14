package com.proyecto.integrador.service;

import com.proyecto.integrador.model.Libro;
import com.proyecto.integrador.util.ScannerUtil;

import java.util.List;
import java.util.ArrayList;

public class BibliotecaService implements Gestionable {
    private List<Libro> libros;
    private int nextId;

    public BibliotecaService() {
        this.libros = new ArrayList<>();
        this.nextId = 1;// Inicializa el ID para el primer libro, se incrementará con cada nuevo libro.
    }

    @Override
    public void agregar() {
        agregarLibro();
    }

    public void agregarLibro() {
        System.out.println("\n--- Agregar Libro ---");
        String titulo = ScannerUtil.leerString("Ingrese el título del libro: ");
        String autor = ScannerUtil.leerString("Ingrese el autor del libro: ");
        String genero = ScannerUtil.leerString("Ingrese el género del libro: ");
        String isbn = ScannerUtil.leerString("Ingrese el ISBN del libro: ");

        Libro nuevoLibro = new Libro(nextId++, titulo, autor, genero, isbn);
        libros.add(nuevoLibro);
        System.out.println("Libro agregado con éxito.");
    }

    @Override
    public void buscar() {
        buscarLibro();
    }

    public void buscarLibro() {
        System.out.println("\n--- Buscar Libro ---");
        String titulo = ScannerUtil.leerString("Ingrese el título del libro a buscar: ");
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Libro encontrado: " + libro.getTitulo() + " por " + libro.getAutor());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }   
    }

    @Override
    public void eliminar() {
        eliminarLibro();
    }

    public void eliminarLibro() {
        System.out.println("\n--- Eliminar Libro ---");
        String titulo = ScannerUtil.leerString("Ingrese el título del libro a eliminar: ");
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                libros.remove(i);
                System.out.println("Libro eliminado con éxito.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    @Override
    public void listar() {
        listarLibros();
    }

    public void listarLibros() {
        System.out.println("\n--- Lista de Libros ---");
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (Libro libro : libros) {
                System.out.println("ID: " + libro.getId() + ", Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor() + ", Género: " + libro.getGenero() + ", ISBN: " + libro.getIsbn());
            }
        }
    }
}