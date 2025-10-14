package com.proyecto.integrador.app;

import com.proyecto.integrador.service.InventarioService;
import com.proyecto.integrador.util.ScannerUtil;

public class MenuInventario {
    

    public MenuInventario() {
    }

    public static void Menu() {
            InventarioService inventarioService = new InventarioService();
            
            do{
                System.out.println("--- Menú Inventario ---");
                System.out.println("1- Agregar producto");
                System.out.println("2- Buscar producto");
                System.out.println("3- Eliminar producto");
                System.out.println("4- Listar productos");
                System.out.println("5- Volver al menú principal");  
                int opcion = ScannerUtil.leerInt("Seleccione una opción: ");
                switch (opcion) {
                    case 1:
                        inventarioService.agregarProducto();
                        break;
                    case 2:
                        inventarioService.buscarProducto();
                        break;
                    case 3:
                        inventarioService.eliminarProducto();
                        break;
                    case 4:
                        inventarioService.listarProductos();
                        break;
                    case 5:
                    
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

                if (opcion == 5) {
                    MenuPrincipal.mostrarMenuPrincipal();
                    break; // Salir del bucle si la opción es 5
                }

            }while(true);
        ScannerUtil.cerrarScanner();
    }
}
