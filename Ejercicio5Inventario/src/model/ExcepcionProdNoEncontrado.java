/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 * Clase de excepción personalizada para el inventario.
 * 
 * Esta excepción se lanza cuando un producto no se encuentra en el repositorio.
 * Ejemplo: al intentar actualizar o eliminar un producto que no existe.
 * 
 * Uso de POO:
 * - Herencia: extiende de RuntimeException para crear un tipo específico de excepción.
 * - Abstracción: encapsula el mensaje de error, permitiendo manejar errores de forma clara.
 * - Polimorfismo: se comporta como cualquier RuntimeException, pero con significado específico.
 * 
 * @author Emir Alvarado
 */


public class ExcepcionProdNoEncontrado  extends RuntimeException {
    public ExcepcionProdNoEncontrado(String mensaje) {
        super(mensaje);
    }
}