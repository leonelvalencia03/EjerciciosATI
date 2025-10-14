package com.proyecto.integrador.model;


public class Libro implements Mostrable {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private String isbn;

    public Libro(int id, String titulo, String autor, String genero, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * INTERFACES: Implementación del método de la interfaz Mostrable
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL LIBRO ===");
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("ISBN: " + isbn);
        System.out.println("============================");
    }

    /**
     * POLIMORFISMO: Sobrescritura del método toString() de Object
     */
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
