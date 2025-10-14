package com.proyecto.integrador.app;
import com.proyecto.integrador.util.ScannerUtil;

import com.proyecto.integrador.service.BibliotecaService;


public class MenuBiblioteca {
    public MenuBiblioteca() {
        
    }

    public static void Menu() {
        BibliotecaService bibliotecaService = new BibliotecaService();

        do{
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1- Agregar libro");
            System.out.println("2- Buscar libro");
            System.out.println("3- Eliminar libro");
            System.out.println("4- Listar libros");
            System.out.println("5- Volver al menú principal");  
            int opcion = ScannerUtil.leerInt("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    bibliotecaService.agregarLibro();
                    break;
                case 2:
                    bibliotecaService.buscarLibro();
                    break;
                case 3:
                    bibliotecaService.eliminarLibro();
                    break;
                case 4:
                    bibliotecaService.listarLibros();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida");
        }

        if (opcion == 5) {            
            break; // Salir del bucle si la opción es 5
        }
    }while(true);
        MenuPrincipal.mostrarMenuPrincipal();
    }
}

