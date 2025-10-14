package com.proyecto.integrador.app;
import com.proyecto.integrador.util.ScannerUtil;

public class MenuPrincipal {
    public MenuPrincipal() {
        
    }

    public static void mostrarMenuPrincipal() {
        

        System.out.println("\n--- Menú Principal ---");
        System.out.println("1- Biblioteca");
        System.out.println("2- Inventario");
        System.out.println("3- Nómina");
        System.out.println("4- Salir");
        int opcion = ScannerUtil.leerInt("Seleccione una opción: ");
        switch (opcion) {
            case 1:
                MenuBiblioteca.Menu();
                break;
            case 2:
                MenuInventario.Menu();
                break;
            case 3:
                MenuNomina.Menu();
                break;
            case 4:
                System.out.println("Gracias por usar el sistema");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

}