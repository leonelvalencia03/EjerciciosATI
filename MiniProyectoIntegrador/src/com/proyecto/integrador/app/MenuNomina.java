package com.proyecto.integrador.app;

import com.proyecto.integrador.util.ScannerUtil;
import com.proyecto.integrador.service.NomivaService;


public class MenuNomina {
    public MenuNomina() {
        
    }
    public static void Menu() {
        NomivaService nominaService = new NomivaService();

       do{
         System.out.println("--- Menú Nómina ---");
        System.out.println("1- Agregar empleado");
        System.out.println("2- Buscar empleado");
        System.out.println("3- Eliminar empleado");
        System.out.println("4- Listar empleados");
        System.out.println("5- Volver al menú principal");
        int opcion = ScannerUtil.leerInt("Seleccione una opción: ");
        switch (opcion) {
            case 1:
                nominaService.agregarEmpleado();
                break;
            case 2:
                nominaService.buscarEmpleado();
                break;
            case 3:
                nominaService.eliminarEmpleado();
                break;
            case 4:
                nominaService.listarEmpleados();
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
       }while (true);
        ScannerUtil.cerrarScanner();
    }
}
