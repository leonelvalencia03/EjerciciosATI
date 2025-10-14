/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Producto;

/**
 * author Emir Alvarado Exporta una lista de productos a un archivo CSV.
 *
 * @param productos Lista de productos a exportar.
 * @param nombreArchivo Nombre del archivo CSV (por ejemplo "inventario.csv").
 * @throws IOException Si ocurre un error al escribir el archivo.
 */
public class ExportadorCSV {

    public static void exportar(List<Producto> productos, String nombreArchivo) throws IOException {
       // try-with-resources cierra automáticamente el FileWriter al terminar
        try (FileWriter writer = new FileWriter(nombreArchivo)) {

            // Encabezados del archivo CSV
            writer.write("ID,Nombre,Precio,Stock\n");

            // Escribir cada producto en una línea
            for (Producto p : productos) {
                writer.write(p.getId() + "," + 
                             p.getNombre() + "," + 
                             p.getPrecio() + "," + 
                             p.getStock() + "\n");
            }
        }
    }
}