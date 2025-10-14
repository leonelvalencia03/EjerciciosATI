package com.proyecto.integrador.service;

public interface Gestionable {
    /**
     * Agrega un nuevo elemento al sistema
     */
    void agregar();
    
    /**
     * Lista todos los elementos del sistema
     */
    void listar();
    
    /**
     * Elimina un elemento del sistema
     */
    void eliminar();
    
    /**
     * Busca un elemento en el sistema
     */
    void buscar();
}
